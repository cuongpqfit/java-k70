import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {
    private static List<ClientHandler> clients = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        // Khởi tạo ServerSocket với cổng số 5000
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running...");

        while (true) {
            // Chấp nhận kết nối từ Socket Client
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket);

            // Tạo luồng riêng cho kết nối đó
            ClientHandler clientHandler = new ClientHandler(socket);
            clients.add(clientHandler);
            // Khởi động luồng
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }



    // Class ClientHandler thực hiện xử lý dữ liệu của một Socket Client
    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String username;
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                while(true) {

                    //Bắt client nhập username đến khi nhập thành công
                    //Client nhập username lưu vào thuộc tính username của class ClientHandler
                    writer.println("Enter your username: ");
                    username = reader.readLine();
                    if (username == null) {
                        return;
                    }
                    synchronized (clients) {
                        if (!username.isEmpty()) {
                            break;
                        }
                    }
                }
                writer.println("Welcome " + username );

                // Tạo luồng đọc dữ liệu từ Socket Client
                // Đọc và ghi dữ liệu liên tục
                while(true) {
                    writer.println("Enter the message for another user as format username + message");
                    String inputData = reader.readLine();
                    if (inputData == null) {
                        break;
                    }
                    boolean isPrivateMessage = false;
                    //Nếu receivedData có bắt đầu = @[username] thì sẽ gửi msg đến client có username tương ứng
                    for (ClientHandler client : clients) {
                        if (inputData.startsWith(client.getUsername())) {
                            int index = inputData.indexOf(' ');
                            if (index != -1) {
                                String recipient = inputData.substring(0, index);
                                sendTo(username + ": " + inputData.substring(index + 1), recipient);
                                isPrivateMessage = true;
                                break;
                            }
                        }
                    }
                    if(!isPrivateMessage){
                        broadcast(username + ": " + inputData, this);
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


        public static void sendTo(String message, String username) {
            for (ClientHandler client : clients) {
                if (client.getUsername().equals(username)) {
                    client.sendPrivateMessage(message);
                    break;
                }
            }
        }
        public static void broadcast(String message, ClientHandler sender) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendPublicMessage(message);
                }
            }
        }
        public void sendPrivateMessage(String message)  {
            writer.println("Message from client " + message);
        }
        public void sendPublicMessage(String message)  {
            writer.println("Server sends messages to all clients--> " + message);
        }
        public String getUsername() {
            return username;
        }
    }
}



