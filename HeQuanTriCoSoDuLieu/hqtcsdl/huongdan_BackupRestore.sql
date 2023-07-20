--Hướng dẫn Module 8. BACKUP VÀ RESTORE DATABASE  
--##################################################
--1. Các loại backup : xem lại lý thuyết (quan trọng)
----Full  backup 
----Differential backup
----Transaction Log Backup

--2. Recovery (restore ): phục hồi database dựa trên các bản backup đã có 
-- 1 nguyên tắc : 
--  giả định là database bị hư hỏng (ko thể truy suất) / bị xóa (các file mdf, ndf, ldf bị  xóa)
--  => buộc phải có tối thiểu 1 full backup 
--  => lệnh restore đầu tiên luôn luôn là restore từ bản Full backup  

--3.Chọn Recovery Mode (?) 
----Simple Recovery model  : cho phép thực hiện full+differential backup
----Full Recovery model    : cho phép thực hiện full backup + differential backup + log backup

--=========================================================================
---------------------------------------------------------------------------

--1. Trong SQL Server, tạo thiết bị backup có tên adv2008back lưu trong thư mục
--T:\backup\adv2008back.bak

EXEC sp_addumpdevice 'disk', 'adv2008back', 't:\adv2008back.bak';  ---???
--hoặc dùng tool (Object Explorer)
--...
EXEC sp_dropdevice 'adv2008back'
go

--2. Attach CSDL AdventureWorks2008, 
--chọn mode recovery cho CSDL này là full, rồi thực hiện full backup vào thiết bị backup vừa tạo

use master
go
ALTER DATABASE AdventureWorks2012 SET RECOVERY FULL;    
GO  
--t1
BACKUP DATABASE AdventureWorks2012    --ghi lại File = ? 1
TO   adv2008back
WITH FORMAT;  

--tương đương
--BACKUP DATABASE AdventureWorks2012   
--TO DISK = 'F:\data\AdventureWorks2012.bak'   
--WITH FORMAT;  

go
--3. Mở CSDL AdventureWorks2008, tạo một transaction giảm giá tất cả mặt hàng xe
--đạp trong bảng Product xuống $15 nếu tổng trị giá các mặt hàng xe đạp không thấp
--hơn 60%.
--4. Tạo 1 differential backup
use AdventureWorks2012
go
begin tran
update Production.Product set name = 'ttt' where ProductID =1
commit
go
---t2
BACKUP DATABASE AdventureWorks2012   --ghi lại File = ? 2
TO adv2008back
WITH DIFFERENTIAL;  



--5. Xóa mọi bản ghi trong bảng Person.EmailAddress, 
-- tạo 1 transaction log backup
delete from person.EmailAddress

--t3
BACKUP DATABASE AdventureWorks2012   --ghi lại File = ? 3
TO adv2008back
WITH DIFFERENTIAL;  

go
drop table person.EmailAddress

go
--t4
BACKUP  LOG  AdventureWorks2012    --ghi lại File = ?  4
TO adv2008back

--6a. Bổ sung thêm 1 số phone mới cho nhân viên có mã số business là 10000 như
--sau:
INSERT INTO Person.PersonPhone VALUES (10000,'123-456-
7890',1,GETDATE())
--6b. Sau đó tạo 1 differential backup cho AdventureWorks2008 và lưu vào thiết bị
--backup vừa tạo.

--t5
BACKUP DATABASE AdventureWorks2012   --ghi lại File = ?  5
TO adv2008back
WITH DIFFERENTIAL;  
--6c. Đợi 1 phút sau, xóa bảng Sales.ShoppingCartItem

--7. Xóa CSDL AdventureWorks2008
use master
go
drop database AdventureWorks2012
go


--8. phuc hoi ve thoi diem t2
---b1 :Restore dựa trên bản full backup  (FILE =1 )
RESTORE DATABASE  AdventureWorks2012   
FROM adv2008back
WITH  FILE=1 ,  NORECOVERY ;				---NORECOVERY --- đang trong tiến trình recovery
go
---b2 :Restore dựa trên bản differential backup (FILE =2 )
RESTORE DATABASE  AdventureWorks2012   
FROM adv2008back 
WITH  FILE=2 ,  RECOVERY ;	



--8. phuc hoi ve thoi diem t5
go
drop database AdventureWorks2012
---b1 :Restore dựa trên bản full backup  (FILE =1 )
RESTORE DATABASE  AdventureWorks2012   
FROM adv2008back
WITH  FILE=1 ,  NORECOVERY ;				---NORECOVERY --- đang trong tiến trình recovery
go
---b2 :Restore dựa trên bản differential backup (FILE =5 )
RESTORE DATABASE  AdventureWorks2012   
FROM adv2008back 
WITH  FILE=5 ,  RECOVERY ;	


--8. phuc hoi ve thoi diem t4
drop database AdventureWorks2012
---b1 :Restore dựa trên bản full backup  (FILE =1 )
RESTORE DATABASE  AdventureWorks2012   
FROM adv2008back
WITH  FILE=1 ,  NORECOVERY ;				---NORECOVERY --- đang trong tiến trình recovery
go
---b2 :Restore dựa trên bản differential backup (FILE =3 )
RESTORE DATABASE  AdventureWorks2012   
FROM adv2008back 
WITH  FILE=3 ,  NORECOVERY ;	
	
---b3
RESTORE LOG  AdventureWorks2012   
FROM adv2008back
WITH  FILE=4 ,  RECOVERY ;						----- end	

--test ....
--??

--đọc thông tin file log ?

