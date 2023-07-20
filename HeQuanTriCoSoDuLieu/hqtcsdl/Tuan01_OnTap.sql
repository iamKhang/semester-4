select * from Sales.SalesOrderHeader

select *from Person.Person
select *from Sales.Customer

select FirstName + ' ' + MiddleName + ' ' + LastName as HoTen
from Person.Person
where FirstName = 'Carol'

select CustomerID
from Sales.Customer
where StoreID = 430


--2
CREATE DATABASE SmallWorks 
ON PRIMARY
(
NAME = 'SmallWorksPrimary',
FILENAME = 'T:\LeHoangKhang\SmallWorks.mdf', 
SIZE = 10MB,
FILEGROWTH = 20%, 
MAXSIZE = 50MB
),
FILEGROUP SWUserData1 
(
NAME = 'SmallWorksData1',
FILENAME = 'T:\LeHoangKhang\SmallWorksData1.ndf', 
SIZE = 10MB,
FILEGROWTH = 20%, 
MAXSIZE = 50MB
),
FILEGROUP SWUserData2 
(
NAME = 'SmallWorksData2',
FILENAME = 'T:\LeHoangKhangSmallWorksData2.ndf', 
SIZE = 10MB,
FILEGROWTH = 20%, 
MAXSIZE = 50MB
)
LOG ON 
(
NAME = 'SmallWorks_log',
FILENAME = 'T:\LeHoangKhang\SmallWorks_log.ldf', 
SIZE = 10MB,
FILEGROWTH = 10%, 
MAXSIZE = 20MB
)

--3
--a) co 3 file group, figroup mac dinh la PRIMARY
--b) 

--4.  Dùng T-SQL tạo thêm một filegroup tên Test1FG1 trong SmallWorks, sau đó add 
--thêm 2 file filedat1.ndf và filedat2.ndf dung lượng 5MB vào filegroup Test1FG1.
--Dùng SSMS xem kết  quả.

--5.  Dùng T-SQL tạo thêm một một file thứ cấp  filedat3.ndf  dung lượng 3MB trong 
--filegroup Test1FG1. Sau đó sửa kích thước tập tin này lên 5MB. Dùng SSMS xem 
--kết quả. Dùng T-SQL xóa file thứ cấp filedat3.ndf. Dùng SSMS xem kết  quả
--6.  Xóa  filegroup  Test1FG1?  Bạn  có  xóa  được  không?  Nếu  không  giải  thích?  Muốn  xóa 
--được bạn phải làm  gì?
--7.  Xem  lại  thuộc  tính  (properties)  của  CSDL  SmallWorks  bằng  cửa  sổ  thuộc  tính 
--properties  và  bằng  thủ  tục  hệ  thống  sp_helpDb,  sp_spaceUsed,  sp_helpFile. 
--Quan sát và cho biết các trang thể hiện thông tin  gì?.
--8.  Tại cửa sổ properties của CSDL SmallWorks, chọn thuộc tính ReadOnly, sau đó 
--đóng  cửa  sổ  properties.  Quan  sát  màu  sắc  của  CSDL.  Dùng  lệnh  T-SQL  gỡ  bỏ
--thuộc  tính  ReadOnly  và  đặt  thuộc  tính  cho  phép  nhiều  người  sử  dụng  CSDL
--SmallWorks.





