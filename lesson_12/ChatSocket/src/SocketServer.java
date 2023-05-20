import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        try {
            // Khởi tạo ServerSocket với cổng số 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is running...");

            while (true) {
                // Chấp nhận kết nối từ Socket Client
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket);

                // Tạo luồng riêng cho kết nối đó
                ClientHandler clientHandler = new ClientHandler(socket);

                // Khởi động luồng
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Class ClientHandler thực hiện xử lý dữ liệu của một Socket Client
    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Tạo luồng đọc dữ liệu từ Socket Client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Tạo luồng ghi dữ liệu vào Socket Client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // Đọc và ghi dữ liệu liên tục
                while (true) {
                    String receivedData = reader.readLine();
                    if (receivedData != null) {
                        System.out.println("Received from client " + socket + ": " + receivedData);
                        writer.println("Server: " + receivedData);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // Đóng kết nối khi kết thúc luồng
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
