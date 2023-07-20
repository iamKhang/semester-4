use 
--- insert 
create table SPMOI2 (Masp int, tensp nvarchar(40))
INSERT SPMOI2(Od.Masp, P.Tensp)
	SELECT distinct  od.ProductID, p.ProductName
	FROM Products as P INNER JOIN [Order Details]  Od ON P.ProductID = Od.ProductID
Select * from SPMOI2


--- update 
UPDATE [Order Details]
	SET UnitPrice=UnitPrice+0.1*UnitPrice
WHERE ProductID<5

----
UPDATE [Order Details]
SET unitprice=
( SELECT UnitPrice+0.2*UnitPrice  FROM Products) where ProductID=2
