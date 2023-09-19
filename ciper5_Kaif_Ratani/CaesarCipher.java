package encryption.ciphers;

/**

 *Lab5- CaesarCipher class

 * Student Name: Kaif Ratani

 * Student Number: 041076291

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 3

 * Professor: daniel cormier 
 
  */

import encryption.Encryptable;

public class CaesarCipher implements Encryptable {
    public int key;

    /**
     * Constructor for the CaesarCipher class.
     *
     * @param key the encryption/decryption key
     */
    public CaesarCipher(int key) {
        this.key = key;
    }

    /**
     * Encrypts the input string using the Caesar cipher.
     *
     * @param input the string to be encrypted
     * @return the encrypted string
     */
    public String encrypt(String input) {
        StringBuilder en = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int rechar = ((int) c) + key;// Shift the character by the encryption key
            en.append((char) rechar);// Append the encrypted character to the result
        }
        return en.toString();// Return the encrypted result string
    }

    /**
     * Decrypts the input string using the Caesar cipher.
     *
     * @param input the string to be decrypted
     * @return the decrypted string
     */
    public String decrypt(String input) {
        StringBuilder de = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int rechar = ((int) c) - key; // Shift the character back by the encryption key
            de.append((char) rechar);// Append the decrypted character to the result
        }
        return de.toString();// Return the decrypted result string
    }
}
