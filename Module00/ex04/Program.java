import java.util.Scanner;

public class Program {
    public static int[][] addRowOrIncrement(int[][] original, char ch) {
        for (int i = 0; i < original.length; i++) {
            int ch1 = (char) original[i][0];
            if (ch1 == ch) {
                original[i][1]++;
                return original;
            }
        }
        int newArray[][] = new int[original.length + 1][3];
        for (int i = 0; i < original.length; i++) {
            newArray[i] = original[i];
        }
        newArray[original.length][0] = ch;
        newArray[original.length][1] = 1;
        newArray[original.length][2] = 0;
        return newArray;
    }

    public static void SortArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ( array[i][1] < array[j][1] || ( (array[i][1] ==  array[j][1]) &&  (array[i][0] > array[j][0])) ) {
                    int [] temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void PrintArray(int[][] array) {
        for(int i  = 0; i < array.length; i++) {
            System.out.println("{" + (char )array[i][0] + "," + array[i][1] + ',' + array[i][2] + '}');
        }
    }

    public static int[][] FillAndResizeArray(int [][]array, int max) {
        int size = array.length < 10 ? array.length : 10;
        int [][] newArray = new int[size][3];
        for (int i = 0; i < size; i++) {
            int numberOfHash = ( array[i][1] * 10 ) / max;
            newArray[i][0] = array[i][0];
            newArray[i][1] = array[i][1];
            newArray[i][2] = numberOfHash;
        }
        return newArray;
    }

    public static void DispalyChart(int [][]array) {
        String chart = "";
        String lastLine = " ";
        while (array[0][2] != -1) {
            String line = "";
            for (int i = 0; i < array.length; i++) {
                if (array[i][2] == 0) {
                    line += " " + array[i][1];
                    array[i][2]--;
                } else if (array[i][2] > 0) {
                    line += " #";
                    array[i][2]--;
                }
            }
            chart = line + '\n' + chart;
        }

        for (int i = 0; i < array.length; i++) {
            lastLine += (char) array[i][0] + " ";
        }
        chart += lastLine;
        System.out.println(chart);
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equals("")) {
            System.exit(1);
        }
        char [] line = s.toCharArray();
        int initialSize = 1;
        int[][] stock = new int[1][3];
        stock[0][0] = line[0];
        stock[0][1] = 1;
        stock[0][2] = 0;
        for (int i = 1; i < line.length; i++) {
            stock = addRowOrIncrement(stock, line[i]);
        }
        SortArray(stock);
        stock = FillAndResizeArray(stock, stock[0][1]);
        DispalyChart(stock);
    }
}
// output in console:
/* 
// 36 -> 10
// 4 ->
-> AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42
    36
    # 35
    # #
    # # 27
    # # #
    # # #
    # # #
    # # # 14 12
    # # # # # 9
    # # # # # # 7 4
    # # # # # # # # 2 2
    D A S W L K O T E R
    $> 
*/


