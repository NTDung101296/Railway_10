-- Create Database --
DROP DATABASE IF EXISTS Testing_System_Assigment3;
CREATE DATABASE IF NOT EXISTS Testing_System_Assigment3;
USE Testing_System_Assigment3;

##Table 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE IF NOT EXISTS Department(
	DepartmentID INT,
	DepartmentName VARCHAR(200)
);
-- Thay đổi ở bảng Department
ALTER TABLE Department
  MODIFY DepartmentID INT PRIMARY KEY AUTO_INCREMENT;

##Table 2: Position
CREATE TABLE IF NOT EXISTS Position1(
    PositionID INT PRIMARY KEY AUTO_INCREMENT,
    PositionName VARCHAR(150)
);
-- Xoá bảng Position1
DROP TABLE IF EXISTS Position1;
CREATE TABLE IF NOT EXISTS `Position`(
	PositionID INT AUTO_INCREMENT,
    PositionName NVARCHAR(150),
    PRIMARY KEY(PositionID)
);

##Table 3: Account
DROP TABLE IF EXISTS Account1;
CREATE TABLE IF NOT EXISTS Account1(
AccountID INT,
Email1 VARCHAR(100),
Username VARCHAR(50),
Fullname VARCHAR(50) NOT NULL,
DepartmentID INT,
PositionID INT,
CreateDate DATE,
CONSTRAINT Account_to_Department FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);
-- Sửa tên bảng Account1
ALTER TABLE Account1
RENAME TO `Account`,
CHANGE COLUMN AccountID AccountID INT PRIMARY KEY AUTO_INCREMENT,
DROP COLUMN Email1,
ADD COLUMN Email VARCHAR(200) NOT NULL UNIQUE KEY;
-- Rằng buộc khoá ngoại với bảng Position
ALTER TABLE `Account`
ADD CONSTRAINT Account_to_Position FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID);

##Table 4: Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE IF NOT EXISTS `Group`(
GroupID SMALLINT PRIMARY KEY AUTO_INCREMENT,
GroupName NVARCHAR(200) NOT NULL UNIQUE KEY,
CreatorID INT,
CreateDate DATE,
FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
);

##Table 5: GroupAccount
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE IF NOT EXISTS GroupAccount(
GroupID SMALLINT,
AccountID INT,
JoinDate DATE,
PRIMARY KEY(GroupID,AccountID)
);

##Table 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE IF NOT EXISTS TypeQuestion(
TypeID INT PRIMARY KEY AUTO_INCREMENT,
TypeName ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE KEY
);

##Table 7: CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE IF NOT EXISTS CategoryQuestion(
CategoryID INT PRIMARY KEY AUTO_INCREMENT,
CategoryName NVARCHAR(200) UNIQUE KEY
);

##Table 8: Question
DROP TABLE IF EXISTS Question;
CREATE TABLE IF NOT EXISTS Question(
QuestionID INT PRIMARY KEY AUTO_INCREMENT,
Content NVARCHAR(200),
CategoryID INT,
TypeID INT,
CreatorID INT,
CreateDate DATE,
CONSTRAINT Question_to_CatageryQuestion FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
CONSTRAINT Question_to_TypeQuestion FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
CONSTRAINT Question_to_Account FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

##Table 9: Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE IF NOT EXISTS Answer(
AnswerID INT PRIMARY KEY AUTO_INCREMENT,
Content NVARCHAR(200),
QuestionID INT,
isCorrect ENUM('TRUE','FALSE'),
CONSTRAINT Answer_to_Question FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

##Table 10: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE IF NOT EXISTS Exam(
ExamID INT PRIMARY KEY AUTO_INCREMENT,
`Code` VARCHAR(50),
Title NVARCHAR(200),
CategoryID INT,
Duration TINYINT,
CreatorID INT,
CreateDate DATE,
CONSTRAINT Exam_to_CategoryQuestion FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
CONSTRAINT Exam_to_Account FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

##Table 11: ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE IF NOT EXISTS ExamQuestion(
ExamID INT,
QuestionID INT,
PRIMARY KEY (ExamID, QuestionID)
);

##Testing_System_3
##Question 1: Thêm ít nhất 10 record vào mỗi table
-- Add data Department
-- Cột DepartmentID khoá chính tự động tăng nên không cần thêm dữ liệu--
INSERT INTO Department(DepartmentName)
VALUES
      ('Marketing'),
      ('Sale'),
      ('Bao ve'),
      ('Nhan su'),
      ('Ky thuat'),
      ('Tai chinh'),
      ('Pho giam doc'),
      ('Giam doc'),
      ('Thu ky'),
      ('Ban hang');

