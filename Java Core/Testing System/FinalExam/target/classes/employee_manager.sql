-- Tạo CSDL
DROP DATABASE IF EXISTS employee_manager;
CREATE DATABASE IF NOT EXISTS employee_manager;
USE employee_manager;

-- Tạo bảng employee
DROP TABLE IF EXISTS employee;
CREATE TABLE IF NOT EXISTS employee (
    employee_id VARCHAR(5) PRIMARY KEY,
    full_name 	VARCHAR(50) NOT NULL,
    email 		VARCHAR(50) NOT NULL UNIQUE KEY,
    `password` 	VARCHAR(18) NOT NULL CHECK ((length(`password`) >= 6)) DEFAULT '123456',
    pro_skill 	VARCHAR(50) NOT NULL
);

-- Tạo bảng manager
DROP TABLE IF EXISTS manager;
CREATE TABLE IF NOT EXISTS manager (
    manager_id 	VARCHAR(5) PRIMARY KEY,
    full_name 	VARCHAR(50) NOT NULL,
    email 		VARCHAR(50) NOT NULL UNIQUE KEY,
    `password` 	VARCHAR(18) NOT NULL CHECK ((length(`password`) >= 6)) DEFAULT '123456',
    exp_in_year TINYINT UNSIGNED
);

-- Tạo bảng project
DROP TABLE IF EXISTS project;
CREATE TABLE IF NOT EXISTS project (
    project_id  INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    team_size 	TINYINT UNSIGNED NOT NULL,
    id_manager 	VARCHAR(5),
    FOREIGN KEY (id_manager) REFERENCES manager(manager_id)
);

-- Tạo bảng project_and_employee
DROP TABLE IF EXISTS project_and_employee;
CREATE TABLE IF NOT EXISTS project_and_employee (
    project_id  INT UNSIGNED NOT NULL,
    employee_id VARCHAR(5),
    FOREIGN KEY (project_id) REFERENCES project (project_id),
    FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
    PRIMARY KEY(project_id, employee_id)
);

/* ========== INSERT DATA ========== */
INSERT INTO employee
VALUES
	('E1', 		'Nguyễn Thanh Huyền', 			'nguyen-thanh.huyen@gmail.com', 		'Huyen96', 			'SQL'	),
	('E2', 		'Tăng Mạnh Hùng', 				'tang-manh.hung@gmail.com', 			'THung97', 			'Java'		),
	('E3', 		'Nguyễn Diệu Hà', 				'nguyen-dieu.ha@gmail.com', 			'2016P@ss', 		'PHP'		),
	('E4', 		'Hoàng Kiều Chinh', 			'hoang-kieu.chinh@gmail.com', 			'P@ss2017', 		'.NET'		),
	('E5', 		'Lưu Đỗ Trường', 				'luu-do.truong@gmail.com', 				'2018P@ss', 		'ReactJS'	),
	('E6', 		'Trần Đình Định', 				'tran-dinh.dinh@gmail.com', 			'DinhTran', 		'NodeJS'	),
	('E7', 		'Nguyễn Đức Anh', 				'nguyen-duc.ạnh@gmail.com', 			'ANh1994', 			'ReactJS'	),
	('E8', 		'Nguyễn Văn Huấn',				'nguyen-van.huan@gmail.com', 			'P@ss2021', 		'PHP'		),
	('E9', 		'Trương Quỳnh Châu', 			'truong-quynh.chau@gmail.com', 			'ChauQuynh', 		'SQL'		),
	('E10', 	'Đinh Lan Anh', 				'dinh-lan.anh@gmail.com', 				'1234Anh', 			'Java'		),
	('E11', 	'Nguyễn Công Đức', 				'nguyen-cong.duc@gmail.com', 			'DucCong97', 		'NodeJS'	),
	('E12', 	'Lê Thị Hồng', 					'le-thi.hong@gmail.com', 				'HOng98', 		 	'C#'		),
	('E13', 	'Trương Hải Ly', 				'truong-hai.ly@gmail.com', 				'P@ss2019', 		'C#'		),
	('E14', 	'Nguyễn Ngọc Thanh', 			'nguyen-ngoc.thanh@gmail.com', 			'Th@nh93', 			'Python'	),
	('E15', 	'Tống Đức Huân', 				'tong-duc.huan@gmail.com', 				'HuanTonG', 		'.Net'		);

