##SQL- Assigmment 6
USE Testing_System_Assigment3;

-- Trên lớp --
DROP PROCEDURE IF EXISTS getAccountByID;
DELIMITER $$
    CREATE PROCEDURE getAccountByID (IN idAccount INT, OUT username_ VARCHAR(50))
    BEGIN
       SELECT Username INTO username_ FROM `Account` WHERE AccountID = idAccount;
    END$$
DELIMITER ;
SET @UserNameByID = '';
SELECT @UserNameByID;
CALL getAccountByID (3, @UserNameByID);
SELECT @UserNameByID;

DROP PROCEDURE IF EXISTS getDepartmentNameByID;
DELIMITER $$
    CREATE PROCEDURE getDepartmentNameByID (IN id INT, OUT dpName VARCHAR(50), OUT dpID INT)
    BEGIN
       SELECT DepartmentName, DepartmentID INTO dpName,dpID FROM Department WHERE DepartmentID = id;
    END$$
DELIMITER ;
SET @DepartmentName = '';
SET @DepartmentID = 0;
CALL getDepartmentNameByID (2, @DepartmentName, @DepartmentID);
SELECT @DepartmentName, @DepartmentID;

DROP PROCEDURE IF EXISTS getDepartmentNameByID;
DELIMITER $$
    CREATE PROCEDURE getDepartmentNameByID (IN id INT)
    BEGIN
       DECLARE DepartmentName_ VARCHAR(200);
       DECLARE DepartmentID_ TINYINT;
       SELECT DepartmentName, DepartmentID INTO DepartmentName_, DepartmentID_ FROM Department WHERE DepartmentID = id;
       SELECT DepartmentName_, DepartmentID_;
    END$$
DELIMITER ;
CALL getDepartmentNameByID (4);


-- Exercise -- 
##Question 1: Tạo store để người dùng nhập vaò tên phòng ban và in ra tất cả các Account thuộc phòng ban
DROP PROCEDURE IF EXISTS get_Account_By_DepartmentName;
DELIMITER $$
CREATE PROCEDURE get_Account_By_DepartmentName (IN in_DepartmentName VARCHAR(200))
BEGIN
   SELECT * FROM `Account` JOIN Department USING(DepartmentID)
   WHERE DepartmentName LIKE CONCAT('%', in_DepartmentName ,'%');
   -- Hoặc: WHERE DepartmentName LIKE in_DepartmentName;
   -- Hoặc: WHERE DepartmentName = in_DepartmentName;
END$$
DELIMITER ;

CALL get_Account_By_DepartmentName ('Market');
CALL get_Account_By_DepartmentName ('%Market%');

##Question 2: Tạo store để in ra số lượng Account mỗi Group
DROP PROCEDURE IF EXISTS get_Account_By_GroupID;
DELIMITER $$
CREATE PROCEDURE get_Account_By_GroupID (IN in_GroupID INT)
BEGIN
   SELECT GroupID, COUNT(AccountID) AS 'Number_of_Account'
   FROM GroupAccount WHERE GroupID = in_GroupID GROUP BY GroupID;
END$$
DELIMITER ;
CALL get_Account_By_GroupID (3);

##Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại 
DROP PROCEDURE IF EXISTS get_typequestion_of_month;
DELIMITER $$
CREATE PROCEDURE get_typequestion_of_month()
BEGIN
   SELECT COUNT(TypeID)
   FROM Question
   WHERE Month(CreateDate) = Month(Now());
END $$
DELIMITER ;
CALL get_typequestion_of_month();

select concat(month(now()),'/',year(now()));

##Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS get_TypeID_by_MaxQuestion;
DELIMITER $$
CREATE PROCEDURE get_TypeID_by_MaxQuestion ()
BEGIN
   SELECT TypeID, COUNT(TypeID) AS 'Number_of_Question'
   FROM Question
   GROUP BY TypeID
   ORDER BY COUNT(TypeID) DESC
   LIMIT 1;
END $$
DELIMITER ;
CALL get_TypeID_by_MaxQuestion ();
   
