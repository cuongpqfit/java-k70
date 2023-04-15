package com.ttd.backend;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Backend {
    public void maxFind(int n){
        Scanner scanner = new Scanner(System.in);
        int sum =0;
        int average =0;


        LinkedList<Integer> linkedList = new LinkedList<Integer>();

            System.out.println("Xin nhập " + n + " số nguyên:");
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập số nguyên thứ " + (i + 1) + ": ");
                int element = scanner.nextInt();
                if (element > 0) {
                    linkedList.add(element);
                } else {
                    System.out.println("Xin nhập lai số nguyên thứ " + (i + 1) + ": ");
                    i--;

                }
            }
            System.out.println("linkedList=" + linkedList);
            int max = linkedList.getFirst();
            for (int x : linkedList) {
                if (x > max) {
                    max = x;
                }
            }
            System.out.println("Giá trị max là: " + max);
        }
    }

