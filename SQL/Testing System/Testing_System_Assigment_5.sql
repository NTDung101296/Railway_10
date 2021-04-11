##SQL- Assigmment 5
-- Exercise 1: Sử dụng Subquery hoặc CTE --
USE Testing_System_Assigment3;

##Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban Sale
-- VIEW --
CREATE OR REPLACE VIEW View_DSNV_Sale 
AS
   SELECT *
   FROM `Account` A
   JOIN Department D
   USING (DepartmentID)
   WHERE D.DepartmentName = 'Sale';
SELECT *
FROM View_DSNV_Sale;

-- CTE --
WITH 
CTE_DSNV_Sale AS(
   SELECT A.*, D.DepartmentName
   FROM `Account` A JOIN Department D
   USING (DepartmentID)
   WHERE D.DepartmentName = 'Sale')
SELECT *
FROM CTE_DSNV_Sale;

##Question 2: Tạo View có chứa thông tin các Account tham gia vào nhiều Group nhất
-- VIEW --
CREATE OR REPLACE VIEW View_DS_Account 
AS
 SELECT A.*, Count(GA.AccountID) AS 'Số lượng group tham gia'
 FROM `Account` A
 JOIN GroupAccount GA
 USING (AccountID)
 GROUP BY GA.AccountID
 HAVING Count(GA.AccountID) = (SELECT COUNT(GA.AccountID)
									FROM `Account` A 
                                    JOIN GroupAccount GA
                                    USING(AccountID) 
                                    GROUP BY A.AccountID
                                    ORDER BY COUNT(GA.AccountID) DESC
                                    LIMIT 1);
SELECT *
FROM View_DS_Account;

-- CTE --
WITH
CTE_Max_Account AS
(
SELECT A.*, Count(GA.AccountID) AS 'Number_of_group'
 FROM `Account` A
 JOIN GroupAccount GA
 USING (AccountID)
 GROUP BY GA.AccountID
 HAVING Count(GA.AccountID) = (SELECT COUNT(GA.AccountID)
									FROM `Account` A 
                                    JOIN GroupAccount GA
                                    USING(AccountID) 
                                    GROUP BY A.AccountID
                                    ORDER BY COUNT(GA.AccountID) DESC
                                    LIMIT 1)
)
SELECT *
FROM CTE_Max_Account;
-- HOẶC --
WITH
CTE_Max_Account AS
(
   SELECT COUNT(GA.AccountID)
   FROM `Account` A INNER JOIN GroupAccount GA USING(AccountID) 
   GROUP BY A.AccountID ORDER BY COUNT(GA.AccountID) DESC LIMIT 1
)
SELECT A.*, COUNT(GA.AccountID) AS 'Number_of_group'
FROM `Account` A JOIN GroupAccount GA
USING (AccountID)
GROUP BY A.AccountID
HAVING COUNT(GA.AccountID) = (SELECT * FROM CTE_Max_Account);

/*Question 3: Tạo View có chứa câu hỏi có những content quá dài (content quá 300 từ được coi 
là quá dài) và xoá nó đi */
DROP VIEW IF EXISTS View_Length_Content;
CREATE VIEW View_Length_Content
AS
 SELECT char_length(Content)
 FROM Question
 WHERE char_length(Content) > 300;
 
SELECT *
FROM View_Length_Content;

DELETE
FROM View_Length_Content;

/*Question 4: Tạo View có chứa danh sách các phòng ban có nhiều nhân viên nhất */
-- VIEW --
DROP VIEW IF EXISTS View_DepartmentName;
CREATE VIEW View_DepartmentName
AS
 SELECT D.DepartmentName, COUNT(A.DepartmentID) AS 'Number_of_Account'
 FROM Department D JOIN `Account` A USING(DepartmentID)
 GROUP BY A.DepartmentID
 HAVING COUNT(A.DepartmentID) = (SELECT COUNT(A.DepartmentID)
                                FROM Department D JOIN `Account` A USING(DepartmentID)
                                GROUP BY A.DepartmentID
                                HAVING COUNT(A.DepartmentID)
                                ORDER BY COUNT(A.DepartmentID) DESC
                                LIMIT 1);

SELECT *
FROM View_DepartmentName;

-- CTE -- 
WITH
CTE_Max_Count_DepartmentID AS
(
   SELECT COUNT(A.DepartmentID)
   FROM Department D JOIN `Account` A 
   USING(DepartmentID)
   GROUP BY A.DepartmentID 
   HAVING COUNT(A.DepartmentID)
   ORDER BY COUNT(A.DepartmentID) DESC
   LIMIT 1
),
CTE_Count_DepartmentID AS
(
   SELECT D.DepartmentName, COUNT(A.DepartmentID) AS 'Number_of_Account'
   FROM Department D JOIN `Account` A 
   USING(DepartmentID)
   GROUP BY A.DepartmentID
   HAVING COUNT(A.DepartmentID)
)
SELECT *
FROM CTE_Count_DepartmentID
WHERE Number_of_Account = (SELECT * FROM CTE_Max_Count_DepartmentID);

/*Question 5: Tạo View có chứa tất cả các câu hỏi do user họ Nguyễn tạo */
-- VIEW --
CREATE OR REPLACE VIEW View_Question
AS
 SELECT Q.*, A.Fullname
 FROM Question Q JOIN `Account` A
 ON Q.CreatorID = A.AccountID
 WHERE A.Fullname LIKE 'Nguyễn%';
 
 SELECT *
 FROM View_Question;
 
 -- CTE --
 WITH
 CTE_Question AS
 (
  SELECT Q.*, A.Fullname
  FROM Question Q JOIN `Account` A
  ON Q.CreatorID = A.AccountID
  WHERE A.Fullname LIKE CONCAT ('%','Nguyễn','%')
 )
 SELECT *
 FROM CTE_Question;
