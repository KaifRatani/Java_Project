
package lab4test.matrices;

/**

 *Lab4- Calculating matrix result depending on user input 

 * Student Name: Kaif Ratani

 * Student Number: 041076291

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 3

 * Professor: daniel cormier 
 
  */
import java.util.Arrays;

public class Matrix {
    protected final double[][] array; // 2D array to store the matrix elements
    protected final int rows, columns; // variables to store the number of rows and columns

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.array = new double[rows][columns]; // Initialize the 2D array with the specified dimensions
    }

    public Matrix(double[][] mainArray) {
        this.rows = mainArray.length;
        this.columns = mainArray.length;
        this.array = new double[rows][columns]; // Initialize the 2D array with the specified dimensions

        // Copy the elements from the mainArray to the matrix array
        for (int vRows = 0; vRows < rows; vRows++) {
            for (int vCol = 0; vCol < columns; vCol++) {
                this.array[vRows][vCol] = mainArray[vRows][vCol];
            }
        }
    }

    /**
     * Adds the given matrix to this matrix and returns a new Matrix object as the
     * result.
     */
    public Matrix add(Matrix matrix) {
        Matrix k = new Matrix(rows, columns); // Create a new Matrix object with the same dimensions
        for (int vRows = 0; vRows < rows; vRows++) {
            for (int vCol = 0; vCol < columns; vCol++) {
                k.array[vRows][vCol] = this.array[vRows][vCol] + matrix.array[vRows][vCol];
            }
        }
        return k;
    }

    /**
     * Subtracts the given matrix from this matrix and returns a new Matrix object
     * as the result.
     */
    public Matrix sub(Matrix matrix) {
        Matrix k = new Matrix(rows, columns); // Create a new Matrix object with the same dimensions
        for (int vRows = 0; vRows < rows; vRows++) {
            for (int vCol = 0; vCol < columns; vCol++) {
                k.array[vRows][vCol] = this.array[vRows][vCol] - matrix.array[vRows][vCol];
            }
        }
        return k;
    }

    /**
     * Multiplies this matrix with the given matrix and returns a new Matrix object
     * as the result.
     */
    public Matrix mult(Matrix matrix) {
        Matrix k = new Matrix(rows, columns); // Create a new Matrix object with the same dimensions
        for (int vRows = 0; vRows < rows; vRows++) {
            for (int vCol = 0; vCol < columns; vCol++) {
                k.array[vRows][vCol] = this.array[vRows][vCol] * matrix.array[vRows][vCol];
            }
        }
        return k;
    }

    /**
     * Calculates the sum of all elements in the matrix.
     */
    public double sum() {
        double k = 0.0;
        for (int vRows = 0; vRows < rows; vRows++) {
            for (int vCol = 0; vCol < columns; vCol++) {
                k = +array[vRows][vCol];
            }
        }
        return k;
    }

    /**
     * Returns a submatrix of this matrix based on the specified parameters.
     */
    public Matrix subMatrix(int row, int column, int length, int width) {
        Matrix k = new Matrix(length, width); // Create a new Matrix object with the specified dimensions
        for (int side = 0; side < length; side++) {
            for (int up = 0; up < width; up++) {
                k.array[side][up] = this.array[row + side][column + up];
            }
        }
        return k;
    }

    /**
     * Returns a string representation of the matrix.
     */
    public String toString() {
        StringBuffer result = new StringBuffer();

        for (double[] row : array) {
            result.append(Arrays.toString(row));
            result.append('\n');
        }
        return result.toString();
    }
}
