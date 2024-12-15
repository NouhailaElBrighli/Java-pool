
import java.util.Scanner;

public class Program  {
    public static void main(String[] args) {
        System.out.print("-> ");
        Scanner scanner = new Scanner(System.in);
        try { // maybe we should not use try-catch
            int inputNum = scanner.nextInt();
            int steps = 1;
            String msg = ""; // don't use non-primitive types
            if (inputNum <= 0 || inputNum == 1 || inputNum % 2 == 0) {
                if (inputNum <= 0 || inputNum == 1) {
                    msg = "IllegalArgument";
                }
                else if (inputNum == 2) {
                    msg = "true 1";
                }
                else {
                    msg = "false 1";
                }
            } else {
                for (int i = 3; i <= inputNum / 2; i+= 2) {
                    if (inputNum % i == 0) {
                        msg = "false " + steps;
                        break;
                    }
                    steps++;
                }
            }
            if (msg.isEmpty()) {
                msg = "true " + steps;
            }
            System.out.println(msg);
        } catch (Exception e) {
            System.err.println("IllegalArgument");
        }
    }
}