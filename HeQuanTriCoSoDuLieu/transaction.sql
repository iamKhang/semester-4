create table taikhoanA(
	sotien money 
CONSTRAINT chksotien check (sotien > 0)
)

create table taikhoanB(
	sotien money 
CONSTRAINT chksotienB check (sotien > 0)
)

insert into taikhoanA(sotien)
values (20000)

insert into taikhoanB(sotien)
values (10000)


go
declare @no money
set @no = 100
begin transaction
 update taikhoanA
 set sotien = sotien - @no
 update taikhoanB
 set sotien = sotien + @no
commit transaction
go

select * from taikhoanA
select * from taikhoanB

