package com.ttd.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backend {
    public void averageCalculation(int n){
        Scanner scanner = new Scanner(System.in);
        int sum =0;
        int average =0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("Xin nhập " + n + " số nguyên:");
        for (int i=0;i<n;i++) {
            System.out.print("Nhập số nguyên thứ " + (i + 1) + ": ");
            arrayList.add(scanner.nextInt());
        }
        System.out.println("arrayList=" +arrayList);
        for(int x:arrayList){
            sum+=x;
        }
        average = sum/n;
        System.out.println("Giá trị trung bình của mảng arrayList = " + average);
    }
}
