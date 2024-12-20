
import java.util.Scanner;

public class Program  {
    public static int square(int n) {
        int x = 0;
        while (x * x <= n) {
            x++;
        }
        return x - 1;
    }

    public static void main(String[] args) {
        System.out.print("-> ");
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        int steps = 1;
        if (inputNum % 2 == 0 && inputNum > 0) {
            System.out.println("false 1");
            System.exit(0);
        }
        if (inputNum <= 0 || inputNum == 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        else if (inputNum == 2) {
            System.out.println("true 1");
            System.exit(0);
        }
        for (int i = 3; i <= square(inputNum); i+= 2) {
            if (inputNum % i == 0) {
                System.out.println("false " + steps);
                System.exit(0);
            }
            steps++;
        }
        System.out.println("true " + steps);
    }
}