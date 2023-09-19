
/**
 * Lab6Test - main method 
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
import encryption.EncryptionType;
import encryption.ScannerUtils;
import encryption.ciphers.CaesarCipher;
import java.util.ArrayList;

public class Lab6Test {
	/**
	 * Main method of the Lab6Test class.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Encryption tester");

		ArrayList<String> encryptedText = new ArrayList<>();// Create an ArrayList to store encrypted texts
		EncryptionType et = new CaesarCipher(0);
		boolean exit = false;
		while (!exit) {
			int choice = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit");

			switch (choice) {// Enter the loop until the user chooses to exit
				case 1:
					String textToEncrypt = ScannerUtils.getString("Enter text to encrypt");

					EncryptionType encryptionMethod = et.getMethod();// Get the encryption method

					String encrypted = encryptionMethod.encrypt(textToEncrypt);// Encrypt the text
					System.out.println("encrypted text: " + encrypted);// Display the encrypted text
					encryptedText.add(encrypted);// Add the encrypted text to the list
					break;
				case 2:
					if (encryptedText.isEmpty()) {
						System.out.println("No encrypted text available.");
					} else {
						int textIndex = ScannerUtils.getMenuItem(encryptedText.toArray(new String[0]));// Get the index
						// of the text to
						// decrypt
						String textToDecrypt = encryptedText.get(textIndex - 1);// Get the selected encrypted text
						EncryptionType decryptionMethod = et.getMethod(); // Decrypt the text
						String decrypted = decryptionMethod.decrypt(textToDecrypt); // Display the
																					// decrypted
																					// text
						System.out.println("\nDecrypted text: " + decrypted); // Display the title of the encrypted list
					}
					break;
				case 3:
					System.out.println("Encrypted List:");
					System.out.println("----------------------------------");
					int i = 1;
					for (String text : encryptedText) {
						System.out.print((i++) + ": ");
						System.out.println(text); // Display each encrypted text in the list
					}
					System.out.println("----------------------------------");
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
