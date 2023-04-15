import com.ttd.backend.accountBackend;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        accountBackend accountBackend =  new accountBackend();
        while(true) {
            System.out.println("---------------------------------");
            System.out.println("Mời bạn chọn chức năng sử dụng:");
            System.out.println("1. Tạo Account");
            System.out.println("2. Hiển thị thông tin tài khoản");
            System.out.println("3. Gửi tiền vào tài khoản");
            System.out.println("4. Rút tiền từ tài khoản");
            System.out.println("5. Đáo hạn");
            System.out.println("6. Chuyển tiền từ account này sang account khác:");
            System.out.println("7. Thoát chương trình");
            int chooseMenu = scanner.nextInt();
            switch (chooseMenu) {
                case 1:
                    accountBackend.accountInformation();
                    break;
                case 2:
                    accountBackend.printBankAccountInformation();
                    break;
                case 3:
                    accountBackend.depositAmount();
                    break;
                case 4:
                    accountBackend.withdrawAmount();
                    break;
                case 5:
                    accountBackend.monthInterestAmount();
                    break;
                case 6:
                    accountBackend.transferMoney();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Chọn số trên menu");
                    break;
            }
        }

    }
}
