import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class lesson_10_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream1 =null;
        FileInputStream fileInputStream2 =null;
        System.out.print("Nhập đường dẫn file 1 ");
        String file1 = scanner.nextLine();
        System.out.print("Nhập đường dẫn file 2  ");
        String file2 = scanner.nextLine();
        int differenceSum = 0;
        int n=0;


        try  {
            fileInputStream1 = new FileInputStream(file1);
            fileInputStream2 = new FileInputStream(file2);
            int i = 0;
            while (fileInputStream1.available()>0 && fileInputStream2.available()>0) {
                i++;
                int b1 = fileInputStream1.read();
                int b2 = fileInputStream2.read();
                if (b1 != b2) {
                    System.out.println(i + " " + (char) b1 + " " + (char) b2);
                    differenceSum++;
                }
            }
            System.out.println(differenceSum);
        } catch (IOException e) {
            System.out.println("Một trong 2  đường dẫn của files bị lỗi");
        } finally {
            try{
                fileInputStream1.close();
                fileInputStream2.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
