import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lesson8_Sort {
    static class Book {
        String maSach;
        String info;

        public Book(String maSach, String info) {
            this.maSach = maSach;
            this.info = info;
        }

        public String getMaSach() {
            return maSach;
        }

        public void setMaSach(String maSach) {
            this.maSach = maSach;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "maSach='" + maSach + '\'' +
                    ", info='" + info + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        int[] inp = {5, -2, 10, 2, 1, 12};

        Arrays.sort(inp);
        System.out.println("Mang đã sắp xếp");
        for(int num : inp) {
            System.out.print(num + " ");
        }

        Integer[] inp2 = {5, -2, 10, 2, 1, 12};
        Arrays.sort(inp2, Collections.reverseOrder());
        System.out.println("\nMang đã sắp xếp");
        for(int num : inp2) {
            System.out.print(num + " ");
        }

        //Sắp xếp đối tượng
        System.out.println("\n");
        Book[] books = {
                new Book("A1", "Thông tin sách A1"),
                new Book("A3", "Thông tin sách A3"),
                new Book("A2", "Thông tin sách A2"),
        };
        //Sắp xếp tượng theo dữ liệu tùy biến
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getMaSach().compareTo(o2.getMaSach());
            }
        });

        for(Book num : books) {
            System.out.println(num + " ");
        }

    }
}
