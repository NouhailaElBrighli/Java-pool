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
        for(int i = 0; i < array.length; i++) {
            System.out.println("students:" + array[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] students = getStudents(scanner);
        if (students[0] == null) {
            System.err.println("No student found");
            System.exit(-1);
        }
        printArray(students);
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