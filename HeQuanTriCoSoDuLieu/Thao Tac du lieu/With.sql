use AdventureWorks2008R2

WITH SumSale2 AS
(SELECT SUM(TotalDue) AS SumTotalDue,
CustomerID
FROM Sales.SalesOrderHeader
GROUP BY CustomerID)

SELECT o.CustomerID, TotalDue,
TotalDue / SumTotalDue * 100 AS PercentOfSales
FROM SumSale2 INNER JOIN Sales.SalesOrderHeader AS o
ON SumSale2.CustomerID = o.CustomerID
ORDER BY CustomerID;
