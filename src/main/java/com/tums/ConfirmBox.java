package com.tums;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    protected static boolean showConfirmation(String title, String message) {
        Stage confirmationWindow = new Stage();

        //Making window modal
        confirmationWindow.initModality(Modality.APPLICATION_MODAL);

        //Setting title of the window
        confirmationWindow.setTitle(title);

        //Setting window minimum width
        confirmationWindow.setMinWidth(350);
        confirmationWindow.setMinHeight(150);

        //Setting displayed message
        Label label = new Label(message);

        //Creating answer buttons
        Button yesButton = new Button();
        yesButton.setText("Yes");
        yesButton.setOnAction(e -> {
            answer=true;
            confirmationWindow.close();
        });
        Button noButton = new Button();
        noButton.setText("No");
        noButton.setOnAction(e -> {
            answer=false;
            confirmationWindow.close();
        });

        //Creating layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);

        //Creating a scene object
        Scene scene = new Scene(layout);
        confirmationWindow.setScene(scene);
        confirmationWindow.showAndWait();

        return answer;
    }
}
