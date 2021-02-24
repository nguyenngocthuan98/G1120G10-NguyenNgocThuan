create database bank;
use bank;

create table customers(
	customer_number int not null auto_increment primary key,
    fullname varchar(255) not null, 
    address varchar(255), 
    email varchar(255) not null, 
    phone varchar(50)
);

create table accounts(
	account_number int not null auto_increment primary key,
    account_type varchar(50) not null, 
    date_open date,
    balance float,
    cus_number int,
    foreign key(cus_number) references customers(customer_number)
);

create table transactions(
	tran_number int not null auto_increment primary key,
    account_number int not null,
    tran_date date,
    amounts float,
    descriptions varchar(255),
    foreign key(account_number) references accounts(account_number)
);
