USE classicmodels;

-- type IN
DELIMITER $$
CREATE PROCEDURE getCusById(IN cusNum int)
BEGIN
	SELECT * FROM customers WHERE customerNumber = cusNum;
END; $$
DELIMITER ;

CALL getCusById(175);

-- type OUT
DELIMITER $$
CREATE PROCEDURE GetCustomersCountByCity(IN in_city VARCHAR(50), OUT total INT)
BEGIN
	SELECT COUNT(customerNumber) INTO total FROM customers WHERE city = in_city;
END; $$
DELIMITER ;

CALL GetCustomersCountByCity('Lyon',@total);
SELECT @total as City;

-- type INOUT
DELIMITER $$
CREATE PROCEDURE SetCounter( INOUT counter INT,  inc INT)
BEGIN
	SET counter = counter + inc;
END; $$
DELIMITER ;
	-- Gọi store procedure:
SET @counter = 1;
CALL SetCounter(@counter,1);
SELECT @counter; -- 2

CALL SetCounter(@counter,1); 
SELECT @counter; -- 3

CALL SetCounter(@counter,5);
SELECT @counter; -- 8