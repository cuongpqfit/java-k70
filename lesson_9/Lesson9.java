import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson9 {
    public static void main(String[] args) {
        int a = 32;
        int b = 0;

        try {
            //Khối lệnh muốn bắt ngoại lệ có thể xuất hiện
            System.out.println(a / b);
        } catch (ArithmeticException ex) {
            //Khối lệnh xử lý khi ngoại lệ xuất hiện
            b = 1;
            System.out.println("Xử lý ngoại lệ khi xuất hiện gán b=1");
            System.out.println(a / b);
        }

        int n = 0;
        Scanner in = new Scanner(System.in);
        int i =0;

        try {
            System.out.print("Nhập số nguyện N: ");
            n = in.nextInt();
            i = i+1;
            i = i+2;
            i = i+3;
        } catch (InputMismatchException ex) {
            System.out.println("Số N nhập không đúng định dạng");
            n = 1;
        }

        try {
            System.out.print("Nhập số nguyện N: ");
            n = in.nextInt();
//            System.out.println(a / b);
            return;
        } catch (InputMismatchException ex) {
            System.out.println("Số N nhập không đúng định dạng");
            n = 1;

            return;

        } catch (Exception ex) {
            System.out.println("Exception chưa xác định");
        } finally {
            i = i+1;
            i = i+2;
            i = i+3;
        }

        try {
            try {
                System.out.print("Nhập số nguyện N: ");
                n = in.nextInt();
                return;
            } catch (InputMismatchException ex) {
                throw new ArithmeticException();
            }
        } catch (InputMismatchException ex) {
            System.out.println("InputMismatchException Số N nhập không đúng định dạng");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException Số N nhập không đúng định dạng");
        }

        System.out.println("Số N đã nhập là:  " + n);
    }
}