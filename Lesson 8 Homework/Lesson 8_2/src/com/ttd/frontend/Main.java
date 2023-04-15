package com.ttd.frontend;

import com.ttd.backend.Backend;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Backend backend = new Backend();
        System.out.println("Nhập vào phần tử số nguyên : ");
        int n = scanner.nextInt();
        backend.maxFind(n);
    }
}