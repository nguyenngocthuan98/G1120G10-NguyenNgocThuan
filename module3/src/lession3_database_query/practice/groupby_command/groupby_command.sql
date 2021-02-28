USE classicmodels;

-- trả về hiển thị các trạng thái khác nhau của đơn hàng
SELECT status FROM orders GROUP BY status;

-- có bao nhiêu đơn đặt hàng trong mỗi trạng thái, chúng ta có thể sử dụng hàm COUNT với mệnh đề GROUP BY
SELECT status, COUNT(*) AS amount
	FROM orders
	GROUP BY status;
    
-- tính tổng số tiền của các đơn hàng theo trạng thái đặt hàng. 
-- Ta sẽ sử dụng lệnh inner join để kết nối 2 bảng và sử dụng hàm sum để tính tổng số tiền, nhóm theo trường status
SELECT status, sum(quantityOrdered * priceEach) AS amount
	FROM orders 
	INNER JOIN orderdetails 
    ON orders.ordernumber = orderdetails.ordernumber
	GROUP BY status;
    
-- tính tổng tiền của từng đơn hàng
SELECT orderNumber, sum(quantityOrdered * priceEach) AS total
	FROM orderdetails
	GROUP BY orderNumber;

-- lọc các nhóm được trả về bởi mệnh đề GROUP BY, chúng ta sử dụng mệnh đề HAVING
-- sử dụng mệnh đề HAVING để bao gồm tổng doanh thu của những năm lớn hơn năm 2003.
SELECT year(orderDate) AS year, sum(quantityOrdered * priceEach) AS total
	FROM orders 
	INNER JOIN orderdetails 
    ON orders.orderNumber = orderdetails.orderNumber
	WHERE status = 'shipped'
	GROUP BY year
	HAVING year > 2003;