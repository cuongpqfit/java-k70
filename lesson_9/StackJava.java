import java.util.*;

public class StackJava {
    public static void main(String[] args) {
        int n = 5;
        Scanner scanner = new Scanner(System.in);

        //Stack trong java
        Deque<Integer> stack = new ArrayDeque<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        int item;

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập vào số nguyên thứ " + (i + 1) + ": ");
            int element = scanner.nextInt();
            //Đẩy phần tử vào stack
            stack.push(element);
//            list.add(element);
        }

        System.out.println("Lấy ra phần tử cuối cùng nạp vào stack: " + stack.peek());
        System.out.println("Lấy kích thước stack: " + stack.size());

        while (!stack.isEmpty()) {
            //POP: Lấy phần tử vào stack
           item =  stack.pop();
           System.out.print(item + " ");
        }
    }
}
