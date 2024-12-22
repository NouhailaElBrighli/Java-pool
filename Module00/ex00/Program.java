
public class Program  {
    public static void main(String[] args) {
        int number = 198131;
        int sumNumber = 0;
        if (number < 0) {
            number = -number;
        }
        while (number > 0) {
            int num = number % 10;
            number = number / 10;
            sumNumber += num;
        }
        System.out.println(sumNumber);
    }
}