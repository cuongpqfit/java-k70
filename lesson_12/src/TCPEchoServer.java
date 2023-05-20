import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPEchoServer {
    private static int port = 7;
    public static void main(String[] args) throws IOException {
        //Tạo Socket Server tại port 7
        //Các address default luôn có 1 máy tính: localhost/127.0.0.1

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("[OK] Socket Server running: " + InetAddress.getLocalHost().getHostAddress() + ":" + port);

            //Chờ kết nối từ Socket Client
            System.out.println("Listening client connect");
            Socket socket = serverSocket.accept();
            System.out.println("[CON] New client connected: " + socket);

            //Tạo luồng đọc dữ liệu từ Socket Client(Nhận dữ liệu từ client gửi lên)
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //Tọa luông ghi dữ liệu vào Socket Client(Gửi dữ liệu xuống client)
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            //Nhận dữ liệu liên tục từ client
            while (true) {
                //Đọc dữ liệu từ client
                String receiveData = reader.readLine();

                if (receiveData != null) {
                    System.out.println("Server received: " + receiveData);

                    //Gửi dữ liệu xuống client
                    writer.println("Server: " + Integer.parseInt(receiveData) * Integer.parseInt(receiveData));
                }
            }
        } catch (SocketException e) {
            System.out.println("Client close connected!");
        }
    }
}
