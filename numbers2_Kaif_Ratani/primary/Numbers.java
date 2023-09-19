/**
 * lab 2
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and its processing
 * Student Name: Kaif Ratani
 * Student Number: 041076291
 * Section #: 312
 * Course: CST8130 - Data Structures
 * Professor: George Kriger.
 */

package primary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Numbers {
    private Float[] num;
    private int maxValue;
    private int len; // Array size
    private int arrayCount; // Number of values currently in the array

    /**
     * Default constructor that initializes the array with a size of 5.
     */
    public Numbers() {
        len = 5;
        num = new Float[len];
        arrayCount = 0;
    }

    /**
     * Constructor that allows specifying the maximum size of the array.
     *
     * @param maxlen The maximum size of the array.
     */
    public Numbers(int maxlen) {
        len = maxlen;
        num = new Float[len];
        arrayCount = 0;
    }

    /**
     * Reads data from a text file and populates the 'num' array with the values.
     *
     * @param fileName The name of the file to read from.
     */
    void readFile(String fileName) {
        try {
            // Create a FileReader and wrap it in a BufferedReader for efficient reading
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Read the file line by line
            String line;
            String line1 = bufferedReader.readLine();
            if (Integer.parseInt(line1) <= len + arrayCount) {
                while ((line = bufferedReader.readLine()) != null) {
                    if (arrayCount < len) {
                        num[arrayCount++] = Float.parseFloat(line);
                    } else {
                        System.out.println("Out of bound.");
                    }
                }

                // Close the BufferedReader when done
                bufferedReader.close();
            } else {
                System.out.println("No room in array to add all values");
            }
        } catch (IOException e) {
            // Handle any IO exceptions that may occur
            System.out.println("File Not found");
        }
    }

    /**
     * Adds a specified number of values to the 'num' array from user input.
     *
     * @param in The Scanner object for user input.
     */
    void addValues(Scanner in) {
        System.out.println("How many values do you wish to add? ");
        maxValue = in.nextInt();

        if (len >= arrayCount + maxValue) {
            for (int i = 0; i < maxValue; i++) {
                if (arrayCount < len) {
                    System.out.println("Enter value: ");
                    num[arrayCount++] = in.nextFloat();
                } else {
                    System.out.println("No room in array to add all values");
                }
                // numbers.addValue(in.nextFloat());
            }
        } else {
            System.out.println("No room in array to add all values");
        }
    }

    /**
     * Saves the contents of the 'num' array to a text file.
     *
     * @param fileName The name of the file to save to.
     */
    void saveFile(String fileName) {
        try {
            // Create a FileWriter and wrap it in a BufferedWriter for efficient writing
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(num.length));
            bufferedWriter.newLine();
            // Write data into the file
            for (int i = 0; i < num.length; i++) {
                bufferedWriter.write(num[i].toString()); // Write a line of text
                bufferedWriter.newLine();
            }
            // Close the BufferedWriter to save and close the file
            bufferedWriter.close();

            // System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            // Handle any IO exceptions that may occur
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println("Array is null.");
        }
    }

    /**
     * Adds a value to the array.
     *
     * @param value The value to be added.
     */
    public void addValue(Float value) {
        if (arrayCount < len) {
            num[arrayCount++] = value;
        } else {
            System.out.println("Out of bound.");
        }
    }

    /**
     * Calculates and returns the average of the values in the array.
     *
     * @return The average of the values in the array.
     */
    public float calcAverage() {
        float sum = 0;
        if (arrayCount == 0) {
            return 0;
        } else {
            for (int i = 0; i < arrayCount; i++) {
                sum += num[i];
            }
            return sum / arrayCount;
        }
    }

    /**
     * Finds and returns the minimum and maximum values in the array, along with Max
     * Mod Min.
     *
     * @return A string containing the minimum, maximum, and Max Mod Min.
     */
    public String findMinMax() {
        if (arrayCount == 0) {
            return "Empty array.";
        }
        float min = num[0];
        float max = num[0];
        for (int i = 1; i < arrayCount; i++) {
            if (num[i] < min) {
                min = num[i];
            }
            if (num[i] > max) {
                max = num[i];
            }
        }
        float mmm = max % min;
        return "Minimum: " + min + ", Maximum: " + max + ", Max Mod Min: " + mmm;
    }

    /**
     * Computes and returns the factorial of the maximum value in the array after
     * dropping the decimal part.
     *
     * @return The factorial of the maximum value.
     */
    public int getFactorialMax() {
        if (arrayCount == 0) {
            return 0;
        } else {
            float max = num[0];

            for (int i = 1; i < arrayCount; i++) {
                if (num[i] > max) {
                    max = num[i];
                }
            }
            int factor = 1;
            for (int i = 1; i <= ((int) max); i++) {
                factor *= i;
            }
            return factor;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayCount; i++) {
            sb.append(num[i]);
            if (i < arrayCount - 1) {
                sb.append("\n");
            }
        }
        if (arrayCount == 0) {
            return "array is null";
        } else {
            return sb.toString();
        }

    }
}
