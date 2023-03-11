#Tạo cơ sở dữ liệu 'ThucTap'
DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE IF NOT EXISTS ThucTap;

USE ThucTap;
/*Question 1: Tạo table với các rằng buộc và kiểu dữ liệu
			 Thêm ít nhất 3 bản ghi vào table
*/
#Tạo bảng 'Country'
DROP TABLE IF EXISTS Country;
CREATE TABLE IF NOT EXISTS Country (
    country_id TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    country_name VARCHAR(100) NOT NULL
);
#Tạo bảng 'Location'
DROP TABLE IF EXISTS Location;
CREATE TABLE IF NOT EXISTS Location (
    location_id TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    street_address VARCHAR(100) NOT NULL,
    postal_code CHAR(10) NOT NULL,
    country_id TINYINT UNSIGNED,
    CONSTRAINT fk_1 FOREIGN KEY (country_id) REFERENCES Country(country_id) ON DELETE CASCADE
);
#Tạo bảng 'Employee'
DROP TABLE IF EXISTS Employee;
CREATE TABLE IF NOT EXISTS Employee (
    employee_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE KEY,
    location_id TINYINT UNSIGNED,
    CONSTRAINT fk_2 FOREIGN KEY (location_id) REFERENCES Location(location_id)
);

#Thêm bản ghi
INSERT INTO Country(country_name)
VALUES
		('Viet Nam'),
        ('Lao'	),
        ('Campuchia'),
        ('China'),
        ('Thailand');


INSERT INTO Location(street_address,postal_code,country_id)
VALUES
		('Ha Noi',    		'10000',	1),
        ('Da Nang',   		'50000',	1),
        ('Quang Chau',		'160000',	4),
        ('Bangkok',			'10110',	5),
        ('Phnom Penh',		'12100',	3);
        
INSERT INTO Employee(full_name,email,location_id)
VALUES
		('Nguyễn Trung Dũng',    		'trungdungbka59@gmail.com',		1),
        ('Dư Cảnh Thiên',   			'nn03@gmail.com',				3),
        ('Lisa Marie',					'lisa98@gmail.com',				4),
        ('Henry Cavill',			   'henry123@gmail.com',	        5),
        ('Nguyễn Hồng Đăng',		    'nhdang56@gmail.com',			2);

/*Question 2: Viết lệnh để
				a) Lấy tất cả các nhân viên thuộc Việt Nam
*/
SELECT 
    E.*, L.street_address, C.country_name
FROM
    Employee E
        JOIN
    Location L USING (location_id)
        JOIN
    Country C USING (country_id)
WHERE
    C.country_name = 'Viet Nam';
    
/*b) Lấy ra tên quốc gia của employee có email 'nn03@gmail.com'
*/
SELECT 
    C.country_name
FROM
    Employee E
        JOIN
    Location L USING (location_id)
        JOIN
    Country C USING (country_id)
WHERE
    E.email = 'nn03@gmail.com';
/*c) Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc
*/
SELECT 
    C.country_name,
    L.street_address,
    COUNT(E.location_id) AS number_of_employee
FROM
    Country C
        JOIN
    Location L USING (country_id)
		JOIN
    Employee E USING (location_id)
GROUP BY E.location_id;

-- c)  Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc. 
SELECT			C.country_id As Id, C.country_name As Country_Or_Location, COUNT(E.employee_id) As Employee_Count
FROM			Country As C
LEFT JOIN		Location As L ON C.country_id = L.country_id
LEFT JOIN		Employee As E ON L.location_id = E.location_id
GROUP BY		C.country_id, C.country_name
UNION ALL 
SELECT			L.location_id As Id, L.street_address As Country_Or_Location, COUNT(E.employee_id) As Employee_Count
FROM			Location As L
LEFT JOIN		Employee As E ON L.location_id = E.location_id
GROUP BY		L.location_id, L.street_address; 


