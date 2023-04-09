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
    private ArrayList<Books> textbooksArray;

    //Ngay dau
    private Books[] a = new Books[1000];

    private ArrayList<Books> referencebooksArray;
    private Scanner scanner;

    public BookBackend(){
        textbooksArray = new ArrayList<>();


        referencebooksArray = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void BookInventory() throws ParseException {
        System.out.println("Nhập xuất danh sách các loại sách ");
        System.out.println("--------------------------------------");
        System.out.println("1. Nhập danh sách các sách giáo khoa ");
        System.out.println("2. Nhập danh sách các sách tham khảo ");
        System.out.println("3. Xuất danh sách các sách  ");
        int choose = scanner.nextInt();
        switch(choose){
            case 1:
                System.out.println("Mời bạn nhập vào mã sách giáo khoa");
                String code = scanner.next();

                System.out.println("Mời bạn nhập vào ngày xuất bản");
                String dateFormat = "dd/mm/yyyy";
                String sPublish = scanner.next();
                Date publish =new SimpleDateFormat(dateFormat).parse(sPublish);

                System.out.println("Mời bạn nhập vào giá sách");
                double price = scanner.nextDouble();

                System.out.println("Mời bạn nhập vào số lượng sách");
                int quantity = scanner.nextInt();

                System.out.println("Mời bạn nhập vào nhà xuất bản");
                String publisher = scanner.next();

                System.out.println("Mời bạn nhập vào tình trạng sách");
                String condition = scanner.next();

                Books textBook = new TextBooks(code, publish, price, quantity,publisher, condition);

                textbooksArray.add(textBook);

                System.out.println(textBook);
                break;

            case 2:

                System.out.println("Mời bạn nhập vào mã sách tham khảo");
                String codeR = scanner.next();

                System.out.println("Mời bạn nhập vào ngày xuất bản");
                String dateFormatR = "dd/mm/yyyy";
                Date publishR =new SimpleDateFormat(dateFormatR).parse(scanner.nextLine());

                System.out.println("Mời bạn nhập vào giá sách");
                double priceR = scanner.nextDouble();

                System.out.println("Mời bạn nhập vào số lượng sách");
                int quantityR = scanner.nextInt();

                System.out.println("Mời bạn nhập vào nhà xuất bản");
                String publisherR = scanner.next();

                System.out.println("Mời bạn nhập vào thuế");
                double tax = scanner.nextDouble();

                Books referenceBook = new ReferenceBooks(codeR, publishR, priceR, quantityR,publisherR, tax);
                referencebooksArray.add(referenceBook);
                break;
            case 3:
                showBookInformation();
                break;
        }

    }
    public void showBookInformation() {
        System.out.println("--------------------------------------");
        System.out.println("1. Sách giáo khoa ");
        System.out.println("2. Sách tham khảo ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Hiển thị thông tin sách giáo khoa");

                for (Books book : textbooksArray) {
                    System.out.println(book.toString());
                }
                break;
            case 2:
                System.out.println("Hiển thị thông tin sách tham khảo");

                for (Books book : referencebooksArray) {
                    System.out.println(book.toString());
                }
                break;
        }
    }
    public void TotalPrice() {
        System.out.println("2. Tính tổng thành tiền từng loại");
        System.out.println("Chọn loại sách muốn tính tiền ");
        System.out.println("--------------------------------------");
        System.out.println("1. Sách giáo khoa ");
        System.out.println("2. Sách tham khảo ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                TextBooks textBook1 = new TextBooks();
                double finalPrice;
                System.out.println("Xin nhập tình trạng của sách ( New/Old)");
                String condition = scanner.next();

                if (textBook1.getBookCondition() == "New") {
                    finalPrice = textBook1.getBookQuantity() * textBook1.getBookPrice();
                } else {
                    finalPrice = textBook1.getBookQuantity() * textBook1.getBookPrice() / 2;
                }
                System.out.println("Tổng giá của sách giáo khoa là: " + finalPrice);
                break;
//            case 2:
////                double finalPrice2;
////                ReferenceBooks referenceBook = new ReferenceBooks();
////                for (int i; i < referencebooksArray.size(); i++) {
////                    finalPrice2 = referencebooksArray.get(i).getBookQuantity() * referencebooksArray.get(i).getBookTax();
////
////                    System.out.println("Tổng giá của sách tham khảo là: " + finalPrice2);
////                    break;
//                }
//        }
        }
    }
    public void AverageofReferenceBook(){
        System.out.println("3. Tính trung bình cộng đơn giá cúa sách tham khảo");
        double averagePrice;
        double sum=0;
        int count=0;
        ReferenceBooks referenceBook1 = new ReferenceBooks();
        for(int i=0; i<referencebooksArray.size();i++){
            sum+= referenceBook1.getBookPrice()*referenceBook1.getBookQuantity();
            count+=1;
        }
        averagePrice = sum/count;
    }
    public void FilterbyPublisher(){
        System.out.println("4. Xuất ra các sách giáo khoa của nhà xuất bản X  ");
        System.out.println("Mời bạn nhập vào tên nhà xuất bản");
        String nameSearch = scanner.next();

        for (Books book: textbooksArray){
            if(book.getBookPublisher().equals(nameSearch)){
                System.out.println(book.toString());
            }
        }

    }
}
