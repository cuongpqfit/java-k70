package com.ttd.backend;

import com.ttd.entity.MoneyType;
import com.ttd.entity.Trade;
import com.ttd.entity.cashMethod;
import com.ttd.entity.goldMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TradeBackend {
    private ArrayList<Trade> tradeArray;

    private Scanner scanner;

    public TradeBackend() {
        tradeArray = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void TradeInventory() throws ParseException {
        System.out.println("Nhập xuất danh sách các giao dịch ");
        System.out.println("--------------------------------------");
        System.out.println("1. Nhập danh sách các giao dịch bằng vàng");
        System.out.println("2. Nhập danh sách các giao dịch bằng cash");
        System.out.println("3. Xuất danh sách các giao dịch ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Mời bạn nhập vào mã giao dich");
                String tradeCode = scanner.next();

                System.out.println("Mời bạn nhập ngày giao dịch");
                String dateFormat = "dd/MM/yyyy";
                Date tradeDate = new SimpleDateFormat(dateFormat).parse(scanner.next());

                System.out.println("Mời bạn nhập vào giá dao dịch");
                double tradePrice = scanner.nextDouble();

                System.out.println("Mời bạn nhập vào số lượng ");
                int quantity = scanner.nextInt();

                System.out.println("Mời bạn nhập vào loại vàng");
                String goldType = scanner.next();


                Trade goldTrade = new goldMethod(tradeCode, tradeDate, tradePrice, quantity, goldType);

                tradeArray.add(goldTrade);
                break;

            case 2:

                System.out.println("Mời bạn nhập vào mã giao dich");
                String tradeCode1 = scanner.next();

                System.out.println("Mời bạn nhập ngày giao dịch");
                String dateFormat1 = "dd/MM/yyyy";
                Date tradeDate1 = new SimpleDateFormat(dateFormat1).parse(scanner.next());

                System.out.println("Mời bạn nhập vào giá dao dịch");
                double tradePrice1 = scanner.nextDouble();

                System.out.println("Mời bạn nhập vào số lượng ");
                int quantity1 = scanner.nextInt();

                System.out.println("Mời bạn nhập vào tỉ giá ");
                double exchangeRate = scanner.nextDouble();

                System.out.println("Mời bạn nhập vào loại tiền tệ: 1. VND 2.USD 3.EURO");
                int moneyTypeChoose = scanner.nextInt();
                MoneyType moneyType = null;
                switch(moneyTypeChoose) {
                    case 1:
                        moneyType = MoneyType.VND;
                        break;
                    case 2:
                        moneyType = MoneyType.USD;
                        break;
                    case 3:
                        moneyType = MoneyType.EURO;
                        break;
                }


                Trade cashTrade = new cashMethod(tradeCode1, tradeDate1, tradePrice1, quantity1, exchangeRate, moneyType);

                tradeArray.add(cashTrade);
                break;
            case 3:
                showTradeInformation();
                break;
        }

}
    public void showTradeInformation() {
        System.out.println("--------------------------------------");
        System.out.println("Hiển thị thông tin giao dịch ");
        System.out.println("1. Giao dịch bằng vàng ");
        System.out.println("2. Giao dịch bằng tiền ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:

                for (Trade trade : tradeArray) {
                    if (trade instanceof goldMethod) {
                        System.out.println(trade.toString());
                    }
                }
                break;
            case 2:
                for (Trade trade : tradeArray) {
                    if (trade instanceof cashMethod) {
                        System.out.println(trade.toString());
                    }
                }
                break;
        }
    }

    public void TotalQuantity() {
        System.out.println("Tính tổng số lương từng loại giao dịch");
        System.out.println("Chọn loại giao dịch muốn tính tổng số lượng ");
        System.out.println("--------------------------------------");
        System.out.println("1. Gaio dịch vàng ");
        System.out.println("2. Giao dịch tiền ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                int sum = 0;

                for (Trade trade : tradeArray) {
                    if (trade instanceof goldMethod) {
                        sum+= trade.getTradeQuantity();

                    }
                }
                System.out.println("Tổng số lượng giao dịch bằng vàng: " + sum);
                break;
            case 2:
                double sum1 = 0;

                for (Trade trade : tradeArray) {
                    if (trade instanceof cashMethod) {
                        sum1+= trade.getTradeQuantity();

                    }
                }
                System.out.println("Tổng số lượng giao dịch bằng tiền: " + sum1);
                break;

        }
    }

    public void AverageofMoneyTrade() {
        System.out.println("Tính trung bình cúa giao dịch tiền tệ");
        double averagePrice = 0;
        double sum = 0;
        int count = 0;
        for (Trade trade : tradeArray) {
            if (trade instanceof cashMethod) {
                sum += ((cashMethod) trade).cashTypeCalculation(((cashMethod) trade).getMoneyType());
                count += 1;
            }
        }
        averagePrice = sum / count;
        System.out.println("Trung bình cộng đơn giá của sách tham khảo: "+ averagePrice);
    }

    public void FilterbyTradeUnit(){
        System.out.println("Xuất ra các giao dich > 1 tỷ  ");

        for (Trade trade: tradeArray){
            if(trade.getTradeUnit()>1000000000){
                System.out.println(trade.toString());
            }
        }

    }
}