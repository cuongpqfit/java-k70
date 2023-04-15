package com.ttd.frontend;

import com.ttd.backend.FoodBackend;

import java.text.ParseException;
import java.util.Scanner;

 public class Main {
        public static void main(String[] args) throws ParseException {

            Scanner scanner = new Scanner(System.in);
            FoodBackend foodBackend = new FoodBackend();
            while (true) {
                System.out.println("---------------------------------");
                System.out.println("Mời bạn chọn chức năng sử dụng:");
                System.out.println("1. Tạo thông tin sản phẩm");
                System.out.println("2. Hiển thị thông tin sản phẩm");
                System.out.println("3. Kiểm tra hạn sử dụng của sản phẩm");
                System.out.println("4. Thoát chương trình");

                int chooseMenu = scanner.nextInt();
                switch (chooseMenu) {
                    case 1:
                        foodBackend.addFoodInformation();
                        break;
                    case 2:
                        foodBackend.printFoodInformation();
                        break;
                    case 3:
                        foodBackend.foodDateCheck();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Mời nhập lại lựa chọn");
                        break;

                }
            }
        }
    }
