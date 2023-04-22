import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteAppenFile {
    public static void main(String[] args) {
        String fileName = "D:\\new\\java-k70\\lesson_10\\example.out";

        //Ghi tiếp dữ liệu vào file
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("Dong tiep theo\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
