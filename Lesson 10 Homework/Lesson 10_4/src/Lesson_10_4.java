import java.util.*;

public class Lesson_10_4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Xin nhập vào chuỗi ngoặc:");
        String S= scanner.next();
        Deque<String> stack = new ArrayDeque<String>();
        List<String> list = new ArrayList<String>();
        boolean isTrue = true;




        for(int i=0;i<S.length();i++){
            if(S.charAt(0)==')'){
                isTrue=false;
                break;
            }
            if(S.charAt(i)=='('){
                int n = Integer.parseInt(S.valueOf(i))+1;
                stack.push(S.valueOf(n));
            }
            if(S.charAt(i)==')'){
                if(!stack.isEmpty()) {
                    int m = Integer.parseInt(S.valueOf(i)) + 1;
                    list.add((stack.pop()) + " " + m);
                }
                else{
                    isTrue=false;
                }
            }
        }
        Collections.sort(list);

        if(isTrue){
            for(String i:list)
            System.out.println(i);
        }
        else{
            System.out.println("chuỗi ngoặc nhập đã sai");
        }

    }
}
