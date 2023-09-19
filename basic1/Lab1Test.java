/**

 *Lab1-main method

 * Student Name: Kaif Ratani

 * Student Number: 041076291

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor: daniel cormier 
 
  */
import java.util.Scanner;

public class Lab1Test {
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);//scanner object
		System.out.println("Enter the value : ");//user message
		int me = user.nextInt();//getting user input
		user.nextLine();
		
		Lab1 l = new Lab1();//object for lab1 class
		l.generateAllValues(me);//passing the value to generateAllValues
	}
}
