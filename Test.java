import java.util.Scanner;

public class Test {
    // public static void printMessage() {
    //     System.out.println("static");
    // }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a full line of text:");
        String line = scanner.nextLine();
        
        Scanner lineScanner = new Scanner(line);

        System.out.println("Words in the line:");
        while (lineScanner.hasNext()) {
            String word = lineScanner.next();
            System.out.println(word);
        }

        lineScanner.close();
        scanner.close();
    }
}

// 

// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42
//     36
//     # 35
//     # #
//     # # 27
//     # # #
//     # # #
//     # # #
//     # # # 14 12
//     # # # # # 9
//     # # # # # # 7 4
//     # # # # # # # # 2 2
//     D A S W L K O T E R
//     $> 