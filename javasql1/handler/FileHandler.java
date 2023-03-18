package handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class FileHandler implements Runnable {
    private String dirPath;
    private BlockingQueue<String> queue;

    public FileHandler(String dirPath, BlockingQueue<String> queue) {
        this.dirPath = dirPath;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            File dir = new File(dirPath);
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            queue.offer(line, 1, TimeUnit.SECONDS);
                        }
                        file.delete();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(5 * 60 * 1000); // sleep for 5 minutes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
