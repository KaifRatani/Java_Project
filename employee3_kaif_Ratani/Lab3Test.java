
/**

 *Lab2- main method 

 * Student Name: Kaif Ratani

 * Student Number: 041076291

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 3

 * Professor: daniel cormier 
 
  */

import java.util.Scanner;

public class Lab3Test {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in); // scannner object
        System.out.println("Enter name of the store: ");
        String storeName = in.nextLine(); // input value for storename
        System.out.println("How many employees do you have? ");
        int empnum = in.nextInt(); // input value for number of employee
        in.nextLine();

        Store store = new Store(empnum); // store object with parameter
        store.readEmpolyeeDetails(in); // calling employee method
        store.printEmpolyeeDetails(storeName); // printing all values

        in.close(); // closing scanner

    }
}
