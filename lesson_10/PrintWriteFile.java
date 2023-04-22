import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriteFile {
    public static void main(String[] args) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("D:\\new\\java-k70\\lesson_10\\example.out");

            writer.write("Write 100 line\n");
            writer.flush();

            for (int i=0; i<1; i++) {
                writer.write("Lesson 10 write to file\n");
                writer.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
