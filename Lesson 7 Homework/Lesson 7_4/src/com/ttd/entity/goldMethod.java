package com.ttd.entity;

import java.util.Date;

public class goldMethod extends Trade{
    private String goldType;

    public goldMethod(){
        super();
    }

    public goldMethod(String tradeCode, Date tradeDate, double tradeUnit, double tradeQuantity, String goldType ) {
        super(tradeCode, tradeDate, tradeUnit, tradeQuantity);
        this.goldType = goldType;
    }

    public String getGoldType() {
        return goldType;
    }

    public void setGoldType(String goldType) {
        this.goldType = goldType;
    }

    @Override
    public String toString() {
        return "goldMethod{" +
                "tradeCode='" + super.getTradeCode() + '\'' +
                ", tradeDate=" + super.getTradeDate() +
                ", tradeUnit=" + super.getTradeUnit() +
                ", tradeQuantity=" + super.getTradeQuantity() +
                ", goldType='" + this.goldType + '\'' +
                '}';
    }
}
