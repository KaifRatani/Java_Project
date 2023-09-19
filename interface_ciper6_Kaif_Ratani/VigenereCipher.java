package encryption.ciphers;

/**
 * The VigenereCipher class represents the Vigenere cipher algorithm for encryption and decryption.
 * 
 * Lab6- VigenereCipher class
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

public class VigenereCipher extends EncryptionType {
    String newPass, password;

    /**
     * Constructor for the VigenereCipher class.
     *
     * @param password the password used for encryption/decryption
     */
    public VigenereCipher(String password) {
        this.password = password;
    }

    /**
     * Sets the password of the VigenereCipher by repeating it to match the input
     * length.
     *
     * @param len the length of the input to be encrypted
     * @return the repeated password to match the input length
     */
    public String setPassword(int len) {
        StringBuilder passSB = new StringBuilder();

        for (int z = 0; z < len; z++) {
            if (z >= password.length()) {
                char passchar = password.charAt(z % password.length());
                passSB.append(passchar);
            } else {
                char passchar = password.charAt(z);
                passSB.append(passchar);
            }
        }
        return passSB.toString();
    }

    /**
     * Encrypts the input string using the Vigenere cipher.
     *
     * @param input the string to be encrypted
     * @return the encrypted string
     */
    public String encrypt(String input) {
        StringBuilder en = new StringBuilder();
        char[] finalchar = new char[input.length()];

        // input == password
        if (input.length() > password.length()) {
            newPass = setPassword(input.length());
        } else {
            newPass = password;
        }

        for (int i = 0; i < input.length(); i++) {

            char passchar = newPass.charAt(i);
            char inchar = input.charAt(i);
            int passNum = ((int) passchar) - START_CHAR; // convert password to int
            int inputNum = ((int) inchar) - START_CHAR;// convert input to int

            // result = ((int) shiftChar(((char) (inputNum - START_CHAR)), passNum)) %
            // RANGE;// res(ps - 32 + en -32)% 91
            char returnChar = shiftChar((char) inputNum, passNum);
            int result = (returnChar) % RANGE;
            char echar = (char) (result);
            finalchar[i] = echar;
            if (result < 0)// if 0 < 91
            {
                result += RANGE;// res + 91
            }
            result += START_CHAR; // Convert the index to ASCII value
            en.append((char) (result)); // Append the encrypted character to the result
            // result = (passNum + inputNum) % RANGE + RANGE;
        }
        // String qqq = new String(finalchar);

        return en.toString(); // Return the encrypted result string
    }

    /**
     * Decrypts the input string using the Vigenere cipher.
     *
     * @param input the string to be decrypted
     * @return the decrypted string
     */
    public String decrypt(String input) {
        StringBuilder en = new StringBuilder();
        char[] finalchar = new char[input.length()];

        // input == password
        if (input.length() > password.length()) {
            newPass = setPassword(input.length());
        } else {
            newPass = password;
        }

        for (int i = 0; i < input.length(); i++) {

            char passchar = newPass.charAt(i);
            char inchar = input.charAt(i);
            int passNum = ((int) passchar); // - START_CHAR); // convert password to int
            char returnChar = shiftChar(inchar, -passNum);
            int result = (returnChar) % RANGE + START_CHAR;
            char echar = (char) (result);
            finalchar[i] = echar;
            if (result < 0)// if 0 < 91
            {
                result += RANGE;// res + 91
            }
            result += START_CHAR; // Convert the index to ASCII value
            en.append((char) (result)); // Append the encrypted character to the result
            // result = (passNum + inputNum) % RANGE + RANGE;
        }
        String qqq = new String(finalchar);

        return qqq; // Return the encrypted result string
    }

}
