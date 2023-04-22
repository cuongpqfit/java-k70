import java.io.*;

public class BufferedReaderFile {
    public static void main(String[] args) {
        Reader reader = null;

        try {
            //Khơi tạo đối tượng fileInputStream truyền vào đường dẫn đến file muốn đọc
            reader = new FileReader("D:\\new\\java-k70\\lesson_10\\example.inp");
            BufferedReader br = new BufferedReader(reader);


            //Cach 1:
//            int i;
//            while((i = br.read()) != -1) {
//                System.out.print((char)i);
//            }

            //Cach 2:
            String line;
            while ((line = br.readLine()) != null){
                System.out.print(line+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Luôn đóng file sau khi thao tác xong
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
