DROP DATABASE IF EXISTS RDBMS;
-- Tạo CSDL tên là RDBMS --
CREATE DATABASE IF NOT EXISTS RDBMS;

USE RDBMS;

/* Câu 1: Tạo table với các rằng buộc và kiểu dữ liệu
          Thêm ít nhất 5 bản ghi vào table
*/
-- Tạo bảng lưu thông tin khách hàng: customer --
DROP TABLE IF EXISTS customer;
CREATE TABLE IF NOT EXISTS customer(
    customer_id TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    phone CHAR(10),
    email VARCHAR(255) UNIQUE KEY,
    address VARCHAR(255),
    note VARCHAR(255)
);
-- Tạo bảng lưu thông tin về xe: car --
DROP TABLE IF EXISTS car;
CREATE TABLE IF NOT EXISTS car (
    car_id CHAR(5),
    maker ENUM('HONDA', 'TOYOTA', 'NISSAN'),
    model VARCHAR(50),
    `year` VARCHAR(10),
    color VARCHAR(50),
    note VARCHAR(255),
    PRIMARY KEY (car_id)
);
-- Tạo bảng lưu thông tin về đơn hàng: car_order -- 
DROP TABLE IF EXISTS car_order;
CREATE TABLE IF NOT EXISTS car_order (
    order_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    customer_id TINYINT UNSIGNED,
    car_id CHAR(5),
    amount TINYINT DEFAULT 1,
    sale_price BIGINT UNSIGNED NOT NULL,
    order_date DATE,
    delivery_date DATE,
    delivery_address VARCHAR(255),
    `status` ENUM('0', '1', '2') DEFAULT '0',
    note VARCHAR(255),
    CONSTRAINT fk_1 FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    CONSTRAINT fk_2 FOREIGN KEY (car_id) REFERENCES car(car_id)
);

-- Thêm bản ghi vào bảng customer --
INSERT INTO customer (`name`,phone,email,address,note)
VALUES
		('Lê Ánh Tuyết','0986986194','leanhtuyet94@gmail.com','Hưng Hà-Thái Bình','VIP'),
		('Lưu Đỗ Trường','0981792781','luudotruong97@gmail.com','Quất Lâm-Nam Định','KH tiềm năng'),
		('Nguyễn Hải Đăng','0975839267','nguyenhaidang85@gmail.com','Thanh Hoá','KH khó tính'),
		('Trần Xuân Trường','0935163390','trãnuantruong88@gmail.com','TPHCM','VIP'),
		('Dương Bảo Châu','0903617366','duongbaochau78@gmail.com','Huế','KH tiềm năng');
-- Thêm bản ghi vào bảng car --
INSERT INTO car
VALUES
		('HD001','HONDA','CR-V 1.5E','2021','Black','Lắp ráp'),
		('HD002','HONDA','City 1.5RS','2020','Red','Lắp ráp'),
		('HD003','HONDA','Brio 1.2G','2020','Blue','Nhập khẩu'),
		('HD004','HONDA','Civic 1.8E','2021','Black','Nhập khẩu'),
		('HD005','HONDA','Accord','2019','White','Nhập khẩu'),
		('TY006','TOYOTA','Vios','2018','Red','Lắp ráp'),
		('TY007','TOYOTA','Corolla Altis 2.0V Luxury','2019','Gray','Nhập khẩu'),
		('TY008','TOYOTA','Camry 2.5G','2017','Black','Lắp ráp'),
		('TY009','TOYOTA','Fortuner','2018','Black','Nhập khẩu'),
		('TY010','TOYOTA','Yaris','2018','Gray','Lắp ráp'),
		('NS011','NISSAN','Sunny','2020','Red','Nhập khẩu'),
		('NS012','NISSAN','Navara','2020','Blue','Nhập khẩu'),
		('NS013','NISSAN','Terra','2019','White','Lắp ráp'),
		('NS014','NISSAN','X-Trail','2019','Orange','Nhập khẩu');
