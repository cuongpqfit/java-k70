import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferInputStream {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferInputStream;

        try {
            //Khơi tạo đối tượng fileInputStream truyền vào đường dẫn đến file muốn đọc
            fileInputStream = new FileInputStream("D:\\new\\java-k70\\lesson_10\\example.inp");

            bufferInputStream = new BufferedInputStream(fileInputStream, 10);

            byte[] b = new byte[1];
            int i;
            while((i = bufferInputStream.read()) != -1) {
                System.out.print((char) i);
            }

            while((bufferInputStream.read(b)) != -1) {
                System.out.print(new String(b));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Luôn đóng file sau khi thao tác xong
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
