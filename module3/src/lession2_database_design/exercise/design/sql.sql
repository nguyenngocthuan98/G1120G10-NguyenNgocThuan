create database car_manage;
use car_manage;

create table customers(
	customerNumber int not null primary key,
    customerName varchar(50) not null,
    contactLastName varchar(50) not null,
    contactFirstName varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    postalCode varchar(15) not null,
    country varchar(50) not null,
    creditLimit double
);

create table orders(
	orderNumber int not null primary key,
    orderDate date not null,
    requiredDate date not null,
    shippedDate date,
    status varchar(15) not null,
    comments text,
    quantityOrdered int not null,
    priceEach double not null
);

create table payments(
	customerNumber int not null primary key,
    checkNumber varchar(50) not null,
    paymentDate date not null,
    amount double not null
);

create table products(
	productCode varchar(15) not null primary key,
    productName varchar(70) not null,
	productScale varchar(10) not null,
	productVendor varchar(50) not null,
	productDescription text not null,
	quantityInStock int not null,
	buyPrice double not null,
	MSRP double not null
);

create table productlines(
	productLine varchar(50) not null,
	textDescription text,
	image varchar(255)
);

create table employees(
	employeeNumber int not null primary key,
	lastName varchar(50) not null,
	firstName varchar(50) not null,
	email varchar(100) not null,
	jobTitle varchar(50) not null
);

create table offices(
	officeCode varchar(10) not null primary key,
	city varchar(50) not null,
	phone varchar(50) not null,
	addressLine1 varchar(50) not null,
	addressLine2 varchar(50),
	state varchar(50) not null,
	country varchar(50) not null,
	postalCode varchar(15) not null
);

alter table orders 
	add customerNumber int, 
	add foreign key(customerNumber) references customers(customerNumber); -- Customers - Orders (1: N)
    
alter table payments
	add customerNumber int, 
	add foreign key(customerNumber) references customers(customerNumber); -- Customers - Payments (1: N)
    
create table OrderDetails(
	orderNumber int not null,
    productCode varchar(15) not null,
    primary key(orderNumber, productCode),
    foreign key(orderNumber) references orders(orderNumber), -- Products – OrderDetails (1 : N)
    foreign key(productCode) references products(productCode) -- OrderDetails – Orders (N : 1)
); -- Products - Orders (N:M)

alter table products
	add productLine varchar(50) not null,
    add foreign key(productLine) references productlines(productLine); -- ProductLine - Products (1: N)
    
alter table employees
	add salesRepEmployeeNumber varchar(50) not null,
    add foreign key(salesRepEmployeeNumber) references customers(salesRepEmployeeNumber), -- Employees - Customers (1: N)
    add reportTo int,
	add foreign key(reportTo) references employees(reportTo), -- Employees - Employees (1: N)
    add officeCode varchar(10) not null,
    add foreign key(officeCode) references offices(officeCode); -- Offices - Employees (1: N)

