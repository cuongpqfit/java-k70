package baitap.bai2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.*;

//Sủ dụng Queue để xử lý
public class Bai2 {
    public static void main(String[] args) throws Exception {
        bai1();

        // Khởi tạo BlockingQueue để truyền dữ liệu giữa các thread
        BlockingQueue<Integer> queueThread2 = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> queueThread3 = new LinkedBlockingQueue<>();

        // Tạo thread 1 để đọc dữ liệu từ file number.txt
        Thread thread1 = new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("number.txt"));
                int n = Integer.parseInt(reader.readLine());

                String line;
                while ((line = reader.readLine()) != null) {
                    int number = Integer.parseInt(line);
                    queueThread2.put(number);
                    queueThread3.put(number);
                }

                reader.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Tạo thread 2 để in ra tất cả các ước số của số được truyền từ thread 1
        Thread thread2 = new Thread(() -> {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("output2.txt"));

                while (true) {
                    int number = queueThread2.take();

                    if (number % 2 == 0) {
                        writer.write("Thread -2: " + number + " = ");
                        for (int i = 1; i <= number; i++) {
                            if (number % i == 0) {
                                writer.write(i + ", ");
                            }
                        }
                        writer.write("\n");
                        writer.flush();
                    }

                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Tạo thread 3 để in ra bình phương của số được truyền từ thread 1
        Thread thread3 = new Thread(() -> {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("output3.txt"));

                while (true) {
                    int number = queueThread3.take();
                    if (number % 2 == 1) {
                        writer.write("Thread -3: " + number + " = " + (number * number) + "\n");
                        writer.flush();
                    }

                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Bắt đầu chạy các thread
        thread1.start();
        thread2.start();
        thread3.start();

        // Đợi các thread kết thúc
        thread1.join();
        thread2.join();
        thread3.join();
    }

    public static void bai1() {
        try {
            FileWriter writer = new FileWriter("number.txt");

            // ghi số ngẫu nhiên n xuống file
            Random random = new Random();
            int n = random.nextInt(91) + 10;
            writer.write(n + "\n");

            // ghi n số nguyên dương ngẫu nhiên từ 1 đến 500 xuống file
            for (int i = 0; i < n; i++) {
                int randomNumber = random.nextInt(500) + 1;
                writer.write(randomNumber + "\n");
            }

            writer.close();
            System.out.println("Ghi dữ liệu vào file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}


/* SỬ DỤNG TỪ KHÓA wait, notify, synchronized trong thread */
//public class Bai2 {
//    static BufferedReader reader;
//    static FileWriter writer2;
//    static FileWriter writer3;
//    static int n;
//
//    public static void main(String[] args) {
//        try {
//            bai1();
//            reader = new BufferedReader(new FileReader("number.txt"));
//            writer2 = new FileWriter("output2.txt");
//            writer3 = new FileWriter("output3.txt");
//            String line = reader.readLine();
//            n = Integer.parseInt(line);
//            Thread t1 = new Thread(new Thread1());
//            Thread t2 = new Thread(new Thread2());
//            Thread t3 = new Thread(new Thread3());
//            t1.start();
//            t2.start();
//            t3.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void bai1() {
//        try {
//            FileWriter writer = new FileWriter("number.txt");
//
//            // ghi số ngẫu nhiên n xuống file
//            Random random = new Random();
//            int n = random.nextInt(91) + 10;
//            writer.write(n + "\n");
//
//            // ghi n số nguyên dương ngẫu nhiên từ 1 đến 500 xuống file
//            for (int i = 0; i < n; i++) {
//                int randomNumber = random.nextInt(500) + 1;
//                writer.write(randomNumber + "\n");
//            }
//
//            writer.close();
//            System.out.println("Ghi dữ liệu vào file thành công!");
//        } catch (IOException e) {
//            System.out.println("Lỗi: " + e.getMessage());
//        }
//    }
//
//    static class Thread1 implements Runnable {
//        public void run() {
//            try {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    int x = Integer.parseInt(line);
//                    if (x % 2 == 0) {
//                        synchronized (writer2) {
//                            writer2.write("Thread -2:  " + x + " = ");
//                            for (int i = 1; i <= x; i++) {
//                                if (x % i == 0) {
//                                    writer2.write(i + ", ");
//                                }
//                            }
//                            writer2.write("\n");
//                            writer2.flush();
//                        }
//                    } else {
//                        synchronized (writer3) {
//                            writer3.write("Thread -3:  " + x + " = " + (x * x) + "\n");
//                            writer3.flush();
//                        }
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    static class Thread2 implements Runnable {
//        public void run() {
//            while (true) {
//                synchronized (writer2) {
//                    try {
//                        writer2.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    writer2.notify();
//                }
//            }
//        }
//    }
//
//    static class Thread3 implements Runnable {
//        public void run() {
//            while (true) {
//                synchronized (writer3) {
//                    try {
//                        writer3.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    writer3.notify();
//                }
//            }
//        }
//    }
//}
