/*
 * Name: Tiffany Davidson
 * Date: May 2026
 * Assignment: Module 7.2
 * Course: CSD420
 *
 * This JavaFX program displays four circles.
 * The first two circles use a CSS style class for white fill and black stroke.
 * The third and fourth circles use CSS IDs for red and green fill colors.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Davidson_Mod7_CSD420 extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create four circles with radius 30
        Circle circle1 = new Circle(30);
        Circle circle2 = new Circle(30);
        Circle circle3 = new Circle(30);
        Circle circle4 = new Circle(30);

        // Apply CSS class to the first two circles
        circle1.getStyleClass().add("plaincircle");
        circle2.getStyleClass().add("plaincircle");

        // Apply CSS IDs to the red and green circles
        circle3.setId("redcircle");
        circle4.setId("greencircle");

        // Place circles horizontally with spacing
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(circle1, circle2, circle3, circle4);

        // Create the scene
        Scene scene = new Scene(hBox, 320, 150);

        // Connect the external CSS file
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("Exercise31_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*
     * Main method launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}