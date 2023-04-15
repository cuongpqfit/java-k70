package com.vtv.backend;

import com.vtv.entity.Books;
import com.vtv.entity.ReferenceBooks;
import com.vtv.entity.TextBooks;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookBackend {
    private ArrayList<Books> booksArray;

    private Scanner scanner;

    public BookBackend() {
        booksArray = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void BookInventory() throws ParseException {
        System.out.println("Nhập xuất danh sách các loại sách ");
        System.out.println("--------------------------------------");
        System.out.println("1. Nhập danh sách các sách giáo khoa ");
        System.out.println("2. Nhập danh sách các sách tham khảo ");
        System.out.println("3. Xuất danh sách các sách  ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Mời bạn nhập vào mã sách giáo khoa");
                String code = scanner.next();

                System.out.println("Mời bạn nhập vào ngày xuất bản");
                String dateFormat = "dd/MM/yyyy";
                Date publish = new SimpleDateFormat(dateFormat).parse(scanner.next());

                System.out.println("Mời bạn nhập vào giá sách");
                double price = scanner.nextDouble();

                System.out.println("Mời bạn nhập vào số lượng sách");
                int quantity = scanner.nextInt();

                System.out.println("Mời bạn nhập vào nhà xuất bản");
                String publisher = scanner.next();
                System.out.println("Mời bạn nhập vào tình trạng sách");
                String condition = scanner.next();

                Books textBook = new TextBooks(code, publish, price, quantity, publisher, condition);

                booksArray.add(textBook);
                break;

            case 2:

                System.out.println("Mời bạn nhập vào mã sách tham khảo");
                String codeR = scanner.next();

                System.out.println("Mời bạn nhập vào ngày xuất bản");
                String dateFormatR = "dd/MM/yyyy";
                Date publishR = new SimpleDateFormat(dateFormatR).parse(scanner.next());

                System.out.println("Mời bạn nhập vào giá sách");
                double priceR = scanner.nextDouble();

                System.out.println("Mời bạn nhập vào số lượng sách");
                int quantityR = scanner.nextInt();

                System.out.println("Mời bạn nhập vào nhà xuất bản");
                String publisherR = scanner.next();

                System.out.println("Mời bạn nhập vào thuế");
                double bookTax = scanner.nextDouble();

                Books referenceBook = new ReferenceBooks(codeR, publishR, priceR, quantityR, publisherR, bookTax);
                booksArray.add(referenceBook);
                break;
            case 3:
                showBookInformation();
                break;
        }

    }

    public void showBookInformation() {
        System.out.println("--------------------------------------");
        System.out.println("Hiển thị thông tin sách ");
        System.out.println("1. Sách giáo khoa ");
        System.out.println("2. Sách tham khảo ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:

                for (Books book : booksArray) {
                    if (book instanceof TextBooks) {
                        System.out.println(book.toString());
                    }
                }
                break;
            case 2:
                for (Books book : booksArray) {
                    if (book instanceof ReferenceBooks) {
                        System.out.println(book.toString());
                    }
                }
                break;
        }
    }

    public void TotalPrice() {
        System.out.println("Tính tổng thành tiền từng loại");
        System.out.println("Chọn loại sách muốn tính tiền ");
        System.out.println("--------------------------------------");
        System.out.println("1. Sách giáo khoa ");
        System.out.println("2. Sách tham khảo ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                double finalPrice = 0;
                System.out.println("Xin nhập mã giáo khoa sách muốn tính tiền");
                String bookCode = scanner.next();

                for (Books book : booksArray) {
                    if (book instanceof TextBooks) {
                        if (book.getBookCode().equals(bookCode)) {
                            if (((TextBooks) book).getBookCondition().equals("New")) {
                                finalPrice = book.getBookQuantity() * book.getBookPrice();
                            } else {
                                finalPrice = book.getBookQuantity() * book.getBookPrice() / 2;
                            }
                        }

                    }
                }
                System.out.println(finalPrice);
                break;
            case 2:
                double finalPrice1 = 0;
                System.out.println("Xin nhập mã sách tham khảo muốn tính tiền");
                String bookCode1 = scanner.next();

                for (Books book : booksArray) {
                    if (book instanceof ReferenceBooks) {
                        finalPrice1 = book.getBookQuantity() * book.getBookPrice() * ((ReferenceBooks) book).getBookTax();
                    }
                }
                System.out.println(finalPrice1);
                break;

        }
    }


    public void AverageofReferenceBook() {
        System.out.println("Tính trung bình cộng đơn giá cúa sách tham khảo");
        double averagePrice = 0;
        double sum = 0;
        int count = 0;
        for (Books book : booksArray) {
            if (book instanceof ReferenceBooks) {
                sum += book.getBookPrice();
                count += 1;
            }
        }
        averagePrice = sum / count;
        System.out.println("Trung bình cộng đơn giá của sách tham khảo: "+ averagePrice);
        }


    public void FilterbyPublisher(){
        System.out.println("Xuất ra các sách giáo khoa của nhà xuất bản X  ");
        System.out.println("Mời bạn nhập vào tên nhà xuất bản");
        String nameSearch = scanner.next();

        for (Books book: booksArray){
            if(book instanceof  TextBooks){
                if(book.getBookPublisher().equals(nameSearch))
                System.out.println(book.toString());
            }
        }

    }
}

