CREATE DATABASE RestaurantDB;

USE RestaurantDB;

CREATE TABLE empinfo (
	empid NVARCHAR(20) PRIMARY KEY,
	empname	NVARCHAR(30)	NOT NULL,
	sex NVARCHAR(10)	NOT NULL,
	position NVARCHAR(30) NOT NULL,
	address NVARCHAR(50),
	education NVARCHAR(20)
);
INSERT INTO empinfo VALUES ('mhl001', 'Tom', 'M', 'Boss', 'address01', 'PHD');
INSERT INTO empinfo VALUES ('mhl002', 'Jack', 'M', 'Manager', 'address02', 'Master');
INSERT INTO empinfo VALUES ('mhl003', 'Dave', 'M', 'Director', 'address03', 'Bachelor');
INSERT INTO empinfo VALUES ('mhl004', 'Eric', 'M', 'Director', 'address04', 'Bachelor');
INSERT INTO empinfo VALUES ('mhl005', 'Ben', 'M', 'Chief ', 'address05', '');
INSERT INTO empinfo VALUES ('mhl006', 'Bob', 'M', 'Chief', 'address06', '');
INSERT INTO empinfo VALUES ('mhl007', 'Edwin', 'M', 'Chief', 'address07', '');
INSERT INTO empinfo VALUES ('mhl008', 'Alice', 'F', 'Captain', 'address08', '');
INSERT INTO empinfo VALUES ('mhl009', 'Amy', 'F', 'Captain', 'address09', '');
INSERT INTO empinfo VALUES ('mhl010', 'Ted', 'M', 'Buyer', 'address10', '');
INSERT INTO empinfo VALUES ('mhl011', 'Wayne', 'M', 'Buyer', 'address11', '');
INSERT INTO empinfo VALUES ('mhl012', 'Candy', 'M', 'Cashier', 'address012', '');
INSERT INTO empinfo VALUES ('mhl013', 'Lily', 'M', 'Cashier', 'address013', '');
INSERT INTO empinfo VALUES ('mhl014', 'Emma', 'M', 'waitress', 'address014', '');
INSERT INTO empinfo VALUES ('mhl015', 'Grace', 'M', 'waitress', 'address015', '');


CREATE TABLE login (
	empid NVARCHAR(20) PRIMARY KEY,
	empname	NVARCHAR(30) NOT NULL,
	passwd NVARCHAR(20) NOT NULL,
	position NVARCHAR(30) NOT NULL
);
INSERT INTO login VALUES ('mhl001', 'Tom', 'mhl001', 'Boss');
INSERT INTO login VALUES ('mhl002', 'Jack', 'mhl002', 'Manager');
INSERT INTO login VALUES ('mhl003', 'Dave', 'mhl003', 'Director');
INSERT INTO login VALUES ('mhl004', 'Eric', 'mhl004', 'Director');
INSERT INTO login VALUES ('mhl012', 'Candy', 'mhl012', 'Cashier');
INSERT INTO login VALUES ('mhl013', 'Lily', 'mhl013', 'Cahshier');


CREATE TABLE menu (
	foodid NVARCHAR(10) PRIMARY KEY,
	foodname NVARCHAR(20) NOT NULL,
	price INT NOT NULL,
	type NVARCHAR(30)
);
INSERT INTO menu VALUES ('bbf', 'Babaofan', 15, 'ZS');
INSERT INTO menu VALUES ('cf', 'Chaofan', 10, 'ZS');
INSERT INTO menu VALUES ('cght', 'Chungenhuntun', 10, 'T');
INSERT INTO menu VALUES ('cj', 'Chunjuan', 5, 'ZS');
INSERT INTO menu VALUES ('csb', 'Chashaobao', 2, 'ZS');
INSERT INTO menu VALUES ('tlhs', 'Talianhuoshao', 5, 'ZS');
INSERT INTO menu VALUES ('gbjd', 'Gongbaojiding', 15, 'RC');
INSERT INTO menu VALUES ('hlsm', 'Hualianshaomai', 10, 'ZS');
INSERT INTO menu VALUES ('hyb', 'Heyebin', 5, 'ZS');
INSERT INTO menu VALUES ('hzz', 'Haozaizou', 20, 'T');
INSERT INTO menu VALUES ('hzzz', 'Huzhouzhongzi', 3, 'ZS');
INSERT INTO menu VALUES ('mms', 'Meimaosu', 15, 'ZS');
INSERT INTO menu VALUES ('sb', 'Suibin', 10, 'ZS');
INSERT INTO menu VALUES ('stb', 'Shoutaobao', 2, 'ZS');
INSERT INTO menu VALUES ('szm', 'Saozimian', 10, 'ZS');
INSERT INTO menu VALUES ('ty', 'Tangyuan', 5, 'TD');
INSERT INTO menu VALUES ('ysj', 'Yinjuansi', 10, 'TD');
INSERT INTO menu VALUES ('yxrs', 'Yuxiangrousi', 15, 'CC');
INSERT INTO menu VALUES ('dkl', 'Dakele', 10, 'YL');
INSERT INTO menu VALUES ('xkl', 'Xiaokele', 3, 'YL');
INSERT INTO menu VALUES ('jlf', 'Jinliufu', 50, 'YL');
INSERT INTO menu VALUES ('xhtx', 'Xiaohutuxian', 60, 'YL');
INSERT INTO menu VALUES ('ccgh', 'Changchengganhong', 100, 'YL');
INSERT INTO menu VALUES ('dfd', 'Dafenda', 10, 'YL');
INSERT INTO menu VALUES ('xfd', 'Xiaofenda', 3, 'TL');



