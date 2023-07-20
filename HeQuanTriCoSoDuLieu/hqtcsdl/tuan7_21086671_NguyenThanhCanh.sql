--1.  Tạo một Instead of trigger thực hiện trên view. Thực hiện theo các bước  sau:
create table  M_Department
(
DepartmentID int not null primary key, 
Name nvarchar(50),
GroupName nvarchar(50)
)
create table M_Employees 
(
EmployeeID int not null primary key, 
Firstname nvarchar(50),
MiddleName nvarchar(50), 
LastName nvarchar(50),
DepartmentID int foreign key references M_Department(DepartmentID)
)

--Tạo  một  view  tên  EmpDepart_View  bao  gồm  các  field:  EmployeeID,
--FirstName,  MiddleName,  LastName,  DepartmentID,  Name,  GroupName,  dựa 
--trên 2 bảng M_Employees và  M_Department
go

create view EmpDepart_View as
select EmployeeID, FirstName,  MiddleName,  LastName,  e.DepartmentID,  Name,  GroupName
from M_Department as d join M_Employees as e on d.DepartmentID = e.DepartmentID


go


go
--Tạo  một  trigger  tên  InsteadOf_Trigger  thực  hiện  trên  view
--EmpDepart_View,  dùng  để  chèn  dữ  liệu  vào  các  bảng  M_Employees  và 
--M_Department khi chèn một record mới thông qua view EmpDepart_View.
create trigger InsteadOf_Trigger on EmpDepart_View
instead of insert as
	if not exists (select * from inserted i join M_Department d on i.DepartmentID = d.DepartmentID)
		insert into M_Department select DepartmentID, Name, GroupName from inserted
		
	if not exists (select * from inserted i join M_Employees e on i.EmployeeID = e.EmployeeID)
		insert into M_Employees select EmployeeID, Firstname, MiddleName, LastName, DepartmentID from inserted
go


insert into EmpDepart_View values (2, 'Thanh', 'Canh', 'Canh', 3, 'Phong IT', 'PhongIT')
--select * from EmpDepart_View

--2. Tạo một trigger thực hiện trên bảng  MSalesOrders có chức năng thiết lập độ ưu 
--tiên của  khách hàng (CustPriority) khi người dùng thực hiện các thao tác  Insert, 
--Update và Delete trên bảng MSalesOrders theo điều kiện như  sau:
--  Nếu tổng tiền Sum(SubTotal) của khách hàng dưới 10,000 $ thì độ ưu tiên của 
--khách hàng (CustPriority) là 3
--  Nếu tổng tiền  Sum(SubTotal)  của khách hàng từ 10,000 $ đến dưới 50000  $ 
--thì độ ưu tiên của khách hàng (CustPriority) là  2
--  Nếu tổng tiền Sum(SubTotal) của khách hàng từ 50000  $ trở lên thì độ ưu tiên 
--của khách hàng (CustPriority) là 1
create table  MCustomer
(
CustomerID int not null primary key, 
CustPriority int )
create table MSalesOrders 
(
SalesOrderID int not null primary key, 
OrderDate date,
SubTotal money,
CustomerID int foreign key references MCustomer(CustomerID) )
--Chèn  dữ  liệu  cho  bảng  MCustomers,  lấy  dữ  liệu  từ  bảng  Sales.Customer, 
--nhưng chỉ lấy CustomerID>30100 và CustomerID<30118, cột CustPriority cho 
--giá trị  null
insert into MCustomer (CustomerID, CustPriority)
select CustomerID, null from Sales.Customer
where CustomerID > 30100 and CustomerID < 30118

--Chèn dữ liệu cho bảng MSalesOrders, lấy dữ liệu từ bảng
--Sales.SalesOrderHeader, chỉ lấy những hóa đơn của khách hàng có trong bảng 
--khách hàng.
insert into MSalesOrders (SalesOrderID, OrderDate, SubTotal, CustomerID) 
select SalesOrderID, OrderDate, SubTotal, c.CustomerID from Sales.SalesOrderHeader soh join MCustomer as c on soh.CustomerID = c.CustomerID

--Viết trigger để lấy dữ liệu từ 2 bảng inserted và deleted
select * from MCustomer
select * from MSalesOrders
go
create trigger cau2 on MSalesOrders 
after insert, delete, update
as
	declare @CustomerID int;
	declare @sum money;
	select @CustomerID = CustomerID  from inserted
	if (@CustomerID is null) select @CustomerID = CustomerID from deleted

	select @sum = Sum(SubTotal) from MSalesOrders where CustomerID = @CustomerID;

	if (@CustomerID is not null) update MCustomer set CustPriority = 
	(case
		when @sum < 10000 then 3
		when @sum < 50000 then 2
		else 1
	 end ) where CustomerID = @CustomerID
go

delete from MSalesOrders where SalesOrderID = 43865
insert into MSalesOrders values(43865, getDate(), 500, 30117)
select * from MCustomer where CustomerID = 30117


--3. Viết một trigger thực hiện trên bảng MEmployees sao cho khi người dùng thực
--hiện chèn thêm một nhân viên mới vào bảng MEmployees thì chương trình cập
--nhật số nhân viên trong cột NumOfEmployee của bảng MDepartment. Nếu tổng
--số nhân viên của phòng tương ứng <=200 thì cho phép chèn thêm, ngược lại thì
--hiển thị thông báo “Bộ phận đã đủ nhân viên” và hủy giao tác. Các bước thực hiện:

