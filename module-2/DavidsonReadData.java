/*
 * Name: Tiffany Davidson
 * Course: CSD 420
 * Module: 2.2
 * Assignment: Read and display data from a data file
 * Date: [Enter Date Here]
 *
 * Description:
 * This program reads the contents of davidson_datafile.dat
 * and displays the data to the console.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DavidsonReadData {

    public static void main(String[] args) {
        String fileName = "davidson_datafile.dat";
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("The file does not exist yet.");
            System.out.println("Run DavidsonWriteData first to create the file.");
            return;
        }

        try (Scanner input = new Scanner(file)) {
            System.out.println("Displaying contents of " + fileName + ":");
            System.out.println();

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}