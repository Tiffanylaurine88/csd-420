/*
 * Name: Tiffany Davidson
 * Course: CSD 420
 * Module: 2.2
 * Assignment: Write random integer and double arrays to a data file
 * Date: [Enter Date Here]
 *
 * Description:
 * This program creates an array of five random integers and an array of
 * five random double values. The program writes the data to a file named
 * davidson_datafile.dat. If the file does not exist, it is created.
 * If the file already exists, the new data is appended to the file.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class DavidsonWriteData {

    public static void main(String[] args) {
        String fileName = "davidson_datafile.dat";

        int[] integerArray = new int[5];
        double[] doubleArray = new double[5];

        Random random = new Random();

        // Fill integer array with random integers from 1 to 100
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = random.nextInt(100) + 1;
        }

        // Fill double array with random doubles from 0.0 to 100.0
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = random.nextDouble() * 100.0;
        }

        // Write data to file, append if file already exists
        try (PrintWriter output = new PrintWriter(new FileWriter(fileName, true))) {
            output.println("----- New Entry -----");

            output.print("Integers: ");
            for (int value : integerArray) {
                output.print(value + " ");
            }
            output.println();

            output.print("Doubles: ");
            for (double value : doubleArray) {
                output.printf("%.2f ", value);
            }
            output.println();
            output.println();

            System.out.println("Data successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}