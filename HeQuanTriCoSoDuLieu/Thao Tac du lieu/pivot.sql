create database tam2
use tam2 
CREATE TABLE pvt (VendorID INT, Emp1 INT, Emp2 INT,  
    Emp3 INT, Emp4 INT, Emp5 INT);  
CREATE TABLE orders (VendorID INT,Quantity int );  
GO  
INSERT INTO pvt VALUES (1,4,3,5,4,4);  
INSERT INTO pvt VALUES (2,4,1,5,5,5);  
INSERT INTO pvt VALUES (3,4,3,5,4,4);  
INSERT INTO pvt VALUES (4,4,2,5,5,4);  
INSERT INTO pvt VALUES (5,5,1,5,5,5);  

insert into orders values (1,5)
insert into orders values (1,15)
insert into orders values (2,5)
insert into orders values (2,25)
GO  
---- tao pivot tren orders


SElect  [1],[2],[3],[4]
FROM (SELECT VendorID,Quantity from orders) AS DD
PIVOT(SUM(quantity) FOR vendorID    IN([1], [2], [3], [4])) AS P;
---
select * from orders
select * from pvt

---pivot tren pvt 
SElect  [1],[2],[3],[4],[5]
FROM (SELECT VendorID,emp2 from pvt) AS DD
PIVOT(SUM(emp2) FOR vendorID    IN([1], [2], [3], [4],[5])) AS P;

-- Unpivot the table.  
SELECT VendorID, Employee, Orders  
FROM   
   (SELECT VendorID, Emp1, Emp2, Emp3, Emp4, Emp5  
   FROM pvt) p  
UNPIVOT  
   (Orders FOR Employee IN   
      (Emp1, Emp2, Emp3, Emp4, Emp5)  
)AS unpvt;  
GO  