
create proc tinhTong @a int, @b int, @tong int output
as
begin
	set @tong = @a-@b;
end

declare @tong1 int;
exec tinhTong 2,3,@tong1 output
print convert(varchar(100), @tong1)

drop proc tinhTong


--EXAMPLE 5:
drop procedure  prcGetUnitPrice_UnitsInStock
go
CREATE PROCEDURE  prcGetUnitPrice_UnitsInStock  @ProductID int, @Unitprice Money OUTPUT, @UnitsInStock smallint OUTPUT
AS
BEGIN
	IF EXISTS (SELECT * FROM Products 
		    WHERE ProductID = @ProductID)
	     BEGIN
	         SELECT @Unitprice=Unitprice,@UnitsInStock=UnitsInStock
	         FROM Products
	         WHERE ProductID=@ProductID
	         RETURN 0
	     END
	ELSE
	     RETURN 1
END
go

Declare @Unitprice Money, @UnitsInStock smallint 
EXEC prcGetUnitPrice_UnitsInStock  1, @Unitprice  OUTPUT, @UnitsInStock  OUTPUT
Select @Unitprice AS Gia, @UnitsInStock  AS SoLuongTon


--FUNTION
--Ví dụ 1:
Create function tong2so()
Returns int
as
Begin
	Declare @so1 int, @so2 int
	Set @so1 = 4
	set @so2 =6
	Return @so1+@so2
end
--thuc hien 
print 'Tong = ' +convert(char(10),dbo.tong2so())
print 'Tong = ' +convert(char(10),tong2so())
select dbo.tong2so() as Tong

Alter function tong2so()
Returns int
With Encryption
as
Begin
	Declare @so1 int, @so2 int
	Set @so1 = 4
	set @so2 =6
	Return @so1+@so2
End
--Xem lệnh
	sp_helptext tong2so
--thuc hien 
	print 'Tong = ' +convert(char(10),dbo.tong2so())
	select dbo.tong2so() as Tong
--Xóa hàm 	Drop function Tong2so

--Ví dụ 2:
Create function Tongtien()
Returns money
AS
Begin
	Declare @tong money
	Select @tong = sum(unitprice*Quantity) from orders o, [Order Details] d
	where o.orderid = d.orderid and customerid = 'TOMSP'
	Return @tong
End
print 'Tong = ' +convert(char(10),dbo.tongtien())
select dbo.tongtien() as [Tong Tien Cua Khach Hang TOMPS]

--BÀI TẬP 1
--Viết hàm tên SubTotalOfEmp (dạng scalar function) trả về tổng doanh thu của một nhân viên trong một tháng tùy ý 
--trong một năm tùy ý, với tham số vào @EmplID, @MonthOrder, @YearOrder (Thông tin lấy từ bảng [Sales].[SalesOrderHeader])
go
create function dbo.SubTotalOfEmp(@empID int , @monthOrder int, @yearOrder int)
returns float
as
begin
	declare @total float;;
	select @total = sum(lineTotal)
	from Sales.SalesOrderHeader a inner join Sales.SalesOrderDetail b
	on a.SalesOrderID = b.SalesOrderID
	where SalesPersonID = @empID and month(OrderDate) = @monthOrder  and year(OrderDate)= @yearOrder
	return (@total)
end
go
--BÀI TẬP 2:
--Viết hàm tên là InventoryProd (dạng scalar function) với tham số vào là @ProductID và @locationID
--trả về số lượng tồn kho của sản phẩm trong khu vực tương ứng với giá trị của tham số (Dữ liệu lấy từ bảng[Production].[ProductInventory])
go
create function InventoryProd(@ProductId int, @locationID int)
returns int
as
begin
	declare @tonKho int;
	select @tonKho = Quantity
	from Production.ProductInventory
	where ProductID = @ProductId and LocationID = @locationID
	return @tonKho
end
go
--The table-valued UDFs
--Ví dụ 1:
go
CREATE FUNCTION  CountOrderCust()
RETURNS  @fn_CountOrderCust  TABLE
(OrderIdent  tinyint Not null, Cust varchar(5) )
AS
Begin
	Insert @fn_CountOrderCust	
	Select Count(orderid),CustomerId From Orders Group by customerid
	Return
end
go
--Thi hành
Select * from CountOrderCust()

SELECT ProductID, Total=dbo.TotalAmount(UnitPrice, Quantity, Discount)
FROM [Order details]
WHERE OrderID=10250