create table MDepartment
(
	DepartmentID int not null primary key,
	Name nvarchar(50),
	NumOfEmployee int
)

insert MDepartment
select [DepartmentID],[Name], null
from [HumanResources].[Department]

create table Memployees
(
	EmployeeID int not null,
	Firtname nvarchar(50),
	MiddleName nvarchar(50),
	LastName nvarchar(50),
	DepartmentID int foreign key references MDepartment(DepartmentID)
	constraint pk_emp_depart primary key(EmployeeID, DepartmentID)
)
insert [Memployees]
select e.[BusinessEntityID], [FirstName],[MiddleName],[LastName], [DepartmentID]
from [HumanResources].[Employee] e join [Person].[Person] p on e.BusinessEntityID=p.BusinessEntityID
								   join [HumanResources].[EmployeeDepartmentHistory] h on e.BusinessEntityID=h.BusinessEntityID
select*from [dbo].[Memployees]
order by [DepartmentID]


select *from Memployees
select *from MDepartment

go
create trigger cau3 
on [dbo].[Memployees]
for insert 
as
	declare @numofEmp int, @DepartID int
	select @DepartID=i.DepartmentID from inserted i
	set @numofEmp=(select COUNT(*) 
			       from [dbo].[Memployees] e
			       where e.DepartmentID=@DepartID
			      )
	if @numofEmp>=180 
		begin
			print 'so nhan vien da du'
			rollback
		end
	else
		update MDepartment
		set NumOfEmployee =@numofEmp
		where DepartmentID= @DepartID
go

insert [dbo].[Memployees] values(291, 'Nguyen','Hoang','Anh',1)
insert [dbo].[Memployees] values(292, 'Nguyen','Hoang','Thu',2)
insert [dbo].[Memployees] values(300, 'Nguyen','Hoang','Khang',2)


--5.  Viết một trigger thực hiện trên bảng ProductInventory (lưu thông tin số lượng  sản 
--phẩm trong kho). Khi chèn thêm một đơn đặt hàng vào bảng SalesOrderDetail  với 
--số lượng xác định trong   fieldOrderQty, nếu số lượng trong kho Quantity> OrderQty 
--thì cập nhật lại  số   lượng   trong   kho Quantity=  Quantity-  OrderQty, ngược lại nếu Quantity=0 
--thì xuất thông báo “Kho hết hàng” và đồng thời hủy giao  tác.
go
create trigger  cau5
on Sales.SalesOrderDetail
after insert
as
declare @productid int, @qty smallint  , @locationid int
select  @qty= OrderQty,  @productid = ProductID
from inserted

if exists (select * from  Production.ProductInventory where ProductID = @productid 
						and Quantity >= @qty)
begin
	select  top 1 @locationid=  LocationID
	from  Production.ProductInventory where ProductID = @productid and Quantity >= @qty

	update Production.ProductInventory
	set	Quantity = Quantity - @qty
	where ProductID = @productid  and @locationid=  LocationID
end

else
begin
	print N'Kho ....hết hàng'
	rollback
end
go

--6.Tạo trigger cập nhật tiền thưởng (Bonus) cho nhân viên bán hàng SalesPerson,  khi 
--người  dùng  chèn thêm một  record mới  trên  bảng  SalesOrderHeader,  theo  quy  định 
--như sau: Nếu tổng tiền bán được của nhân  viên có hóa  đơn  mới  nhập vào bảng 
--SalesOrderHeader  có giá trị >10000000 thì tăng tiền thưởng lên  10% của  mức 
--thưởng hiện tại. Cách thực  hiện:
use AdventureWorks2012;
create table M_SalesPerson 
(
SalePSID int not null primary key, 
TerritoryID int,
BonusPS money
)
create table M_SalesOrderHeader 
(
SalesOrdID int not null primary key, 
OrderDate date,
SubTotalOrd money,
SalePSID int foreign key references M_SalesPerson(SalePSID)
)
--Chèn dữ liệu cho hai bảng trên lấy từ SalesPerson và SalesOrderHeader chọn 
--những field tương ứng với 2 bảng mới  tạo.

insert into M_SalesPerson select SalesPerson.BusinessEntityID, TerritoryID, Bonus from Sales.SalesPerson

insert into M_SalesOrderHeader select SalesOrderID, OrderDate, SubTotal, SalesPersonID from Sales.SalesOrderHeader

--Viết trigger cho thao tác insert trên bảng M_SalesOrderHeader, khi trigger 
--thực thi thì dữ liệu trong bảng M_SalesPerson được cập  nhật.
go
create trigger cau6 on M_SalesOrderHeader
after insert
as
 declare @subtotal int;
 select @subtotal = SubTotalOrd from inserted

 if (@subtotal > 100000) 
	begin
		declare @PersonID int;
		select @PersonID = SalePSID from inserted
		if (@PersonID is not null) update M_SalesPerson set BonusPS = BonusPS*1.1 where SalePSID = @PersonID
	end
go
-- Test
declare @before money, @after money;
select @before = BonusPS from M_SalesPerson where SalePSID = 279
delete from M_SalesOrderHeader where SalesOrdID = 99999
insert into M_SalesOrderHeader values(99999, getdate(), 100001, 279)
select @after = BonusPS from M_SalesPerson where SalePSID = 279

print concat('Truoc: ', @before, '$; Sau: ', @after,'$');