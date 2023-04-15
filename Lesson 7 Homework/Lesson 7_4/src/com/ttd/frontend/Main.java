package com.ttd.frontend;

import com.ttd.backend.TradeBackend;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        TradeBackend tradeBackend = new TradeBackend();
        while (true) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("                       Choose Please                                ");
            System.out.println("             1. Nhập xuất danh sách các giao dịch                   ");
            System.out.println("             2. Tính tổng số lượng từng loại                        ");
            System.out.println("             3. Tính trung bình thành tiền của giao dịch tiền tệ    ");
            System.out.println("             4. Xuất ra các giao dịch > 1 tỷ                        ");
            System.out.println("             5. Thoát chương trình                                  ");
            System.out.println("--------------------------------------------------------------------");

            int chooseMenu = scanner.nextInt();
            switch (chooseMenu) {
                case 1:
                    tradeBackend.TradeInventory();
                    break;
                case 2:
                    tradeBackend.TotalQuantity();
                    break;
                case 3:
                    tradeBackend.AverageofMoneyTrade();
                    break;
                case 4:
                    tradeBackend.FilterbyTradeUnit();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Chọn lại");
                    break;
            }
        }
    }
}