-- Add data Position
INSERT INTO `Position`(PositionName)
VALUES
      ('Dev'),
      ('Test'),
      ('Scrum Master'),
      ('PM'),
      ('Staff'),
      ('Team leader'),
      ('Vice Section Manager'),
      ('Section Manager'),
      ('Vice Department Manager'),
      ('Department Manager');
	
-- Add data Account
INSERT INTO `Account`(Email,Username,FullName,DepartmentID,PositionID,CreateDate)
VALUES
      ('haidang29productions@gmail.com'	, 'dangblack'		,'Nguyễn hải Đăng'		,   '5'			,   '1'		,'2020-03-05'),
	  ('account1@gmail.com'				, 'quanganh'		,'Nguyen Chien Thang2'	,   '1'			,   '2'		,'2020-03-05'),
	  ('account2@gmail.com'				, 'vanchien'		,'Nguyen Van Chien'		,   '2'			,   '3'		,'2020-03-07'),
	  ('account3@gmail.com'				, 'cocoduongqua'	,'Duong Do'				,   '3'			,   '4'		,'2020-03-08'),
	  ('account4@gmail.com'				, 'doccocaubai'		,'Nguyen Chien Thang1'	,   '4'			,   '4'		,'2020-03-10'),
	  ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Ngo Ba Kha'			,   '6'			,   '3'		,'2020-04-05'),
	  ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Bui Xuan Huan'		,   '7'			,   '2'		, NULL		),
	  ('sontungmtp@gmail.com'			, 'tungnui'			,'Nguyen Thanh Tung'	,   '8'			,   '1'		,'2020-04-07'),
	  ('duongghuu@gmail.com'			, 'duongghuu'		,'Duong Van Huu'		,   '9'			,   '2'		,'2020-04-07'),
	  ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Vi Ti Ai'				,   '10'		,   '1'		,'2020-04-09');
     
-- Add data Group
INSERT INTO `Group`(GroupName,CreatorID,CreateDate)
VALUES
      ('Testing System'		    ,   5			,'2019-03-05'),
	  ('Development'	 		,   1			,'2020-03-07'),
	  ('VTI Sale 01'			,   2			,'2020-03-09'),
	  ('VTI Sale 02'			,   3			,'2020-03-10'),
	  ('VTI Sale 03'			,   4			,'2020-03-28'),
	  ('VTI Creator'			,   6			,'2020-04-06'),
	  ('VTI Marketing 01'	    ,   7			,'2020-04-07'),
	  ('Management'			    ,   8			,'2020-04-08'),
	  ('Chat with love'		    ,   9			,'2020-04-09'),
	  ('Vi Ti Ai'			    ,   10			,'2020-04-10');

-- Add data GroupAccount
INSERT INTO GroupAccount(GroupID,AccountID,JoinDate)
VALUES
      (	1		,    1		,'2019-03-05'),
	  (	1		,    2		,'2020-03-07'),
	  (	3		,    3		,'2020-03-09'),
	  (	3		,    4		,'2020-03-10'),
	  (	5		,    5		,'2020-03-28'),
	  (	1		,    3		,'2020-04-06'),
	  (	1		,    7		,'2020-04-07'),
	  (	8		,    3		,'2020-04-08'),
	  (	1		,    9		,'2020-04-09'),
	  (	10		,    10		,'2020-04-10');

-- Add data TypeQuestion
INSERT INTO TypeQuestion(TypeName)
VALUES
      ('Essay'			), 
	  ('Multiple-Choice'	);

-- Add data CategoryQuestion
INSERT INTO CategoryQuestion(CategoryName)
VALUES
    ('Java'         ),
	('ASP.NET'		),
	('ADO.NET'		),
	('SQL'			),
	('Postman'		),
	('Ruby'			),
	('Python'		),
	('C++'			),
	('C Sharp'		),
	('PHP'			);

