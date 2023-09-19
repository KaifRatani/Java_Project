package lab4test.matrices;

/**
 * 
 * Lab4- Convolution class
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
public class Convolution {
    private Matrix kernel;

    public Convolution(Matrix kernel) {
        this.kernel = kernel;
    }

    public Matrix filter(Matrix image) {
        // creating varibles amd matrix
        int rows, columns;
        rows = image.rows - kernel.rows + 1;
        columns = image.columns - kernel.columns + 1;
        double[][] outputImage = new double[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                // Create a submatrix of the input image
                Matrix subMatrix = image.subMatrix(r, c, kernel.rows, kernel.columns);
                // Multiply the submatrix by the kernel
                Matrix multipliedMatrix = subMatrix.mult(kernel);
                // Calculate the sum of the multiplied matrix
                outputImage[r][c] = multipliedMatrix.sum();
            }
        }

        return new Matrix(outputImage);
    }
}