-- Hoặc --
DROP PROCEDURE IF EXISTS get_TypeID_by_MaxQuestion;
DELIMITER $$
CREATE PROCEDURE get_TypeID_by_MaxQuestion ()
BEGIN
   WITH
   CTE_Max_Count_TypeID AS
   (
    SELECT COUNT(TypeID)
    FROM Question
    GROUP BY TypeID
    HAVING COUNT(TypeID)
    ORDER BY COUNT(TypeID) DESC
    LIMIT 1
   )
   SELECT TypeID
   FROM Question
   GROUP BY TypeID
   HAVING COUNT(TypeID) = (SELECT * FROM CTE_Max_Count_TypeID);
END $$
DELIMITER ;
CALL get_TypeID_by_MaxQuestion ();

/* Question 5: Sử dụng store ở question 4 để tìm ra tên của typequestion */
DROP PROCEDURE IF EXISTS get_TypeName_Question;
DELIMITER $$
CREATE PROCEDURE get_TypeName_Question ()
BEGIN
   WITH
   CTE_Max_Count_TypeID AS
   (
    SELECT COUNT(TypeID)
    FROM Question
    GROUP BY TypeID
    HAVING COUNT(TypeID)
    ORDER BY COUNT(TypeID) DESC
    LIMIT 1
   )
   SELECT TQ.TypeName
   FROM Question Q JOIN TypeQuestion TQ USING(TypeID)
   GROUP BY Q.TypeID
   HAVING COUNT(Q.TypeID) = (SELECT * FROM CTE_Max_Count_TypeID);
END $$
DELIMITER ;
CALL get_TypeName_Question ();

/* Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi 
của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào */
-- Nhập 0: Trả về Group có tên chứa chuỗi
-- Nhập 1: Trả về User có tên chứa chuỗi
DROP PROCEDURE IF EXISTS get_Name_byString;
DELIMITER $$
CREATE PROCEDURE get_Name_byString (IN in_String NVARCHAR(100), IN in_select INT)
BEGIN
   IF in_select = 0 
   THEN
       SELECT *
       FROM `Group`
       WHERE GroupName LIKE CONCAT('%',in_String,'%');
   ELSE
       SELECT FullName, Username, Email
       FROM `Account`
       WHERE Username LIKE CONCAT('%',in_String,'%');
   END IF;
END $$
DELIMITER ;
CALL get_Name_byString('van',1);
CALL get_Name_byString('n',0);

/* Question 7: Viết 1 store cho phép người dùng nhập vào thông tin FullName, email 
và trong store sẽ tự động gán:
 Username: sẽ giống email nhưng bỏ phần @...mail đi
 positionID: sẽ có default là Developer
 departmentID: sẽ được cho vào 1 phòng chờ
 Sau đó in ra kết quả tạo thành công. */
/*  DROP PROCEDURE IF EXISTS Import_Account;
 DELIMITER $$
 CREATE PROCEDURE Import_Account (INT in_Fullname NVARCHAR(255), INT in_Email VARCHAR(255))
 BEGIN
    DECLARE User_name VARCHAR(255) DEFAULT SUBSTRING_INDEX(in_Email,'@',1) ;
    /*Substring_index (str, delim, count) trả về một chuỗi con từ một chuỗi trước một số lần xuất hiện cụ thể của dấu phân cách.
    str: chuỗi gốc; delim: 1 chuỗi, hđ như dấu phân cách, count: xđ số lần tìm kiếm dấu phân cách, nó có thể là số + or -
    +: hàm trả về tất cả bên trái dấu phân cách, -: trả về bên phải */
SET GLOBAL log_bin_trust_function_creators = 1;

-- VIẾT 1 Function: Đầu vào AccountID, đầu ra là Fullname
DELIMITER $$
CREATE FUNCTION get_fullname (p_account_id INT) RETURNS VARCHAR(50)
BEGIN
   DECLARE V_Fullname VARCHAR(50);
   
   SELECT Fullname INTO V_Fullname
   FROM `Account`
   WHERE AccountID = p_account_id;
   
   RETURN V_Fullname;
END$$
DELIMITER ;

SELECT get_fullname (100);

