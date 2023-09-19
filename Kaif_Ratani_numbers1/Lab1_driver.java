/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Kaif Ratani 
 * Student Number: 041076291      
 * Section #: 312  
 * Course: CST8130 - Data Structures
 * Professor: George Kriger. 
 * 
 */
package primary;

import java.util.Scanner;

public class Lab1_driver {
    /**
     * The main method of the program, where user interactions take place.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Numbers numbers = null; // Declare a Numbers object to store values
        Scanner in = new Scanner(System.in); // Create a Scanner for user input

        while (true) { // Infinite loop to display the menu until the user chooses to exit
            displayMainMenu(); // Display the main menu options
            System.out.print("> "); // Prompt the user for input
            if (in.hasNextInt()) { // Check if the input is an integer

                int choice = in.nextInt(); // Read the user's choice as an integer

                switch (choice) {
                    case 1:
                        numbers = new Numbers(); // Initialize a default Numbers object
                        System.out.println("Default array initialized.");
                        break;
                    case 2:
                        System.out.print("Enter new size of array : ");
                        int len = in.nextInt(); // Read the max size as an integer
                        numbers = new Numbers(len); // Initialize a Numbers object with the specified max size
                        break;
                    case 3:
                        if (numbers != null) {
                            System.out.print("Add Value : ");
                            numbers.addValue(in.nextFloat()); // Add the value to the Numbers object
                        } else {
                            System.out.println("Please initialize first.");
                        }
                        break;
                    case 4:
                        if (numbers != null) {
                            System.out.println("Number are : \n" + numbers.toString()); // Display the values in the
                                                                                        // Numbers object
                        } else {
                            System.out.println("Please initialize first.");
                        }
                        break;
                    case 5:
                        if (numbers != null) {
                            System.out.println("Average: " + String.format("%.2f", numbers.calcAverage())); // Calculate
                                                                                                            // and
                                                                                                            // display
                                                                                                            // average
                            System.out.println(numbers.findMinMax()); // Display minimum, maximum, and max mod min
                            System.out.println("Factorial of MaxValue: " + numbers.getFactorialMax()); // Display
                                                                                                       // factorial of
                                                                                                       // max value
                        } else {
                            System.out.println("Please initialize first.");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting"); // Exit the program
                        in.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
                System.out.println("\n"); // Add a newline for separation
            } else {
                System.out.println("Invalid input. Please enter an integer for the menu choice.\n"); // Handle invalid
                                                                                                     // input
                in.nextLine(); // Consume the invalid input
            }
        }
    }

    /**
     * Displays the main menu options to the console.
     */
    public static void displayMainMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Initialize a default array");
        System.out.println("2: To specify the max size of the array");
        System.out.println("3: Add value to the array");
        System.out.println("4: Display values in the array");
        System.out.println("5: Display average of the values, minimum value, maximum value, max mod min, factorialMax");
        System.out.println("6: To Exit");
    }
}
