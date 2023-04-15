package com.ttd.backend;


import com.ttd.entity.BankAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class accountBackend {
    private ArrayList<BankAccount> bankAccountArrayList;
    private Scanner scanner;

    public accountBackend(){
        bankAccountArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void accountInformation(){

        // create a bank account for user
        System.out.println("Mời bạn nhập vào thông tin cần nhập:");
        System.out.println("Mời bạn nhập số tài khoản:");
        long accountNumber = scanner.nextLong();


        System.out.println("Mời bạn nhập tên tài khoản:");
        String accountName = scanner.next();


        System.out.println("Mời bạn nhập tiền trong tài khoản:");
        double accountBalance = scanner.nextDouble();

        BankAccount bankAccount = new BankAccount(accountNumber,accountName,accountBalance);
        bankAccountArrayList.add(bankAccount);

    }

    public void printBankAccountInformation(){
        System.out.println("Hiển thị thông tin tài khoản");
        for(BankAccount account:bankAccountArrayList){
            System.out.println(account.toString());
        }
    }
    public void depositAmount(){
        System.out.println("Mời bạn nhập tên tài khoản:");
        String nameSearch = scanner.next();
        System.out.println("Mời bạn nhập tiền vào tài khoản:");
        double amount = scanner.nextDouble();


        for(BankAccount bankAccount:bankAccountArrayList){
            if(bankAccount.getAccountName().equals(nameSearch)) {
                bankAccount.deposit(amount);
                System.out.println("Số tiền trong tài khoản là: " + bankAccount.getAccountBalance());
            }
            else{
                System.out.println("Tài khoản không tồn tại");
            }
        }

    }
    public void withdrawAmount(){
        System.out.println("Mời bạn nhập tên tài khoản:");
        String nameSearch = scanner.next();
        System.out.println("Mời bạn nhập tiền muốn rút vào tài khoản:");
        double amount = scanner.nextDouble();


        for(BankAccount bankAccount:bankAccountArrayList){
            if(bankAccount.getAccountName().equals(nameSearch)) {
                bankAccount.withdrawal(amount);
                System.out.println("Số tiền trong tài khoản là: " + bankAccount.getAccountBalance());
            }
            else{
                System.out.println("Tài khoản không tồn tại");
            }
        }

    }
    public void monthInterestAmount(){
        System.out.println("Mời bạn nhập tên tài khoản:");
        String nameSearch = scanner.next();


        for(BankAccount bankAccount:bankAccountArrayList){
            if(bankAccount.getAccountName().equals(nameSearch)) {
                bankAccount.monthlyInterest();
                System.out.println("Số tiền trong tài khoản là: " + bankAccount.getAccountBalance());
            }
            else{
                System.out.println("Tài khoản không tồn tại");
            }
        }

    }

    public void transferMoney(){
        System.out.println("Mời bạn nhập tên tài khoản muốn rút tiền:");
        String account1 = scanner.next();
        System.out.println("Mời bạn nhập tiền muốn rút từ tài khoản:");
        double amount = scanner.nextDouble();
        double withdrawAmount=0;
        double depositAmount =0;

        System.out.println("Mời bạn nhập tên tài khoản muốn nhận tiền:");
        String account2 = scanner.next();

        for(BankAccount bankAccount:bankAccountArrayList){
            if(bankAccount.getAccountName().equals(account1)) {
                withdrawAmount = bankAccount.getAccountBalance()-amount;
                bankAccount.setAccountBalance(withdrawAmount);
                System.out.println("Số tiền trong tài khoản " + bankAccount.getAccountName() +  " là: " + bankAccount.getAccountBalance());
            }
        }
        for(BankAccount bankAccount:bankAccountArrayList){
            if(bankAccount.getAccountName().equals(account2)) {
                depositAmount = bankAccount.getAccountBalance()+amount;
                bankAccount.setAccountBalance(depositAmount);
                System.out.println("Số tiền trong tài khoản " + bankAccount.getAccountName() +  " là: " + bankAccount.getAccountBalance());
            }
        }

    }
}


