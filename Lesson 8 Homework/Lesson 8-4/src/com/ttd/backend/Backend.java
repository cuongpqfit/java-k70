package com.ttd.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Backend {
    public void ReverseOrder(int n){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập vào số nguyên thứ " + (i + 1) + ": ");
            int element = scanner.nextInt();
            list.add(element);
        }
        Collections.reverse(list);
        System.out.println("Mảng đảo ngược " + list);
    }

}
