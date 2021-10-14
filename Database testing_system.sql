-- Quy tắc đặt tên trong MySQL:
-- 1. Các chữ cái trong tên database, column, ... sẽ viết thường 
-- 2. Nếu tên database, column, ... có 2 từ trở lên thì các từ sẽ phân cách bằng dấu _

-- Tạo cơ sở dữ liệu Hệ Thống Thi Cử
DROP DATABASE IF EXISTS testing_system;
CREATE DATABASE testing_system;	
USE testing_system;

-- Tạo các bảng
-- Tạo bảng phòng ban
CREATE TABLE department(
	department_id			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    department_name			VARCHAR(50) UNIQUE NOT NULL CHECK (LENGTH(department_name) >= 2 )
);


-- tạo bảng chức vụ
CREATE TABLE `position`(
	position_id				TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    position_name			VARCHAR(20) UNIQUE NOT NULL CHECK (LENGTH(position_name) >= 2)
);


-- tạo bảng nhân viên
CREATE TABLE `account`(
	account_id				SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
	email					VARCHAR(50) UNIQUE NOT NULL,
	user_name				VARCHAR(30) UNIQUE NOT NULL CHECK (LENGTH(user_name) >= 6),
 	full_name				VARCHAR(30),
 	department_id			TINYINT UNSIGNED DEFAULT 1,
 	position_id				TINYINT UNSIGNED DEFAULT 2,
	create_date 			DATETIME DEFAULT NOW(),
    FOREIGN KEY (department_id) REFERENCES department(department_id) ON DELETE CASCADE,
    FOREIGN KEY (position_id) REFERENCES `position`(position_id) ON DELETE CASCADE
);


-- tạo bảng nhóm 
CREATE TABLE `group`(
	group_id				TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT ,				
	group_name				VARCHAR(30) UNIQUE NOT NULL,
	creator_id 				SMALLINT UNSIGNED NOT NULL DEFAULT 1, -- creator: trưởng nhóm (là 1 nhân viên)
	create_date				DATETIME DEFAULT NOW(),
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE
);


-- tạo bảng thành viên nhóm
CREATE TABLE group_account(
	group_id				TINYINT UNSIGNED NOT NULL,
    account_id				SMALLINT UNSIGNED NOT NULL,
    join_date				DATETIME DEFAULT NOW(),
	PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (account_id) REFERENCES `account`(account_id) ON DELETE CASCADE,
    FOREIGN KEY (group_id) REFERENCES `group`(group_id) ON DELETE CASCADE
);

-- tạo bảng loại câu hỏi
CREATE TABLE type_question(
	type_id					TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT ,
    type_name				ENUM('Essay', 'Multiple-Choice') NOT NULL DEFAULT 'Essay'
);


-- tạo bảng chủ đề câu hỏi
CREATE TABLE category_question(
	category_id				TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	category_name			VARCHAR(50) UNIQUE NOT NULL CHECK ( LENGTH(category_name) >=3 )
);


-- tạo bảng câu hỏi 
CREATE TABLE question(
	question_id				SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
 	content					VARCHAR(200) UNIQUE NOT NULL CHECK ( LENGTH(content) > 5 ),
	category_id				TINYINT UNSIGNED NOT NULL DEFAULT 1,
	type_id					TINYINT UNSIGNED NOT NULL DEFAULT 2,
	creator_id				SMALLINT UNSIGNED NOT NULL DEFAULT 3,
	create_date				DATETIME DEFAULT NOW(),
    FOREIGN KEY (category_id) REFERENCES category_question (category_id) ON DELETE CASCADE,
    FOREIGN KEY (type_id) REFERENCES type_question (type_id) ON DELETE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE
);


-- tạo bảng câu trả lời
CREATE TABLE answer(
	answer_id				SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	content					VARCHAR(200) UNIQUE NOT NULL CHECK ( LENGTH(content) > 2 ),
	question_id				SMALLINT UNSIGNED NOT NULL,
    is_correct				ENUM('True', 'False') NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question (question_id) ON DELETE CASCADE
);


