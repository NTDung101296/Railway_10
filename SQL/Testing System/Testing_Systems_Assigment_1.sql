##ao Database
CREATE DATABASE IF NOT EXISTS Testing_System_Assigment1;
USE Testing_System_Assigment1;
##IF NOT EXISTS la tranh loi khi tao bang da ton tai
##Table 1: Department
CREATE TABLE IF NOT EXISTS Department(
##auto increment la cai dat chu so tu dong tang
DepartmentID INT PRIMARY KEY AUTO_INCREMENT,
## day la phong ban kieu du lieu varchar
DepartmentName VARCHAR(50)
);
##Table 2: Position
CREATE TABLE IF NOT EXISTS `Position`(
    PositionID INT PRIMARY KEY AUTO_INCREMENT,
    PositionName VARCHAR(50)
);
##Table 3: Account
CREATE TABLE IF NOT EXISTS `Account`(
AccountID INT PRIMARY KEY AUTO_INCREMENT,
Email VARCHAR(50),
Username VARCHAR(50),
Fullname VARCHAR(50),
DepartmentID INT,
PositionID INT,
CreateDate DATE
);
##Table 4: Group
CREATE TABLE IF NOT EXISTS `Group`(
GroupID INT PRIMARY KEY AUTO_INCREMENT,
GroupName VARCHAR(50),
CreatorID INT,
CreateDate DATE
);
##Table 5: GroupAccount
CREATE TABLE IF NOT EXISTS GroupAccount(
GroupID INT,
AccountID INT,
JoinDate DATE
);
##Table 6: TypeQuestion
CREATE TABLE IF NOT EXISTS TypeQuestion(
TypeID INT PRIMARY KEY AUTO_INCREMENT,
TypeName ENUM('Essay','Multiple-Choice')
);
##Table 7: CategoryQuestion
CREATE TABLE IF NOT EXISTS CategoryQuestion(
CategoryID INT PRIMARY KEY AUTO_INCREMENT,
CategoryName ENUM('Java','.NET','SQL','Postman','Ruby','...')
);
##Table 8: Question
CREATE TABLE IF NOT EXISTS Question(
QuestionID INT PRIMARY KEY AUTO_INCREMENT,
Content VARCHAR(100),
CategoryID INT,
TypeID INT,
Creator INT,
CreateDate DATE
);
##Table 9: Answer
CREATE TABLE IF NOT EXISTS Answer(
AnswerID INT PRIMARY KEY AUTO_INCREMENT,
Content VARCHAR(100),
QuestionID INT,
isCorrect VARCHAR(50)
);
##Table 10: Exam
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
CREATE TABLE IF NOT EXISTS ExamQuestion(
ExamID INT,
QuestionID INT
);