/*Question 3: Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 
10 employee
*/
DROP TRIGGER IF EXISTS before_insert_employee;
DELIMITER $$
CREATE TRIGGER before_insert_employee
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
	DECLARE V_country_name VARCHAR(100);
	SELECT T1.country_name INTO V_country_name 
    FROM
    (SELECT 
        C.country_name, COUNT(E.employee_id)
    FROM
        Country C
    JOIN Location L USING (country_id)
    JOIN Employee E USING (location_id)
    GROUP BY C.country_name
    HAVING COUNT(E.employee_id) = 10) AS T1;
    
    IF NEW.location_id IN (SELECT T2.location_id 
							FROM ( SELECT L.location_id 
									FROM Country C JOIN Location L USING(country_id) 
                                    WHERE C.country_name = V_country_name) AS T2)
    THEN 
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'Over number of employee for each country';
    END IF;
END$$
FOR EACH 
DELIMITER ;

 DROP TRIGGER IF EXISTS getquestion3;
 DELIMITER $$
-- CREATE TRIGGER getquestion3
-- BEFORE INSERT ON Employee
-- FOR EACH ROW
-- BEGIN
-- DECLARE Nhan_vien TINYINT   ;
-- DECLARE So_Quoc_Gia TINYINT ;

-- SELECT  L.Country_ID INTO So_Quoc_Gia
-- FROM   Location L 
-- WHERE L.Location_ID = NEW.Location_ID ;

-- SELECT COUNT(E.Location_ID) INTO Nhan_vien 
-- FROM   Employee E
-- JOIN Location L ON L.Location_ID = E.Location_ID 
-- GROUP BY L.Country_ID 
-- HAVING L.Country_ID = So_Quoc_Gia ;

-- IF Nhan_vien > 10 THEN
-- SIGNAL SQLSTATE '12345'
-- SET MESSAGE_TEXT = 'Ko the add them Employee';
-- END IF ;
-- END$$
 DELIMITER ;
 
  3.  Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
DROP TRIGGER IF EXISTS Tr_beforeEmployeeInsert;
DELIMITER $$
CREATE TRIGGER Tr_beforeEmployeeInsert
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
	DECLARE	V_country_id INT;
	DECLARE	v_employeeCount INT;
    
    SELECT	country_id INTO V_country_id
    FROM	Location
    WHERE	location_id = NEW.location_id;
        
	WITH Cte_Employee_Raw As(
		SELECT			E.*, C.country_id, C.country_name
		FROM			Employee As E
		INNER JOIN		Location As L ON E.location_id = L.location_id
		INNER JOIN		Country As C ON	L.country_id = C.country_id
    )
    SELECT		COUNT(employee_id) INTO v_employeeCount		
    FROM		Cte_Employee_Raw As C_E
    WHERE		C_E.country_id = V_country_id;
	
	-- Logic 
	IF(v_employeeCount > 3) 
		THEN
			SIGNAL SQLSTATE '12345' -- Disallow insert this record
            SET MESSAGE_TEXT = 'Error : Countries with maximum 10 employees';
	END IF;
END
$$ DELIMITER ;

-- Thử insert
INSERT INTO Employee(full_name,email,location_id)
VALUES
		('Nguyễn Văn A',    		'nguyenvana@gmail.com',		1),
		('Nguyễn Văn B',    		'nguyenvanb@gmail.com',		1),
		('Nguyễn Văn C',    		'nguyenvanc@gmail.com',		1),
		('Nguyễn Văn D',    		'nguyenvand@gmail.com',		1),
		('Nguyễn Văn E',    		'nguyenvane@gmail.com',		1),
		('Nguyễn Văn F',    		'nguyenvanf@gmail.com',		1),
		('Nguyễn Văn G',    		'nguyenvang@gmail.com',		1),
		('Nguyễn Văn H',    		'nguyenvanh@gmail.com',		1),
		('Nguyễn Văn J',    		'nguyenvanj@gmail.com',		1),
		('Nguyễn Văn K',    		'nguyenvank@gmail.com',		1);
        

/*Question 4: Hãy cấu hình table sao cho khi xoá 1 location nào đó thì tất cả employee
ở location đó sẽ có location_id= NULL
*/
-- Delete foreign key của bảng Employee: 'fk_2'
ALTER TABLE Employee
DROP FOREIGN KEY fk_2;

ALTER TABLE Employee
ADD FOREIGN KEY (location_id) REFERENCES Location(location_id) ON DELETE SET NULL;
