package com.vtv.entity;

import java.util.Date;

public class Books {
    private String bookCode;
    private Date publishedDate;
    private double bookPrice;
    private int bookQuantity;
    private String bookPublisher;

    public Books(){
        super();
    }
    public Books(String bookCode, Date publishedDate, double bookPrice, int bookQuantity, String bookProduction) {
        this.bookCode = bookCode;
        this.publishedDate = publishedDate;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.bookPublisher = bookProduction;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public double getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Book{" +
                "bookCode='" + bookCode + '\'' +
                ", createDate=" + publishedDate +
                ", bookPrice=" + bookPrice +
                ", bookQuantity=" + bookQuantity +
                ", bookProduction='" + bookPublisher + '\'' +
                '}';
    }
}
