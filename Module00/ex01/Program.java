
import java.util.Scanner;

public class Program  {
    public static void main(String[] args) {
        System.out.print("-> ");
        Scanner scanner = new Scanner(System.in);
        try {
            int inputNum = scanner.nextInt();
            int steps = 0;
            boolean found = true;
            if (inputNum <= 0 || inputNum == 1) {
                System.err.println("IllegalArgument");
                return;
            }
            for (int i = 3; i <= Math.sqrt(inputNum); i++) {
                steps++;
                if (inputNum % i == 0) {
                    found = false;
                    break;
                }
            }
            System.out.println(found + " " + steps);
        } catch (Exception e) {
            System.err.println("wrong number");
        }
    
        
    }
}