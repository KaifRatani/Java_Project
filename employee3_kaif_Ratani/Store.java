
/**

 *Lab2- Store class 

 * Student Name: Kaif Ratani

 * Student Number: 041076291

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 3

 * Professor: daniel cormier 
 
  */
import java.util.Scanner;

public class Store {
    private Employee[] employees;

    public Store(int size) {
        employees = new Employee[size];
    }

    public void readEmpolyeeDetails(Scanner in) {
        // employee array
        for (int count = 0; count < employees.length; count++) {

            System.out.printf("\nEnter Details for Empolyee %d", (count + 1));
            employees[count] = new Employee();
            employees[count].readEmpolyee(in);
        }
    }

    public void printEmpolyeeDetails(String storename) {
        // format for print message
        printTitle(storename);
        System.out.printf("%10s |%15s |%25s |%10s |%10s |\n", "Emp#", "Name", "Email", "Phone", "Salary");
        printLine();
        // print for the array
        for (Employee employee : employees) {
            employee.printEmpolyee();
        }

    }

    // line method
    public static void printLine() {
        System.out.println("================================================================================");

    }

    // header method
    public static void printTitle(String storeName) {
        printLine();
        System.out.println("\t Employee Deatails for " + storeName);
        printLine();
    }

}
