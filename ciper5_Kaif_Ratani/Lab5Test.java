
/**

 *Lab5- main method 

 * Student Name: Kaif Ratani

 * Student Number: 041076291

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 3

 * Professor: daniel cormier 
 
  */
import java.util.Scanner;

import encryption.Encryptable;
import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab5Test {
	private Scanner input;

	public Lab5Test() {
		input = new Scanner(System.in);
	}

	/**
	 * Displays a menu with options and retrieves the user's choice.
	 *
	 * @param options the menu options to display
	 * @return the user's choice
	 */
	public int getMenuItem(String... options) {
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
	public String getString(String prompt) {
		System.out.print(prompt + ": ");
		return input.nextLine();// Read the user's input as a string
	}

	/**
	 * Prompts the user for an integer input.
	 *
	 * @param prompt the prompt message
	 * @return the user's input integer
	 */
	public int getInt(String prompt) {
		int value = -1;
		boolean validInput = false;

		while (!validInput) {
			System.out.print(prompt);
			String inputStr = input.nextLine();// Read the user's input

			try {
				value = Integer.parseInt(inputStr);// Convert the input to an integer
				if (value >= 0 && value <= 92) {
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

	/**
	 * Retrieves the encryption method chosen by the user.
	 *
	 * @return the selected encryption method
	 */
	public Encryptable getMethod() {
		System.out.println("Encryption method :");

		int choice = getMenuItem(" Caesar", "Vigenere");// Get the user's choice for the encryption method

		switch (choice) { // Determine the encryption method based on the choice
			case 1:
				int userKey = getInt("Enter Shift Value: ");// Get the shift value for Caesar
															// cipher
				return new CaesarCipher(userKey); // Create and return a CaesarCipher object

			case 2:
				String userPass = getString("Enter Password: ");
				return new VigenereCipher(userPass);// Create and return a VigenereCipher object
			default:
				break;
		}

		return null;// Return null if no valid encryption method is selected
	}

	/**
	 * Main method of the Lab5Test class.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Encrytion tester");

		ArrayList<String> encryptedText = new ArrayList<>();// Create an ArrayList to store encrypted texts
		Lab5Test lab5Test = new Lab5Test();

		boolean exit = false;
		while (!exit) {
			int choice = lab5Test.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit");

			switch (choice) {// Enter the loop until the user chooses to exit
				case 1:
					String textToEncrypt = lab5Test.getString("Enter text to encrypt");
					Encryptable encryptionMethod = lab5Test.getMethod();// Get the encryption method
					String encrypted = encryptionMethod.encrypt(textToEncrypt);// Encrypt the text
					System.out.println(encrypted);// Display the encrypted text
					encryptedText.add(encrypted);// Add the encrypted text to the list
					break;
				case 2:
					if (encryptedText.isEmpty()) {
						System.out.println("No encrypted text available.");
					} else {
						int textIndex = lab5Test.getMenuItem(encryptedText.toArray(new String[0]));// Get the index of
																									// the text to
																									// decrypt
						String textToDecrypt = encryptedText.get(textIndex - 1);// Get the selected encrypted text
						Encryptable decryptionMethod = lab5Test.getMethod(); // Decrypt the text
						String decrypted = decryptionMethod.decrypt(textToDecrypt); // Display the decrypted text
						System.out.println("\nDecrypted text: " + decrypted); // Display the title of the encrypted list
					}
					break;
				case 3:
					System.out.println("Encrypted List:");
					for (String text : encryptedText) {
						System.out.println(text); // Display each encrypted text in the list
					}
					break;
				case 4:
					exit = true;// Set exit to true to exit the loop
					break;
				default:
					break;
			}
		}
		System.out.println("Goodbye!");
	}

}
