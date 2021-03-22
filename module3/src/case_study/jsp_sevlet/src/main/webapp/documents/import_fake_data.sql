USE db_furama_casestudy;

insert into role(role_name) values	
    ("admin"),
    ("manager"),
    ("director"),
    ("employee");
    
insert into `position`(position_name) values
	("Receptionist"),
	("Serve"),
	("Expert"),
	("Supervision"),
	("Manager"),
	("Director");

insert into education_degree(education_degree_name) values 
    ("Intermediate"),
    ("College"),
    ("University"),
    ("Postgraduate");

insert into division(division_name) values 
	("Sale–Marketing"),
	("Administration"),
	("Serve"),
	("Manager");

insert into user(username, password) values	
    ("admin", "admin"), 
    ("guest_a1","1234"), 
    ("guest_a2","1234"), 
    ("guest_a3","1234"), 
	("guest_a4","1234"), 
	("guest_a11","1234"),
	("guest_a12","1234"),
	("guest_a51","1234"),
	("guest_a31","1234"), 
	("guest_a17","1234");
    
insert into user_role(role_id,username) values	
    (1,"admin"), 
    (2,"guest_a1"), 
    (3,"guest_a2"), 
    (4,"guest_a3"), 
    (4,"guest_a17"), 
	(4,"guest_a12"), 
    (2,"guest_a51"), 
    (4,"guest_a11"), 
    (4,"guest_a4"),
    (2,"guest_a31");

insert into attach_service(attach_service_name,attach_service_cost,attach_service_unit,attach_service_status) values 
	("Massage",20.0,"times","available"),
	("Karaoke",9.0,"hours","available"),
	("Food",10.0,"plates","available"),
	("Water",2.0,"bottles","available"),
	("Car rental",24.0,"times","not available");
    
insert into rent_type(rent_type_name,rent_type_cost) values 
    ("Rent by Hour",50.0),
    ("Rent by Day",500.0),
    ("Rent by Month",7000.0),
    ("Rent by Year",60000.0);
    
insert into service_type(service_type_name) values 
    ("Villa"),
    ("House"),
    ("Room"),
    ("Attach Service");
    
insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,
					standard_room,description_other_convenience,pool_area,number_of_floors)
values 	
    ("DV-2321","Villa6388",50,500.0,10,2,1,"VIP","6388-description",45.0,6),
	("DV-1524","House4581",38,300.0,8,2,2,"Normal","none",null,7),
	("DV-4215","Room1478",26,100.0,7,3,3,"","",null,null),
	("DV-8371","Villa9701",65,550.0,15,3,1,"Bussiness","9701-description",55.0,9),
	("DV-8964","House0207",30,285.0,7,1,2,"VIP","none",null,5),
    ("DV-4216","Room1478",26,100.0,7,3,3,"","",null,null),
	("DV-8372","Villa9701",65,550.0,15,3,1,"Bussiness","9701-description",55.0,9),
	("DV-8965","House0207",30,285.0,7,1,2,"VIP","none",null,5),
	("DV-5651","Room3417",25,125.0,11,4,3,"","",null,null);

    
insert into customer_type(customer_type_name) values 
    ("Diamond"),
    ("Platinum"),
    ("Gold"),
    ("Silver"),
    ("Member");

insert into employee(
	employee_name,position_id,education_degree_id,division_id,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,username)
	values 	("Griffin Nguyen",6,4,4,'1997-07-09','636502479087',900.0,'0340946511',"okita_seguin@gmail.com","Ap #649-6743 Tempor Av.","admin"),
			("Mccullough Nguyen",2,1,2,'1999-12-19','300189869',500.0,'0366174723',"niuav_88@gmail.com","885-1750 Aliquam Ave","guest_a2"),
			("Dawson",1,2,1,'1995-04-24','950605254',550.0,'84)+916280008',"eeoh4421@gmail.com","3989 Nibh Street","guest_a3"),
			("English Novacovic",2,3,1,'1992-05-06','304739678222',500.0,'0383957038','mivenha.uivainoi@gmail.com',"649-6743 Tempor Av.","guest_a1"),
			("Nuffman",5,2,4,'1993-09-20','894904724',930.0,'0387152490',"sed.sem@ac.co.uk","9528 Condimentum. Street","guest_a17"),
			("Logan",2,2,2,'1985-11-04','881487038169',520.0,'0302349770',"rcu@temporbibendum.com","8776 Velit. St.","guest_a12"),
			("Farmer",4,3,4,'1998-02-25','449220227094',700.0,'0309629590',"monalisa.928@gmail.com","P.O. Box 830, 1841 Bibendum. St.m","guest_a51"),
			("Fowler Long",1,1,1,'2000-09-24','744244903245',540.0,'0305241394',"hecman_hak@gmail.com","501 Tristique St","guest_a11"),
            ("Mccullough",6,3,4,'1995-10-17','202457884',930.0,'0914791104',"sed.sem.egestas@amet.org","181-2218 Vitae Rd","guest_a4"),
			("Solomon",3,4,2,'1994-01-27','970506787',860.0,'(84)+906820144',"per.inceptos@lectusjusto.net","771 Nam St.","guest_a31");
