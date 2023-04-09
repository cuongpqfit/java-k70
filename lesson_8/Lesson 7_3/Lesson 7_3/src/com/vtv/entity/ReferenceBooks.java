package com.vtv.entity;

import java.util.Date;

public class ReferenceBooks extends Books {
    private double bookTax;

    public ReferenceBooks(){
        super();
    }
    public ReferenceBooks(String bookCode, Date publishedDate, double bookPrice, int bookQuantity, String bookPublisher, double bookTax) {
        super(bookCode, publishedDate, bookPrice, bookQuantity, bookPublisher);
        this.bookTax= bookTax;
    }
    @Override
    public String toString() {
        return "bookCode: " + super.getBookCode() +
                ", createDate:" + super.getPublishedDate() +
                ", bookPrice: " + super.getBookPrice() +
                ", bookQuantity=" + super.getBookQuantity() +
                ", bookProduction='" + super.getBookPublisher() +
                "bookTax='" + this.bookTax + '\'' +
                '}';
    }

    public double getBookTax() {
        return bookTax;
    }

    public void setBookTax(double bookTax) {
        this.bookTax = bookTax;
    }
}
