
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
        public static void main(String[] args) {
            String inputFileName = "palindromeIn.txt";
            String outputFileName = "palindromeOut.txt";

            try  {
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                FileWriter writer = new FileWriter(outputFileName);

                int n = Integer.parseInt(reader.readLine());
                for (int i = 0; i < n; i++) {
                    String line = reader.readLine();
                    if (isPalindrome(line)) {
                        writer.write("1"+"\n");
                    } else {
                        writer.write("0"+"\n");
                    }
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Đường nhập link bị lỗi");
                e.printStackTrace();
            }
        }

    private static boolean isPalindrome(String str) {
        Queue<Character> queue = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        if (queue.poll() == stack.pop()) {
            return true;
        }
        else {
            return false;
        }
    }
    }

