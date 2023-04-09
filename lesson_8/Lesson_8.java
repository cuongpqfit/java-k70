import com.vtv.entity.Books;

import java.util.*;

public class Lesson_8 {
    public static void main(String[] args) {
        Integer[] a = new Integer[1000];
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        //Thêm mới
        list2.add(1);
        list2.add(1);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        System.out.println(list2);

        //Xóa
        list2.remove(4);
        System.out.println(list2);

        //Lấy kích thước của Danh sách
        System.out.println(list2.size());

        //Kiểm tra phần tử trong danh sách
        if (list2.contains(5)) {
            System.out.println("4 Tồn tại");
        } else System.out.println("Không tồn tại");


        System.out.println("Set collection!");
        Set<String> mySet = new HashSet<>();
        mySet.add("A1");
        mySet.add("A2");
        mySet.add("A3");
        System.out.println(mySet);

        System.out.println("Map collection!");
        Map<String, String> myMap = new HashMap<>();
        myMap.put("A1", "Thông tin của cuốn sách A1");
        myMap.put("A1", "Thông tin của cuốn sách A2");
        myMap.put("A2", "Thông tin của cuốn sách A2");
        myMap.put("A3", "Thông tin của cuốn sách A3");
        myMap.put("A4", "Thông tin của cuốn sách A4");

        //Lấy giá trị theo key
        System.out.println(myMap.get("A1"));
    }
}
