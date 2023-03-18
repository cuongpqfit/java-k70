import handler.FileHandler;
import handler.StoreHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BatchFileStore {

    public static void main(String[] args) {
        // Sử dụng class Properties để đọc file config lưu dạng key-value
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("app.config");
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            // Đọc properties values
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String dirPath = properties.getProperty("dirPath");

            // Create queue
            BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

            // Start threads
            Thread writerThread = new Thread(new StoreHandler(url, user, password, queue));
            Thread loaderThread = new Thread(new FileHandler(dirPath, queue));

            writerThread.start();
            loaderThread.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
