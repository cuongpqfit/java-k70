package com.ttd.entity;

import java.util.Date;

public class Trade {
    private String tradeCode;
    private Date tradeDate;
    private double tradeUnit;
    private double tradeQuantity;

    public Trade(String tradeCode, Date tradeDate, double tradeUnit, double tradeQuantity) {
        this.tradeCode = tradeCode;
        this.tradeDate = tradeDate;
        this.tradeUnit = tradeUnit;
        this.tradeQuantity = tradeQuantity;
    }

    public Trade() {
        super();
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public double getTradeUnit() {
        return tradeUnit;
    }

    public void setTradeUnit(double tradeUnit) {
        this.tradeUnit = tradeUnit;
    }

    public double getTradeQuantity() {
        return tradeQuantity;
    }

    public void setTradeQuantity(double tradeQuantity) {
        this.tradeQuantity = tradeQuantity;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeCode='" + tradeCode + '\'' +
                ", tradeDate=" + tradeDate +
                ", tradeUnit=" + tradeUnit +
                ", tradeQuantity=" + tradeQuantity +
                '}';
    }
}
