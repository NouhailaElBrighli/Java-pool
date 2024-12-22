import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int numberOfWeeks = 1;
        long storeMinimumGrades = 0;
        long factor = 1;
        while (numberOfWeeks <= 18) {
            // System.out.print("->");
            input = scanner.nextLine();
            if (input.equals("42")) {
                break;
            }
            if (input.equals("Week " + numberOfWeeks)) {
                if (numberOfWeeks == 17) {
                    System.out.print("storeMinimumGrades->" + storeMinimumGrades);
                }
                numberOfWeeks++;
                long min = scanner.nextInt();
                for (int i = 1; i < 5; i++) {
                    int integer = scanner.nextInt();
                    if (integer <= 0 || integer > 9) {
                        System.err.println("IllegalArgument wrong range of grades");
                        System.exit(-1);
                    }
                    if (integer < min) {
                        min = integer;
                    }
                }
                String lastNewLine = scanner.nextLine();
                if (lastNewLine.equals("")) {
                    if (numberOfWeeks == 18) {
                        System.out.println("storeMinimumGrades--->" + storeMinimumGrades);
                    }
                    min *= factor;
                    storeMinimumGrades += min;
                    if (numberOfWeeks == 18) {
                        System.out.println("here");
                        System.out.println("storeMinimumGrades--->" + storeMinimumGrades);
                    }
                } else {
                    System.err.println("IllegalArgument too many test arguments");
                    System.exit(-1);
                }
            } else {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
             if (numberOfWeeks == 18) {
                System.out.println("factor--->" + factor);
            }
            factor *= 10;
        }
        int Weeks = 1;
        while (storeMinimumGrades > 0) {
            long digit = storeMinimumGrades % 10;
            storeMinimumGrades /= 10;
            System.out.print("Week ");
            System.out.print(Weeks + " ");
            while (digit > 0) {
                System.out.print("=");
                digit--;
            }
            System.out.println(">");
            Weeks++;
        }
        scanner.close();
    }
}