import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamReader {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;

        try {
            //Khơi tạo đối tượng fileInputStream truyền vào đường dẫn đến file muốn đọc
            fileInputStream = new FileInputStream("D:\\new\\java-k70\\lesson_10\\example.inp");

            byte[] b = new byte[1];
//            int i;
//            while((i = fileInputStream.read()) != -1) {
//                System.out.print(i + " ");
//            }

            while((fileInputStream.read(b)) != -1) {
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
