package encryption;

import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;

/**
 * This abstract class represents the common interface for encryption
 * algorithms.
 * It provides methods for encrypting and decrypting text using different
 * ciphers.
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
public abstract class EncryptionType {
    protected final int START_CHAR = 32; // Starting ASCII value for characters in the encryption range
    protected final int END_CHAR = 122; // Ending ASCII value for characters in the encryption range
    protected final int RANGE = END_CHAR - START_CHAR + 1; // Calculating range

    /**
     * Abstract method for decrypting a given input string.
     *
     * @param input the string to be decrypted
     * @return the decrypted string
     */
    public abstract String decrypt(String input);

    /**
     * Abstract method for encrypting a given input string.
     *
     * @param input the string to be encrypted
     * @return the encrypted string
     */
    public abstract String encrypt(String input);

    /**
     * Shifts a character by a given offset to perform encryption or decryption.
     *
     * @param inchar the character to be shifted
     * @param offset the offset by which the character is shifted
     * @return the shifted character
     */
    public char shiftChar(char inchar, int offset) {
        int rechar = (int) (((int) inchar) + offset);

        while (rechar < START_CHAR) {
            rechar += RANGE; // Adding the total number of characters in the range to wrap around
        }

        while (rechar > 122) {
            rechar -= RANGE; // Subtracting the total number of characters in the range to wrap around
        }

        char result = (char) rechar;
        return result;
    }

    /**
     * Prompts the user to choose an encryption method (Caesar or Vigenere) and
     * returns an instance of the selected cipher class.
     *
     * @return an instance of the selected cipher class (CaesarCipher or
     *         VigenereCipher)
     */
    public EncryptionType getMethod() {
        System.out.println("Encryption method :");

        int choice = ScannerUtils.getMenuItem(" Caesar", "Vigenere"); // Get the user's choice for the encryption method

        switch (choice) { // Determine the encryption method based on the choice
            case 1:
                int userKey = ScannerUtils.getInt("Enter Shift Value: "); // Get the shift value for Caesar
                return new CaesarCipher(userKey); // Create and return a CaesarCipher object

            case 2:
                String userPass = ScannerUtils.getString("Enter Password: ");
                return new VigenereCipher(userPass); // Create and return a VigenereCipher object

            default:
                break;
        }

        return null; // Return null if no valid encryption method is selected
    }
}
