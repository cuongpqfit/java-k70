package com.ttd.entity;

import java.util.Date;

public class cashMethod extends Trade {

    private double exchangeRate;
    private MoneyType moneyType;

    public cashMethod() {
        super();
    }

    public cashMethod(String tradeCode, Date tradeDate, double tradeUnit, double tradeQuantity, double exchangeRate, MoneyType moneyType) {
        super(tradeCode, tradeDate, tradeUnit, tradeQuantity);
        this.exchangeRate = exchangeRate;
        this.moneyType = moneyType;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public MoneyType getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(MoneyType moneyType) {
        this.moneyType = moneyType;
    }

    @Override
    public String toString() {
        return "cashMethod{" +
                "tradeCode='" + super.getTradeCode() + '\'' +
                ", tradeDate=" + super.getTradeDate() +
                ", tradeUnit=" + super.getTradeUnit() +
                ", tradeQuantity=" + super.getTradeQuantity() +
                ", exchangRate='" + this.exchangeRate + '\'' +
                ", moneyType='" + this.moneyType + '\'' +
                '}';
    }

    public double cashTypeCalculation(MoneyType moneyType) {
        double finalPrice;
        String cashType = String.valueOf(this.moneyType);
        if (cashType == "VND") {
            finalPrice = this.getTradeUnit() * this.getTradeQuantity() * this.getExchangeRate();
        } else {
            finalPrice = this.getTradeUnit() * this.getTradeQuantity();
        }
        return finalPrice;
    }

}

