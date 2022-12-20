DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;

DROP TABLE IF EXISTS giangVien;
CREATE TABLE giangVien(
	maGv 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    hoTen 			VARCHAR(50) NOT NULL,
    luong 			VARCHAR(50)
);

DROP TABLE IF EXISTS sinhVien;
CREATE TABLE sinhVien(
	maSv 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    hoTen 			VARCHAR(50) NOT NULL,
    namSinh			Year,
    queQuan 		VARCHAR(100)
);

DROP TABLE IF EXISTS deTai;
CREATE TABLE detai(
	maDt 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tenDt 			VARCHAR(50) NOT NULL,
    kinhPhi			Varchar(30),
    noiThucTap 		VARCHAR(100)
);

DROP TABLE IF EXISTS huongDan;
CREATE TABLE huongDan(
	id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    maSv 		TINYINT UNSIGNED,
    maDt		TINYINT UNSIGNED,
    maGv 		TINYINT UNSIGNED,
    ketQua     	Varchar(30) ,
	FOREIGN KEY(maSv) 	REFERENCES sinhVien(maSv), 	-- ON DELETE CASCADE --
    FOREIGN KEY(maDt) 	REFERENCES detai(maDt),		-- ON DELETE CASCADE --
    FOREIGN KEY(maGv) 	REFERENCES giangVien(maGv) 	-- ON DELETE CASCADE --
);

-- Questions 1: Tạo table với các ràng buộc và kiểu dữ liệu 
			 -- Thêm ít nhất 3 bản ghi vào table
INSERT INTO GiangVien( hoten, luong)
VALUES 	('Nguyen Van Chien' , '900$'),
		('Bui Xuan Huan' , '1200$'),
        ('Nguyen Thanh Tung' , '800$'),
        ('Duong Van Huu' , '2000$'),
        ('Ngo Ba Kha' , '1500$');

INSERT INTO SinhVien(hoten, namsinh, quequan)
VALUES 	('Nguyen Ngoc Hieu' ,'2001', 'Ha Noi'),
		('Ngo Hai Yen' ,'2002', 'Nam Dinh'),
		('Nguyen Thanh Long' ,'1999', 'HCM'),
		('Nguyen Thi Xuan' ,'2004', 'Da Nang'),
		('Nguyen Bao Khang' ,'1998', 'Hue');
  
INSERT INTO DeTai( tendt, kinhphi, NoiThucTap)
VALUES  ('Cong Nghe Oto' ,'1000$', 'Ha Noi'),
		('Cong Nghe Sinh Hoc' ,'900$', 'Nam Dinh'),
        ('Cong Nghe Hoa Hoc' ,'800$', 'HCM'),
        ('Cong Nghe Tu Dong 4' ,'2000$', 'Hue'),
        ('Cong Nghe Moi' ,'1500$', 'Da Nang');
        
INSERT INTO HuongDan( masv, madt, magv, ketqua)
VALUES 	( 1,2, 2, 'Dat'),
		( 2,3, 4, 'not pass'),
        ( 1,3, 2, 'Dat'),
        ( 4,1, 2, 'Dat'),
        ( 4,2, 4, 'not pass');

-- Questions 2: Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT sv.* 
FROM sinhVien sv
LEFT JOIN huongDan hd ON sv.maSv = hd.maSv
WHERE maDt is null;

-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’
SELECT dt.tenDt, count(hd.maSv) AS SL 
FROM sinhVien sv
JOIN huongDan hd ON sv.maSv = hd.maSv
JOIN deTai dt ON dt.maDt = hd.maDt
GROUP BY dt.maDt
HAVING dt.tenDt = 'Cong Nghe Sinh Hoc';

/* 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm: mã số, họ tên và tên đề tài
(Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có") */
DROP VIEW IF EXISTS SinhVienInfo;
CREATE VIEW SinhVienInfo AS
	SELECT sv.maSv, sv.hoTen, 	CASE	
									WHEN dt.tenDt is null then 'Chưa có'
                                    ELSE dt.tenDt
								END tenDt
	FROM sinhVien sv
	LEFT JOIN huongDan hd ON sv.maSv = hd.maSv
	LEFT JOIN deTai dt ON dt.maDt = hd.maDt;

SELECT * FROM SinhVienInfo;

/* 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900
thì hiện ra thông báo "năm sinh phải > 1900" */
Drop TRIGGER IF EXISTS verify_insert_namSinh;
DELIMITER $$
CREATE TRIGGER verify_insert_namSinh
BEFORE INSERT ON sinhVien
FOR EACH ROW
	BEGIN 	
		IF(NEW.namSinh <= '1900') THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'năm sinh phải > 1900';
		END IF;
	END $$
DELIMITER ;

INSERT INTO SinhVien(hoten, namsinh, quequan)
VALUES 	('Test' ,'1899', 'Ha Noi');

/* 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi */

-- Cách 1: sử dụng ON DELETE CASCADE trên FOREIGN KEY của bảng huongDan

-- Cách 2: sử dụng TRIGGER
Drop TRIGGER IF EXISTS Delete_sinhVien;
DELIMITER $$
CREATE TRIGGER Delete_sinhVien
BEFORE DELETE ON sinhVien
FOR EACH ROW
	BEGIN 	
		DELETE FROM huongDan
        WHERE maSv = old.maSv;
	END $$
DELIMITER ;

DELETE FROM sinhVien
WHERE maSv = 1;
