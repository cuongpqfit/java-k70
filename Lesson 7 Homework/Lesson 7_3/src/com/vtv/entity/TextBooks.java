package com.vtv.entity;

import java.util.Date;

public class TextBooks extends Books {
    private String bookCondition;

    public TextBooks() {
        super();
    }

    public TextBooks(String bookCode, Date publishedDate, double bookPrice, int bookQuantity, String bookPublisher, String bookCondition) {
        super(bookCode, publishedDate, bookPrice, bookQuantity, bookPublisher);
        this.bookCondition = bookCondition;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }

    @Override
    public String toString() {
        return  "bookCode: " +super.getBookCode() +
                ", createDate:" + super.getPublishedDate() +
                ", bookPrice: " + super.getBookPrice() +
                ", bookQuantity=" + super.getBookQuantity() +
                ", bookProduction='" + super.getBookPublisher() +
                ", bookCondition='" + this.bookCondition + '\'' +
                '}';
    }

    public double priceCalculation(String condition){
        double finalPrice;
        System.out.println("Xin nhập tình trạng của sách ( New/Old)");
        if(condition == "New"){
            finalPrice = this.getBookQuantity()*this.getBookPrice();
        }
        else{
            finalPrice = this.getBookQuantity()*this.getBookPrice()/2;
        }
        return finalPrice;
    }
}
