package encryption.ciphers;

/**

 *Lab5-  VigenereCipher class

 * Student Name: Kaif Ratani

 * Student Number: 041076291

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 3

 * Professor: daniel cormier 
 
  */
import encryption.Encryptable;

public class VigenereCipher implements Encryptable {
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
     * Encrypts the input string using the Vigenere cipher.
     *
     * @param input the string to be encrypted
     * @return the encrypted string
     */
    public String encrypt(String input) {
        StringBuilder en = new StringBuilder();

        // input == password
        if (input.length() > password.length()) {
            StringBuilder passSB = new StringBuilder();
            for (int z = 0; z < input.length(); z++) {
                if (z >= password.length()) {
                    char passchar = password.charAt(z % password.length());
                    passSB.append(passchar);
                } else {
                    char passchar = password.charAt(z);
                    passSB.append(passchar);
                }

            }
            newPass = passSB.toString();
            System.out.println(newPass);// Print the updated password
        } else {
            newPass = password.toString();
            System.out.println(newPass);
        }

        for (int i = 0; i < input.length(); i++) {
            int result = 0;
            char passchar = newPass.charAt(i);
            char inchar = input.charAt(i);
            int passNum = (int) passchar; // convert password to int
            int inputNum = (int) inchar;// convert input to int
            result = (((passNum - START_CHAR) + (inputNum - START_CHAR)) % RANGE); // res(ps - 32 + en -32)% 91
            if (result < 0)// if 0 < 91
            {
                result += RANGE;// res + 91
            }
            result += START_CHAR; // Convert the index to ASCII value
            en.append((char) result); // Append the encrypted character to the result string

        }

        return en.toString(); // Return the encrypted result string
    }

    /**
     * Decrypts the input string using the Vigenere cipher.
     *
     * @param input the string to be decrypted
     * @return the decrypted string
     */
    public String decrypt(String input) {
        StringBuilder de = new StringBuilder();

        // input == pass
        if (input.length() > password.length()) {
            StringBuilder passSB = new StringBuilder();
            for (int z = 0; z < input.length(); z++) {
                if (z >= password.length()) {
                    char passchar = password.charAt(z % password.length());
                    passSB.append(passchar);
                } else {
                    char passchar = password.charAt(z);
                    passSB.append(passchar);
                }

            }
            newPass = passSB.toString();
            System.out.println(newPass);
        } else {
            newPass = password.toString();
            System.out.println(newPass);
        }

        for (int i = 0; i < input.length(); i++) {
            int result = 0;
            char passchar = newPass.charAt(i);
            char inchar = input.charAt(i);
            int passNum = (int) passchar;
            int inputNum = (int) inchar;
            result = (((inputNum - START_CHAR) - (passNum - START_CHAR)) % RANGE); // res(ps - 32 + en -32)% 91
            if (result < 0)// if 0 < 91
            {
                result += RANGE;// res + 91
            }
            result += START_CHAR;
            de.append((char) result);

        }

        return de.toString();

    }

}
