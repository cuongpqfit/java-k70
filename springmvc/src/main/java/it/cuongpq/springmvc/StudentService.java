package it.cuongpq.springmvc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentService {
    private static StudentService INSTANCE = null;

    private  Connection connection;

    private StudentService() {

    }

    public static StudentService getInstance() {
        if (INSTANCE != null) return INSTANCE;

        INSTANCE = new StudentService();
        INSTANCE.initConnectDatabase();

        return INSTANCE;
    }

    public void initConnectDatabase() {
        //Đọc các giá trị từ file app.config
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("D:\\JavaFull\\springmvc\\src\\main\\java\\it\\cuongpq\\springmvc\\app.config"))  {
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
            connection = DriverManager.getConnection(url, username, password);

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
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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
}
