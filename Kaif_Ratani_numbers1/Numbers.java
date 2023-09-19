/**
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

public class Numbers {
    private Float[] num;
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
        sb.append("Array num: ");
        for (int i = 0; i < arrayCount; i++) {
            sb.append(num[i]);
            if (i < arrayCount - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
