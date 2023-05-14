
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {

        String file1 = "number.txt";
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        try  {
            FileWriter writer = new FileWriter(file1);
            writer.write(n + "\n");

            for (int i = 0; i < n; i++) {
                int num = rand.nextInt(500) + 1;
                writer.write(num + "\n");

            }
            writer.close();
            System.out.println("Đã ghi file thành công");
        } catch (IOException e) {
            System.out.println("File bị lỗi");
            e.printStackTrace();
        }


    }
}
