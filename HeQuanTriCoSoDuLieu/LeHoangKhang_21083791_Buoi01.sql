CREATE DATABASE SmallWorks 
ON PRIMARY
(
NAME = 'SmallWorksPrimary',
FILENAME = 'T:\SmallWorks.mdf', 
SIZE = 10MB,
FILEGROWTH = 20%, 
MAXSIZE = 50MB
),
FILEGROUP SWUserData1 
(
NAME = 'SmallWorksData1',
FILENAME = 'T:\SmallWorksData1.ndf', 
SIZE = 10MB,
FILEGROWTH = 20%, 
MAXSIZE = 50MB
),
FILEGROUP SWUserData2 
(
NAME = 'SmallWorksData2',
FILENAME = 'T:\SmallWorksData2.ndf', 
SIZE = 10MB,
FILEGROWTH = 20%, 
MAXSIZE = 50MB
)
LOG ON 
(
NAME = 'SmallWorks_log',
FILENAME = 'T:\SmallWorks_log.ldf', 
SIZE = 10MB,
FILEGROWTH = 10%, 
MAXSIZE = 20MB
)

--3.  Dùng SSMS để xem kết quả: Click phải trên tên của CSDL vừa  tạo
--a.  Chọn filegroups, quan sát kết  quả:
--  Có bao nhiêu filegroup, liệt kê tên các filegroup hiện  tại: -có 3 filegroup: PRIMARY SWUserData1, SWUserData2
--  Filegroup mặc định là gì? -PRIMAY
--b.  Chọn file, quan sát có bao nhiêu database  file? -có 3
--4.  Dùng T-SQL tạo thêm một filegroup tên Test1FG1 trong SmallWorks, sau đó add 
--thêm 2 file filedat1.ndf và filedat2.ndf dung lượng 5MB vào filegroup Test1FG1. 
--Dùng SSMS xem kết  quả.
ALTER DATABASE SmallWorks
ADD FILEGROUP Test1FG1

ALTER DATABASE SmallWorks
ADD FILE 
(
	NAME = filedat1,
	FILENAME = 'T:\filedat1.ndf',
	SIZE = 5MB
), 
(
	NAME = filedat2,
	FILENAME = 'T:\filedat2.ndf',
	SIZE = 5MB
) TO FILEGROUP Test1FG1
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
--9.  Trong CSDL SmallWorks, tạo 2 bảng mới theo cấu trúc như  sau:
--FILEGROUP SWUserData2 
--(
--NAME = 'SmallWorksData2',
--FILENAME = 'T:\HoTen\SmallWorksData2.ndf', 
--SIZE = 10MB,
--FILEGROWTH = 20%, 
--MAXSIZE = 50MB
--)
--LOG ON 
--(
--NAME = 'SmallWorks_log',
--FILENAME = 'T:\HoTen\SmallWorks_log.ldf', 
--SIZE = 10MB,
--FILEGROWTH = 10%, 
--MAXSIZE = 20MB
--) 
--Bài tập Thực hành  Hệ Quản Trị Cơ sở Dữ Liệu
---  6-CREATE TABLE dbo.Person 
--(
--PersonID int NOT NULL, 
--FirstName varchar(50) NOT NULL, 
--MiddleName varchar(50) NULL, 
--LastName varchar(50) NOT NULL, 
--EmailAddress nvarchar(50) NULL
--) ON SWUserData1
--------------------------CREATE TABLE dbo.Product 
--(
--ProductID int NOT NULL, 
--ProductName varchar(75) NOT NULL,
--ProductNumber nvarchar(25) NOT NULL, 
--StandardCost money NOT NULL, 
--ListPrice money NOT NULL
--) ON SWUserData2
--10.  Chèn dữ liệu vào 2 bảng trên, lấy dữ liệu từ bảng  Person  và bảng  Product  trong 
--AdventureWorks2008  (lưu  ý:  chỉ  rõ  tên  cơ  sở  dữ  liệu  và  lược  đồ),  dùng  lệnh 
--Insert…Select...  Dùng  lệnh  Select *  để  xem  dữ  liệu  trong  2  bảng  Person  và  bảng
--Product  trong SmallWorks.
--11.  Dùng SSMS, Detach cơ sở dữ liệu SmallWorks ra khỏi phiên làm việc của  SQL.
--12.  Dùng SSMS, Attach cơ sở dữ liệu SmallWorks vào  SQL