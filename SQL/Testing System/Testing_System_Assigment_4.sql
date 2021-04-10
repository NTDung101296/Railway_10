
-- Exercise 1: JOIN --
USE Testing_System_Assigment3;

##Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ 
SELECT *
FROM `Account` A
INNER JOIN Department D
ON A.DepartmentID = D.DepartmentID; 

SELECT *
FROM `Account` 
INNER JOIN Department 
USING(DepartmentID);

##Question 2: Viết lệnh để lấy ra thông tin các Account được tạo sau ngày 20/12/2010
SELECT *
FROM `Account`
WHERE CreateDate < '2010/12/20';

##Question 3: Viết lệnh để lấy ra tất cả các Developer
SELECT *
FROM `Account` A
JOIN  `Position` P
USING(PositionID)
WHERE P.PositionName = 'Dev';

SELECT *
FROM `Account` A
INNER JOIN  `Position` P
ON A.PositionID = P.PositionID
WHERE P.PositionName = 'Dev';

##Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT D.DepartmentName, Count(A.AccountID) AS 'Số lượng NV'
FROM Department D
JOIN `Account` A
ON D.DepartmentID = A.DepartmentID
GROUP BY D.DepartmentName
HAVING Count(A.AccountID) > 3;

##Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất 
-- C1
SELECT Q.Content, COUNT(EQ.ExamID) AS 'Number_of_Exams'						
FROM Question Q						
INNER JOIN ExamQuestion EQ						
USING(QuestionID)						
GROUP BY Q.Content					
HAVING COUNT(Q.Content) = (SELECT MAX(CountQ) 
                           FROM (SELECT COUNT(EQ.ExamID) AS CountQ
                           FROM Question Q JOIN ExamQuestion EQ 
						   USING(QuestionID) 
						   GROUP BY Q.Content) AS MaxContent);
-- C2
SELECT Q.Content, COUNT(EQ.ExamID) AS 'Number_of_Exams'
FROM Question Q 
INNER JOIN ExamQuestion EQ 
ON Q.QuestionID = EQ.QuestionID
GROUP BY Q.Content
ORDER BY COUNT(EQ.ExamID) DESC
LIMIT 1;

##Question 6: Thống kê mỗi Category Question được sử dụng trong bao nhiêu Question
SELECT CQ.CategoryID, CQ.CategoryName, COUNT(Q.CategoryID) AS 'Number_of_Category'				
FROM CategoryQuestion CQ	 				
LEFT JOIN Question Q				
USING(CategoryID)				
GROUP BY CQ.CategoryID;

##Question 7: Thống kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT Q.Content, COUNT(EQ.QuestionID) AS 'Number_of_Question'				
FROM Question Q				
LEFT JOIN ExamQuestion EQ				
USING(QuestionID)				
GROUP BY Q.QuestionID;

##Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT Q.QuestionID, Q.Content, COUNT(A.QuestionID) AS 'Number_of_MaxQuestion'				
FROM Question Q				
JOIN Answer A			
USING(QuestionID)				
GROUP BY A.QuestionID				
HAVING COUNT(A.QuestionID) = (SELECT MAX(CountM_Q) 
                              FROM (SELECT COUNT(A.QuestionID) AS 'CountM_Q'
									FROM Answer A 
                                    RIGHT JOIN Question Q 
                                    USING(QuestionID) 
                                    GROUP BY A.QuestionID) AS Max_CountQ);				
##Question 9: Thống kê số lượng Account trong mỗi Group
SELECT G.GroupName, COUNT(GA.AccountID) AS 'Number_of_Account'
FROM GroupAccount GA			
RIGHT JOIN `Group` G	
USING(GroupID)			
GROUP BY G.GroupID;
				
##Question 10: Tìm chức vụ có ít người nhất
SELECT P.PositionName, COUNT(A.PositionID) AS 'Number_of_MinPosition'		
FROM `Position` P						
INNER JOIN `Account` A						
USING(PositionID)				
GROUP BY P.PositionID
HAVING COUNT(A.PositionID) = (SELECT MIN(CountP) 
                              FROM (SELECT COUNT(P.PositionID) AS 'CountP' 
									FROM `Position` P 
                                    JOIN `Account` A 
                                    USING(PositionID) 
                                    GROUP BY P.PositionID) AS Min_CountP);
                                    
