package com.vtv.frontend;

import com.vtv.backend.BookBackend;

import java.awt.print.Book;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        List<Book> myBook = new ArrayList<>();
        List<Book> myBook2 = new LinkedList<>();



        Scanner scanner = new Scanner(System.in);
        BookBackend bookBackend = new BookBackend();
        while (true) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("                       Choose Please                                ");
            System.out.println("             1. Nhập xuất danh sách các loại sách                   ");
            System.out.println("             2. Tính tổng thành tiền từng loại                      ");
            System.out.println("             3. Tính trung bình cộng đơn giá cúa sách tham khảo     ");
            System.out.println("             4. Xuất ra các sách giáo khoa của nhà xuất bản X       ");
            System.out.println("             5. Thoát chương trình                                  ");
            System.out.println("--------------------------------------------------------------------");

            int chooseMenu = scanner.nextInt();
            switch (chooseMenu) {
                case 1:
                    bookBackend.BookInventory();
                    break;
                case 2:
                    bookBackend.TotalPrice();
                    break;
                case 3:
                    bookBackend.AverageofReferenceBook();
                    break;
                case 4:
                    bookBackend.FilterbyPublisher();
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