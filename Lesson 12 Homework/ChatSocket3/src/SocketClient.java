import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        // Kết nối đến địa chỉ IP và cổng số 5000 của Socket Server
        Socket socket = new Socket("localhost", 5000);

        // Tạo luồng đọc dữ liệu từ Socket Server
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String message = reader.readLine();
                        if (message != null) {
                            System.out.println("User added to Server: " + message);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        // Tạo luồng ghi dữ liệu vào Socket Server
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        // Đọc dữ liệu từ bàn phím
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        // Đọc và ghi dữ liệu liên tục
        while(true) {
            System.out.print("Input: ");
            // Đọc dữ liệu từ Socket Server và in ra màn hình
            String inputData = consoleReader.readLine();
            // Ghi dữ liệu vào Socket Server
            if (inputData != null) {
                writer.println(inputData);
                System.out.println("[Receive] " + inputData);
            }
        }

    }
}

