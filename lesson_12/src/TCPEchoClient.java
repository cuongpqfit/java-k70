import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPEchoClient {
    private static String ipAddress = "localhost";
    private static int port = 7;

    public static void main(String[] args) throws IOException {
        //Tạo Socket Client kết nối đến Socket Server tại ipAddress:port
        Socket socket = new Socket(ipAddress, port);

        //Tạo luồng đọc dữ liệu từ Socket Client(Nhận dữ liệu từ Server gửi về)
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //Tạo luông ghi dữ liệu vào Socket Client(Gửi dữ liệu lên Server)
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        for (int i=1; i<10; i++) {
            //Gửi dữ liệu lên Server
            System.out.println("Client send: " + i);
            writer.println(i);

            //Đọc dữ liệu từ client
            String receiveData = reader.readLine();

            if (receiveData != null) {
                System.out.println("--> Client received: " + receiveData);

            }
        }

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
