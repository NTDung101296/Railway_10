DROP DATABASE IF EXISTS SQL1;
CREATE DATABASE IF NOT EXISTS SQL1;
USE SQL1;

-- Questions
-- 1. Tạo table với các ràng buộc và kiểu dữ liệu
-- Thêm ít nhất 3 bản ghi vào table 
DROP TABLE IF EXISTS Student;
CREATE TABLE IF NOT EXISTS Student(
    StudentID     TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    StudentName   VARCHAR(50) NOT NULL,
    StudentAge    INT UNSIGNED NOT NULL,
    StudentGender ENUM('0', '1', 'NULL')
);

INSERT INTO Student(StudentName	,StudentAge, StudentGender)
VALUES		   ('BINH AN'	,	18		,	'0'),
	           ('HOA BINH'	,	25		,	'1'),
                   ('TRUNG DUNG',	32		,	'NULL');
                    
DROP TABLE IF EXISTS `Subject`;
CREATE TABLE IF NOT EXISTS `Subject`(
    SubjectID   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    SubjectName VARCHAR(50) NOT NULL
);

INSERT INTO `Subject`(SubjectName)
VALUES		     ('TOAN'),
	             ('LY'),
		     ('HOA');

DROP TABLE IF EXISTS StudentSubject;
CREATE TABLE IF NOT EXISTS StudentSubject(
    StudentID   TINYINT UNSIGNED NOT NULL,
    SubjectID   TINYINT UNSIGNED NOT NULL,
    Mark        TINYINT UNSIGNED,
    `Date`      DATETIME DEFAULT NOW(),
    PRIMARY KEY (StudentID, SubjectID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (SubjectID) REFERENCES `Subject`(SubjectID)
);

INSERT INTO StudentSubject(StudentID	,	SubjectID	,	Mark	)
VALUES			  (1		,	2		,	10	),	
			  (2		,	2		,	9	),	
                          (3		,	3		,	8	),
                          (3		,	2		,	8	);
                            
                            
-- 2. Viết lệnh để
-- a) Lấy tất cả các môn học không có bất kì điểm nào
SELECT 
    su.SubjectName, ss.Mark
FROM
    `Subject` su
        LEFT JOIN
    StudentSubject ss ON su.SubjectID = ss.SubjectID
WHERE ss.Mark IS NULL;
    
SELECT SubjectName
FROM `Subject` 
WHERE SubjectName NOT IN (
	SELECT b.SubjectName
	FROM StudentSubject as a
	JOIN `Subject` AS b ON a.SubjectID = b.SubjectID);

SELECT SubjectName
FROM `Subject` 
WHERE SubjectID NOT IN (
	SELECT b.SubjectID
	FROM StudentSubject AS a
	JOIN `Subject` AS b ON a.SubjectID = b.SubjectID);
    
SELECT b.SubjectID
FROM StudentSubject AS a
	JOIN 
     `Subject` AS b 
	ON a.SubjectID = b.SubjectID
GROUP BY a.SubjectID;

SELECT *
FROM `Subject`
WHERE SubjectID NOT IN(
	SELECT SubjectID
        FROM StudentSubject);

--Chat GPT
SELECT * 
FROM `Subject`
WHERE SubjectID NOT IN(
	SELECT DISTINCT SubjectID
        FROM StudentSubject
	WHERE Mark IS NOT NULL);
   
-- b) Lấy danh sách các môn học có ít nhất 2 điểm
SELECT 
    su.SubjectID, su.SubjectName, COUNT(ss.SubjectID) AS so_luong
FROM
    `subject` su
        JOIN
    studentsubject ss ON ss.SubjectID = su.SubjectID
GROUP BY ss.SubjectID
HAVING so_luong >= 2;

SELECT 
	b.SubjectName,
    count(b.SubjectName) AS 'Total' 
FROM
	StudentSubject AS a
JOIN `Subject` AS b ON a.SubjectID = b.SubjectID
GROUP By a.SubjectID
having Total>=2;

SELECT 
    b.SubjectName, COUNT(b.SubjectID) AS 'Total'
FROM
    StudentSubject AS a
        RIGHT JOIN
    `Subject` AS b ON a.SubjectID = b.SubjectID
GROUP BY a.SubjectID
HAVING 'Total' >= 2;

--Chat GPT
SELECT 
    a.SubjectName, a.SubjectID
FROM
    `Subject` a
    	JOIN
    StudentSubject b
        ON a.SubjectID = b.SubjectID
WHERE Mart >= 2
GROUP BY a.SubjectID
HAVING COUNT(*) >= 2;

