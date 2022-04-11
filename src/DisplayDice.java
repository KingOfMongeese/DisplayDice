/*
KingOfMongeese
April 11, 2022
DisplayDice Main
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.Random;

import java.io.IOException;

public class DisplayDice extends Application
{
    private static String[] dieFaces = {"DieFace1.gif", "DieFace2.gif", "DieFace3.gif", "DieFace4.gif", "DieFace5.gif", "DieFace6.gif"};
    private static Pane pane = new HBox();

    @Override
    public void start(Stage stage) throws IOException
    {
        //Buidling the scene
        pane.setPadding(new Insets(5,5,5,5));

        //setting button handler
        Button rollButton = new Button();
        rollButton.setOnAction(new ButtonHandler());
        rollButton.setText("Roll");
        pane.getChildren().add(rollButton);

        //setting default images
        Image image1 = new Image(dieFaces[0]);
        Image image2 = new Image(dieFaces[0]);
        Image image3 = new Image(dieFaces[0]);

        //setting the ImageView Objects
        pane.getChildren().add(new ImageView(image1));
        pane.getChildren().add(new ImageView(image2));
        pane.getChildren().add(new ImageView(image3));

        //setting the scene
        Scene scene = new Scene(pane, 450, 150);
        stage.setScene(scene);
        stage.setTitle("Roll 3 Dice");
        stage.show();



    }

    public static void main(String[] args)
    {
        launch();
    }

    public static void roll()
    {
        //Generates the roll of a D6 3 times
        Random random = new Random();
        int die1 = random.nextInt(6);
        int die2 = random.nextInt(6);
        int die3 = random.nextInt(6);

        //Sets the indexes of the pane to new ImageViews that are linked to the specified roll
        pane.getChildren().set(1, new ImageView(dieFaces[die1]));
        pane.getChildren().set(2, new ImageView(dieFaces[die2]));
        pane.getChildren().set(3, new ImageView(dieFaces[die3]));


    }



}