-- Add data Question
INSERT INTO Question(Content,CategoryID,TypeID,CreatorID,CreateDate)
VALUES
     (N'Câu hỏi về Java'   ,	1		,   '1'			,   '2'		,'2020-04-05'),
	 (N'Câu Hỏi về PHP'	   ,	10		,   '2'			,   '2'		,'2020-04-05'),
	 (N'Hỏi về C#'		   ,	9		,   '2'			,   '3'		,'2020-04-06'),
	 (N'Hỏi về Ruby'	   ,	6		,   '1'			,   '4'		,'2020-04-06'),
	 (N'Hỏi về Postman'	   ,	5		,   '1'			,   '5'		,'2020-04-06'),
	 (N'Hỏi về ADO.NET'	   ,	3		,   '2'			,   '6'		,'2020-04-06'),
	 (N'Hỏi về ASP.NET'	   ,	2		,   '1'			,   '7'		,'2020-04-06'),
	 (N'Hỏi về C++'		   ,	8		,   '1'			,   '8'		,'2020-04-07'),
	 (N'Hỏi về SQL'		   ,	4		,   '2'			,   '9'		,'2020-04-07'),
	 (N'Hỏi về Python'	   ,	7		,   '1'			,   '10'	,'2020-04-07');

-- Add data Answer
INSERT INTO Answer(Content,QuestionID,isCorrect)
VALUES
     (N'Trả lời 01'	,   1			,	'FALSE'	),
	 (N'Trả lời 02'	,   1			,	'TRUE'	),
	 (N'Trả lời 03'	,   1			,	'FALSE'	),
	 (N'Trả lời 04'	,   1			,	'TRUE'  ),
	 (N'Trả lời 05'	,   2			,	'TRUE'  ),
	 (N'Trả lời 06'	,   3			,	'TRUE'  ),
	 (N'Trả lời 07'	,   4			,	'FALSE' ),
	 (N'Trả lời 08'	,   8			,	'FALSE' ),
	 (N'Trả lời 09'	,   9			,	'TRUE'  ),
	 (N'Trả lời 10'	,   10			,	'TRUE'  );
     
-- Add data Exam
INSERT INTO Exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate)
VALUES 
	('VTIQ001'		, N'Đề thi C#'			,	1			,	60		,   '5'			,'2019-04-05'),
	('VTIQ002'		, N'Đề thi PHP'			,	10			,	60		,   '2'			,'2019-04-05'),
	('VTIQ003'		, N'Đề thi C++'			,	9			,	120		,   '2'			,'2019-04-07'),
	('VTIQ004'		, N'Đề thi Java'		,	6			,	60		,   '3'			,'2020-04-08'),
	('VTIQ005'		, N'Đề thi Ruby'		,	5			,	120		,   '4'			,'2020-04-10'),
    ('VTIQ006'		, N'Đề thi Postman'		,	3			,	60		,   '6'			,'2020-04-05'),
	('VTIQ007'		, N'Đề thi SQL'			,	2			,	60		,   '7'			,'2020-04-05'),
	('VTIQ008'		, N'Đề thi Python'		,	8			,	60		,   '8'			,'2020-04-07'),
	('VTIQ009'		, N'Đề thi ADO.NET'		,	4			,	90		,   '9'			,'2020-04-07'),
	('VTIQ010'		, N'Đề thi ASP.NET'		,	7			,	90		,   '10'		,'2020-04-08');
								
-- Add data ExamQuestion
INSERT INTO ExamQuestion(ExamID,QuestionID)
VALUES 
     (	1	,		5		),
     (	2	,		10		), 
     (	3	,		4		), 
	 (	4	,		3		), 
	 (	5	,		7		), 
	 (	6	,		10		), 
	 (	7	,		2		), 
	 (	8	,		10		), 
	 (	9	,		9		), 
	 (	10	,		8		); 

-- Hiển thị tất cả các cột của bảng --
SHOW COLUMNS FROM Department;

##Question 2: Lấy ra tất cả các phòng ban
SELECT *
FROM Department;

##Question 3: Lấy ra ID của phòng ban Sales
SELECT DepartmentID
FROM Department 
WHERE DepartmentName = 'Sale';


-- Sử dụng SUB QUERY, trả về độ dài của Fullname lớn nhất từ bảng Account
SELECT MAX(char_length(Fullname)) FROM `Account`;
-- Trả về độ dài của Fullname lớn nhất từ bảng Account với điều kiện ID của phòng ban = 3
SELECT MAX(char_length(Fullname)) FROM `Account` WHERE DepartmentID= 3;
-- Trả về thông tin Account có độ dài của Fullnname lớn nhất từ bảng Account
SELECT * FROM `Account` WHERE char_length(Fullname) = (SELECT MAX(char_length(Fullname)) FROM `Account`);
-- Trả về thông tin Account của phòng có ID = 3 có độ dài Fullname lớn nhất 
SELECT * FROM `Account` WHERE char_length(Fullname) = (SELECT MAX(char_length(Fullname)) FROM `Account` WHERE DepartmentID=3) AND DepartmentID=3;

