-- Create database
DROP DATABASE IF EXISTS Testing_System_Assigment2;
CREATE DATABASE IF NOT EXISTS Testing_System_Assigment2;
USE Testing_System_Assigment2;

##Table 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE IF NOT EXISTS Department(
	DepartmentID INT,
	DepartmentName VARCHAR(200)
);
-- Thay doi o bang Department
ALTER TABLE Department
  MODIFY DepartmentID INT NOT NULL PRIMARY KEY AUTO_INCREMENT;

##Table 2: Position
CREATE TABLE IF NOT EXISTS Position1(
    PositionID INT PRIMARY KEY AUTO_INCREMENT,
    PositionName VARCHAR(150)
);
-- Xoa bang Position1
DROP TABLE IF EXISTS Position1;
CREATE TABLE IF NOT EXISTS `Position`(
	PositionID INT NOT NULL AUTO_INCREMENT,
    PositionName NVARCHAR(150),
    PRIMARY KEY(PositionID)
);

##Table 3: Account
DROP TABLE IF EXISTS Account1;
CREATE TABLE IF NOT EXISTS Account1(
AccountID INT,
Email1 VARCHAR(100),
Username VARCHAR(50),
Fullname VARCHAR(50),
DepartmentID INT,
PositionID INT,
CreateDate DATE,
CONSTRAINT Account_to_Department FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);
-- Sua ten bang Account1
ALTER TABLE Account1
RENAME TO `Account`,
CHANGE COLUMN AccountID AccountID SMALLINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
DROP COLUMN Email1,
ADD COLUMN Email VARCHAR(100);

ALTER TABLE `Account`
ADD CONSTRAINT Account_to_Position FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID);

##Table 4: Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE IF NOT EXISTS `Group`(
GroupID SMALLINT PRIMARY KEY AUTO_INCREMENT,
GroupName VARCHAR(50),
CreatorID INT,
CreateDate DATE
);

##Table 5: GroupAccount
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE IF NOT EXISTS GroupAccount(
GroupID SMALLINT,
AccountID SMALLINT,
JoinDate DATE,
CONSTRAINT GroupAccount_to_Group FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
CONSTRAINT GroupAccount_to_Account FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
);

##Table 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE IF NOT EXISTS TypeQuestion(
TypeID INT PRIMARY KEY AUTO_INCREMENT,
TypeName VARCHAR(200)
);

##Table 7: CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE IF NOT EXISTS CategoryQuestion(
CategoryID INT PRIMARY KEY AUTO_INCREMENT,
CategoryName VARCHAR(100)
);

##Table 8: Question
DROP TABLE IF EXISTS Question;
CREATE TABLE IF NOT EXISTS Question(
QuestionID INT PRIMARY KEY AUTO_INCREMENT,
Content VARCHAR(100),
CategoryID INT,
TypeID INT,
Creator INT,
CreateDate DATE,
CONSTRAINT Question_to_CatageryQuestion FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID)
);

##Table 9: Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE IF NOT EXISTS Answer(
AnswerID INT PRIMARY KEY AUTO_INCREMENT,
Content VARCHAR(100),
QuestionID INT,
isCorrect ENUM('Dung','Sai'),
CONSTRAINT Answer_to_Question FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

##Table 10: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE IF NOT EXISTS Exam(
ExamID INT PRIMARY KEY AUTO_INCREMENT,
`Code` VARCHAR(10),
Title VARCHAR(50),
CategoryID INT,
Duration TIME,
CreatorID INT,
CreateDate DATE
);

##Table 11: ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE IF NOT EXISTS ExamQuestion(
ExamID INT,
QuestionID INT,
CONSTRAINT ExamQuestion_to_Exam FOREIGN KEY (ExamID) REFERENCES Exam(ExamID)
);

-- Add data Department
INSERT INTO Department(DepartmentID,DepartmentName)
VALUES
      (1,  'Maintenance Sales'  ),
      (2,  'Maintenance Field'  ),
      (3,  'Quality Control'  ),
      (4,  'Sale Engineer'  ),
      (5,  'Installation'  );
      
-- Add data Position
INSERT INTO `Position`(PositionID,PositionName)
VALUES
      (1,  'Staff'  ),
      (2,  'Team Leader'  ),
      (3,  'Engineer'  ),
      (4,  'Vice Section Manager'  ),
      (5,  'Section Manager'  );

-- Add data Account

INSERT INTO `Account`(AccountID,Email,Username,FullName,DepartmentID,PositionID,CreateDate)
VALUES
      (1,'nguyen-trung.dung@vmec.vn','Dung','Nguyen Trung Dung',1,1,2018/10/01),
      (2,'hoang-kieu.chinh@vmec.vn','Chinh','Hoang Kieu Chinh',1,2,2016/09/05),
      (3,'doan-truong.long@vmec.vn','Long','Doan Truong Long',2,4,2010/03/01),
      (4,'nguyen-thanh.huong@vmec.vn','Huong','Nguyen Thi Thanh Huong',3,5,2015/06/28),
      (5,'nguyen-thi.la@vmec.vn','La','Nguyen Thi La',5,5,2008/04/08);
     
-- Add data Group
INSERT INTO `Group`(GroupID,GroupName,CreatorID,CreateDate)
VALUES
      (1,'MS2',101296,2020/10/01),
      (2,'MF2',281296,2019/09/05),
      (3,'QC',280696,2013/03/01),
      (4,'SE2',151194,2018/11/28),
      (5,'ID2',140290,2017/04/08);

      



