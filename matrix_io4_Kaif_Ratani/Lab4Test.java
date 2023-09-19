package lab4test.matrices;
/*
 * Description: The main method of the image processing application
 * Student Name: Kaif Ratani  StudentID 041076291
 * Due Date: June 24, 2023
 * Program: CET-CS CST8132
 * Lab Professor: James Mwangi PhD , daniel cormier 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * This class provides the driver of the image processing
 * application
 */
public class Lab4Test {

	/**
	 * Fields
	 * Description: Kernels that can be used to do image
	 * processing based on https://en.wikipedia.org/wiki/Kernel_(image_processing)
	 * 
	 * kernels Array of convolution kernels
	 */
	private NamedMatrix[] kernels = {
			new NamedMatrix("identity", new double[][] {
					{ 0, 0, 0 },
					{ 0, 2, 0 },
					{ 0, 0, 0 }
			}),

			new NamedMatrix("ridge", new double[][] {
					{ -1, -1, -1 },
					{ -1, 10, -1 },
					{ -1, -1, -1 }
			}),

			new NamedMatrix("sharpen", new double[][] {
					{ 0, -1, 0 },
					{ -1, 7, -1 },
					{ 0, -1, 0 }
			}),

			new NamedMatrix("unsharpen masking 5x5", new double[][] {
					{ -1.0 / 257, -1.0 / 65, -3.0 / 128, -1.0 / 65, -1.0 / 257 },
					{ -1.0 / 65, -16.0 / 257, -3.0 / 65, -16.0 / 257, -1.0 / 65 },
					{ -3.0 / 128, -3.0 / 65, 119.0 / 65, -3.0 / 65, -6.0 / 257 },
					{ -1.0 / 65, -16.0 / 257, -3.0 / 65, -16.0 / 257, -1.0 / 65 },
					{ -1.0 / 257, -1.0 / 65, -3.0 / 128, -1.0 / 65, -1.0 / 257 }
			}),

			new NamedMatrix("laplace", new double[][] { // ridge + identity
					{ -1, -1, -1 },
					{ -1, 12, -1 },
					{ -1, -1, -1 }
			})
	};

	/**
	 * Description: Method that opens a dialog box to load an image file
	 * 
	 * @return The selected File. If the dialog box is canceled, a
	 *         non existent File is returned
	 */
	public File getImageFile() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		File file;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			System.out.println("You chose to open this file: " + file.getAbsolutePath());
		} else {
			file = new File("noneExistent");
			System.out.println("No file chosen");
		}
		return file;
	}

	/**
	 * Description: Method that returns the selected kernel.
	 * This method handled all invalid kernel selections
	 * 
	 * @return A NamedMatrix of the kernel
	 */
	public NamedMatrix getKernel() {

		try (Scanner in = new Scanner(System.in)) { // scanner object
			int choice;
			do {
				System.out.println("Please select one of the following:");
				for (int i = 0; i < kernels.length; i++) {
					System.out.println("\t" + (i + 1) + " " + kernels[i].getName()); // printing the opions
				}
				System.out.print("Select a filter: ");

				if (in.hasNextInt()) {
					choice = in.nextInt();// user input
					if (choice >= 1 && choice <= kernels.length) {
						return kernels[choice - 1]; // return value
					} else if (choice <= 1 || choice >= kernels.length) {
						System.out.print("\nSelect a value in the range, "); // error print
					}

				} else {
					System.out.print("\nSelect an integer, "); // error print
					in.next();
				}

			} while (true);
		}
	}

	/**
	 * Description: Entry point for the application. Gets an
	 * image file and selects kernel then applies filter to
	 * the image and saves the file
	 * 
	 * @param args Commandline parameters, not used
	 */
	public static void main(String[] args) {

		Lab4Test lab4 = new Lab4Test();

		// Choose image file
		File imageFile = lab4.getImageFile();
		if (!imageFile.exists())
			return;

		// Choose kernel
		NamedMatrix kernel = lab4.getKernel();

		try {
			// Create filtered image using original image and kernal
			Matrix originalImage = new FileMatrix(imageFile);
			Convolution convolve = new Convolution(kernel);
			FileMatrix filteredImage = new FileMatrix(convolve.filter(originalImage));

			// Save filtered image in a file named:
			// "image file name" "-" "kernel name" "." "image file extension"
			String fileName = imageFile.getAbsolutePath();
			int dot = fileName.indexOf('.');
			String output = fileName.substring(0, dot) + "-" + kernel.getName() + fileName.substring(dot);
			File outputFile = new File(output);
			if (filteredImage.save(outputFile))
				System.out.println("File: " + output + " succesfully written");
			else
				System.out.println("Could not write file: " + output);

		} catch (FileNotFoundException e) {
			System.out.println("Could not find file: " + imageFile.getAbsolutePath());
		}

	}

}
