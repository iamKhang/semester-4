go
CREATE TRIGGER ThemxoaCTHD ON [dbo].[Order Details] FOR INSERT, UPDATE
AS
	Raiserror ('Co %d dòng đã được hiệu chỉnh',0,1,@@rowcount)
RETURN
go

select * from [dbo].[Order Details]

Insert into [dbo].[Order Details] values(10248,15,2000,50,0)

go 
	CREATE TRIGGER NoDelete
	ON Products
	FOR DELETE AS 
	IF(SELECT ProductID FROM  Deleted )=12
	BEGIN
		Print 'You cannot delete the Productid=12'
		RollBack transaction
	END

go

go 
	CREATE TRIGGER NoDelete
	ON [dbo].[Customers]
	FOR DELETE AS ]
	IF(SELECT [CustomerID] FROM  Deleted )= 'ANTON'
	BEGIN
		Print 'You cannot delete the Productid=12'
		RollBack transaction
	END

go

Delete from [dbo].[Customers] where [CustomerID] = 'ANTON'

select *from [dbo].[Customers]
go
CREATE TRIGGER OrdDet_Insert
ON [Order Details]
FOR INSERT
AS
UPDATE P SET UnitsInStock = (P.UnitsInStock – I.Quantity)
FROM Products AS P INNER JOIN Inserted AS I ON P.ProductID = I.ProductID
go

go
	CREATE TRIGGER ktTonTai ON [Orders] FOR INSERT AS
	IF EXISTS (SELECT * FROM INSERTED i inner join Orders o ON i.OrderID = o.OrderID)
	BEGIN
		print 'Đã có hóa đơn này rồi, nhập lại'
		ROLLBACK TRANSACTION
	END
go

select *from Orders



go
	CREATE TRIGGER Trg_NgayLap_NgayGiaoHD ON Orders AFTER INSERT
	AS
	DECLARE @NgayLapHD DateTime, @NgayGiao DateTime
	SELECT @NgayLapHD=hd.Orderdate, @NgayGiao=hd.RequiredDate
	FROM Orders hd INNER JOIN Inserted i ON hd.OrderID=i.OrderID
	If @NgayGiao<@NgayLapHD
	BEGIN 
		RAISERROR(500103,10,1)
		ROLLBACK TRANSACTION
	END
go

select *from Orders

