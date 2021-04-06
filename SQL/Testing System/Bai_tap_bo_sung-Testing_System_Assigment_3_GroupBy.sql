-- Create Database --
DROP DATABASE IF EXISTS Testing_System_Assigment3_GroupBy;
CREATE DATABASE IF NOT EXISTS Testing_System_Assigment3_GroupBy;
USE Testing_System_Assigment3_GroupBy;

/*============================== CREATE TABLE=== =======================================*/
/*======================================================================================*/
-- Create Table 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE IF NOT EXISTS Department(
	DepartmentID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	DepartmentName VARCHAR(30) NOT NULL UNIQUE KEY
);

-- Add data Department - Bảng phòng ban
INSERT INTO Department(DepartmentName)
VALUES
       ('Marketing'),
       ('Sale'),
       ('Bảo vệ'),
       ('Nhân sự'),
       ('Kỹ thuật'),
       ('Tài chính'),
       ('Phó giám đốc'),
       ('Giám đốc'),
       ('Tài vụ'),
       ('Kế toán');

-- Create table 2: Position - Bảng chức danh
DROP TABLE IF EXISTS `Position`;
CREATE TABLE IF NOT EXISTS `Position`
(
    PositionID   TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName ENUM ('Dev','Test','Scrum Master','PM', 'Mentor', 'Supporter','Leader') NOT NULL UNIQUE KEY
);

-- Add data Position
INSERT INTO `Position` (PositionName)
VALUES 
	   ('Dev'),
       ('Test'),
       ('Scrum Master'),
       ('Supporter'),
       ('Leader'),
       ('Mentor'),
       ('PM');

-- Create table 3: Account -
DROP TABLE IF EXISTS `Account`;
CREATE TABLE IF NOT EXISTS `Account`
(
    AccountID    INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email        VARCHAR(50) NOT NULL UNIQUE KEY,
    Username     VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName     VARCHAR(50) NOT NULL,
    DepartmentID INT UNSIGNED NOT NULL,
    PositionID   INT UNSIGNED NOT NULL,
    CreateDate   DATETIME
#     FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID) ON DELETE NO ACTION,
#     FOREIGN KEY (PositionID) REFERENCES `Position` (PositionID)
);

