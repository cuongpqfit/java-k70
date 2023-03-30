package it.cuongpq.springmvc.service;

import it.cuongpq.springmvc.dto.HocVienDto;
import it.cuongpq.springmvc.model.HocVien;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class StudentService {
    private static StudentService INSTANCE = null;
    private Connection connection;

    private StudentService() {
    }

    public static StudentService getInstance() {
        if (INSTANCE != null) return INSTANCE;

        INSTANCE = new StudentService();
        INSTANCE.connectDatabase();

        return INSTANCE;
    }

    public void connectDatabase() {
        //Đọc các giá trị từ file app.config
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("D:\\springmvc\\src\\app.config")) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Thiết lập tham số kết nối
        //Step 2: Định nghĩa url kết nối
        String url = properties.getProperty("url");

        //Step 3: Tạo kết nối
        String username = properties.getProperty("user");
        String password = properties.getProperty("password");

        //Step 1: Load driver
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading driver: " + e);
        }

        //Tạo đối tượng connection
        try {
            this.connection = DriverManager.getConnection(url, username, password);

            System.out.println("Database connected!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Database connect fail!");
        }
    }

    public List<String> getStudentList() {
        List<String> output = new ArrayList<>();

        //Định nghĩa chuỗi truy vấn dữ liệu
        String query = "SELECT * FROM HOCVIEN WHERE HO LIKE ? ";

        //Tạo đối tượng preparedStatement
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, "Nguyen%");

            ResultSet rs = preparedStatement.executeQuery();

            //In kết quả truy vấn SELECT
            while (rs.next()) {
                String mahv = rs.getString("MAHV");
                String ho = rs.getString("HO");
                String ten = rs.getString("TEN");
                Date ngaysinh = rs.getDate("NGSINH");
                String gioitinh = rs.getString("GIOITINH");
                String noisinh = rs.getString("NOISINH");
                String malop = rs.getString("MALOP");

                //In ra màn hình
                String format = "%-5s %-15s %-15s %-10s %-15s %-15s %-5s";
                System.out.println(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
                output.add(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return output;
    }

    public HocVien getStudentById(String studentId) {
        HocVien output = null;
        //Định nghĩa chuỗi truy vấn dữ liệu
        String query = "SELECT * FROM HOCVIEN WHERE MAHV = ? ";

        //Tạo đối tượng preparedStatement
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, studentId);

            ResultSet rs = preparedStatement.executeQuery();

            //In kết quả truy vấn SELECT
            while (rs.next()) {
                String mahv = rs.getString("MAHV");
                String ho = rs.getString("HO");
                String ten = rs.getString("TEN");
                Date ngaysinh = rs.getDate("NGSINH");
                String gioitinh = rs.getString("GIOITINH");
                String noisinh = rs.getString("NOISINH");
                String malop = rs.getString("MALOP");

                //In ra màn hình
                String format = "%-5s %-15s %-15s %-10s %-15s %-15s %-5s";
                System.out.println(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
                output = new HocVien(mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return output;
    }

    public HocVien addStudent(HocVienDto hocVienDto) {
        UUID uuid = UUID.randomUUID();
        String mahv =  "HH" + uuid.toString().substring(0, 8);

        HocVien hocVien = new HocVien(
                mahv,
                hocVienDto.getHo(),
                hocVienDto.getTen(),
                hocVienDto.getNgaysinh(),
                hocVienDto.getGioitinh(),
                hocVienDto.getNoisinh(),
                hocVienDto.getMalop()
        );
        // Prepare SQL statement with parameters
        String sql = "INSERT INTO HOCVIEN (MAHV, HO, TEN, NGSINH, GIOITINH, NOISINH, MALOP) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            // Set parameter values
            statement.setString(1, hocVien.getMahv());
            statement.setString(2, hocVien.getHo());
            statement.setString(3, hocVien.getTen());
            statement.setDate(4, new Date(hocVien.getNgaysinh().getTime()));
            statement.setString(5, hocVien.getGioitinh());
            statement.setString(6, hocVien.getNoisinh());
            statement.setString(7, hocVien.getMalop());

            // Execute the statement
            int rowsInserted = statement.executeUpdate();
            System.out.println(rowsInserted + " rows inserted.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return hocVien;
    }
}
