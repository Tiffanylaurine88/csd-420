/*
 * Name: Tiffany Davidson
 * Course: CSD 420
 * Module: 5.2
 * Assignment: Read words from a text file and display all non duplicate words
 *             in ascending order and descending order.
 * Date: April 19, 2026
 *
 * Description:
 * This program reads words from a file named collection_of_words.txt.
 * It stores only unique words by using a TreeSet.
 * The words are displayed in ascending order and then descending order.
 * The program also includes simple test output to confirm that the file
 * was read successfully and that duplicates were removed.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Davidson_Mod5_Assignment5_2_CSD420 {

    public static void main(String[] args) {
        String fileName = "collection_of_words.txt";
        TreeSet<String> uniqueWords = new TreeSet<>();

        try {
            File inputFile = new File(fileName);
            Scanner fileScanner = new Scanner(inputFile);

            while (fileScanner.hasNext()) {
                String word = fileScanner.next();

                // Remove punctuation from beginning and end, then convert to lowercase
                word = word.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "").toLowerCase();

                if (!word.isEmpty()) {
                    uniqueWords.add(word);
                }
            }

            fileScanner.close();

            // Test output to confirm program worked
            System.out.println("File read successfully: " + fileName);
            System.out.println("Total unique words found: " + uniqueWords.size());

            System.out.println("\nWords in ascending order:");
            for (String word : uniqueWords) {
                System.out.println(word);
            }

            System.out.println("\nWords in descending order:");
            for (String word : uniqueWords.descendingSet()) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file " + fileName + " was not found.");
        }
    }
}