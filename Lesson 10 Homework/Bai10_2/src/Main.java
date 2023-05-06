import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào đường dẫn của file cần sao chép ");
        String originalFile = scanner.nextLine();
        FileInputStream fileInputStream=null;
        System.out.print("Nhập vào đường dẫn của file được sao chép ");
        String replacedFile = scanner.nextLine();


        List<String> excludedWords = new ArrayList<>();
        excludedWords.add("a");
        excludedWords.add("an");
        excludedWords.add("the");
        try  {
            fileInputStream = new FileInputStream(originalFile) ;
            FileOutputStream fileOutStream = new FileOutputStream(replacedFile) ;
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutStream);

            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = fileInputStream.read()) != -1) {
                sb.append((char) i);
            }
            String[] words = sb.toString().split("\\s+");
            sb.setLength(0);
            for (String word : words) {
                if (!excludedWords.contains(word.toLowerCase())) {
                    sb.append(word).append(" ");
                }
            }
            outputStream.writeObject(sb.toString());
            System.out.println("Đã copy file thành công");
        } catch (IOException e) {
            System.out.println("Lỗi xảy ra khi copy file");
        }
        try
        {
            FileInputStream inputStream = new FileInputStream(replacedFile);
            ObjectInputStream in = new ObjectInputStream(inputStream);

            Object obj1 = in.readObject();
            System.out.println(obj1);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
