-- Tạo CSDL
DROP DATABASE IF EXISTS user_manager;
CREATE DATABASE IF NOT EXISTS user_manager;
USE user_manager;

-- Tạo bảng `user`
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
    user_id 	SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    full_name 	VARCHAR(50) NOT NULL,
    email 		VARCHAR(50) NOT NULL UNIQUE KEY,
    `password` 	VARCHAR(18) NOT NULL CHECK ((length(`password`) >= 6)) DEFAULT '123456',
    `exp` 		TINYINT UNSIGNED DEFAULT '0',
    skill 		VARCHAR(50) NOT NULL,
    is_senior 	ENUM('Senior', 'Fresher') NOT NULL DEFAULT 'Fresher'
);

-- Thêm DL vào bảng `user`
INSERT INTO `user` (full_name,				email,						`password`,				`exp`,			skill,			is_senior	)
VALUES
				   ('Nguyễn Thị Mỵ',			'mynt2407@gmail.com', 		'Mynguyen123',			8,				'Java',			'Senior'	),
				   ('Nguyễn Ngọc Duy',		'duynn03@gmail.com', 		'duyNguyen',			1,				'PHP',			'Fresher'	),
				   ('Nguyễn Hùng Mạnh',		'hungmanh@gmail.com', 		'hunGmanh1',			2,				'Python',		'Fresher'	),
				   ('Tống Thị Nhung',		'nhung@gmail.com', 			'nhungtOng',			5,				'PHP',			'Senior'	),
                   ('Trần Thị Kim Anh',		'kimoanh.tran@gmail.com', 	'Tran.kim',				6,				'Python',		'Senior'	);