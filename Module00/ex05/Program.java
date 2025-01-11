import java.util.Scanner;

public class Program {

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
        String student = scanner.nextLine();
        while (!student.equals(".")) {
            char [] studentArray = student.toCharArray();
            if (studentArray.length > 10 || checkCharacter(studentArray, ' ')) {
                printErrorAndExit("ERROR: Maximum length of a student\'s name is 10 (no spaces)");
            }
            students = resizeArray(students, student);
            student = scanner.nextLine();
        }
        return students;
    }

    public static void printArray(String[] array) {
        System.out.println("-------------printArray----------------");
        for(int i = 0; i < array.length; i++) {
            System.out.println(i + "->" + array[i]);
        }
    }

    public static int check_day(String[] days, String day) {
        for (int i = 0; i < days.length; i++) {
            if (day.equals(days[i])){
                return i;
            }
        }
        return -1;
    }

    public static String[][] addClass(String[][] classes, String time, String day) {
        if (classes.length == 1 && classes[0][0] == null) {
            classes[0][0] = time;
            classes[0][1] = day;
            return classes;
        }
        String[][] newClass = new String[classes.length + 1][2];
        for(int i = 0; i < classes.length; i++) {
            newClass[i] = classes[i];
        }
        newClass[classes.length][0] = time;
        newClass[classes.length][1] = day;
        return newClass;
    }

    public static String[][] getClasses(String[] days, Scanner scanner) {
        String line = scanner.nextLine();
        String [][] classes = new String[1][2];
        while (!line.equals(".")) {
            char [] splitLine = line.toCharArray();
            if (splitLine.length != 4 || !(splitLine[0] >= '1' && splitLine[0] <= '6') || splitLine[1] != ' ') {
                printErrorAndExit("invalid input");
            }
            int index = check_day(days, "" + splitLine[2] + splitLine[3]);
            if (index == -1) {
                printErrorAndExit("invalid input");
            }
            classes = addClass(classes, "" + splitLine[0], days[index]);
            line = scanner.nextLine();
        }
        return classes;
    }

    public static void printClasses(String[][] classes) {
        for (int i = 0; i < classes.length; i++) {
            System.out.println("{" + classes[i][0] + "," + classes[i][1] + "}");
        }
    }

    public static String[] buildVisitArray(String line) {
        char[] lineChars = line.toCharArray();
        String word = "";
        String[] visits = new String[1];
        for (int i = 0; i < lineChars.length; i++) {
            if (lineChars[i] != ' ') {
                word += lineChars[i];
            } else {
                visits = resizeArray(visits, word);
                word = "";
            }
        }
        return visits;
    }

    public static void getVisits(Scanner scanner, String[] students, String[] days, String[][] classes) {
        String line = scanner.nextLine();
        String[] visits = buildVisitArray(line);
        printArray(visits);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] students = getStudents(scanner);
        String[] days = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
        if (students[0] == null) {
            printErrorAndExit("ERROR: invalid students input");
        }
        // printArray(students);
        String[][] classes = getClasses(days, scanner);
        if (classes[0][0] == null) { // maybe it's valid
            printErrorAndExit("ERROR: invalid classes input");
        }
        getVisits(scanner, students, days, classes);
        // printClasses(classes);


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