package ChatSocket;

import java.io.*;
import java.net.Socket;
import java.util.Locale;

public class ClientHandler implements Runnable {
    private SocketServerJava socketServerJava;
    private Socket clientSocket;
    private ClientInfo clientInfo;
    private String username;

    public ClientHandler(Socket socket, SocketServerJava socketServerJava) {
        this.clientSocket = socket;
        this.socketServerJava = socketServerJava;
    }

    @Override
    public void run() {
        try {
            //Tạo đối tượng để nhận dữ liệu từ client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //Tạo đối tượng để gửi dữ liệu cho client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            do {
                //Gửi yêu cầu đến client;
               out.println("Input username (a-z,A-Z,0-9)? ");
               username = in.readLine();
               System.out.println("Username: " + username);
               //TODO: kiểm tra username tên người dùng có trong phạm vi a..zA..Z0..9
               ///lưu vào biến username
                if (!username.matches("^[a-zA-Z0-9]+$")) {
                    out.println("Username " + username + " không đúng format, xin hãy nhập lại");
                    username = "";
                    continue;
                }
            } while (username.isEmpty() || this.socketServerJava.getClients().containsKey(username));

            out.println("Welcome to the chat server, " + username + "!");
            this.clientInfo = new ClientInfo(username,clientSocket, in, out);

            //Lưu client vào danh sách các Clients được quản lý ở SocketServer
            this.socketServerJava.getClients().put(username, this.clientInfo);

            //Đọc dữ liệu từ client gửi lên và in ra console
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                //TODO: lưu lại dữ liệu người dùng nhập lên vào file tương ứng
                // Lưu dữ liệu của inputLine vào file.
                //Cầu trúc là:
                //Thư mục: History/[Người dùng]/fileluudulieuchat.txt
                storeMessageToFile(this.username, inputLine);
                System.out.println("<--Client: " + inputLine);
                //Gửi lại dữ liệu cho client VIẾT HOA NỘI DUNG
                out.println("Server-->: " + inputLine.toUpperCase(Locale.ROOT));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void storeMessageToFile(String username, String message) {
        String filePath = "./History/"+username+"/fileluudulieuchat.txt";

        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(message);
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
