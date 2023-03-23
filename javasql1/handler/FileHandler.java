package handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.nio.charset.StandardCharsets;

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
                System.out.println("Read file processing...!");
                for (File file : files) {                    
                    //BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))
                    // try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            queue.offer(line, 1, TimeUnit.SECONDS);
                        }
                        br.close();
                        file.delete();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Read file DONE!");
            } else {
                System.out.println("Folder is empty!");
            }
            try {
                Thread.sleep(10 * 1000); // sleep for 5 minutes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
