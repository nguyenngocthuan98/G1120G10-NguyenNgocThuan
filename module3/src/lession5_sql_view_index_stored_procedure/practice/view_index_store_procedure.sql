create database demo_lesson5;
use demo_lesson5;

create table products(
	Id int not null primary key,
	productCode varchar(50),
	productName varchar(50),
	productPrice int,
	productAmount int,
	productDescription varchar(50),
	productStatus varchar(50)
);

insert into products
	(Id, productCode, productName, productPrice, productAmount, productDescription, productStatus) values 
	(1,'procode1', 'Mercedes AMG', 100000, 100, 'Special Limited', 'able'),
	(2,'procode2', 'Lamborghini', 250000, 63, 'Super Limited', 'able'),
	(3,'procode3', 'Ferrari', 230000, 50, 'Super Limited', 'able'),
	(4,'procode4', 'Bugati', 1000000, 3, 'Super Limited', 'unable'),
	(5,'procode5', 'Audi RS', 100000, 100, 'Special Limited', 'able'),
	(6,'procode1', 'Mercedes', 100000, 500, 'Limited', 'able'),
	(7,'procode6', 'Vinfast President', 20000, 200, 'Limited', 'able'),
	(8,'procode7', 'BMW', 100000, 500, 'Limited', 'able'),
	(9,'procode1', 'Mercedes SL', 1200000, 2, 'Super Limited', 'unable');
select * from products;

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)    
alter table products add index idx_productCode(productCode);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table products add index idx_productInfo(productName, productPrice);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from products where productCode = 'procode1';
explain select * from products where productName = 'Mercedes%' or productPrice = 100000;
-- So sánh câu truy vấn trước và sau khi tạo index

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view product_view as
	select productCode, productName, productPrice, productStatus
	from products;
select * from product_view;

-- Tiến hành sửa đổi view
create or replace view product_view as
	select productCode, productName, productPrice, productDescription, productStatus
	from products
	where productPrice = 100000;
select * from product_view;
	
-- Tiến hành xoá view
drop view product_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER $$
create procedure getProduct()
begin
	select * from products;
end; $$
DELIMITER ;
call getProduct();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER $$
create procedure addProduce(
	in addId int,
	in addproductCode varchar(50),
	in addproductName varchar(50),
	in addproductPrice int,
	in addproductAmount int,
	in addproductDescription varchar(50),
	in addproductStatus varchar(50))
	begin
		insert into products(Id, productCode, productName, productPrice, productAmount, productDescription, productStatus) values
        (addId, addproductCode, addproductName, addproductPrice, addproductAmount, addproductDescription, addproductStatus);
    end; $$
DELIMITER ;
call addProduce(10,'procode7', 'BMW M-Sport Personalized', 220000, 1, 'Super Limited', 'unable');
call getProduct();

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER $$
create procedure updateProduct(
	in inputID int, 
    in updateproductCode varchar(50),
	in updateproductName varchar(50),
	in updateproductPrice int,
	in updateproductAmount int,
	in updateproductDescription varchar(50),
	in updateproductStatus varchar(50))
begin
	update products 
    set productCode = updateproductCode, 
		productName = updateproductName, 
		productPrice = updateproductPrice, 
        productAmount = updateproductAmount, 
        productDescription = updateproductDescription, 
		productStatus = updateproductStatus
	where Id = inputId;
end; $$
DELIMITER ;
call updateProduct(10,'procode7', 'BMW M-Sport', 125000, 200, 'Special Limited', 'able');
call getProduct();

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER $$
create procedure deleteProduct(in inputID int)
begin
	delete from products where Id = inputID;
end; $$
DELIMITER ;
call deleteProduct(10);
call getProduct();