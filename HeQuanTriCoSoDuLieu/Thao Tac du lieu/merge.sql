
create database Merge_data2
CREATE TABLE T3(col1 int Primary Key);
CREATE TABLE T4(col1 int  Primary Key);

insert into T3 values (1)
insert into T3 values (2)
insert into T4 values (1)
insert into T4 values (2)

SELECT T3.col1, T4.col1FROM T3 Inner Merge join T4 ON dbo.T3.col1 = dbo.T4.col1;

-----
CREATE TABLE dbo.BookInventory
(
  TitleID INT NOT NULL PRIMARY KEY,
  Title NVARCHAR(100) NOT NULL,
  Quantity INT NOT NULL
  CONSTRAINT Qutitydeft1 DEFAULT 0
);

 
CREATE TABLE dbo.BookOrder 
(
  TitleID INT NOT NULL PRIMARY KEY,
  Title NVARCHAR(100) NOT NULL,
  Quantity INT NOT NULL
  CONSTRAINT Qutitydeflt DEFAULT 0
); 
--- NHẬP DỮ LIỆU CHO BẢNG bằng design hoặc lệnh 
----Ví dụ Merge - WHEN MATCHED 

MERGE BookInventory bi
USING BookOrder bo
ON bi.TitleID = bo.TitleID
WHEN MATCHED THEN
  UPDATE
  SET bi.Quantity = bi.Quantity+bo.Quantity;
----Ví dụ Merge - WHEN MATCHED 
MERGE BookInventory bi
USING BookOrder bo
ON bi.TitleID = bo.TitleID
WHEN MATCHED AND
  bi.Quantity + bo.Quantity = 0 THEN
  DELETE
WHEN MATCHED THEN
  UPDATE
  SET bi.Quantity = bi.Quantity + bo.Quantity;

  ---
  SELECT * from BookOrder
  select * from BookInventory
  ---Ví dụ Merge -WHEN NOT MATCHED BY TARGET
 MERGE BookInventory bi
USING BookOrder bo
ON bi.TitleID = bo.TitleID
WHEN MATCHED AND
  bi.Quantity + bo.Quantity = 0 THEN DELETE
WHEN MATCHED THEN UPDATE
  SET bi.Quantity = bi.Quantity + bo.Quantity
WHEN NOT MATCHED BY TARGET THEN
  INSERT (TitleID, Title, Quantity)
  VALUES (bo.TitleID, bo.Title,bo.Quantity);


  ---
  MERGE BookInventory bi
USING BookOrder bo
ON bi.TitleID = bo.TitleID
WHEN MATCHED AND
  bi.Quantity + bo.Quantity = 0 THEN
  DELETE
WHEN MATCHED THEN
  UPDATE
  SET bi.Quantity = bi.Quantity + bo.Quantity;

  -----





  ---Ví dụ Merge -WHEN NOT MATCHED BY TARGET
  MERGE BookInventory bi
USING BookOrder bo
ON bi.TitleID = bo.TitleID
WHEN MATCHED AND
  bi.Quantity + bo.Quantity = 0 THEN DELETE
WHEN MATCHED THEN UPDATE
  SET bi.Quantity = bi.Quantity + bo.Quantity
WHEN NOT MATCHED BY TARGET THEN
  INSERT (TitleID, Title, Quantity)
  VALUES (bo.TitleID, bo.Title,bo.Quantity);

----Ví dụ Merge -WHEN NOT MATCHED BY SOURCE
MERGE BookInventory bi
USING BookOrder bo
ON bi.TitleID = bo.TitleID
WHEN MATCHED AND
  bi.Quantity + bo.Quantity = 0 THEN DELETE
WHEN MATCHED THEN UPDATE
  SET bi.Quantity = bi.Quantity + bo.Quantity
WHEN NOT MATCHED BY TARGET THEN
  INSERT (TitleID, Title, Quantity)
  VALUES (bo.TitleID, bo.Title,bo.Quantity);
  --Implementing the WHEN NOT MATCHED BY SOURCE
  MERGE BookInventory bi
USING BookOrder bo
ON bi.TitleID = bo.TitleID
WHEN MATCHED AND
  bi.Quantity + bo.Quantity = 0 THEN DELETE
WHEN MATCHED THEN UPDATE
  SET bi.Quantity = bi.Quantity + bo.Quantity
WHEN NOT MATCHED BY TARGET THEN
  INSERT (TitleID, Title, Quantity)
  VALUES (bo.TitleID, bo.Title,bo.Quantity)
WHEN NOT MATCHED BY SOURCE
  AND bi.Quantity = 0 THEN DELETE;
  ---
  select * from BookInventory
  select * from BookOrder
  ---