create table `mydb.employeedetails`  (id int(11) NOT NULL AUTO_INCREMENT, userName varchar(20) DEFAULT NULL, department varchar(10) DEFAULT NULL, salary varchar(10) DEFAULT NULL, role varchar(20) DEFAULT NULL, PRIMARY KEY (`id`));

CREATE TABLE mydb.loginuser (loginid  int(11) NOT NULL AUTO_INCREMENT, userName varchar(40) DEFAULT NULL, password VARCHAR(45) DEFAULT NULL, role VARCHAR(25) DEFAULT NULL, ip VARCHAR(40) DEFAULT NULL, PRIMARY KEY (`loginid`));

insert into loginuser( userName, password, role, ip) values ('suji', 'suji', 'ADMIN', '0:0:0:0:0:0:0:1');

