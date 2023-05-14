//Tao Thread cach 1: implements từ Runable
class FirstThread implements Runnable {
    @Override
    public void run() {
        for (int i=1; i<=10; i++) {
            System.out.println("Message from first Thread: " + i);

            //Tạm dừng thread trong 1s

            try {
                System.out.println("Message from first Thread: Sleeping" );
                //State: Sleeping
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Message from first Thread: Done" );
    }
}

class SecondThread implements Runnable {
    @Override
    public void run() {
        for (int i=1; i<=10; i++) {
            System.out.println("Message from Second Thread: " + i);

            //Tạm dừng thread trong 1s

            try {
                System.out.println("Message from Second Thread: Sleeping" );
                //State: Sleeping
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Message from Second Thread: Done" );
    }
}

//Tao Thread cach 2: extends từ class Thread
class SimpleThread extends Thread {
    public SimpleThread(String str) {
        super(str);
    }

    @Override
    public void run() {
        for (int i=1; i<=10; i++) {
            System.out.println("Message from " + getName() + " Thread: " + i);

            //Tạm dừng thread trong 1s

            try {
                System.out.println("Message from " + getName() + " Thread: Sleeping" );
                //State: Sleeping
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Message from " + getName() + " Thread: Done" );
    }
}

public class JavaThread {
    public static void main(String[] args) {
        //Tạo ra nhiều luồng để thực hiện nhiều công việc
        //Tạo đối tượng từ lớp thực thi của Runable
        FirstThread t1 = new FirstThread();

        //Tạo đối tượng của lớp Thread với tham số là đối tượng từ Runable
        //State: NEW
        Thread t = new Thread(t1);
        //State: Ready

        //Thực thi Thread
        //State: Running
        t.start();


        //Style code 2
        Thread t2 = new Thread(new SecondThread());
        t2.start();


        //Tạo ra nhiều luồng để thực hiện 1 công việc
        SimpleThread s1 = new SimpleThread("TSimple");
        SimpleThread s2 = new SimpleThread("TSimple-2");
        s1.start();
        s2.start();
    }
}
