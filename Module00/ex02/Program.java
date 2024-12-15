import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("-> ");
        int inputNum = scanner.nextInt();
        int sumOfPrimes = 0;
        while (inputNum != 42) {
            boolean isPrime = true;
            int sumNumber = 0;
            if (inputNum < 0) {
                inputNum = -inputNum;
            }
            while (inputNum > 0) {
                int num = inputNum % 10;
                inputNum = inputNum / 10;
                sumNumber += num;
            }
            if (sumNumber <= 0 || sumNumber == 1 || sumNumber % 2 == 0) {
                isPrime = false;
            } else {
                for (int i = 3; i <= sumNumber / 2; i+= 2) {
                    if (sumNumber % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) {
                    sumOfPrimes += 1;
                }  
            }
            System.out.print("-> ");
            inputNum = scanner.nextInt();
        }
        System.out.println("Count of coffee-request : " + sumOfPrimes);
    }
}