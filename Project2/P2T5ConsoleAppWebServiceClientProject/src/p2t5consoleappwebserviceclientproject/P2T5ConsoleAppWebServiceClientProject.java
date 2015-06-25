/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2t5consoleappwebserviceclientproject;

import edu.cmu.andrew.kmakaew.Studenttable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Karinya
 */
public class P2T5ConsoleAppWebServiceClientProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Please enter operation number:");
        System.out.println("1) Create student record");
        System.out.println("2) Read student record");
        System.out.println("3) Update student record");
        System.out.println("4) Delete student record");

        Scanner keyboard = new Scanner(System.in);
        int operationNum = keyboard.nextInt();
        switch (operationNum) {
            case 1:
                create();
                break;
            case 2:
                read();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
        }
    }

    /**
     * get input from user and create student record to database
     *
     */
    private static void create() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter student ID:");
        Short studentID = keyboard.nextShort();
        keyboard.nextLine();
        System.out.println("Please enter student name:");
        String studentName = keyboard.nextLine();

        System.out.println("Please enter scholarship amount:");
        Double scholarship = keyboard.nextDouble();

        if (createStudent(studentID, studentName, scholarship)) {
            System.out.println("(" + studentID + ", " + studentName + ", " + scholarship + ") is created");
        } else {
            System.out.println("Fail to create record.");
        }
    }

    /**
     * get input from user and read student record to database
     *
     */
    private static void read() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter student ID:");
        Short studentID = keyboard.nextShort();

        Studenttable student = readStudent(studentID);
        if (student != null) {
            System.out.println("Student ID: " + student.getStudentId()
                    + "\nName: " + student.getStudentName()
                    + "\nScholarship Amount: " + student.getScholarshipAmount());
        } else {
            System.out.println("Fail to read record.");
        }
    }

    /**
     * get input from user and update student record to database
     *
     */
    private static void update() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter student ID:");
        Short studentID = keyboard.nextShort();
        keyboard.nextLine();

        System.out.println("Please enter name:");
        String studentName = keyboard.nextLine();

        System.out.println("Please enter scholarship amount:");
        Double studentScholarship = keyboard.nextDouble();

        if (updateStudent(studentID, studentName, studentScholarship)) {
            System.out.println("Student ID " + studentID + "is updated to ("
                    + studentID + ", " + studentName + ", " + studentScholarship + ")");
        } else {
            System.out.println("Fail to update record.");
        }
    }

    /**
     * get input from user and delete student record to database
     *
     */
    private static void delete() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter student ID:");
        Short studentID = keyboard.nextShort();
        if (deleteStudent(studentID)) {
            System.out.println("Student ID " + studentID + " is deleted");
        } else {
            System.out.println("Fail to delete record.");
        }
    }

    private static boolean createStudent(java.lang.Short arg0, java.lang.String arg1, java.lang.Double arg2) {
        edu.cmu.andrew.kmakaew.StudentListService_Service service = new edu.cmu.andrew.kmakaew.StudentListService_Service();
        edu.cmu.andrew.kmakaew.StudentListService port = service.getStudentListServicePort();
        return port.createStudent(arg0, arg1, arg2);
    }

    private static boolean deleteStudent(java.lang.Short arg0) {
        edu.cmu.andrew.kmakaew.StudentListService_Service service = new edu.cmu.andrew.kmakaew.StudentListService_Service();
        edu.cmu.andrew.kmakaew.StudentListService port = service.getStudentListServicePort();
        return port.deleteStudent(arg0);
    }

    private static java.util.List<java.lang.Object> findAllStudentNames() {
        edu.cmu.andrew.kmakaew.StudentListService_Service service = new edu.cmu.andrew.kmakaew.StudentListService_Service();
        edu.cmu.andrew.kmakaew.StudentListService port = service.getStudentListServicePort();
        return port.findAllStudentNames();
    }

    private static Studenttable readStudent(java.lang.Short arg0) {
        edu.cmu.andrew.kmakaew.StudentListService_Service service = new edu.cmu.andrew.kmakaew.StudentListService_Service();
        edu.cmu.andrew.kmakaew.StudentListService port = service.getStudentListServicePort();
        return port.readStudent(arg0);
    }

    private static boolean updateStudent(java.lang.Short arg0, java.lang.String arg1, java.lang.Double arg2) {
        edu.cmu.andrew.kmakaew.StudentListService_Service service = new edu.cmu.andrew.kmakaew.StudentListService_Service();
        edu.cmu.andrew.kmakaew.StudentListService port = service.getStudentListServicePort();
        return port.updateStudent(arg0, arg1, arg2);
    }
}
