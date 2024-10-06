
public class Program  {
    public static void main(String[] args) {
        int number = 479598;
        int sumNumber = 0;
        while (number > 0) {
            int num = number % 10;
            number = number / 10;
            sumNumber += num;
        }
        System.out.println(sumNumber);
    }
}