##Question 4: Lấy ra thông tin account có fullname dài nhất
SELECT *
FROM `Account`
WHERE char_length(Fullname)=(SELECT MAX(char_length(Fullname)) FROM `Account`);

##Question 5: Lấy ra thông tin account có fullname dài nhất và thuộc phòng ban có id=3
SELECT *
FROM `Account`
WHERE length(Fullname)=(SELECT max(length(Fullname)) FROM `Account`) AND DepartmentID='3';

##Question 6: Lấy ra tên Group đã tham gia trước ngày 20/12/2019
SELECT GroupName
FROM `Group`
WHERE CreateDate < '2019/12/20';


-- Group by: Nhóm nhiều hàng có chung thuộc tính Question ID
-- Having: Đặt điều kiện bổ sung tạo bởi mệnh đề Group By
##Question 7: Lấy ra ID có Question >=4 câu trả lời
SELECT QuestionID
FROM Answer
GROUP BY QuestionID
HAVING Count(QuestionID) >= 4;

##Question 8: Lấy ra các mã đề thi có thời gian thi >=60 phút và tạo ra trước ngày 20/12/2019
SELECT `Code`
FROM Exam
WHERE Duration>=60 AND CreateDate>='2019/12/20';

##Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT GroupName
FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

##Question 10: Đếm số nhân viên thuộc Department có ID=2
SELECT Count(AccountID) AS 'SO NHAN VIEN'
FROM `Account`
WHERE DepartmentID = 2;

-- LIKE
SELECT *
FROM Department
WHERE DepartmentName LIKE '%giám%'; -- Hoặc '%giám'/'giám%'

-- DISTINCT: Loại bỏ những cái trùng lặp
SELECT DISTINCT PositionID FROM `Account`;

-- Order by: Câu lệnh sắp xếp, ưu tiên cột viết trước, ưu tiên sắp xếp tăng dần
SELECT * FROM `Group` ORDER BY CreatorID;

-- As: Đặt tên cho cột mới tạo ra
SELECT COUNT(*) AS 'TOTAL' FROM GroupAccount;
SELECT COUNT(DISTINCT GroupID) AS 'TOTAL' FROM GroupAccount;
SELECT COUNT(1) FROM GroupAccount WHERE GroupID=1;

SELECT MIN(GroupID) FROM GroupAccount WHERE GroupID=1;
SELECT * FROM GroupAccount LIMIT 6;

SELECT GroupID,COUNT(*) FROM GroupAccount GROUP BY GroupID;
SELECT GroupID,COUNT(*) FROM GroupAccount WHERE GroupID=1;
-- WHERE: Đếm một nhóm một
-- GROUP BY: Đếm từng bản ghi, đếm cho hết
SELECT GroupID,COUNT(*),sum(GroupID),sum(AccountID) FROM GroupAccount GROUP BY GroupID;


##Question 11: Lấy ra tên nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT FullName
FROM `Account`
WHERE FullName LIKE 'D%o';

-- Trước khi xoá các bản ghi, phải xoá hết các khoá ngoại tham chiếu đến bảng đó
##Question 12: Xoá tất cả các exam được tạo trước ngày 20/12/2019
DELETE 
FROM Exam
WHERE CreateDate < '2019/12/20';

##Question 13: Xoá tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
-- Cần bỏ các khoá ngoại tham chiếu đến bảng Question
ALTER TABLE Answer
DROP FOREIGN KEY Answer_to_Question;

DELETE
FROM Question
WHERE Content LIKE 'Câu hỏi%';

##Question 14: Uppdate thông tin của account có id=5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.edu.vn
UPDATE `Account`
SET Fullname = 'Nguyễn Bá Lộc',
	Email = 'loc.nguyenba@vti.edu.vn'
WHERE AccountID = 5;

##Question 15: Uppdate account có id=5 sẽ thuộc group có id =4
UPDATE GroupAccount
SET AccountID = 5
WHERE GroupID = 4;
    