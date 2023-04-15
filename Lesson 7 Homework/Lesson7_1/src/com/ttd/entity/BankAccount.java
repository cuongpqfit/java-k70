package com.ttd.entity;

public class BankAccount {
    private long accountNumber;
    private String accountName;
    private double accountBalance;

    public static final  double interestRate = 0.039;

    public BankAccount(){
        super();
    }

    public BankAccount(long accountNumber, String accountName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public BankAccount(long accountNumber, String accountName){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        accountBalance = 50;
    }

    public double deposit(double amount) {
        if(amount <0){
            System.out.println("Không hợp lệ, hãy nhập lại");
        }
        else {
            this.accountBalance = this.accountBalance + amount;
        }
        return this.accountBalance;
    }

    public double withdrawal (double amount){
        double fee = 0.05*amount;
        if(this.accountBalance > amount){
            this.accountBalance = this.accountBalance - (amount+ fee);
        }
        else{
            System.out.println("Không hợp lệ, hãy nhập lại");
        }
        return this.accountBalance;
    }
    public double monthlyInterest() {
        if(this.accountBalance>0){
        this.accountBalance = this.accountBalance + this.accountBalance * interestRate;
        }
        else{
            System.out.println("No Interest");
        }
        return accountBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
