package com.ttd.frontend;

import com.ttd.backend.Backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Backend backend = new Backend();
        System.out.println("Nhập vào phần tử n: ");
        int n = scanner.nextInt();
        backend.averageCalculation(n);
    }
}