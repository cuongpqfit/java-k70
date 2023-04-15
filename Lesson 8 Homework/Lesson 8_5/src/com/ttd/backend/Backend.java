package com.ttd.backend;

import java.util.HashSet;
import java.util.Scanner;

public class Backend {
    public void printAlphabet(int n){
        Scanner scanner = new Scanner(System.in);

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập vào số nguyên thứ " + (i + 1) + ": ");
            int element = scanner.nextInt();
            if (element >= 0 && element <= 9) {
                set.add(element);
            } else {
                System.out.println("Giá trị nhập ko hợp lệ.Xin nhập lại giá trị từ 0 đến 9");
                i--;
            }
        }
        String[] words = {"Không", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín"};
        for (int i = 0; i < words.length; i++) {
            if (set.contains(i)) {
                System.out.println(i + " --> "+ words[i]);
            }
        }
    }
}
