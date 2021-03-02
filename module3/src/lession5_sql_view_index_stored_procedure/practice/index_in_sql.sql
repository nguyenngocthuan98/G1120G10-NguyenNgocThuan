use classicmodels;

SELECT * FROM customers WHERE customerNumber = 175;  -- 0.031s

EXPLAIN SELECT * FROM customers WHERE customerNumber = 175; 
-- điều gì đang xảy ra và kiểu kết hợp (Join) nào đang diễn ra bên trong.

ALTER TABLE customers ADD INDEX idx_customerNumber(customerNumber);

EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;
-- possible_keys : Đưa ra những Index có thể sử dụng để query
-- key : và Index nào đang được sử dụng
-- key_len : Chiều dài của từng mục trong Index
-- ref : Cột nào đang sử dụng
-- rows : Số hàng (rows) mà MySQL dự đoán phải tìm
-- extra : Thông tin phụ, thật tệ nếu tại cột này là “using temporary” hay “using filesort”

SELECT * FROM customers WHERE customerNumber = 175; -- 0.0s

-- thêm Index cho những cột mà có thể có nhiều hơn 1 kết quả khi query
ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';

-- xoá chỉ mục trong bảng
ALTER TABLE customers DROP INDEX idx_full_name;