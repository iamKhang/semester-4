CREATE LOGIN sinhvien WITH PASSWORD = '123';

--Sử dụng SSMS (Sql Server Management Studio) để thực hiện các thao tác sau:
--1)  Đăng nhập vào  SQL  bằng SQL  Server authentication, tài khoản sa.  Sử dụng TSQL.
--2)  Tạo hai login SQL server Authentication User2 và  User3

CREATE LOGIN user2 WITH PASSWORD = '123';
CREATE LOGIN user3 WITH PASSWORD = '123';

--3)  Tạo một database user User2 ứng với login User2 và một database user   User3
--ứng với login User3 trên CSDL AdventureWorks2008.

use AdventureWorks2008R2
create user user2 for login user2

use AdventureWorks2008R2
create user user3 for login user3

--4)  Tạo 2 kết nối đến server thông qua login  User2  và  User3, sau đó thực hiện các 
--thao tác truy cập CSDL  của 2 user  tương ứng (VD: thực hiện  câu Select). Có thực 
--hiện được không?

--5) Gán quyền select trên Employee cho User2, kiểm tra kết quả.  Xóa quyền select 
--trên Employee cho User2. Ngắt 2 kết nối của User2 và  User3

GRANT SELECT
ON [HumanResources].[Employee]
TO  user2

REVOKE SELECT
ON [HumanResources].[Employee]
TO  user2

--6) Trở lại kết nối của sa, tạo một user-defined database Role tên Employee_Role trên 
--CSDL  AdventureWorks2008,  sau  đó  gán  các  quyền  Select,  Update,  Delete  cho 
--Employee_Role.


