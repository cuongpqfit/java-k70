package Module2.handler;

import Module2.model.Order;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class FileHandler implements Runnable{
    private String dirPath;
    private LinkedBlockingQueue<Order> queue;

    public FileHandler(String dirPath, LinkedBlockingQueue<Order> queue) {
        this.dirPath = dirPath;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            //Tạo ra đối tượng quản lý thư mục
            File dir = new File(this.dirPath);

            //Lấy danh sách file trong thư mục
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                System.out.println("Read file processing....!");
                for (File file : files) {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;
                        String[] cols;
                        int i=0;
                        //Đọc từng dòng trong file đến hết
                        while ((line = br.readLine()) != null) {
                            if (i==0) {
                                i++;
                                continue;
                            }

                            cols = line.split(",");
                            Order order = new Order(cols[0], cols[1], cols[2], cols[3], cols[4]);
                            queue.put(order);
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
                Thread.sleep(30 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
