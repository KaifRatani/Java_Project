package lab4test.matrices;

/**
 * 
 * Lab4- NamedMatrix class
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
public class NamedMatrix extends Matrix {
    String name;

    // Public constructor NamedMatrix
    public NamedMatrix(String name, double[][] array) {
        super(array);
        this.name = name;
    }

    // getter method
    public String getName() {
        return name;
    }

}
