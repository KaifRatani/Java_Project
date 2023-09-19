/**
 * lab2
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Kaif Ratani 
 * Student Number: 041076291      
 * Section #: 312  
 * Course: CST8130 - Data Structures
 * Professor: George Kriger. 
 * 
 */

package numtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import primary.Numbers;

import static org.junit.jupiter.api.Assertions.*;

public class lab2_test {
	Numbers numbers = new Numbers();

	@BeforeEach
	void setUp() {
		numbers = new Numbers();
	}

	@Test
	void testDefualtAverage() {// for average
		assertEquals(0.0f, numbers.calcAverage());
	}

	@Test
	void testValueAverage() {// for average
		numbers.addValue(100.0f);
		numbers.addValue(200.0f);
		numbers.addValue(3.0f);
		assertEquals(101.0f, numbers.calcAverage());
	}

	@Test
	void testDefualtMinMax() {// for minmax
		assertEquals("Empty array.", numbers.findMinMax());
	}

	@Test
	void testValueMinMax() {// for minimum , maximan and max mod min
		numbers.addValue(17.0f);
		numbers.addValue(10.0f);
		numbers.addValue(5.0f);
		assertEquals("Minimum: 5.0, Maximum: 17.0, Max Mod Min: 2.0", numbers.findMinMax());
	}

	@Test
	void testDefualtFactor() { // for factor
		assertEquals(0, numbers.getFactorialMax());
	}

	@Test
	void testvaluefactor() { // for factor
		numbers.addValue(10.0f);
		numbers.addValue(12.0f);
		assertEquals(479001600, numbers.getFactorialMax());
	}
}
