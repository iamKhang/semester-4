--Hướng dẫn Module 6. ROLE - PERMISSION
--Sinh viên vận dụng phần hướng dẫn dưới đây để làm bài tập 
---------------------------------------------------------------------
--chú ý khi test ... : phải connect bằng tài khoản đã được cấp quyền để kiểm chứng quyền đã được cấp
--(thực hiện connect từ Object Explorer , và/hoặc từ Query Editor)

---------------------------------------------------------------------
--(1) Login vào SQL server bằng tài khoản sa của SQL Server  
--(2) Tạo một SQL Server Login
CREATE LOGIN sinhvien WITH PASSWORD = '123';
--(3) Connect vào SQL Server bằng login vừa tạo 
...
--(4) Login vừa tạo có quyền gì ? 
...
select * from sys.fn_my_permissions(NULL,'server')		--list all my server level effective permission on SQL Server instance

use master
select * from sys.fn_my_permissions(NULL,'database')	--list all effective permissions on  database X
use northwind
select * from sys.fn_my_permissions(NULL,'database')	--list all effective permissions on  database X


--(5)Tạo user để Tài khoản trên có quyền thao tác trên 2 database
USE  abc
CREATE USER  sinhvien  FOR LOGIN  sinhvien		-- tạo user cho database hiện hành
--test ...
--login trên cửa số query mới bằng tài khoản sinhvien....

go
USE AdventureWorks2008R2
CREATE USER  sinhvien  FOR LOGIN  sinhvien
--test ...
--login trên cửa số query mới bằng tài khoản sinhvien....

go
--(6) Cấp quyền ... trên ...(table/view) cho user sinhvien trên database AdventureWorks2008R2 
--Ví dụ 1:  Cấp quyền đọc trên table sales.salesorderheader cho user sinhvien 
--begin
USE AdventureWorks2008R2
go
---
GRANT SELECT
ON sales.salesorderheader
TO  sinhvien						--- database user
go
---test ... (dùng tài khoản sinhvien)


--quay lui về begin : thu hồi quyền đã cấp
REVOKE SELECT
ON sales.salesorderheader
TO  sinhvien
go
---test ... (dùng tài khoản sinhvien)

--Ví dụ 2: Cấp quyền đọc mọi object trong DB cho user sinhvien
--bằng cách :thêm sinhvien là member của một role đã có trong DB 
--begin
sp_helprole
go
sp_addrolemember  'db_datareader' , sinhvien
--hoặc dùng :  
--ALTER ROLE db_datareader ADD MEMBER  sinhvien
go
--test ...(dùng tài khoản sinhvien)


--quay lui về begin : 
--remove user sinhvien khỏi role db_datareader
sp_droprolemember  'db_datareader' , sinhvien
--hoặc dùng :  
--ALTER ROLE db_datareader DROP MEMBER  sinhvien


--Ví dụ 3: Cấp quyền đọc mọi object trong DB cho user sinhvien, ngoại trừ đọc table sales.salesorderheader
--begin
go
sp_addrolemember  'db_datareader' , sinhvien
go
--cấm quyền đọc
DENY  SELECT
ON sales.salesorderheader
TO  sinhvien
go
-- test ...(dùng tài khoản sinhvien)


--quay lui về begin : 
-- thu hồi quyền đã cấp
REVOKE  SELECT
ON sales.salesorderheader
TO  sinhvien 
go
sp_droprolemember  'db_datareader' , sinhvien
go

--Ví dụ 4: Cấp một số quyền ... trên ... cho user sinhvien và các user khác 
--begin
--tạo mới role mới 
CREATE ROLE  banhang
go
--gán quyền cho role
GRANT SELECT , INSERT , UPDATE ,DELETE 
on  sales.SalesOrderHeader
to banhang
go
GRANT SELECT , INSERT , UPDATE ,DELETE 
on  sales.SalesOrderDetail
to banhang
go
DENY SELECT 
on sales.Store
to banhang
go
sp_addrolemember  'db_datareader' , banhang

go
--thêm sinhvien là member của role banhang
sp_addrolemember  'banhang' , sinhvien

go
--test ... (dùng tài khoản sinhvien)


--quay lui về begin : 
--remove user sinhvien khỏi role banhang
sp_droprolemember  'banhang' , sinhvien
--xóa role banhang
DROP ROLE  banhang
go

--Ví dụ 5: Cấp quyền đọc trên table sales.salesorderheader cho user sinhvien 
-- và sinhvien có thể cấp quyền này cho user khác 
--begin
GRANT  SELECT 
ON  sales.SalesOrderHeader
TO  sinhvien  WITH GRANT OPTION 	
go 
--test ...(dùng tài khoản sinhvien)


-- thu hồi quyền đã cấp cho sinhvien và quyền mà sinhvien đã cấp cho các user khác
REVOKE  SELECT
ON sales.salesorderheader
TO  sinhvien CASCADE
---test ...(dùng tài khoản sinhvien)

--quay lui về begin : 
--...


--Ví dụ 6: GRANT hay DENY trên object/command 
GRANT  SELECT 
ON  sales.SalesOrderHeader   --- object  : table , view, sp, function
TO  sinhvien 

go
GRANT  create table ,create view      ---command
TO  sinhvien 








