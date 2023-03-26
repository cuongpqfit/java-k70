package Module2.handler;

import Module2.model.Order;

import java.sql.*;
import java.util.concurrent.LinkedBlockingQueue;

public class StoreHandler implements Runnable {
    String url;
    String username;
    String password;
    LinkedBlockingQueue<Order> queue;

    Connection conn;
    boolean isConnected = false;

    public StoreHandler(String url, String username, String password, LinkedBlockingQueue<Order> queue) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.queue = queue;
    }

    void connectDatabase() {
        while (!isConnected) {
            try {
                conn = DriverManager.getConnection(url, username, password);
                isConnected = true;
                System.out.println("Database connected");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            connectDatabase();
            while (isConnected) {
                try {
                    Order order = queue.take();
                    if (order != null) {
                        System.out.println(order);
                        String sql = "INSERT INTO orders(account_id, stock_id, stock_name, stock_price, purchase_date) values (?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setString(1, order.getAccountId());
                        preparedStatement.setString(2, order.getStockId());
                        preparedStatement.setString(3, order.getStockName());
                        preparedStatement.setInt(4, order.getStockPrice());
                        preparedStatement.setTimestamp(5, order.getPurchaseDate());
                        //preparedStatement.setDate(5, Date.valueOf(order.getPurchaseDate().toLocalDateTime().toLocalDate()));
                        preparedStatement.executeUpdate();

                    }
                } catch (SQLException | InterruptedException e) {
                    isConnected = false;
                    e.printStackTrace();
                }

            }
        }
    }
}
