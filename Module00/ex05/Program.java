import java.util.Scanner;

public class Program {

    public static String[] addStudent(String[] students, String student) {
        String[] newStudents = new String[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        newStudents[students.length] = student;
        return newStudents;
    }

    public static String[] getStudents(Scanner scanner) {
        String[] students = new String[1];
        String student = scanner.nextLine();
        if (!student.equals(".")){
            students[0] = student;
            student = scanner.nextLine();
        }
        while (!student.equals(".")) {
            students = addStudent(students, student);
            student = scanner.nextLine();
        }
        return students;
    }

    public static void printArray(String[] array) {
        System.out.println("-------------Students----------------");
        for(int i = 0; i < array.length; i++) {
            System.out.println("students:" + array[i]);
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
        boolean firstClass = true;
        while (!line.equals(".")) {
            char [] splitLine = line.toCharArray();
            if (splitLine.length != 4 || !(splitLine[0] >= '1' && splitLine[0] <= '6') || splitLine[1] != ' ') {
                System.err.println("ERROR1");
                System.exit(-1);
            }
            int index = check_day(days, "" + splitLine[2] + splitLine[3]);
            if (index == -1) {
                System.err.println("ERROR2");
                System.exit(-1);
            }
            if (firstClass) {
                classes[0][0] = "" + splitLine[0];
                classes[0][1] = days[index];
                firstClass = false;
            } else {
                classes = addClass(classes, "" + splitLine[0], days[index]);
            }
            line = scanner.nextLine();
        }
        return classes;
    }

    public static void printClasses(String[][] classes) {
        for (int i = 0; i < classes.length; i++) {
            System.out.println("{" + classes[i][0] + "," + classes[i][1] + "}");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] students = getStudents(scanner);
        String[] days = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
        if (students[0] == null) {
            System.err.println("No student found");
            System.exit(-1);
        }
        // printArray(students);
        String[][] classes = getClasses(days, scanner);
        printClasses(classes);

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