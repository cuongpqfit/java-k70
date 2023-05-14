import java.util.*;

public class Main {
    public static void main(String[] args) {

     Scanner scanner = new Scanner(System.in);
     int result=0;
        System.out.println("nhập vào số lượng đá n:");
        int n= scanner.nextInt();

        int stones[] = new int[n];
        System.out.println("Nhập trọng lượng đá cho mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i+1) + ": ");
            stones[i] = scanner.nextInt();
        }
            List<Integer> list = new ArrayList<>();
            for (int stone : stones) {
                list.add(stone);
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(list.size(), Collections.reverseOrder());
            queue.addAll(list);
            while (queue.size() > 1) {
                int stone1 = queue.poll();
                int stone2 = queue.poll();
                if (stone1 != stone2) {
                    queue.add(stone1 - stone2);
                }
            }

            if(queue.isEmpty()){
                result=0;
            }
            else{
                result=queue.poll();
            }

        System.out.println("Trọng lương của hòn đá cuối cùng là: " + result);
        }
    }

