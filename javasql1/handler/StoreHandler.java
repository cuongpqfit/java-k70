package handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;

public class StoreHandler implements Runnable {
    private String url;
    private String user;
    private String password;
    private BlockingQueue<String> queue;

    private Connection conn;
    private boolean isConnected = false;

    public StoreHandler(String url, String user, String password, BlockingQueue<String> queue) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.queue = queue;
    }

    private void connectDatabase() {
        while (!isConnected) {
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                isConnected = true;
                System.out.println("Database Connected!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            connectDatabase();

            while (isConnected) {
                try {
                    String sql = "INSERT INTO DUAL (data) VALUES (?)";
                    PreparedStatement statement = null;
                    statement = conn.prepareStatement(sql);
                    String data = queue.take();

                    statement.setString(1, data);
                    statement.executeUpdate();
                } catch (SQLException | InterruptedException throwables) {
                    isConnected = false;
                    throwables.printStackTrace();
                }
            }
        }
    }
}
