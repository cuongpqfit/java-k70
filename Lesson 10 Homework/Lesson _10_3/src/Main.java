import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào đường dẫn file input: ");
        String inputFile = scanner.nextLine();
        System.out.print("Nhập vào đường dẫn file output : ");
        String outputFile = scanner.nextLine();

        try  {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile );
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                Student student = new Student(name, age);
                oos.writeObject(student);
                System.out.println("dữ liệu object của " + student.toString());
            }

        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra");
        }

    }
}