-- Insert Data Account
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (1, 'cdansey0', 'Calv Dansey', 'cdansey0@boston.com', 9, 4, '2021-02-19');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (2, 'erounsefell1', 'Eloise Rounsefell', 'erounsefell1@etsy.com', 8, 7, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (3, 'bdunrige2', 'Brod Dunrige', 'bdunrige2@seattletimes.com', 8, 4, '2020-07-06');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (4, 'vhartropp3', 'Vincent Hartropp', 'vhartropp3@china.com.cn', 3, 6, '2021-02-17');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (5, 'ccoolahan4', 'Claudio Coolahan', 'ccoolahan4@washingtonpost.com', 5, 2, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (6, 'bhuxtable5', 'Boigie Huxtable', 'bhuxtable5@xing.com', 5, 7, '2020-05-04');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (7, 'mswaile6', 'Mattias Swaile', 'mswaile6@liveinternet.ru', 5, 3, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (8, 'febunoluwa7', 'Fernande Ebunoluwa', 'febunoluwa7@desdev.cn', 4, 1, '2021-01-16');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (9, 'gsextone8', 'Gabrila Sextone', 'gsextone8@rediff.com', 8, 3, '2020-12-23');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (10, 'mitzkov9', 'Mabelle Itzkov', 'mitzkov9@cam.ac.uk', 3, 7, '2021-01-21');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (11, 'hmacgorleya', 'Hildagard MacGorley', 'hmacgorleya@list-manage.com', 9, 6, '2020-09-08');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (12, 'mblinckob', 'Margalit Blincko', 'mblinckob@yolasite.com', 6, 5, '2020-06-05');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (13, 'rhumphrisc', 'Roarke Humphris', 'rhumphrisc@lycos.com', 9, 1, '2021-01-08');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (14, 'tstoterd', 'Tonya Stoter', 'tstoterd@cbc.ca', 1, 2, '2020-11-29');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (15, 'zvenne', 'Zara Venn', 'zvenne@hc360.com', 1, 2, '2020-08-29');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (16, 'ocaseleyf', 'Ofilia Caseley', 'ocaseleyf@unc.edu', 7, 2, '2020-09-28');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (17, 'kfrostdickg', 'Kattie Frostdick', 'kfrostdickg@ihg.com', 5, 1, '2020-11-13');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (18, 'ghazeldeneh', 'Giulia Hazeldene', 'ghazeldeneh@google.es', 3, 7, '2020-05-18');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (19, 'tstichalli', 'Tully Stichall', 'tstichalli@bing.com', 2, 6, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (20, 'ewittj', 'Ernestus Witt', 'ewittj@ocn.ne.jp', 2, 3, '2021-03-29');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (21, 'cvarfalameevk', 'Clara Varfalameev', 'cvarfalameevk@ftc.gov', 4, 6, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (22, 'bjoveyl', 'Babbette Jovey', 'bjoveyl@census.gov', 10, 5, '2020-04-19');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (23, 'anassaum', 'Antonietta Nassau', 'anassaum@ted.com', 7, 7, '2021-03-18');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (24, 'cbarabischn', 'Craggy Barabisch', 'cbarabischn@prnewswire.com', 5, 5, '2020-10-17');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (25, 'rsinnato', 'Ruperto Sinnat', 'rsinnato@merriam-webster.com', 5, 2, '2021-01-05');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (26, 'gmacleesep', 'Genny MacLeese', 'gmacleesep@surveymonkey.com', 3, 6, '2020-10-16');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (27, 'yhoundsomq', 'Yasmin Houndsom', 'yhoundsomq@facebook.com', 9, 3, '2020-06-29');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (28, 'rgrisenthwaiter', 'Rudolfo Grisenthwaite', 'rgrisenthwaiter@altervista.org', 1, 4, '2021-02-17');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (29, 'nduigeds', 'Norina Duiged', 'nduigeds@webnode.com', 6, 4, '2020-08-07');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (30, 'gohmst', 'Glynda Ohms', 'gohmst@mit.edu', 6, 3, '2020-05-17');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (31, 'sbackhouseu', 'Sallee Backhouse', 'sbackhouseu@sfgate.com', 4, 1, '2020-04-25');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (32, 'kgroobyv', 'Kacey Grooby', 'kgroobyv@europa.eu', 6, 4, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (33, 'stippertonw', 'Sallyanne Tipperton', 'stippertonw@plala.or.jp', 10, 1, '2020-08-24');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (34, 'bcoweyx', 'Bryn Cowey', 'bcoweyx@answers.com', 3, 7, '2020-11-29');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (35, 'pradkey', 'Pedro Radke', 'pradkey@umn.edu', 8, 1, '2021-03-17');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (36, 'rdevonz', 'Rikki Devon', 'rdevonz@eepurl.com', 9, 6, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (37, 'csangwine10', 'Clemmy Sangwine', 'csangwine10@hc360.com', 2, 6, '2020-07-22');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (38, 'ljina11', 'Leah Jina', 'ljina11@elpais.com', 9, 5, '2021-03-16');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (39, 'btrumpeter12', 'Barney Trumpeter', 'btrumpeter12@vkontakte.ru', 5, 4, '2021-03-10');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (40, 'hhanigan13', 'Haskel Hanigan', 'hhanigan13@over-blog.com', 2, 6, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (41, 'aensley14', 'Abby Ensley', 'aensley14@jiathis.com', 5, 7, '2020-08-26');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (42, 'rlifsey15', 'Reinhold Lifsey', 'rlifsey15@flavors.me', 2, 2, '2020-07-05');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (43, 'pbycraft16', 'Paddie Bycraft', 'pbycraft16@lycos.com', 6, 6, '2020-11-14');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (44, 'cinworth17', 'Carver Inworth', 'cinworth17@ucla.edu', 4, 7, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (45, 'mliddyard18', 'Marj Liddyard', 'mliddyard18@simplemachines.org', 10, 1, '2020-11-04');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (46, 'mgrishelyov19', 'Mathias Grishelyov', 'mgrishelyov19@china.com.cn', 1, 7, '2021-02-07');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (47, 'wgarlant1a', 'Werner Garlant', 'wgarlant1a@cnn.com', 8, 3, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (48, 'croyle1b', 'Coreen Royle', 'croyle1b@youtube.com', 7, 1, '2020-05-24');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (49, 'bdebill1c', 'Burr Debill', 'bdebill1c@wordpress.org', 7, 3, '2021-03-29');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (50, 'atant1d', 'Anica Tant', 'atant1d@icq.com', 10, 1, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (51, 'emorefield1e', 'Ellerey Morefield', 'emorefield1e@census.gov', 10, 2, '2020-06-18');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (52, 'lscanes1f', 'Lia Scanes', 'lscanes1f@nps.gov', 6, 5, '2020-09-11');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (53, 'kballham1g', 'Kary Ballham', 'kballham1g@dailymotion.com', 9, 5, '2020-11-01');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (54, 'creeves1h', 'Carma Reeves', 'creeves1h@wiley.com', 9, 1, '2021-01-25');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (55, 'vcharlick1i', 'Valera Charlick', 'vcharlick1i@about.me', 5, 7, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (56, 'afrostdicke1j', 'Audy Frostdicke', 'afrostdicke1j@geocities.jp', 4, 6, '2020-08-24');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (57, 'dwheelan1k', 'Demott Wheelan', 'dwheelan1k@ocn.ne.jp', 8, 5, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (58, 'groffey1l', 'Gian Roffey', 'groffey1l@bravesites.com', 1, 4, '2020-08-29');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (59, 'npenk1m', 'Norean Penk', 'npenk1m@storify.com', 5, 1, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (60, 'dgartan1n', 'Dane Gartan', 'dgartan1n@walmart.com', 5, 1, '2021-03-13');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (61, 'kcuddehy1o', 'Kippy Cuddehy', 'kcuddehy1o@virginia.edu', 2, 5, '2020-09-05');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (62, 'ecreggan1p', 'Etta Creggan', 'ecreggan1p@multiply.com', 6, 1, '2020-05-09');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (63, 'gpanther1q', 'Gael Panther', 'gpanther1q@flavors.me', 10, 7, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (64, 'ebillion1r', 'Elvira Billion', 'ebillion1r@google.com.hk', 7, 3, '2020-05-01');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (65, 'agrinishin1s', 'Ariadne Grinishin', 'agrinishin1s@independent.co.uk', 10, 3, '2020-06-11');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (66, 'hdraper1t', 'Helenelizabeth Draper', 'hdraper1t@mail.ru', 8, 3, '2020-04-27');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (67, 'jway1u', 'Jennee Way', 'jway1u@studiopress.com', 1, 7, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (68, 'abartlomiej1v', 'Andria Bartlomiej', 'abartlomiej1v@mysql.com', 6, 4, '2020-09-27');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (69, 'tpilfold1w', 'Tull Pilfold', 'tpilfold1w@senate.gov', 10, 6, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (70, 'dhandrek1x', 'Dov Handrek', 'dhandrek1x@reddit.com', 4, 1, '2020-08-13');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (71, 'rbrookhouse1y', 'Roslyn Brookhouse', 'rbrookhouse1y@sogou.com', 1, 6, '2020-08-11');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (72, 'nbourley1z', 'Nappy Bourley', 'nbourley1z@geocities.com', 7, 3, '2020-09-28');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (73, 'dcosser20', 'Davine Cosser', 'dcosser20@arizona.edu', 6, 3, '2021-01-06');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (74, 'hcleft21', 'Harrison Cleft', 'hcleft21@google.it', 4, 1, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (75, 'cgoodge22', 'Camala Goodge', 'cgoodge22@google.nl', 1, 4, '2020-12-14');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (76, 'llownie23', 'Layton Lownie', 'llownie23@webnode.com', 5, 7, '2021-03-10');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (77, 'brawcliffe24', 'Brunhilde Rawcliffe', 'brawcliffe24@sciencedirect.com', 9, 4, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (78, 'fwoolland25', 'Florenza Woolland', 'fwoolland25@squarespace.com', 4, 4, '2021-03-20');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (79, 'fbillin26', 'Fayre Billin', 'fbillin26@amazon.com', 2, 3, '2020-05-21');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (80, 'yheld27', 'Yule Held', 'yheld27@yale.edu', 6, 5, '2021-01-19');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (81, 'hlytell28', 'Hanni Lytell', 'hlytell28@unc.edu', 3, 6, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (82, 'wjasiak29', 'Whitaker Jasiak', 'wjasiak29@newsvine.com', 1, 1, '2020-06-29');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (83, 'aanand2a', 'Augy Anand', 'aanand2a@sitemeter.com', 7, 7, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (84, 'yruddiforth2b', 'Yuma Ruddiforth', 'yruddiforth2b@cam.ac.uk', 6, 3, '2021-02-01');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (85, 'sgors2c', 'Sallee Gors', 'sgors2c@altervista.org', 3, 7, '2020-08-30');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (86, 'thembrow2d', 'Tracy Hembrow', 'thembrow2d@parallels.com', 7, 2, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (87, 'fredparth2e', 'Francesca Redparth', 'fredparth2e@sphinn.com', 7, 3, '2020-11-13');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (88, 'kkeson2f', 'Karoly Keson', 'kkeson2f@flickr.com', 5, 3, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (89, 'sdelaprelle2g', 'Sancho Delaprelle', 'sdelaprelle2g@geocities.com', 6, 4, '2021-03-19');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (90, 'dleahair2h', 'Den Leahair', 'dleahair2h@phoca.cz', 10, 2, '2020-12-09');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (91, 'dbackes2i', 'Daniele Backes', 'dbackes2i@e-recht24.de', 4, 6, '2020-10-10');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (92, 'ktyers2j', 'Kelbee Tyers', 'ktyers2j@webnode.com', 1, 5, '2020-04-19');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (93, 'mpenswick2k', 'Merwyn Penswick', 'mpenswick2k@craigslist.org', 4, 6, '2020-10-24');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (94, 'lhuckel2l', 'Loy Huckel', 'lhuckel2l@paginegialle.it', 10, 5, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (95, 'braybould2m', 'Bendix Raybould', 'braybould2m@examiner.com', 5, 2, '2021-01-22');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (96, 'eturgoose2n', 'Ellette Turgoose', 'eturgoose2n@java.com', 3, 7, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (97, 'mdearsley2o', 'Maitilde Dearsley', 'mdearsley2o@google.co.jp', 4, 6, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (98, 'gshutt2p', 'Gracia Shutt', 'gshutt2p@hostgator.com', 7, 6, null);
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (99, 'cwhitington2q', 'Chane Whitington', 'cwhitington2q@nymag.com', 6, 1, '2020-05-13');
insert into Account (AccountID, Username, FullName, Email, DepartmentID, PositionID, CreateDate) values (100, 'anutton2r', 'Alick Nutton', 'anutton2r@indiegogo.com', 2, 5, '2020-12-24');

/* Câu hỏi 1: Đếm số lượng nhân viên của các phòng ban (gợi ý dùng Group By và Count trong bảng Account) */
SELECT DepartmentID, COUNT(*) AS 'Số lượng nhân viên'
FROM `Account`
GROUP BY DepartmentID
ORDER BY DepartmentID ASC;  -- Có thể bỏ ASC --

-- Dùng JOIN --
SELECT a.DepartmentID, d.DepartmentName, COUNT(*) AS 'Số lượng nhân viên'
FROM `Account` a JOIN Department d ON a.DepartmentID = d.DepartmentID
GROUP BY a.DepartmentID
ORDER BY a.DepartmentID;

/* Câu hỏi 2: Đếm số lượng nhân viên phòng ban Nhân sự
-- ( gợi ý dùng 2 câu lệnh
 ==> Câu lệnh 1 tìm ra DepartmentID của phòng ban Nhân sự trong bảng Department
 ==> câu lệnh 2 dùng Group By và Count trong bảng Account để đếm số nhân viên giống Câu hỏi 1,
   và kết hợp thêm lệnh điều kiện HAVING DepartmentID = DepartmentID vừa tìm được ở câu lệnh 1 )*/
SELECT DepartmentID
FROM Department
WHERE DepartmentName = 'Nhân sự';

SELECT DepartmentID, COUNT(*) AS 'Số lượng nhân viên'
FROM `Account`
GROUP BY DepartmentID
HAVING DepartmentID= (SELECT DepartmentID FROM Department WHERE DepartmentName = 'Nhân sự');

/*
   Câu hỏi 3: Đếm số lượng nhân viên phòng Marketing và phòng Sale
   (gợi ý : làm giống hệt câu 2 bên trên Nhưng điều kiện HAVING dùng DepartmentID IN (Câu lệnh 1 tìm ra DepartmentID của phòng Marketing và phòng Sale trong bảng Department)
*/
SELECT DepartmentID, COUNT(*) AS 'Số lượng nhân viên'
FROM `Account`
GROUP BY DepartmentID
HAVING DepartmentID IN ((SELECT DepartmentID FROM Department WHERE DepartmentName = 'Marketing'), (SELECT DepartmentID FROM Department WHERE DepartmentName = 'Sale'));

/* Câu hỏi 4: Đếm xem mỗi phòng có bao nhiêu nhân viên Test
Gợi ý
=> dùng 1 câu lênh tìm ra PositionID của chức vụ Test trong bảng Position
=> Sau đó dùng Group BY 2 cột DepartmentID và PositionID ở bảng Account
Và kết hợp điều kiện HAVING PositionID = ID vùa tìm đc ở câu lệnh 1 
*/
SELECT DepartmentID, PositionID, COUNT(*) AS 'Số nhân viên'
FROM `Account`
GROUP BY DepartmentID, PositionID
HAVING PositionID = (SELECT PositionID FROM `Position` WHERE PositionName = 'Test')
ORDER BY DepartmentID;

/* Câu hỏi 5: Đếm xem phòng Kỹ thuật có bao nhiêu nhân viên Test
Gợi ý tương tự câu 4
=> dùng 1 câu lênh tìm ra PositionID của chức vụ Test trong bảng Position
=> dùng tiếp 1 câu lệnh tìm ra DepartmentID của phòng Kỹ thuật

=> Sau đó dùng Group BY 2 cột DepartmentID và PositionID ở bảng Account
Và kết hợp điều kiện HAVING PositionID = ID vùa tìm đc ở câu lệnh 1 và DepartmentID = ID tìm được ở câu lệnh 2
*/
SELECT DepartmentID, PositionID, COUNT(*) AS 'Số nhân viên'
FROM `Account`
GROUP BY DepartmentID, PositionID
HAVING DepartmentID= (SELECT DepartmentID FROM Department WHERE DepartmentName = 'Kỹ thuật') 
AND PositionID = (SELECT PositionID FROM `Position` WHERE PositionName = 'Test');

-- Dùng INNER JOIN (có thể viết là JOIN) -- 
SELECT D.DepartmentName, P.PositionName, COUNT(*) AS 'Số nhân viên'
FROM `Account` JOIN Department D ON `Account`.DepartmentID = D.DepartmentID
JOIN `Position` P ON `Account`.PositionID = P.PositionID
GROUP BY D.DepartmentName, P.PositionName
HAVING D.DepartmentName= (SELECT DepartmentName FROM Department WHERE DepartmentName = 'Kỹ thuật') 
AND P.PositionName = (SELECT PositionName FROM `Position` WHERE PositionName = 'Test');



