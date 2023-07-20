use AdventureWorks2008R2;

--1)  Đăng nhập vào  SQL  bằng SQL  Server authentication, tài khoản sa.  Sử dụng TSQL.
--2)  Tạo hai login SQL server Authentication User2 và  User3
create login User2 with password = '123';
create login User3 with password = '123';
--3)  Tạo một database user User2 ứng với login User2 và một database user   User3
--ứng với login User3 trên CSDL AdventureWorks2008.
create user user2  for login User2;
create user user3  for login User3;
--4)  Tạo 2 kết nối đến server thông qua login  User2  và  User3, sau đó thực hiện các 
--thao tác truy cập CSDL  của 2 user  tương ứng (VD: thực hiện  câu Select). Có thực 
--hiện được không?
-- Khoong the dùng lệnh select vì user này chưa có quyền làm điều đó

--5)  Gán quyền select trên Employee cho User2, kiểm tra kết quả.  Xóa quyền select 
--trên Employee cho User2. Ngắt 2 kết nối của User2 và  User3
go
grant select 
on HumanResources.Employee
to user2

-- user 2 da co the dung lenh select tren HumanResources.Employee
revoke select 
on HumanResources.Employee
to user2


go
--6)  Trở lại kết nối của sa, tạo một user-defined database Role tên Employee_Role trên 
--CSDL  AdventureWorks2008,  sau  đó  gán  các  quyền  Select,  Update,  Delete  cho 
--Employee_Role.
create Role Employee_Role

grant select, update, delete to Employee_Role

go

--7)  Thêm các  User2  và  User3  vào  Employee_Role.  Tạo  lại  2  kết  nối  đến  server  thông 
--qua login User2 và User3 thực hiện các thao tác  sau:
go
exec sp_addrolemember 'Employee_Role', user2
exec sp_addrolemember 'Employee_Role', user3;
go
--a)  Tại kết nối với User2, thực hiện câu lệnh Select để xem thông tin của bảng 
--Employee
-- Co the xem duoc

--b)  Tại kết nối của User3, thực hiện cập nhật JobTitle=’Sale Manager’ của  nhân 
--viên có BusinessEntityID=1
--update HumanResources.Employee 
--set JobTitle =  'Sale Manage' where
--BusinessEntityID=1

-- thanh cong

--c)  Tại kết nối User2, dùng câu lệnh Select xem lại kết  quả.
--d)  Xóa role Employee_Role, (quá trình xóa role    ra sao ?)
-- Phai xoa toan bo member trong do truoc
exec sp_droprolemember 'Employee_Role', user2;
exec sp_droprolemember 'Employee_Role', user3;
drop role Employee_Role 