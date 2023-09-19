package encryption;

/**
 * 
 * Lab5- Encryptable interface
 * 
 * Student Name: Kaif Ratani
 * 
 * Student Number: 041076291
 * 
 * Course: CST8132 Object Oriented Programming
 * 
 * Program: CET-CS-Level 3
 * 
 * Professor: daniel cormier
 * 
 */
public interface Encryptable {
    final int START_CHAR = 32; // Starting ASCII value for characters in the encryption range
    final int END_CHAR = 122;// Ending ASCII value for characters in the encryption range
    final int RANGE = END_CHAR - START_CHAR + 1;// Calculating range

    /**
     * Encrypts the input string.
     *
     * @param input the string to be encrypted
     * @return the encrypted string
     */
    String encrypt(String input);// Method to encrypt the input string

    /**
     * Decrypts the input string.
     *
     * @param input the string to be decrypted
     * @return the decrypted string
     */
    String decrypt(String input);// Method to decrypt the input string

}