/*Tạo view có tên là "StudentInfo" lấy các thông tin về học sinh bao gồm: 
Student ID,Subject ID, Student Name, Student Age, Student Gender, Subject Name, Mark, Date
(Với cột Gender show 'Male' để thay thế cho 0, 'Female' thay thế cho 1 và 'Unknow' thay thế cho null)*/

CREATE OR REPLACE VIEW StudentInfo AS
    SELECT
    a.StudentID, c.SubjectID, a.StudentName, a.StudentAge, c.SubjectName, b.Mark, b.`Date`,
    CASE
        WHEN a.StudentGender = '0' THEN 'Male'
	WHEN a.StudentGender = '1' THEN 'Female'
	ELSE 'Unknow'
    END AS StudentGender
    FROM 
    	Student a 
	  JOIN 
	StudentSubject b USING(StudentID)
    	  JOIN 
	`Subject` c USING(SubjectID);
    
SELECT * FROM StudentInfo;

-- Delete foreign key của bảng Employee: 'fk_2'
ALTER TABLE StudentSubject
DROP FOREIGN KEY `studentsubject_ibfk_1`;

ALTER TABLE StudentSubject
DROP FOREIGN KEY `studentsubject_ibfk_2`;

ALTER TABLE StudentSubject
ADD FOREIGN KEY (StudentID) REFERENCES Student (StudentID) ON DELETE CASCADE;

ALTER TABLE StudentSubject
ADD  FOREIGN KEY (SubjectID) REFERENCES `Subject` (SubjectID) ON UPDATE CASCADE;

-- Question 4. Không sử dụng On Update Cascade & On Delete Cascade
-- a) Tạo trigger cho table Subject có tên là SubjectUpdateID: Khi thay đổi data của cột ID của table Subject, thì giá trị tương
-- ứng với cột SubjectID của table StudentSubject cũng thay đổi theo
DROP TRIGGER IF EXISTS SubjectUpdateID;
DELIMITER $$
CREATE TRIGGER SubjectUpdateID
	BEFORE UPDATE ON `Subject` 
    FOR EACH ROW 
    BEGIN
        UPDATE studentsubject 
        SET SubjectID = NEW.ID
		WHERE SubjectID = OLD.ID;
    END $$
DELIMITER ;

-- DROP TRIGGER IF EXISTS SubjectUpdateID;
-- DELIMITER $$
-- CREATE TRIGGER SubjectUpdateID
-- 	AFTER UPDATE ON `Subject` 
--     FOR EACH ROW 
--     BEGIN
--     SET FOREIGN_KEY_CHECKS=0;
-- UPDATE studentsubject 
-- SET 
--     SubjectID = NEW.ID
-- WHERE
--     SubjectID = OLD.ID;
--          SET FOREIGN_KEY_CHECKS=1;
--     END $$
-- DELIMITER ;


UPDATE `subject` SET id = 7 WHERE id = 3;
-- b) Tạo trigger cho table StudentSubject có tên là StudentDeleteID: Khi xóa data của cột ID của table Student, thì giá trị tương ứng với
-- cột StudentID của table StudentSubject cũng bị xóa theo

DROP TRIGGER IF EXISTS StudentDeleteID;
DELIMITER $$
CREATE TRIGGER StudentDeleteID
	BEFORE DELETE ON `Subject` 
    FOR EACH ROW 
    BEGIN
        DELETE FROM studentsubject
		WHERE SubjectID = old.ID;
    END $$
DELIMITER ;

DELETE FROM `subject` WHERE id =1;

-- Cau 5
/*
Viết 1 store procedure (có 1 parameters: student name) sẽ xóa tất cả các thông tin liên quan tới học sinh có cùng tên như parameter
Trong trường hợp nhập vào student name = "*" thì procedure sẽ xóa tất cả các học sinh
*/
-- Input: student_name
DROP PROCEDURE IF EXISTS sp_detete_student;
DELIMITER $$
CREATE PROCEDURE sp_detete_student(IN in_student_name VARCHAR(255))
BEGIN
   IF in_student_name= '*' THEN
      DELETE FROM StudentSubject;
      DELETE FROM Student;
   ELSE
      DELETE FROM StudentSubject
      WHERE StudentID IN(
       SELECT StudentID FROM Student 
       WHERE StudentName = in_student_name);
       
      DELETE FROM Student 
      WHERE StudentName = in_student_name;
   END IF;
END$$
DELIMITER ;

CALl sp_detete_student('TRUNG DUNG');
CALl sp_detete_student('*');
 






















































