INSERT INTO manager
VALUES
	('M1', 		'Trần Trường Giang', 			'tran-truong.giang@gmail.com', 			'Gi@ngTran', 		9		),
	('M2', 		'Trần Xuân Trường', 			'tran-xuan.truong@gmail.com', 			'TruongTran', 		7		),
	('M3', 		'Nguyễn Thanh Trà', 			'nguyen-thanh.tra@gmail.com', 			'2013P@ss', 		10		),
	('M4', 		'Nguyễn Hải Đăng', 				'nguyen-hai.dang@gmail.com', 			'D@ngHai', 			8		),
	('M5', 		'Nguyễn Thị Hương', 			'nguyen-thi.huong@gmail.com', 			'HuongNT', 			6		),
	('M6', 		'Nguyễn Thu Hằng', 				'nguyen-thu.hang@gmail.com', 			'H@ngNT', 			5		),
	('M7', 		'Nguyễn Mạnh Thắng', 			'nguyen-manh.thang@gmail.com', 			'Th@ngNM', 			6		),
	('M8', 		'Nguyễn Thu Hường', 			'nguyen-thu.huong@gmail.com', 			'NTHuong', 			6		);
    
    
INSERT INTO project		(team_size,		id_manager)		
VALUES					(4, 			'M5'	  ),
						(6, 			'M1'	  ),
						(8, 			'M4'	  ),
						(6, 			'M2'	  ),
						(3, 			'M3'	  );

INSERT INTO project_and_employee		(project_id,		employee_id)		
VALUES									(1,					'E1'	   ),
										(1,					'E3'	   ),
										(1,					'E5'	   ),
										(1,					'E11'	   ),
										(2,					'E2'	   ),
										(2,					'E15'	   ),
										(2,					'E4'	   ),
										(2,					'E1'	   ),
										(2,					'E6'	   ),
										(2,					'E8'	   ),
										(2,					'E10'	   ),
										(3,					'E10'	   ),
										(3,					'E11'	   ),
										(3,					'E12'	   ),
										(3,					'E2'	   ),
										(3,					'E7'	   ),
										(3,					'E9'	   ),
										(3,					'E14'	   ),
										(3,					'E13'	   ),
										(4,					'E2'	   ),
										(4,					'E3'	   ),
										(4,					'E4'	   ),
										(4,					'E5'	   ),
										(4,					'E6'	   ),
										(4,					'E7'	   ),
										(5,					'E13'	   ),
										(5,					'E14'	   ),
										(5,					'E15'	   );

-- Viết function để user lấy ra tất cả manager của các project (in ra dạng table)
DROP PROCEDURE IF EXISTS sp_get_manager_of_all_project;
DELIMITER $$
CREATE PROCEDURE sp_get_manager_of_all_project()
BEGIN
	SELECT 
    p.id_manager,
    m.full_name,
    m.email,
    m.exp_in_year,
    p.project_id
FROM
    manager m
      INNER JOIN
    project p ON m.manager_id = p.id_manager;
END$$
DELIMITER ;
CALL sp_get_manager_of_all_project();

-- Lấy ra thông tin của manager
-- Input: manager_id
DROP PROCEDURE IF EXISTS sp_get_manager_by_id;
DELIMITER $$
CREATE PROCEDURE sp_get_manager_by_id(in_manager_id VARCHAR(5))
BEGIN
	SELECT 
    manager_id,
    full_name,
    email,
    exp_in_year
FROM
    manager
    WHERE manager_id = in_manager_id;
END$$
DELIMITER ;
CALL sp_get_manager_by_id('M1');


-- Lấy ra thông tin của employee
-- Input: employee_id
DROP PROCEDURE IF EXISTS sp_get_employee_by_id;
DELIMITER $$
CREATE PROCEDURE sp_get_employee_by_id(in_employee_id VARCHAR(5))
BEGIN
	SELECT 
    employee_id,
    full_name,
    email,
    pro_skill
FROM
    employee
    WHERE employee_id = in_employee_id;
END$$
DELIMITER ;
CALL sp_get_employee_by_id('E1');

-- Lấy ra thông tin của tất cả nhân viên tham gia vào dự án
-- Input: project_id
DROP PROCEDURE IF EXISTS sp_get_employees_by_project_id;
DELIMITER $$
CREATE PROCEDURE sp_get_employees_by_project_id(in_project_id INT UNSIGNED)
BEGIN
	SELECT 
    pe.employee_id,
    e.full_name,
    e.email,
    e.pro_skill
FROM
    employee e
        JOIN
    project_and_employee pe ON e.employee_id = pe.employee_id
    WHERE project_id = in_project_id;
END$$
DELIMITER ;
CALL sp_get_employees_by_project_id(1);

-- Login 
SELECT * FROM manager WHERE email = ?  AND `password`= ? ;
SELECT * FROM employee WHERE email = ?  AND `password`= ? ;

-- Lấy thông tin của tất cả employee
SELECT 
    *
FROM
    employee;




