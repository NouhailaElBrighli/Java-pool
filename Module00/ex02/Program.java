import java.util.Scanner;

public class Program {

    public static int sum(int n) {
        int sumNumber = 0;
        int sign = 1;
        if (n < 0) {
            n = n * -1;
            sign = -1;
        }
        while (n > 0) {
            int num = n % 10;
            n = n / 10;
            sumNumber += num;
        }

        return sign * sumNumber;
    }

    public static int square(int n) {
        int x = 0;
        while (x * x <= n) {
            x++;
        }
        return x - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumOfPrimes = 0;
        int inputNum = 0;
        while (inputNum != 42) {
            inputNum = scanner.nextInt();
            boolean isPrime = true;
            int sumNumbe = sum(inputNum);
            if (inputNum <= 1) {
                continue;
            }
            for (int i = 2; i <= square(sumNumber); i++) {
                if (sumNumber % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                sumOfPrimes += 1;
            }
        }
        scanner.close();
        System.out.println("Count of coffee-request : " + sumOfPrimes);
    }
}