-- tạo bảng đề thi
CREATE TABLE exam(
	exam_id					TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	`code`					VARCHAR(20) UNIQUE NOT NULL,
	title					VARCHAR(50) UNIQUE NOT NULL,
	category_id				TINYINT UNSIGNED NOT NULL,
	duration				TINYINT UNSIGNED NOT NULL CHECK ( duration >= 15 AND duration <= 180),
	creator_id				SMALLINT UNSIGNED NOT NULL,
	create_date				DATETIME DEFAULT NOW(),
    FOREIGN KEY (category_id) REFERENCES category_question (category_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES  `account`(account_id) ON UPDATE CASCADE ON DELETE CASCADE
);


-- tạo bảng định danh của đề thi
CREATE TABLE exam_question(
	exam_id					TINYINT UNSIGNED NOT NULL,
	question_id				SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY (exam_id,question_id),
    FOREIGN KEY (exam_id) REFERENCES exam (exam_id)  ON DELETE CASCADE,
    FOREIGN KEY (question_id) REFERENCES question (question_id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Thêm dữ liệu vào các bảng
-- Thêm dữ liệu vào bảng department
INSERT INTO department	(department_name)
VALUES					('D1'), -- Alt + Shift
						('D2'),
                        ('D3'),
                        ('D4'),
                        ('D5');

-- Thêm dữ liệu vào bảng position
INSERT INTO `position`	(position_name)
VALUES					('DEV'),
						('TEST'),
                        ('SCRUM_MASTER'), 
                        ('PM'),
                        ('BA');

-- Thêm dữ liệu vào bảng account
INSERT INTO `account`	(email, 						user_name, 			full_name, 			department_id, position_id)   
VALUES					('hien.nguyenvan@vti.com.vn', 	'hien.nguyenvan', 	'Nguyễn Văn Hiến', 		1, 				1),
						('duy.nguyenngoc@vti.com.vn', 	'duy.nguyenngoc', 	'Nguyễn Ngọc Duy', 		1, 				5),
                        ('ngoc.nguyenvan@vti.com.vn', 	'ngoc.nguyenvan', 	'Nguyễn Văn Ngọc', 		2, 				4),
                        ('kiet.phamtuan@vti.com.vn', 	'kiet.phamtuan', 	'Phạm Tuấn Kiệt', 		1, 				4), 
                        ('lien.khanhpham@vti.com.vn', 	'lien.khanhpham', 	'Phạm Khánh Liên ', 	1, 				5),
						('linh.khanhpham@vti.com.vn', 	'linh.khanhpham', 	'Phạm Khánh Linh ', 	2, 				1),
						('hang.tranthi@vti.com.vn', 	'hang.tranthi', 	'Trần Thị Hằng ', 		2, 				2),
                        ('hien.duypham@vti.com.vn', 	'hien.duypham', 	'Phạm Duy Hiền ', 		2, 				3),
                        ('trong.binhtran@vti.com.vn', 	'trong.binhtran', 	'Trần Bình Trọng', 		2, 				4),
                        ('trac.ngoctrac@vti.com.vn', 	'trac.ngoctrac', 	'Trần Ngọc Trác ', 		2, 				5),
                        ('nguyetanh@vti.com.vn', 		'bui.nguyetanh', 	'Bùi Nguyệt Anh ', 		4, 				5),
						('cong.caoxuan@vti.com.vn', 	'cong.caoxuan', 	'Cao Xuân Công ', 		5, 				4),
                        ('duy.hanguyen@vti.com.vn', 	'duy.hanguyen', 	'Nguyễn Hà Duy', 		5, 				3),
                        ('hoang.caophi@vti.com.vn', 	'hoang.caophi', 	'Cao Phi Hoàng ', 		4, 				3),
                        ('hiep.dinhtran@vti.com.vn', 	'hiep.dinhtran', 	'Trần Đình Hiệp ', 		3, 				4),
						('dung.nguyenmanh@vti.com.vn', 	'dung.nguyenmanh', 	'Nguyễn Mạnh Dũng', 	3, 				5),
                        ('nguyen.ngoctrac@vti.com.vn', 	'nguyen.ngoctrac', 	'Nguyễn Ngọc Trác ', 	5, 				2),
                        ('luong.nguyetanh@vti.com.vn', 	'luong.nguyetanh', 	'Lương Nguyệt Anh ', 	4, 				5),
						('nguyen.vantroi@vti.com.vn', 	'nguyen.vantroi', 	'Nguyễn Văn Trỗi ', 	5, 				1),
                        ('lai.dangthi@vti.com.vn', 	    'lai.dangthi', 	    'Đặng Thị Lai', 		4, 				3),
                        ('hoang.nguyenvan@vti.com.vn', 	'hoang.nguyenvan', 	'Nguyễn Văn Hoàng ', 	4, 				1),
                        ('cao.dinhtran@vti.com.vn', 	'cao.dinhtran', 	'Trần Đình Cao ', 		3, 				3);
-- Thêm dữ liệu vào bảng group	
INSERT INTO `group`		(group_name,		creator_id)
VALUES					('Group1_D1',			1),
						('Group2_D1',			5),
                        ('Group1_D2',			3),
						('Group3_D1',			4),
						('Group2_D2',			10),
                        ('Group1_D3',			15),
                        ('Group3_D4',			11),
						('Group2_D5',			12);
                        
-- -- Thêm dữ liệu vào bảng group_account
INSERT INTO `group_account`	(group_id, account_id)	
VALUES						(	1	 ,		1	 ),
							(	1	 ,		2	 ),
                            (	2	 ,		5	 ),
                            (	2	 ,		2	 ),
							(	3	 ,		3	 ),
							(	3	 ,		6	 ),
                            (	3	 ,		7	 ),
                            (	3	 ,		8	 ),
							(	3	 ,		9	 ),
							(	3	 ,		10	 ),
                            (	4	 ,		2	 ),
                            (	4	 ,		4	 ),
                            (	4	 ,		1	 ),
							(	4	 ,		5	 ),
                            (	6	 ,		15	 ),
                            (	6	 ,		16	 ),
							(	6	 ,		22	 ),
							(	7	 ,		11	 ),
                            (	7	 ,		14	 ),
                            (	7	 ,		18	 ),
							(	7	 ,		20	 ),
							(	8	 ,		12	 ),
                            (	8	 ,		13	 ),
                            (	8	 ,		17	 ),
                            (	8	 ,		19	 );
                            
                            
   -- thêm dữ liệu vào bảng   type_question
  INSERT INTO  type_question 	( type_name )
  VALUES						('Essay'),
								('Multiple-Choice');

   -- thêm dữ liệu vào bảng category_question  
  INSERT INTO  category_question 	( category_name )
  VALUES							('Java'),
									('.NET'),
                                    ('SQL'),
                                    ('Postman'),
                                    ('Ruby');

   -- thêm dữ liệu vào bảng question
INSERT INTO question( content, 														category_id    ,	 type_id    , 	creator_id)
	VALUES			('JVM là gì?',														1			,		1		,			5),
                    (' Kích thước của 1 Char là bao nhiêu',				   				1			,		2		,			1),
					('class không thể được khai báo ở chế độ? ',						1			,		1		,			2),
                    ('Bạn có thể truy cập một biến non-static',						   	1			,		2		,			3),
					('SQL là gì?',														3			,   	1		,			4),
                    ('Câu lệnh SQL nào được dùng để trích xuất dữ liệu?',				3			,		2		,			5),
                    (' Cú pháp để thêm bản ghi vào 1 bảng là gì?',					   	3			,		1		,			5),
                    ('Làm thế nào để bạn thêm 1 cột vào 1 bảng?',					    3 			,		1		,			4),
                    ('Ruby là ngôn ngữ lập trình có kiểu tĩnh hay động'	,   			5			,		1		,			3),
                    ('Bạn biết gì về getter và setter trong Ruby'	,    				5			,		1		,			2),
                    (' Điều gì xảy ra khi bạn gọi một phương thức trong Ruby'	,   	5			,		1		,			1),
					(' Callback là gì?'	,   											5			,		1		,			5),
                    ('API là gì?'	,   												4			,		1		,			4),
                    ('. Protocol là gì?'	,    										4			,		1		,			3),
                    ('. HTTP hoạt động như thế nào?',   							 	4			,		1		,			2),
                    (' Vì sao phải test API?'	,   									4			,		1		,			1),
					(' Mệnh đề OR sẽ hiển thị bản ghi nếu bất kỳ điều kiện nào đúng',	3			,		2		,			5),
                    ('Từ khóa SQL nào được sử dụng để sắp xếp danh sách kết quả'	,   3			,		2		,			4),
                    ('Kết quả của mệnh đề SELECT có thể chứa các dòng dữ liệu trùng  ', 3			,		2		,			3),
                    ('Tên đầu tiên của Java là gì',   							 		1			,		2		,			2),
                    (' Đâu không phải thành phần trong cấu trúc của Java'	,   		1			,		2		,			1);
       
                    -- thêm dữ liệu vào bảng answer
INSERT INTO answer	(  content, 																											question_id, 		  is_correct)
	VALUES			('quy trình máy ảo có thể thực thi các Java bytecode',																		1		,			'True'),
					('4 bit',																													2		,			'False'),
                    ('8 bit',																													2		,			'False'),
                    ('16 bit',																													2		,			'True'),
                    ('7 bit',																													2		,			'False'),
                    (' Biến static được tạo khi lớp chứa đó được tải  bởi JVM',																	3		,			'False'),
                    ('Static'            ,																										4		,			'False'),
                    ('Private'            ,																										4		,			'False'),
                    ('`Default`'            ,																									4		,			'True'),
                    ('Viết tắt của Structured Query Language – ngôn ngữ truy vấn cấu trúc',														5		,			'False'),
                    ('Get'				 ,																										6		,			'False'),
                    ('Extract'				 ,																									6		,			'False'),
					('Select'				 ,																									6		,			'True'),
                    ('Open'				 ,																										6		,			'False'),
                    ('ALTER TABLE table_name ADD (column_name)',																				7		,			'True'),
                    ('Sử dụng cú pháp INSERT để thêm bản ghi vào 1 bảng',																		8		,			'False'),
                    ('Ruby là ngôn ngữ động',																									9		,			'True'),
                    ('Một getter cho phép truy cập một biến instance.',																			10		,			'False'),
                    (' Khi một method được gọi, Ruby sẽ xử lý lần lượt 2 công việc: tìm kiếm và thực thi',										11		,			'False'),
					('Callbacks là một phương thức của Active Record',																			12		,			'True'),
                    ('Nói đơn giản, API là cái cầu nối giữa client và server',																	13		,			'False'),
                    ('Giao thức chính là những luật lệ được chấp thuận để 2 cái máy tính có thể nói chuyện với nhau',							14		,			'True'),
                    ('Cuộc sống của HTTP xoay quanh cái vòng luẩn quẩn: Request và Response',													15		,			'False'),
                    (' Khi làm hệ thống web services, dự án của mình chỉ viết API cho bên khác dùng',											16		,			'False'),
					('Đúng rồi',																													17		,			'True'),
                    ('Sai',																														17		,			'False'),
                    ('Sortby',																													18		,			'True'),
                    ('Oder',																													18		,			'False'),
                    (' Sort',																													18		,			'False'),
					('Đúng',																													19		,			'True'),
                    ('Sai rồi',																														19		,			'False'),
                    (' Java',																													20		,			'True'),
                    ('OAK',																														20		,			'False'),
                    ('Cafe',																													20		,			'False'),
                    ('Jame goling',																												20		,			'False'),
                    ('Tên lớp',																													21		,			'False'),
                    (' Phương thức',																											21		,			'False'),
					('Thuộc tính',																												21		,			'True'),
                    ('Biến',																													21		,			'False');
                   
-- thêm dữ liệu vào bảng exam
INSERT INTO  exam 	(   `code`		,	 title	, 							category_id,	 duration, 		creator_id)
	VALUES				(	'Java01'        ,   'Đề thi Java01', 				 1         ,     180        ,     5),			
						(	'Java02'        ,   'Đề thi Java02' , 				 1         ,     90         ,     1),	
                        (	'Java03'        ,   'Đề thi Java03',				 1     	   ,     120        ,     2),	
                        (	'Java04'        ,   'Đề thi Java04',			     1     	   ,     180        ,     3),	
                        (	'SQL01'         ,   'Đề thi SQL01',			     	 3         ,     100        ,     4),	
                        (	'SQL02'         ,   'Đề thi SQL02'	,			     3         ,     180        ,     5),	
                        (	'SQL03'         ,   'Đề thi SQL03',			 		 3         ,     180        ,     5),	
                        (	'SQL04'         ,  	'Đề thi SQL04',	    		 	 3         ,     150        ,     4),
                        (	'Ruby01'        ,   'Đề thi Ruby01',			 	 5         ,     180        ,     3),	
                        (	'Ruby02'        ,   'Đề thi Ruby02'  ,				 5         ,     120        ,     2),
                        (	'Ruby03'        ,   'Đề thi Ruby03',				 5         ,     45         ,     1),
                        (	'Ruby04'        ,   'Đề thi Ruby04',			 	 5         ,     15         ,     5),	
                        (	'Postman01'     ,   'Đề thi Postman01',	    		 4         ,     180        ,     4),
                        (	'Postman02'     ,   'Đề thi Postman02',			 	 4         ,     90         ,     3),	
                        (	'Postman03'     ,   'Đề thi Postman03'  ,			 4         ,     180        ,     2),
                        (	'Postman04'     ,   'Đề thi Postman04',				 4         ,     30         ,     1);
                        
INSERT INTO  exam_question 	( exam_id, question_id )
	VALUES					(  1,  1  ),
							(  1,  2  ),
                            (  1,  3  ),
                            (  2,  1  ),
							(  2,  2  ),
                            (  2,  3  ),
                            (  5,  6  ),
							(  5,  8  ),
                            (  5,  7  ),
                            (  9,  11  ),
							(  9,  9  ),
                            (  13 , 16  ),
                            (  13, 14  ),
							(  9,  10  ),
                            (  9,  12 ),
							(  9,  13  ),
                            (  13,  15  ),
                            (  13 , 13  );

                            
                    
                    
				
                    
                    
                    
                    
                    
                    
                    
                    