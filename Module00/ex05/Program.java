import java.util.Scanner;

public class Program {

    public static void print2DArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(String[] array) {
        System.out.println("-------------printArray----------------");
        for(int i = 0; i < array.length; i++) {
            System.out.println(i + "->" + array[i]);
        }
    }

    public static void printErrorAndExit(String error) {
        System.err.println(error);
        System.exit(-1);
    }

    public static String[] resizeArray(String[] oldArray, String element) {
        if (oldArray.length == 1 && oldArray[0] == null) {
            oldArray[0] = element;
            return oldArray;
        }
        String[] newArray = new String[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[oldArray.length] = element;
        return newArray;
    }

    public static int isIncludes(String[] array, String str) {
        for (int i = 0; i < array.length; i++) {
            if (str.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    public static boolean checkCharacter(char[] studentArray, char c) {
        for (int i = 0; i < studentArray.length; i++) {
            if (studentArray[i] == c) {
                return true;
            }
        }
        return false;
    }

    public static String[] getStudents(Scanner scanner) {
        String[] students = new String[1];
        String student;
        while (!(student = scanner.nextLine()).equals(".")) {
            if (student.length() > 10 || checkCharacter(student.toCharArray(), ' ')) {
                printErrorAndExit("ERROR: Maximum length of a student\'s name is 10 (no spaces)");
            }
            students = resizeArray(students, student);
        }
        return students;
    }

    public static String[] buildArrayFromLine(String line) {
        char[] lineChars = line.toCharArray();
        String word = "";
        String[] newArray = new String[1];
        for (int i = 0; i < line.length(); i++) {
            if (lineChars[i] != ' ') {
                word += lineChars[i];
            }
            if (lineChars[i] == ' ' || i == lineChars.length - 1){
                newArray = resizeArray(newArray, word);
                word = "";
            }
        }
        return newArray;
    }

    public static String[][] build2Darray(String[][] oldarray, String[] toAdd, int size) {
        if (oldarray[0][0] == null) {
            for(int i = 0; i < size; i++) {
                oldarray[0][i] = toAdd[i];
            }
            return oldarray;
        }
        String[][] newArray = new String[oldarray.length + 1][size];
        for (int i = 0; i < oldarray.length; i++) {
            for (int j = 0; j < size; j++) {
                newArray[i][j] = oldarray[i][j];
            }
        }
        for(int i = 0; i < size; i++) {
            newArray[oldarray.length][i] = toAdd[i];
        }
        return newArray;
    }

    public static String[][] getClasses(String[] days, Scanner scanner) {
        String line;
        String [][] classes =  new String[1][2];
        while (!(line = scanner.nextLine()).equals(".")) {
            if (line.equals("")) {
                printErrorAndExit("invalid input");
            }
            String[] lesson = buildArrayFromLine(line);
            char c = lesson[0].toCharArray()[0];
            if (lesson.length != 2 || lesson[0] == null || lesson[0].length() != 1 ||  !(c >= '1' && c <= '6') || isIncludes(days, lesson[1]) == -1) {
                printErrorAndExit("invalid input");
            }
            classes = build2Darray(classes, lesson, 2);
        }
        return classes;
    }

    public static String[][] getVisits(Scanner scanner, String[] students, String[] days, String[][] classes) {
        String line;
        String[] status = { "HERE", "NOT_HERE"};
        String[][] visits = new String[1][4];
        while(!(line = scanner.nextLine()).equals(".")) {
            String[] visit = buildArrayFromLine(line);
            if (visit.length != 4 || isIncludes(students, visit[0]) == -1 || isIncludes(status, visit[3]) == -1) {
                printErrorAndExit("ERROR: invalid input");
            }
            visits = build2Darray(visits, visit, 4);
        }
        return visits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] students = getStudents(scanner);
        String[] days = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
        if (students[0] == null) {
            printErrorAndExit("ERROR: invalid students input");
        }
        printArray(students);
        String[][] classes = getClasses(days, scanner);
        if (classes[0][0] == null) { // maybe it's valid
            printErrorAndExit("ERROR: invalid classes input");
        }
        print2DArray(classes);
        String[][] visits = getVisits(scanner, students, days, classes);
        print2DArray(visits);


    }
}





// $> java Program
// -> John
// -> Mike
// -> .
// -> 2 MO
// -> 4 WE 
// -> .
// -> Mike 2 28 NOT_HERE
// -> John 4 9 HERE
// -> Mike 4 9 HERE
// -> .
// 4:00 WE 2| 2:00 MO 7|4:00 WE 9|2:00 MO 14|4:00 WE 16|2:00 MO 21|4:00 WE 23|2:00 MO 28|2:00 MO 30|
// John     |          |        1|          |          |          |          |          |          |
// Mike     |          |        1|          |          |          |          |        -1|          |
// $>



// MO, TU, WE, TH, FR, SA, SU

// name of students

// (time + day) class 

// student + time + day + status


// 4:00 WE 2|
// John     |
// Mike     |

// Student's name: "%10s"
// Lesson: "%1d:00%3s%3d|"
//          Visit: "%10d|"

// 2:00 MO 7|4:00 MO 7|