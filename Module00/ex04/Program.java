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
        int newArray[][] = new int[original.length + 1][2];
        for (int i = 0; i < original.length; i++) {
            newArray[i] = original[i];
        }
        newArray[original.length][0] = ch;
        newArray[original.length][1] = 1;
        return newArray;
    }

    public static void SortArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i][1] < array[j][1]) {
                    int [] temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void PrintArray(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("{" + (char)array[i][0] + "," + array[i][1] + "}");
        }
    }

    public static void printSecondArray(int [][]array) {
        for(int i  = 0; i < array.length; i++) {
            System.out.println("{" + (char )array[i][0] + "," + array[i][1] + ',' + array[i][2] + '}');
        }
    }

    public static void FillNewArray(int [][]oldArray, int[][] newArray, int max) {
        for (int i = 0; i < oldArray.length; i++) {
            int numberOfHash = ( oldArray[i][1] * 10 ) / max;
            newArray[i][0] = oldArray[i][0];
            newArray[i][1] = oldArray[i][1];
            newArray[i][2] = numberOfHash;
        }
    }

    public static void DispalyChart(int [][]array) {
        String lastLine = "";
        for(int i = 0; i < array.length; i++) {
            lastLine += (char) array[i][0];
        }
        System.out.println(lastLine);
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char [] line = s.toCharArray();
        int initialSize = 1;
        int[][] stock = new int[1][2];
        stock[0][0] = line[0];
        stock[0][1] = 1;
        for (int i = 1; i < line.length; i++) {
            stock = addRowOrIncrement(stock, line[i]);
        }
        SortArray(stock);
        // PrintArray(stock);
        int [][] newArray = new int[stock.length][3];
        FillNewArray(stock, newArray,stock[0][1]);
        printSecondArray(newArray);
        DispalyChart(newArray);
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


