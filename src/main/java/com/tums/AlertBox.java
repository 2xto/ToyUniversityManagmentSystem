package com.tums;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    protected static void showAlert(String title, String message){
        Stage alertWindow = new Stage();

        //Making window modal
        alertWindow.initModality(Modality.APPLICATION_MODAL);

        //Setting title of the window
        alertWindow.setTitle(title);

        //Setting minimum size of the window
        alertWindow.setMinWidth(250);

        //Setting displayed message
        Label label = new Label(message);

        //Creating a button to close the window
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> alertWindow.close());

        //Creating layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        //Creating a scene object
        Scene scene = new Scene(layout);
        alertWindow.setScene(scene);
        alertWindow.showAndWait();

    }
}