-- Thêm bản ghi vào bảng car_order
INSERT INTO car_order(customer_id,car_id,amount,sale_price,order_date,delivery_date,delivery_address,`status`,note)
VALUES
		(4,'NS012',2,'1598000000','2019-12-10','2019-12-20','Tân Bình-TPHCM','1','Tạm ứng 80%'),
		(3,'TY006',1,'905000000','2020-01-01','2020-01-15','Toà Handico-HN','1','Thanh toán 100%'),
		(2,'HD003',3,'3679000000','2021-03-03','2021-04-02','Toà Capital-HN','1','Tạm ứng 50%'),
		(5,'TY009',1,'1278000000','2019-04-10','2019-04-20','Thủ Đức-TPHCM','2','Chưa tạm ứng'),
		(1,'HD001',1,'768000000','2021-01-10','2021-01-15','HN','0','Tạm ứng 50%'),
		(1,'HD003',1,'1068000000','2020-03-10','2020-03-15','HN','1','Thanh toán 100%'),
		(1,'NS011',1,'2068000000','2021-04-10','2021-04-15','HN','1','Tạm ứng 50%');
		
/* Câu 2: Viết lệnh để lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua và sắp xếp tăng dần 
theo số lượng oto đã mua.
*/
SELECT 
    c.`name`,
    IF((SUM(co.amount) IS NULL),0,SUM(co.amount)) AS number_of_car_purchased
FROM
    customer c
        LEFT JOIN
    car_order co USING (customer_id)
WHERE co.`status` = '1'
GROUP BY c.customer_id
ORDER BY SUM(co.amount);

/* Câu 3: Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán
 được nhiều oto nhất năm nay
*/
SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS get_maker;
DELIMITER $$
CREATE FUNCTION get_maker() RETURNS ENUM('HONDA','TOYOTA','NISSAN')
	BEGIN
		DECLARE v_maker ENUM('HONDA','TOYOTA','NISSAN');
        
		SELECT c.maker INTO v_maker
		FROM car c
		JOIN car_order co 
		USING (car_id)
		WHERE YEAR(co.order_date) = YEAR(NOW()) AND co.`status`= '1'
		GROUP BY c.maker
		ORDER BY SUM(co.amount) DESC
        LIMIT 1;
        
		RETURN v_maker;
	END$$
DELIMITER ;
SELECT get_maker();

SELECT 
    c.maker, SUM(co.amount)
FROM
    car c
        JOIN
    car_order co USING (car_id)
WHERE
    YEAR(co.order_date) = YEAR(NOW()) and co.`status`= '1'
GROUP BY c.maker
ORDER BY SUM(co.amount) DESC
LIMIT 1;
		
/* Câu 4: Viết 1 thủ tục (không có parameter) để xoá các đơn hàng đã bị huỷ 
của những năm trước. In ra số lượng bản ghi đã bị xoá
*/
DROP PROCEDURE IF EXISTS delete_order_by_status;
DELIMITER $$
CREATE PROCEDURE delete_order_by_status ()
	BEGIN
        SELECT COUNT(`status`) AS number_order_cancel
        FROM car_order 
        WHERE `status` = '2' AND YEAR(order_date) < YEAR(NOW());  
        
		DELETE
        FROM car_order
        WHERE `status` = '2' AND YEAR(order_date) < YEAR(NOW());
	END$$
DELIMITER ;

CALL delete_order_by_status ();
/* Câu 5: Viết 1 thủ tục (có customer_id parameter) để in ra thông tin của các
đơn hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto và tên hãng
sản xuất
*/
DROP PROCEDURE IF EXISTS get_inf_order_by_id;
DELIMITER $$
CREATE PROCEDURE get_inf_order_by_id (IN in_customerid TINYINT UNSIGNED)
	BEGIN
        SELECT c.`name`,co.order_id,co.amount,car.maker
        FROM car_order co 
        JOIN customer c USING(customer_id)
        JOIN car USING(car_id)
        WHERE c.customer_id = in_customerid AND co.`status` = '0';
	END$$
DELIMITER ;

CALL get_inf_order_by_id(1);

CALL delete_order_by_status ();
/* Câu 6: Viết 1 trigger để tránh trường hợp người dùng nhập thông tin không hợp lệ
vào database (delivery_date < order_date + 15)
*/
DROP TRIGGER IF EXISTS before_insert_car_order;
DELIMITER $$
CREATE TRIGGER before_insert_car_order
BEFORE INSERT ON car_order
FOR EACH ROW
BEGIN
	IF NEW.delivery_date < NEW.order_date + '15' THEN
		SIGNAL SQLSTATE '12345'
 		SET MESSAGE_TEXT = 'delivery_date invalid!';
	END IF;
END $$
DELIMITER ;
-- Lệnh insert để kiểm tra trigger- before_insert_car_order --
INSERT INTO car_order 
VALUES 
		(9,3,'NS013',2,'4598000000','2020-01-10','2020-01-12','TPHCM','0','Đã thanh toán');

