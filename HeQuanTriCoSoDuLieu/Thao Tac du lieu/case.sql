use Northwind
---vid u 1 

Select ProductName, Unitprice, 
	'Classification'=CASE
				when Unitprice<10 then 'Low price'
				When Unitprice Between 10 and 20 then 	'Moderately Price'
				when Unitprice>20 then 'Expensive'
				else 'Unknown'
	end
From Products


-- vid du 2 
Select productid, Quantity, UnitPrice, [discount%]=
	CASE
		When Quantity <=5 then 0.05
		When Quantity between 6 and 10 then 0.07
		When Quantity between 11 and 20 then 0.09
	Else 0.1
	end
	From [Order Details]
	Order by Quantity, Productid	
