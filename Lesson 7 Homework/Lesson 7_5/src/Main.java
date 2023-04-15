import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Vào một buổi sáng anh Bo sắp một đàn bò gồm n con bò để vắt sữa. Anh dự kiến là vào sáng hôm đó, con bò thứ i có khả
        năng sẽ vắt được ai lít sữa. Tuy nhiên đàn bò của anh có đặc tính là cứ mỗi lần vắt sữa một con, những con còn lại trông
        thấy sợ quá nên sẽ bị giảm sản lượng mỗi con 01 lít sữa. Nếu vắt sữa con bò thứ nhất, n-1 con còn lại bị giảm sản lượng.
                Sau đó vắt sữa con bò thứ hai thì n-2 con còn lại bị giảm sản lượng.... Bạn hãy giúp anh Bo tính xem thứ tự vắt sữa bò
        như thế nào để số lượng sữa vắt được là nhiều nhất nhé.
                Input: gồm 2 dòng
                - Dòng thứ nhất là số nguyên n (1 ≤ n ≤ 100) là số lượng con bò.
                - Dòng thứ hai gồm n số nguyên a1, a2,..., an (1 ≤ ai ≤ 1000) là sản lượng sữa của các con bò.
        Output:
        - Là một số nguyên xác định số lít sữa nhiều nhất mà anh Bo có thể vắt được.

                Input           Output
        4               10
        4 4 4 4
                ----------------------
        4               6
        2 1 4 3
*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lương con bò n= ");
        int n= scanner.nextInt();
        int[] milkVolumne = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Nhập số lít sữa của bò:");
            milkVolumne[i]= scanner.nextInt();
        }
        int temp = milkVolumne[0];
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(milkVolumne[i]<milkVolumne[j]){
                    temp=milkVolumne[j];
                    milkVolumne[j]=milkVolumne[i];
                    milkVolumne[i]=temp;
            }

            }
        }

        int totalMilk = 0;
        for (int i = n - 1; i >= 0; i--) {
            totalMilk += milkVolumne[i] - (n - 1 - i);
            if (milkVolumne[i] - (n - 1 - i) < 0) {
                break;
            }
        }
        System.out.println(totalMilk);

    }
}