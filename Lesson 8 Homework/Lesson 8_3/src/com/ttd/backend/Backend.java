package com.ttd.backend;

import java.util.HashMap;
import java.util.Scanner;

public class Backend {
    public void findMin(int n){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Xin nhập " + n + " số nguyên:");
    HashMap<Integer, Integer> map = new HashMap<>();
    int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập số nguyên thứ " + (i + 1) + ": ");
            int element = scanner.nextInt();
            map.put(i, element);
            if (element < min) {
                min = element;
        }
    }
        System.out.println("HashMap= " + map);
        System.out.println("Giá trị nhỏ nhất: " + min);
}
}

