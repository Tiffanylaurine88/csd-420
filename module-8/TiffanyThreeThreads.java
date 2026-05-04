/*
 * Name: Tiffany Davidson
 * Date: May 2026
 * Assignment: Module 8.2
 * Course: CSD420
 *
 * This JavaFX program uses three threads to display random letters,
 * random numbers, and random special characters in a TextArea.
 *
 * Each thread generates at least 10,000 characters.
 * The characters are displayed as they are generated instead of grouped together.
 */

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TiffanyThreeThreads extends Application {

    private static final int CHARACTER_COUNT = 10000;

    private final TextArea textArea = new TextArea();

    private int letterCount = 0;
    private int numberCount = 0;
    private int specialCount = 0;

    private final Random random = new Random();

    @Override
    public void start(Stage primaryStage) {

        textArea.setWrapText(true);
        textArea.setEditable(false);

        BorderPane pane = new BorderPane();
        pane.setCenter(textArea);

        Scene scene = new Scene(pane, 700, 500);

        primaryStage.setTitle("TiffanyThreeThreads");
        primaryStage.setScene(scene);
        primaryStage.show();

        Thread letterThread = new Thread(() -> generateLetters());
        Thread numberThread = new Thread(() -> generateNumbers());
        Thread specialThread = new Thread(() -> generateSpecialCharacters());

        letterThread.start();
        numberThread.start();
        specialThread.start();
    }

    /*
     * Generates random lowercase letters from a to z.
     */
    private void generateLetters() {
        for (int i = 0; i < CHARACTER_COUNT; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            letterCount++;
            appendCharacter(letter);
        }
        testCompletion();
    }

    /*
     * Generates random number digits from 0 to 9.
     */
    private void generateNumbers() {
        for (int i = 0; i < CHARACTER_COUNT; i++) {
            char number = (char) ('0' + random.nextInt(10));
            numberCount++;
            appendCharacter(number);
        }
        testCompletion();
    }

    /*
     * Generates random special characters from the required character list.
     */
    private void generateSpecialCharacters() {
        char[] specialCharacters = {'!', '@', '#', '$', '%', '&', '*', '^'};

        for (int i = 0; i < CHARACTER_COUNT; i++) {
            char special = specialCharacters[random.nextInt(specialCharacters.length)];
            specialCount++;
            appendCharacter(special);
        }
        testCompletion();
    }

    /*
     * Safely updates the JavaFX TextArea from the running threads.
     */
    private void appendCharacter(char character) {
        Platform.runLater(() -> textArea.appendText(String.valueOf(character)));
    }

    /*
     * Test code that checks whether each thread generated 10,000 characters.
     * The result is printed to the console.
     */
    private synchronized void testCompletion() {
        if (letterCount == CHARACTER_COUNT
                && numberCount == CHARACTER_COUNT
                && specialCount == CHARACTER_COUNT) {

            System.out.println("Test passed.");
            System.out.println("Letters generated: " + letterCount);
            System.out.println("Numbers generated: " + numberCount);
            System.out.println("Special characters generated: " + specialCount);
            System.out.println("Total characters generated: "
                    + (letterCount + numberCount + specialCount));
        }
    }

    /*
     * Main method launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}