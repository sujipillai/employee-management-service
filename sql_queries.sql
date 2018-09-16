create table `mydb.employeedetails`  (id int(11) NOT NULL AUTO_INCREMENT, 
userName varchar(20) DEFAULT NULL, department varchar(10) DEFAULT NULL, 
salary varchar(10) DEFAULT NULL, role varchar(20) DEFAULT NULL, PRIMARY KEY (`id`));

insert into mydb.employeedetails(userName, department, salary, role) 
values ('suji', 'Engg', '25000', 'ADMIN');

insert into mydb.employeedetails(userName, department, salary, role) 
values ('test', 'Engg', '22000', 'SUPER_EMPLOYEE');
insert into mydb.employeedetails(userName, department, salary, role)
 values ('test2', 'HR', '2000', 'EMPLOYEE');

update employeedetails
set userName = 'Pooja', department='Engg', salary='253', role='ADMIN' where id=3;
CREATE TABLE mydb.loginuser (loginid  int(11) NOT NULL AUTO_INCREMENT, userName varchar(40) DEFAULT NULL, password VARCHAR(45) DEFAULT NULL, role VARCHAR(25) DEFAULT NULL, ip VARCHAR(40) DEFAULT NULL, PRIMARY KEY (`loginid`));

insert into loginuser( userName, password, role, ip) values ('suji', 'suji', 'ADMIN', '0:0:0:0:0:0:0:1');
insert into loginuser( userName, password, role, ip)
values ('test', 'test', 'SUPER_EMPLOYEE','0:0:0:0:0:0:0:1');
insert into loginuser( userName, password, role, ip) 
 values ('test2', 'HR', 'EMPLOYEE','0:0:0:0:0:0:0:1');

