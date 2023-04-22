import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số N ");
        int N= scanner.nextInt();
        System.out.println("Nhập vào số B (giá trị từ 2 đến 16");
        int B= scanner.nextInt();
        if (B < 2 || B > 16) {
            System.out.println("Cơ số B không hợp lệ!");
            return;
        }
        int powerNo=0;
        int sum=0;

        while(N!=0){
            int m = N%10;
            int temp= (int) (m*(Math.pow(B,powerNo)));
            sum+=temp;
            N=N/10;
            powerNo+=1;
        }
        System.out.println(sum);

    }
}
