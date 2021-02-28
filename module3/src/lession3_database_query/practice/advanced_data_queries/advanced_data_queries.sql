USE classicmodels;

-- hiển thị ra các sản phẩm có giá lớn hơn 56.76 và số lượng trong kho lớn hơn 10
SELECT productCode, productName, buyprice, quantityInStock 
	FROM products
    WHERE buyprice > 56.76 and quantityInStock > 10;
    
-- lấy productcode, productname và buyprice từ bảng products, textdescription từ bảng productlines với điều kiện giá mua nằm trong khoảng từ 56.76 đến 95.59. 
-- Bạn cần chọn dữ liệu từ cả hai bảng và đối chiếu các hàng bằng cách so sánh cột productline từ bảng sản phẩm với cột productline từ bảng productlines    
SELECT p.productCode, p.productName, p.buyprice, pl.textDescription -- 45
	FROM products p
	INNER JOIN productlines pl
	ON p.productline = pl.productline
	WHERE buyprice > 56.76 AND buyprice < 95.59;

-- Bây giờ nếu muốn hiển thị ra các sản phẩm có loại sản phẩm là Classic Cars hoặc nhà cung cấp là 'Min Lin Diecast'
SELECT productCode, productName, buyprice, quantityInStock, productVendor, productLine 
	FROM products 
	WHERE productLine = 'Classic Cars' OR productVendor = 'Min Lin Diecast';