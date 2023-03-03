import java.util.Scanner;

public class ConsoleMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        
        while (true) {
            System.out.println("---- MENU ----");
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("3. Option 3");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    // Code for option 1
                    System.out.println("You chose option 1.");
                    break;
                case 2:
                    // Code for option 2
                    System.out.println("You chose option 2.");
                    break;
                case 3:
                    // Code for option 3
                    System.out.println("You chose option 3.");
                    break;
                case 4:
                    // Exit program
                    System.out.println("Exiting program...");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    // Invalid input
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
