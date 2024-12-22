
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
        if (inputNum <= 0 || inputNum == 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        for (int i = 2; i <= square(inputNum); i++) {
            if (inputNum % i == 0) {
                System.out.println("false " + steps);
                System.exit(0);
            }
            steps++;
        }
        System.out.println("true " + steps);
    }
}