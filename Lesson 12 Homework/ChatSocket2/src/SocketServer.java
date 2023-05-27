import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {
    private static List<Socket> clients = new ArrayList<>();
    public static void main(String[] args) throws IOException {

            // Khởi tạo ServerSocket với cổng số 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is running...");

            while (true) {
                // Chấp nhận kết nối từ Socket Client
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket);
                clients.add(socket);
                // Tạo luồng riêng cho kết nối đó
                ClientHandler clientHandler = new ClientHandler(socket);
                // Khởi động luồng
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
    }

    // Class ClientHandler thực hiện xử lý dữ liệu của một Socket Client
    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private String username ="";
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            //Bắt client nhập username đến khi nhập thành công
            //Client nhập username lưu vào thuộc tính username của class ClientHandler

            try {
                // Tạo luồng đọc dữ liệu từ Socket Client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Đọc và ghi dữ liệu liên tục
                while(true) {
                    String receivedData = reader.readLine();

                    //Nếu receivedData có bắt đầu = @[username] thì sẽ gửi msg đến client có username tương ứng

                    if (receivedData != null) {
                        System.out.println("Received from client " + socket + ": " + receivedData);
                        SendMessage(receivedData);
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    // Đóng kết nối khi kết thúc luồng
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clients.remove(socket);
            }
        }

        private void SendMessage(String message) throws IOException {
            for (Socket client : clients) {
                if(client !=socket){
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println("Server received data from clients:" + message);
                }
            }
        }
    }

}

