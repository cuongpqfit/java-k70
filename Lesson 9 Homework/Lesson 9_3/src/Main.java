import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số N( cơ sô 10) ");
        int N= scanner.nextInt();
        System.out.println("Nhập vào số B (giá trị từ 2 đến 16");
        int B= scanner.nextInt();
        if (B < 2 || B > 16) {
            System.out.println("Cơ số B không hợp lệ!");
            return;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int item;

        while(N>0){
            int m = N%B;
            stack.push(m);
            N=N/B;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            if (digit < 10) {
                result.append(digit);
            } else {
                result.append((char) ('A' + (digit - 10)));
            }
        }
        System.out.println("Số tương ứng ở cơ số " + N + ": " + result.toString());
    }
    }

