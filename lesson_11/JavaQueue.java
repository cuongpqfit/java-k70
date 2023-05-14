import java.util.LinkedList;
import java.util.Queue;

public class JavaQueue {

    public static boolean isPalidromes(String str) {

        return true;
    }

    public static void main(String[] args) {
        //Khơi tạo Queue
        Queue<String> queue = new LinkedList<>();

        //Thêm dữ liệu vào Queue
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        queue.add("f");
        queue.add("g");

        //In queue
        System.out.println("Show queue: " + queue);

        //Remove Queue
        queue.remove();
        System.out.println("Remove queue: " + queue);

        //Get data in Queue
        System.out.println("Show data queue: " + queue.peek());
        //show Queue after peek
        System.out.println("Show data queue: " + queue);


        //Get and remove data in Queue
        System.out.println("Show data queue: " + queue.poll());
        //show Queue after peek
        System.out.println("Show data queue: " + queue);

        while (!queue.isEmpty()) {
            System.out.println("Show data queue: " + queue.poll());
        }
    }
}
