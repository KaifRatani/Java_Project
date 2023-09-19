/**
 * ScannerUtils - Utility class for handling user inputs
 * 
 * Student Name: Kaif Ratani
 * 
 * Student Number: 041076291
 * 
 * Course: CST8132 Object Oriented Programming
 * 
 * Program: CET-CS-Level 3
 * 
 * Professor: Daniel Cormier
 */
package encryption;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner input = new Scanner(System.in);

    /**
     * Displays a menu with options and retrieves the user's choice.
     *
     * @param options the menu options to display
     * @return the user's choice
     */
    public static int getMenuItem(String... options) {
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            for (int i = 0; i < options.length; i++) {
                System.out.println("\t" + (i + 1) + " - " + options[i]);// Print the menu options
            }

            System.out.println("Select action: ");
            String inputStr = input.nextLine();// Read the user's input

            try {
                choice = Integer.parseInt(inputStr);// Convert the input to an integer
                if (choice >= 1 && choice <= options.length) {// Set validInput to true if the choice is within the
                                                              // range
                    validInput = true;
                } else {
                    System.out.println("\nPlease select a number in the range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter an integer");
            }
        }

        return choice;
    }

    /**
     * Prompts the user for a string input.
     *
     * @param prompt the prompt message
     * @return the user's input string
     */
    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        return input.nextLine();// Read the user's input as a string
    }

    /**
     * Prompts the user for an integer input.
     *
     * @param prompt the prompt message
     * @return the user's input integer
     */
    public static int getInt(String prompt) {
        int value = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            String inputStr = input.nextLine();// Read the user's input

            try {
                value = Integer.parseInt(inputStr);// Convert the input to an integer
                if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
                    validInput = true;
                } else {
                    System.out.println("\nPlease select a number in the range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter an integer");
            }
        }

        return value;// Return the user's value
    }

}
