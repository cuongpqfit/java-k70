package com.ttd.backend;

import com.ttd.entity.Food;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FoodBackend {
    private ArrayList<Food> foodArrayList;
    private Scanner scanner;

    public FoodBackend() {
        foodArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void addFoodInformation() throws ParseException {
        System.out.println("--------------------------------");
        System.out.println("Mời bạn nhập thông tin sản phẩm");
        System.out.println("Mời bạn nhập mã sản phẩm");
        String foodCode = scanner.next();

        System.out.println("Mời bạn nhập tên sản phẩm");
        String foodName = scanner.next();

        System.out.println("Mời bạn nhập giá sản phẩm");
        double foodPrice = scanner.nextDouble();

        System.out.println("Mời bạn nhập ngày sản xuất của sản phẩm");
        String dateFormatp = "dd/MM/yyyy";
        Date producedDate =new SimpleDateFormat(dateFormatp).parse(scanner.next());

        System.out.println("Mời bạn nhập ngày hết hạn của sản phẩm");
        String dateFormate = "dd/MM/yyyy";
        Date expiredDate =new SimpleDateFormat(dateFormate).parse(scanner.next());

        Food food = new Food(foodCode,foodName,foodPrice,producedDate,expiredDate);
        foodArrayList.add(food);
    }
    public void printFoodInformation(){
        System.out.println("Hiển thị thông tin sản phẩm");

        for(Food food:foodArrayList){
            System.out.println(food.toString());
        }
    }

    public void foodDateCheck(){
        System.out.println("Mời bạn nhập mã sản phẩm");
        String foodCode = scanner.next();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        System.out.println(date);
        int datediff=0;

        for(Food food:foodArrayList){
            if(food.getFoodCode().equals(foodCode)){
                datediff=food.getExpiredDate().compareTo(date);
                System.out.println(datediff);
            }
        }

        if(datediff>0){
            System.out.println("Sản phẩm còn hạn sử dụng");
        }
        else if (datediff==0){
            System.out.println("Hôm nay là ngày cuối cùng sử dụng sản phầm");
        }
        else{
            System.out.println("Sản phẩm đã hết hạn sử dụng");
        }
    }


}