##Question 11: Thống kê mỗi phòng ban có bao nhiêu Dev, Test, Scrum Master, PM
-- Output: DepartmentName, PositionName, Number_each_Position
SELECT D.DepartmentName, P.PositionName, COUNT(A.AccountID) AS 'Number_each_Position'						
FROM `Account` A						
JOIN Department D USING(DepartmentID)						
JOIN `Position` P USING(PositionID)						
GROUP BY D.DepartmentName, P.PositionName;
						
##Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo 
-- ra câu hỏi , câu trả lời là gì,...
SELECT Q.Content, A.Content, TQ.TypeName, `Account`.Fullname AS 'Người tạo', Q.CreateDate
FROM Question Q
INNER JOIN Answer A USING(QuestionID)
INNER JOIN TypeQuestion TQ USING(TypeID)
INNER JOIN `Account` ON Q.CreatorID = `Account`.AccountID;

##Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
-- Output: TypeName, Number_of_TypeQuestion
SELECT TQ.TypeName, COUNT(Q.TypeID) AS 'Number_of_TypeQuestion'
FROM Question Q
INNER JOIN TypeQuestion TQ
ON Q.TypeID = TQ.TypeID
GROUP BY Q.TypeID;

##Question 14-15: Lấy ra Group không có Account nào
SELECT *
FROM `Group`
WHERE GroupID NOT IN (SELECT GroupID FROM GroupAccount);

-- LEFT EXCLUDING JOIN
SELECT 		G.GroupName
FROM 		`Group` G
LEFT JOIN 	GroupAccount GA 
USING(GroupID)
WHERE GA.GroupID IS NULL;

##Question 16: Lấy ra Question không có Answer nào
SELECT *
FROM Question
WHERE QuestionID NOT IN (SELECT QuestionID FROM Answer);

SELECT Q.Content
FROM Question Q
LEFT JOIN Answer A
ON Q.QuestionID = A.QuestionID
WHERE A.QuestionID IS NULL;


##Thống kê số lượng nhân viên mỗi phòng ban
SELECT D.DepartmentName, COUNT(A.AccountID) AS 'Number_of_Account'					
FROM Department D
LEFT JOIN `Account` A		-- Những trường hợp không có nv nào sẽ để 0 nên dùng LEFT JOIN			
ON D.DepartmentID = A.DepartmentID												
GROUP BY D.DepartmentName;

-- Trường hợp: Account không thuộc phòng ban naò RIGHT JOIN
-- Lấy thông tin từ bảng nào trước thì From thứ tư bảng đó trước

## In ra danh sách tên phòng ban của mỗi nhân viên
-- Output: AccountID, FullName, DepartmentName
SELECT A.AccountID, A.FullName, D.DepartmentName					
FROM Department D
RIGHT JOIN `Account` A			
ON D.DepartmentID = A.DepartmentID;								

-- Exercise 2: UNION --
##Question 17:
-- a) Lấy các Accout thuộc nhóm thứ 1
SELECT A.Fullname
FROM `Account` A
JOIN GroupAccount GA
USING (AccountID)
WHERE GA.GroupID = 1;
-- b) Lấy các Account thuộc nhóm thứ 2
SELECT A.Fullname
FROM `Account` A
JOIN GroupAccount GA
USING (AccountID)
WHERE GA.GroupID = 2;
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT A.Fullname
FROM `Account` A
JOIN GroupAccount GA
USING (AccountID)
WHERE GA.GroupID = 1
UNION
SELECT A.Fullname
FROM `Account` A
JOIN GroupAccount GA
USING (AccountID)
WHERE GA.GroupID = 2;

##Question 18:
-- a) Lấy các Group có lớn hơn 5 thành viên
SELECT G.GroupName, COUNT(1) AS 'Number_of_Account'
FROM `Group` G
JOIN GroupAccount GA
USING(GroupID)
GROUP BY GA.GroupID
HAVING Number_of_Account > 5;
-- b) Lấy các Group có nhỏ hơn 7 thành viên
SELECT G.GroupName, COUNT(1) AS 'Number_of_Account'
FROM `Group` G
JOIN GroupAccount GA
USING(GroupID)
GROUP BY GA.GroupID
HAVING Number_of_Account < 7;
-- c) Ghép hai kết quả câu a) và câu b)
SELECT G.GroupName, COUNT(1) AS 'Number_of_Account'
FROM `Group` G
JOIN GroupAccount GA
USING(GroupID)
GROUP BY GA.GroupID
HAVING Number_of_Account > 5
UNION
SELECT G.GroupName, COUNT(1) AS 'Number_of_Account'
FROM `Group` G
JOIN GroupAccount GA
USING(GroupID)
GROUP BY GA.GroupID
HAVING Number_of_Account < 7;