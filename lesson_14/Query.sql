-- Đọc dữ từ 1 bảng
-- - Lấy tất cả các cột
SELECT * FROM nhanvien;

-- - Lấy vài cột trong bảng
SELECT HOTEN, DTHOAI, NGVL FROM nhanvien;

-- - Với điều kiện xác định
SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE HOTEN = 'Nguyen Nhu Nhut';


SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE MANV > 'NV03';

-- WHere so sanh với NULL
SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE DTHOAI IS NULL;

SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE DTHOAI IS NOT NULL;


-- WHERE với AND - OR - NOT
SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE (DTHOAI IS NULL) AND (MANV > 'NV03');

SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE (DTHOAI IS NULL) OR (MANV < 'NV03');

SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE NOT (MANV < 'NV03');



-- WHERE với IN BETWEEN
SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE MANV = 'NV02' OR (MANV = 'NV03') OR (MANV = 'NV04');

-- <->
SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE MANV IN (SELECT MANV FROM nhanvien WHERE MANV = 'NV02' OR (MANV = 'NV03') OR (MANV = 'NV04'));


SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE MANV IN ('NV02', 'NV03', 'NV04');


SELECT *
FROM nhanvien
-- WHERE là nơi chưa điều kiện lọc dữ liệu
WHERE MANV BETWEEN 'NV01' AND 'NV04';

-- LIKE
-- - Với điều kiện xác định
SELECT *
FROM nhanvien
WHERE HOTEN like 'Nguyen%';

SELECT *
FROM nhanvien
WHERE HOTEN like '%Nhut';

SELECT *
FROM nhanvien
WHERE HOTEN LIKE '%u%';

SELECT *
FROM nhanvien
WHERE HOTEN LIKE '%u%a%';

-- ORDER BY - DESC giảm dần
SELECT *
FROM nhanvien
WHERE MANV BETWEEN 'NV01' AND 'NV04'
ORDER BY MANV DESC;

SELECT *
FROM nhanvien
WHERE MANV BETWEEN 'NV01' AND 'NV04'
ORDER BY MANV ASC;

SELECT *
FROM nhanvien
WHERE MANV BETWEEN 'NV01' AND 'NV04'
-- HAVING
-- GROUP BY
ORDER BY HOTEN DESC;

-- Loai bỏ dữ liệu bị trùng

SELECT DISTINCT HOTEN, DTHOAI
FROM nhanvien a
WHERE MANV BETWEEN 'NV01' AND 'NV04'
ORDER BY HOTEN DESC;


SELECT DISTINCT HOTEN, DTHOAI
FROM nhanvien a
WHERE MANV BETWEEN 'NV01' AND 'NV04'
ORDER BY HOTEN DESC;

-- SỬ dụng function build-in
SELECT A.*, LENGTH(A.HOTEN) AS Do_dat_ten, REVERSE(A.NGVL)
FROM nhanvien AS A
