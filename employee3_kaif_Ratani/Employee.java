
/**

 *Lab2- Employee class 

 * Student Name: Kaif Ratani

 * Student Number: 041076291

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 3

 * Professor: daniel cormier 
 
  */
import java.util.Scanner;

public class Employee {
    private double numHours, hourlyPay;
    private int employeeNumber;
    private Person emp;

    public Employee() {

    }

    public Employee(int employeeNumber, Person emp, double numHours, double hourlyPay) {

        this.employeeNumber = employeeNumber;
        this.emp = emp;
        this.hourlyPay = hourlyPay;
        this.numHours = numHours;
    }

    // getting values for user
    public void readEmpolyee(Scanner in) {

        System.out.println("\nEnter employee number: ");
        employeeNumber = in.nextInt();

        in.nextLine();

        System.out.println("Enter first name: ");
        String fName = in.nextLine();
        System.out.println("Enter last name: ");
        String lName = in.nextLine();
        System.out.println("Enter email: ");
        String email = in.nextLine();
        System.out.println("Enter phone number: ");
        long phone = in.nextLong();
        emp = new Person(fName, lName, email, phone);

        System.out.println("Enter number of hours worked: ");
        numHours = in.nextDouble();
        System.out.println("Enter hourly pay: ");
        hourlyPay = in.nextDouble();

    }

    // printing the each entry
    public void printEmpolyee() {
        System.out.printf("%10d |%15s |%25s |%10d |%10.2f |%n", employeeNumber, emp.getName(),
                emp.getEmail(),
                emp.getPhoneNumber(),
                numHours * hourlyPay);

    }

}