/*Receptionist-1, Serve-2, Expert-3, Supervision-4, Manager-5, Director-6*/

insert into customer(customer_id,customer_type_id,customer_name,customer_gender,customer_birthday,customer_id_card,customer_phone,customer_email,customer_address) values 	
	("KH-1561",1,"Jones",1,'1978-03-28',"657031416","84)+910950317","augue.scelerisque@aliquet.org","733-7305 Sapien Av."),
	("KH-7468",4,"Mcmillan",1,'1979-10-08',"142034984040","0913970994","sociis.natoque.penatibus@InfaucibusMorbi.org","8602 Quam. Avenue"),
	("KH-8628",5,"Mills",0,'1993-11-23',"840295514","0333225520","Mauris@gmail.com","Ap #858-8102 Massa Avenue"),
	("KH-4928",2,"Randolph",1,'1996-12-21',"146635887","0306688683","met.orci.Ut@gmail.com","P.O. Box 628, 6406 Praesent Rd."),
	("KH-6034",2,"Hutchinson",0,'1998-04-05',"575865625","0376817415","congue@gmail.com","Ap #145-1760 Eu Road"),
	("KH-6523",3,"Armstrong",1,'1999-08-05',"635267896","(84)+912124637","fringilla@gmail.com","339-1421 Commodo Ave"),
	("KH-5947",5,"Dunn",0,'1998-11-30',"811939805","0353281200","thuannguyen1998@gmail.com","Ap #380-9893 Massa. St."),
	("KH-4652",1,"Duke",1,'1985-02-01',"410205618","0353335126","bidong7385@gmail.com","Ap #129-7276 Sem Road"),
	("KH-5463",1,"Freeman",0,'1992-06-03',"261451644","0348335977","quis.accumsan.36@gmail.com","1756 Eleifend Road"),
	("KH-9898",4,"Hendricks",1,'1976-10-11',"490481946","0383734616","eogsatonhg@gmail.com","6634 Eleifend Avenue"),
	("KH-2352",2,"Workman",0,'1993-10-24',"472242358","84)+916280008","ha.lorem@codegym.vn","485-799 Sed Av."),
	("KH-8224",3,"Randolph Lewis",1,'1991-08-07',"518229396","0345002785","nguyenvanphuc0601@gmail.com","Ap #802-8988 A Rd."),
	("KH-4584",2,"Boyer",1,'1988-02-08',"384205491","0370553239","ipsum.ac.mi@gmail.com","Ap #623-9004 Venenatis Street"),
	("KH-4253",3,"Vasquez",1,'1988-12-21',"742972532","0378957744","ligula.tortor.nina@gmail.com","4810 Quam Road");

insert into contract(employee_id,customer_id,service_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money)
	values 	
    (2,"KH-4253","DV-2321",'2020-12-01','2021-02-26',1000,2000),
	(5,"KH-4584","DV-8964",'2019-01-25','2019-03-22',500,1000),
	(4,"KH-8224","DV-4215",'2018-08-01','2018-12-20',750,1500),
	(6,"KH-5947","DV-5651",'2021-01-01','2021-03-11',1500,2500),
	(1,"KH-1561","DV-1524",'2020-09-07','2021-04-16',2000,5000),
	(7,"KH-7468","DV-8965",'2016-11-23','2017-02-19',400,1000),
	(8,"KH-6034","DV-8372",'2017-05-23','2017-06-26',600,1200),
	(6,"KH-9898","DV-4216",'2020-06-14','2020-09-02',700,1000),
	(9,"KH-8628","DV-1524",'2018-10-17','2018-10-22',350,1000);

insert into contract_detail(contract_id,attach_service_id,quantity)
	values 	(2,4,1),(3,1,2),(1,2,1),(4,3,3),(6,5,2),(7,4,3),(8,1,2),
			(9,2,4),(1,3,2),(5,5,4),(4,4,5),(3,1,5),(2,2,1),(2,2,3),
            (3,1,2),(6,2,6),(8,2,4),(9,2,4),(4,2,4),(6,5,2),(7,1,4),
            (6,4,1),(3,4,4),(1,3,3);
/*1-9*/ /*1-5*/

