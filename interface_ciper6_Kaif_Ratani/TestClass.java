package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import encryption.ScannerUtils;
import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;

/**
 * 
 * Lab6- junit class
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
public class TestClass {
	ScannerUtils su = new ScannerUtils();
	CaesarCipher testCipher1 = new CaesarCipher(5);
	CaesarCipher testCipher2 = new CaesarCipher(-4);
	VigenereCipher testvigenere1 = new VigenereCipher("test");
	VigenereCipher testvigenere2 = new VigenereCipher("Kaif-Ratani");

	@Test
	public void testciper1() {
		String encripted = testCipher1.encrypt("Once upon a time...");
		assertEquals(encripted, "Tshj%zuts%f%ynrj333");
	}

	@Test
	public void testciper2() {
		String encripted = testCipher1.decrypt("Tshj%zuts%f%ynrj333");
		assertEquals(encripted, "Once upon a time...");
	}

	@Test
	public void testciper3() {

		String encripted = testCipher2.encrypt("kaif");
		assertEquals(encripted, "g]eb");
	}

	@Test
	public void testciper4() {

		String encripted = testCipher2.decrypt("g]eb");
		assertEquals(encripted, "kaif");
	}

	@Test
	public void testvigenere1() {
		String encripted = testvigenere1.encrypt("in a land far far away");
		assertEquals(encripted, "bXsZtVYg]e^Zke^ZkeYpZc");
	}

	@Test
	public void testvigenere2() {

		String encripted = testvigenere1.decrypt("bXsZtVYg]e^Zke^ZkeYpZc");
		assertEquals(encripted, "in a land far far away");
	}

	@Test
	public void testvigenere3() {
		String encripted = testvigenere2.encrypt("hello");
		assertEquals(encripted, "8KZW!");
	}

	@Test
	public void testvigenere4() {

		String encripted = testvigenere2.decrypt("8KZW!");
		assertEquals(encripted, "hello");
	}
}