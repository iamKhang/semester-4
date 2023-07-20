create database abc 
create table Accounts (
AccountID int NOT NULL PRIMARY KEY,
balance int NOT NULL
CONSTRAINT unloanable_account CHECK (balance >= 0) )
----refresh data
truncate table Accounts
select * from Accounts
INSERT INTO Accounts (AccountID,balance) VALUES (101,1000); 
select * from Accounts
 --vi du 1 
 SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
-- Cho phép một transaction có thể đọc dữ liệu đang được cập
--nhật bởi transaction khác trước khi transaction hoàn tất
--– Mức bảo vệ thấp nhất , nguy cơ xảy ra dirty read
-- cả 2 tran cùng 1 kiểu lock , USER A chạy trước (*)
 --start transaction USER A
BEGIN TRAN
update Accounts
set balance = balance +500
where AccountID = 101
select * from Accounts
go
waitfor delay '00:00:5'
update Accounts
set balance = balance +200
where AccountID = 101
select * from Accounts
COMMIT
-- Ví dụ 2 ( ISOLATION LEVEL READ UNCOMMITTED)
----- USER A chạy trước (*)
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED

--start transaction USER A
BEGIN TRAN
update Accounts
set balance = balance +500
where AccountID = 101
select * from Accounts
go
waitfor delay '00:00:10' 
update Accounts
set balance = balance +200
where AccountID = 101
select * from Accounts
COMMIT TRAN

-- ví dụ 3 (READ COMMITTED)
-- USER A
SET TRANSACTION ISOLATION LEVEL READ COMMITTED
--Không cho phép một transaction đọc dữ liệu mà transaction 
--khác đang update chưa hoàn tất; nhưng không bảo vệ
--transaction đọc dữ liệu (transaction khác có thể làm thay đổi
--dữ liệu đang được đọc )
--– Nguy cơ xảy ra nonrepeatable reads , hay phantom data
--– Là thiết lập default của SQL Server
--start transaction USER A
-- B chạy trước 
BEGIN TRAN
update Accounts
set balance = balance +500
where AccountID = 101
select * from Accounts
go
waitfor delay '00:00:10' 
update Accounts
set balance = balance +200
where AccountID = 101
select * from Accounts
COMMIT TRAN

--- Ví dụ 4 :
--REPEATABLE READ
--– Không cho phép một transaction update dữ liệu khi
--một transaction khác đang đọc
--– Chỉ bảo vệ data đang tồn tại, không ngăn được việc
--thêm dữ liệu mới => nguy cơ xảy ra phantom rows

-- USER A
SET TRANSACTION ISOLATION LEVEL READ COMMITTED
-- USER B chạy trước (*)


--start transaction USER A
BEGIN TRAN
update Accounts
set balance = balance +500
where AccountID = 101
select * from Accounts
go
waitfor delay '00:00:10' 
update Accounts
set balance = balance +200
where AccountID = 101
select * from Accounts
COMMIT TRAN
_---ví dụ 5 
-- 2 user cùng thiết lập , USER A chạy trước (*)
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ

--start transaction USER B
Begin tran
INSERT INTO Accounts
VALUES (453,2000)
Commit
select * from accounts

--- Ví dụ 6 
-- USER A thiết lập , USER A chạy trước (*)
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
--– Không cho phép một transaction update dữ liệu khi
--một transaction khác đang đọc, và ngăn việc thêm hay 
--xóa dòng khỏi tập dữ liệu
--– Là mức bảo vệ cao nhất , tránh được 4 vấn đề

--start transaction USER A
Begin tran
select * from Accounts 
waitfor delay '00:00:10' 
select * from Accounts 
Commit
----không lỗi phantom rows

















---Ví dụ 5 --• SERIALIZABLE
