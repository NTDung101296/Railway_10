-- 1. Tạo table với các ràng buộc và kiểu dữ liệu
-- Thêm ít nhất 3 bản ghi vào table
DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;

DROP TABLE IF EXISTS Country;
CREATE TABLE Country (
	country_id		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	country_name	VARCHAR(20) NOT NULL
);
INSERT INTO  Country  (country_name	)
VALUES				  ('Vietnam'    ),
					  ('America'    ),
					  ('Japan'      ),
				      ('Korea'      ),   
				      ('France'     );   
				  
                      
DROP TABLE IF EXISTS Location;
CREATE TABLE  Location (
    location_id			TINYINT UNSIGNED PRIMARY KEY,
	street_address		VARCHAR(30) NOT NULL,
	postal_code			CHAR(10) NOT NULL,
	country_id			TINYINT UNSIGNED NOT NULL,
	CONSTRAINT fk_location FOREIGN KEY(country_id) REFERENCES Country (country_id)
);
INSERT INTO Location  ( location_id, street_address		, postal_code	, country_id)
VALUES		  		  (    1       ,'19 Le Thanh Nghi'	,  '10000' 		,   '1'     ), 
					  (    2       ,'Chiba Matsudo 2'	,  '270-110' 	,   '3'     ), 
					  (    3       ,'Tokyo Asasaka 17'	,  '160-0022' 	,   '3'     ), 
					  (    4       ,'Seoul Gwangjin 36'	,  '300'		,   '4'     ), 
					  (    5       ,'Paris 8'			,  '75008'		,   '5'     );

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
	employee_id		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	full_name		VARCHAR(30) NOT NULL,
	email			VARCHAR(30) NOT NULL UNIQUE KEY,
	location_id		TINYINT UNSIGNED,
    CONSTRAINT fk_employee FOREIGN KEY(location_id) REFERENCES Location (location_id)
);
INSERT INTO Employee (full_name  		, email					,  location_id )  
VALUES				 ('Masumoto Kenta'  , 'kenta.m@gmail.com'   ,       3      ), 
					 ('Nguyen Van Nam'  , 'nn03@gmail.com'   	,       1      ), 
					 ('Park Hang Seo'   , 'seo.park@gmail.com'  ,       4      );
                    
-- 2. Viết lệnh để
-- a) Lấy tất cả các nhân viên thuộc Việt nam
SELECT e.full_name, e.email, c.country_name
FROM Employee e
JOIN Location l ON e.location_id = l.location_id
JOIN Country c ON l.country_id = c.country_id
WHERE c.country_name = 'Vietnam';

-- b) Lấy ra tên quốc gia của employee có email là "nn03@gmail.com"
SELECT c.country_name
FROM Country c 
JOIN Location l ON c.country_id = l.country_id 
JOIN Employee e ON e.location_id = l.location_id
WHERE e.email = 'nn03@gmail.com';

-- c) Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc.
SELECT c.country_id, l.location_id,
	  IF ((COUNT(e.employee_id) IS NULL),0,COUNT(e.employee_id)) AS number_of_employee
FROM Employee e
RIGHT JOIN Location l ON e.location_id = l.location_id
RIGHT JOIN Country c ON l.country_id = c.country_id
GROUP BY c.country_id, l.location_id
ORDER BY c.country_id, l.location_id;

-- 3. Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa
--  10 employee
DROP TRIGGER IF EXISTS before_insert_employee;
DELIMITER $$
CREATE TRIGGER before_insert_employee
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
	DECLARE v_number_of_employee TINYINT;
    
    SELECT COUNT(e.employee_id) INTO v_number_of_employee
	FROM Country c 
	JOIN Location l ON c.country_id = l.country_id 
	RIGHT JOIN Employee e ON e.location_id = l.location_id
    GROUP BY c.country_id;
    
     IF v_number_of_employee > 10 THEN
		SIGNAL SQLSTATE '12345' -- disallow insert this record
		SET MESSAGE_TEXT = 'One country has a maximum of 10 employee!';
	END IF;
END$$
DELIMITER ;

-- 4.Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở
-- location đó sẽ có location_id = null
ALTER TABLE Employee
DROP FOREIGN KEY fk_employee;

ALTER TABLE Employee
ADD CONSTRAINT fk_employee FOREIGN KEY(location_id) REFERENCES Location (location_id) ON DELETE SET NULL;