CREATE TABLE costnum (
	foodid NVARCHAR(10) PRIMARY KEY,
	foodname NVARCHAR(20) NOT NULL,
	materials NVARCHAR(30),
	matscost INT,
	matsnum INT
);
INSERT INTO costnum VALUES ('bbf', 'Babaofan八宝饭', '', 10, 2);
INSERT INTO costnum VALUES ('cf', 'Chaofan', '', 8, 5);
INSERT INTO costnum VALUES ('cght', 'Chungenhuntun', '', 10, 5);
INSERT INTO costnum VALUES ('cj', 'Chunjuan', '', 5, 3);
INSERT INTO costnum VALUES ('csb', 'Chashaobao', '', 2, 5);
INSERT INTO costnum VALUES ('dlhs', 'Talianhuoshao', '', 5, 6);
INSERT INTO costnum VALUES ('gbjd', 'Gongbaojiding', '', 15, 7);
INSERT INTO costnum VALUES ('hlsm', 'Hualianshaomai', '', 10, 5);
INSERT INTO costnum VALUES ('hyb', 'Heyebin', '', 5, 8);
INSERT INTO costnum VALUES ('hzz', 'Haozaizou', '', 20, 4);
INSERT INTO costnum VALUES ('hzzz', 'Huzhouzhongzi', '', 3, 7);
INSERT INTO costnum VALUES ('mms', 'Meimaosu', '', 15, 4);
INSERT INTO costnum VALUES ('sb', 'Suibin', '', 10, 8);
INSERT INTO costnum VALUES ('stb', 'Shoutaobao', '', 2, 4);
INSERT INTO costnum VALUES ('szm', 'Saozimian', '', 10, 7);
INSERT INTO costnum VALUES ('ty', 'Tangyuan', '', 5, 3);
INSERT INTO costnum VALUES ('ysj', 'Yinjuansi', '', 10, 5);
INSERT INTO costnum VALUES ('yxls', 'Yuxiangrousi', '', 15, 5);
INSERT INTO costnum VALUES ('dkl', 'Dakele', '', 10, 8);
INSERT INTO costnum VALUES ('xkl', 'Xiaokele', '', 3, 8);
INSERT INTO costnum VALUES ('jlf', 'Jinliufu', '', 50, 8);
INSERT INTO costnum VALUES ('xhtx', 'Xiaohutuxian', '', 60, 8);
INSERT INTO costnum VALUES ('ccgh', 'Changchengganhong', '', 100, 3);
INSERT INTO costnum VALUES ('dfd', 'Dafenda', '', 10, 8);
INSERT INTO costnum VALUES ('xfd', 'Xiaofenda', '', 3, 8);


CREATE TABLE status (
	deskid NVARCHAR(10),
	deskstatus INT DEFAULT 0
);


CREATE TABLE bookdish (
	deskid NVARCHAR(10),
	bookid NVARCHAR(10)
);


CREATE TABLE bookdetail (
	deskid NVARCHAR(10),
	bookid NVARCHAR(10),
	foodid NVARCHAR(10),
	foodnum NVARCHAR(2)
);


CREATE TABLE orderdesk (
	deskid NVARCHAR(10),
	customname NVARCHAR(30),
	tel NVARCHAR(15),
	num INT,
	ordertime NVARCHAR(50)
);



























