import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.print("->");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String msgError = "";
        int numberOfWeeks = 1;
        int storeMinimumGrades = 0;
        while (!input.equals("42") && numberOfWeeks < 18) {
            if (input.equals("Week " + numberOfWeeks)) {
                numberOfWeeks++;
                int min = scanner.nextInt();
                for (int i = 1; i < 5; i++) {
                    int integer = scanner.nextInt();
                    if (integer < min) {
                        min = integer;
                    }
                }
                String lastNewLine = scanner.nextLine();
                // should we check for wrong input in lastNewLine ?
                if (input == "Week 1") {
                    storeMinimumGrades = min;
                } else {
                    storeMinimumGrades *= 10;
                    storeMinimumGrades += min;
                }
            } else {
                msgError = "IllegalArgument";
                break;
            }
            System.out.print("->");
            input = scanner.nextLine();
        }
        if (!msgError.equals("")) {
            System.err.println(msgError);
        } else {
            int reversedGrades = 0;
            while (storeMinimumGrades != 0) {
                int lastDigit = storeMinimumGrades % 10;
                reversedGrades = reversedGrades * 10 + lastDigit;
                storeMinimumGrades /= 10;
            }
            int i = 1;
            while (reversedGrades > 0) {
                int digit = reversedGrades % 10;
                reversedGrades /= 10;
                System.out.print("Week ");
                System.out.print(i);
                while (digit > 0) {
                    System.out.print("=");
                    digit--;
                }
                System.out.println(">");
                i++;
            }
        }
    }
}