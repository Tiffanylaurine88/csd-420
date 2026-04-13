/*
 * Tiffany Davidson
 * CSD420
 * Module 1.3
 * Davidson_Mod1_3_CSD420.java
 *
 * Assignment Description:
 * This JavaFX program displays four randomly selected playing card images
 * from a deck of 52 cards. The card images are stored in a "cards"
 * subdirectory and are named 1.png through 52.png.
 *
 * The program includes a Refresh button below the displayed cards.
 * When the button is clicked, four different random cards are displayed.
 *
 * This program uses a lambda expression for the Refresh button event.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Davidson_Mod1_3_CSD420 extends Application {

    private final ImageView[] cardViews = new ImageView[4];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        HBox cardBox = new HBox(15);
        cardBox.setAlignment(Pos.CENTER);
        cardBox.setPadding(new Insets(20));

        for (int i = 0; i < cardViews.length; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(100);
            cardViews[i].setFitHeight(150);
            cardViews[i].setPreserveRatio(true);
            cardBox.getChildren().add(cardViews[i]);
        }

        Button refreshButton = new Button("Refresh");

        refreshButton.setOnAction(e -> displayRandomCards());

        HBox buttonBox = new HBox(refreshButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(0, 0, 20, 0));

        root.setCenter(cardBox);
        root.setBottom(buttonBox);

        displayRandomCards();

        Scene scene = new Scene(root, 500, 250);
        primaryStage.setTitle("Module 1.3 Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRandomCards() {
        List<Integer> deck = new ArrayList<>();

        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        Collections.shuffle(deck);

        for (int i = 0; i < 4; i++) {
            int cardNumber = deck.get(i);

            try {
                Image image = new Image(new FileInputStream("cards/" + cardNumber + ".png"));
                cardViews[i].setImage(image);
            } catch (FileNotFoundException ex) {
                System.out.println("Image file not found: cards/" + cardNumber + ".png");
            }
        }
    }
}