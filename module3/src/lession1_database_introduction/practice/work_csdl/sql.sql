use classicmodels;
select * from customers;
select * from customers where customerName = 'Atelier graphique';
select * from customers where customerName like '%At%';
select * from customers where city in('Nantes', 'Las Vegas', 'Warszawa', 'NYC');
select * from orders where orderNumber between 10100 and 10110;
select * from orders where orderDate <= '2003-03-03' and status like 'shipped';
