package lab4test.matrices;

/**

 *Lab4- FileMatrix class 

 * Student Name: Kaif Ratani

 * Student Number: 041076291

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 3

 * Professor: daniel cormier 
 
  */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileMatrix extends Matrix {

    private FileMatrix(Scanner in) {
        // for rows and columns
        super(in.nextInt(), in.nextInt());
        // for values
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                array[r][c] = in.nextDouble();
            }
        }
    }

    // Public constructor used to create a FileMatrix from a file
    public FileMatrix(File file) throws FileNotFoundException {
        this(new Scanner(file));
    }

    // Public constructor used to create a FileMatrix from an existing Matrix.
    public FileMatrix(Matrix matrix) {
        super(matrix.array);

    }

    // saves the FileMatrix to a text file
    protected boolean save(File file) {
        try {
            PrintWriter print = new PrintWriter(file);
            print.println(rows + " " + columns);
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    print.print(array[r][c] + " ");// (array[r][c]);
                }
                print.println();
            }
            print.close();
            return true;
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            return false;
        }
    }

}
