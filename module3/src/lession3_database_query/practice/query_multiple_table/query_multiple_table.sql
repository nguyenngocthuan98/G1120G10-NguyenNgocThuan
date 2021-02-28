USE classicmodels;

-- lấy customerNumber, customerName, phone, paymentDate, amount từ hai bảng customers và payments với điều kiện là các khách hàng sống ở thành phố Las Vegas
SELECT customers.customerNumber, customerName, phone, paymentDate, amount 
	FROM customers
	INNER JOIN payments
	ON customers.customerNumber = payments.customerNumber
	WHERE city = 'Las Vegas';
    
-- tìm tất cả các đơn hàng thuộc từng khách hàng, bạn có thể sử dụng mệnh đề LEFT JOIN
SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
	FROM customers
	LEFT JOIN orders
	ON customers.customerNumber = orders.customerNumber;
    
-- tìm tất cả khách hàng chưa đặt hàng bất kỳ sản phẩm nào
SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
	FROM customers 
    LEFT JOIN orders
	ON customers.customerNumber = orders.customerNumber
	WHERE orderNumber is null;