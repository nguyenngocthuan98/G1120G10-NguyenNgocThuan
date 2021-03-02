USE classicmodels;

-- Tạo View 
CREATE VIEW customer_views AS
	SELECT customerNumber, customerName, phone
	FROM  customers;
	-- Kết quả, ta sẽ có 1 bảng ảo customer_views, và sau đó chúng ta hoàn toàn có thể lấy dữ liệu từ bảng ảo này bằng lệnh:
SELECT * FROM customer_views;

-- Cập nhật view (có điều kiện mới đc cập nhật)
CREATE OR REPLACE VIEW customer_views AS
	SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
	FROM customers
	WHERE city = 'Nantes';
SELECT * FROM customer_views;

-- Xoá view
DROP VIEW customer_views;