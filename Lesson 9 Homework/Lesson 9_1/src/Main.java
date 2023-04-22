
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Xin mời nhập vào số thực a: ");
        double a = inputDouble();
        System.out.println("Số a= " + a);
        System.out.println("Xin mời nhập vào số thực b: ");
        double b = inputDouble();
        System.out.println("Số b= " + b);

        System.out.println("-------------------------------");
        System.out.println("hàm chia");
        System.out.println("Xin mời nhập vào số nguyên c: ");
        int c = scanner.nextInt();
        System.out.println("Xin mời nhập vào số nguyên d: ");
        int d = scanner.nextInt();

        try {
            float result = diviveNo(c,d);
            System.out.println("Kết quả = " + result);
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra");
        }
    }


    public static Double inputDouble() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                return Double.parseDouble(scanner.next().trim());
            } catch (NumberFormatException e) {
                System.out.println("Nhập lại số nguyên");
            }
        }
    }
    public static float diviveNo(int a, int b){
        float c =a/b;
        return c;
    }
}
