package com.tums.users;

import com.tums.Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminUserGui extends Application {
    private final BorderPane rootPane;

    public AdminUserGui() {
        rootPane = new BorderPane();

        //Creating top hbox
        HBox topBox = new HBox();
        topBox.setPadding(new Insets(15,12,15,12));
        topBox.setSpacing(10);
        topBox.setStyle("-fx-background-color: #336699;");

        //Setting alignment of the button
        topBox.setAlignment(Pos.CENTER_RIGHT);

        //Creating button
        Button logOut = new Button("Log out");

        //Adding node to top of the gridpane
        topBox.getChildren().addAll(logOut);


        //Creating bottom hbox
        HBox bottomBox = new HBox();
        bottomBox.setPadding(new Insets(15, 12, 15, 12));
        bottomBox.setSpacing(10);
        bottomBox.setStyle("-fx-background-color: #336699;");

        //Creating text fields
        TextField inputName = new TextField();
        inputName.setPromptText("Name");

        TextField inputLastName = new TextField();
        inputLastName.setPromptText("Last name");

        TextField inputEmail = new TextField();
        inputEmail.setPromptText("e-mail");

        TextField inputBirthDate = new TextField();
        inputBirthDate.setPromptText("Birthdate");

        //Creating buttons
        Button buttonAdd = new Button("Add Student");
        buttonAdd.setPrefSize(100, 20);

        Button buttonDelete = new Button("Delete");
        buttonDelete.setPrefSize(100, 20);

        //Adding nodes to bottom of the gridpane
        bottomBox.getChildren().addAll(inputName, inputLastName, inputEmail, inputBirthDate, buttonAdd, buttonDelete);
        rootPane.setBottom(bottomBox);
        rootPane.setTop(topBox);


    }


    public Pane getRootPane(){
        return rootPane;
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
