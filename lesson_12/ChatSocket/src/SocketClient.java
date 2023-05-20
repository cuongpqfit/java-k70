import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {
            // Kết nối đến địa chỉ IP và cổng số 5000 của Socket Server
            Socket socket = new Socket("localhost", 5000);

            // Tạo luồng đọc dữ liệu từ Socket Server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Tạo luồng ghi dữ liệu vào Socket Server
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Đọc và ghi dữ liệu liên tục
            while (true) {
                System.out.print("Input: ");
                // Đọc dữ liệu từ bàn phím
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
                String inputData = inputReader.readLine();

                // Ghi dữ liệu vào Socket Server
                writer.println(inputData);

                // Đọc dữ liệu từ Socket Server và in ra màn hình
                String receivedData = reader.readLine();
                System.out.println("[Receive] " + receivedData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
