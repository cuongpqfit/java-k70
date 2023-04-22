import java.io.*;

public class ReadWriteObject {
    public static void main(String[] args) {
        String fileName = "D:\\new\\java-k70\\lesson_10\\example.obj";

        MyClass obj = new MyClass("Hello", 10);

        //Ghi object
        try {
            //Tạo một file để lưu đối tượng
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);

            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

            out.writeObject(obj);

            out.close();

            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Đọc object
        try {
            FileInputStream inputStream = new FileInputStream(fileName);

            ObjectInputStream in = new ObjectInputStream(inputStream);

            Object obj1 = in.readObject();

            MyClass myClassObj = (MyClass) obj1;

            System.out.println(myClassObj.hashCode());
            System.out.print(myClassObj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
