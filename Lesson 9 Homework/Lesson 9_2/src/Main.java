import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời nhập số phấn tử của mảng:");
        int n= scanner.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) {
            try {

                System.out.print("nhập phần tử thứ " + (i+1) + " của mảng: ");
                a[i]= scanner.nextInt();
                if (a[i] == 100){
                    throw new ArithmeticException("not valid");}
                }

            catch (ArithmeticException e) {
                System.out.println("Phần tử vừa nhập có giá trị 100");
                System.out.println("Các phần tử đã nhập: ");
                for (int j = 0; j < i; j++) {
                    System.out.print(a[j] + " ");
                    }
                break;
            }
        }

    }

        }

