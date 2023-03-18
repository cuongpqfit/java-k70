import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JavaDatabaseSimple {
    public void sqlStatement(String url, String user, String password) {
        try {
            // Kết nối đến CSDL
            Connection conn = DriverManager.getConnection(url, user, password);

            // Tạo đối tượng Statement
            Statement stmt = conn.createStatement();

            // Thực hiện truy vấn SELECT
            String sql = "SELECT * FROM HOCVIEN";
            ResultSet rs = stmt.executeQuery(sql);

            // In ra thông tin của tất cả học viên
            while (rs.next()) {
                String mahv = rs.getString("MAHV");
                String ho = rs.getString("HO");
                String ten = rs.getString("TEN");
                Date ngaysinh = rs.getDate("NGSINH");
                String gioitinh = rs.getString("GIOITINH");
                String noisinh = rs.getString("NOISINH");
                String malop = rs.getString("MALOP");

                // Sử dụng String.format() để tạo định dạng đẹp hơn
                String format = "%-5s %-15s %-15s %-15s %-10s %-20s %-10s";
                System.out.println(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
            }

            // Thực hiện truy vấn INSERT
            String sql2 = "INSERT INTO HOCVIEN(MAHV, HO, TEN, NGSINH, GIOITINH, NOISINH, MALOP) VALUES ('HV04', 'Nguyễn', 'Văn Tú', '1999-03-01', 'Nam', 'Hà Nội', 'P01')";
            int rowsAffected = stmt.executeUpdate(sql2);
            System.out.println(rowsAffected + " row(s) affected.");

            // Đóng kết nối và tài nguyên
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void sqlPreparedStatement(String url, String user, String password) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Thực hiện truy vấn SELECT
            String selectQuery = "SELECT * FROM HOCVIEN";
            Statement selectStmt = conn.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(selectQuery);

            while (resultSet.next()) {
                String mahv = resultSet.getString("MAHV");
                String ho = resultSet.getString("HO");
                String ten = resultSet.getString("TEN");
                Date ngaysinh = resultSet.getDate("NGSINH");
                String gioitinh = resultSet.getString("GIOITINH");
                String noisinh = resultSet.getString("NOISINH");
                String malop = resultSet.getString("MALOP");

                // In ra thông tin của học viên
//                System.out.println(mahv + " - " + ho + " " + ten + ", " + ngaysinh + ", " + gioitinh + ", " + noisinh + ", " + malop);

                // In ra thông tin của học viên
                System.out.println(String.format("%-5s\t%-20s\t%-20s\t%-10s\t%-5s\t%-20s\t%-5s", mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
            }

            // Thực hiện truy vấn INSERT
            String insertQuery = "INSERT IGNORE INTO HOCVIEN (MAHV, HO, TEN, NGSINH, GIOITINH, NOISINH, MALOP) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, "HV02");
            insertStmt.setString(2, "Nguyễn");
            insertStmt.setString(3, "Văn A");
            insertStmt.setDate(4, Date.valueOf("2000-01-01"));
            insertStmt.setString(5, "Nam");
            insertStmt.setString(6, "Hà Nội");
            insertStmt.setString(7, "L01");
            int rowsInserted = insertStmt.executeUpdate();
            System.out.println(rowsInserted + " rows inserted.");

            // Thực hiện truy vấn UPDATE
            String updateQuery = "UPDATE HOCVIEN SET HO = ?, TEN = ? WHERE MAHV = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setString(1, "Trần");
            updateStmt.setString(2, "Thị B");
            updateStmt.setString(3, "HV02");
            int rowsUpdated = updateStmt.executeUpdate();
            System.out.println(rowsUpdated + " rows updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.setProperty("console.encoding", "UTF-8");
        System.out.println("Xin chào"); // in ra chuỗi "Xin chào" trên console

        // Đọc các giá trị từ file app.config
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("app.config")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Thiết lập kết nối cơ sở dữ liệu
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        JavaDatabaseSimple javaDatabaseSimple = new JavaDatabaseSimple();
        javaDatabaseSimple.sqlStatement(url, user, password);
        javaDatabaseSimple.sqlPreparedStatement(url, user, password);
    }
}
