--vi du 1 
-- cả 2 tran cùng 1 kiểu lock , USER A chạy trước (*)

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
--Cho phép một transaction có thể đọc dữ liệu đang được cập
--nhật bởi transaction khác trước khi transaction hoàn tất
--– Mức bảo vệ thấp nhất , nguy cơ xảy ra dirty read
--start transaction USER B
BEGIN TRAN
declare @i int
select @i=balance 
from Accounts where 
AccountID = 101
select @i
waitfor delay '00:00:10'
select @i=balance from Accounts where 
AccountID = 101
select @i
COMMIT
--hai lần đọc cùng 1 dữ liệu trong 1 tran 
---cho kết quả khác nhau
-- Ví dụ 2 ( ISOLATION LEVEL READ COMMITTED)
--Không cho phép một transaction đọc dữ liệu mà transaction 
--khác đang update chưa hoàn tất; nhưng không bảo vệ
--transaction đọc dữ liệu (transaction khác có thể làm thay đổi
--dữ liệu đang được đọc )
--– Nguy cơ xảy ra nonrepeatable reads , hay phantom data
--– Là thiết lập default của SQL Server
-- USER B
SET TRANSACTION ISOLATION LEVEL READ COMMITTED
--start transaction USER B
BEGIN TRAN
declare @i int   -- đã khai báo 
select @i=balance from Accounts where 
AccountID = 101
select @i
waitfor delay '00:00:5'
select @i=balance from Accounts where 
AccountID = 101
select @i
COMMIT
---hai lần đọc cùng 1 dữ liệu trong 1 tran 
---cho kết quả giống nhau

--- ví dụ 3 (READ COMMITTED)
-- USER B chạy trước (*)
SET TRANSACTION ISOLATION LEVEL READ COMMITTED
--Không cho phép một transaction đọc dữ liệu mà transaction 
--khác đang update chưa hoàn tất; nhưng không bảo vệ
--transaction đọc dữ liệu (transaction khác có thể làm thay đổi
--dữ liệu đang được đọc )
--– Nguy cơ xảy ra nonrepeatable reads , hay phantom data
--– Là thiết lập default của SQL Server
--start transaction USER B
BEGIN TRAN
declare @i int
select @i=balance from Accounts where 
AccountID = 101
select @i
waitfor delay '00:00:5'
select @i=balance from Accounts where 
AccountID = 101
select @i
COMMIT

--- Ví dụ 4
-- USER B chạy trước (*)
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ
--– Không cho phép một transaction update dữ liệu khi
--một transaction khác đang đọc
--– Chỉ bảo vệ data đang tồn tại, không ngăn được việc
--thêm dữ liệu mới => nguy cơ xảy ra phantom rows
--start transaction USER B
BEGIN TRAN
declare @i int
select @i=balance from Accounts where 
AccountID = 101
select @i
waitfor delay '00:00:5'
select @i=balance from Accounts where 
AccountID = 101
select @i
COMMIT
--- bảo vệ transaction đọc dữ liệu 
_---ví dụ 5 
-- 2 user cùng thiết lập , USER A chạy trước (*)
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ

--start transaction USER A
Begin tran
select * from Accounts 
waitfor delay '00:00:10' 
select * from Accounts 
Commit
---phantom rows
Ví dụ 6 
-- USER B thiết lập 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ
Begin tran
INSERT INTO Accounts
VALUES (414,2000)
Commit
select * from Accounts