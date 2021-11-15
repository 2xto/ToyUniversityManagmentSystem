package com.tums;

import com.tums.users.AdminUserGui;
import com.tums.users.StudentUser;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    Stage window;
    public static void main(String[] args) {

        Database.createDatabase();
        Database.createTable();
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //Creating labels
        Text textId = new Text("E-mail:");
        Text textPassword = new Text("Password:");

        //Creating text fields
        TextField inputId = new TextField();
        inputId.setPromptText("Enter your e-mail");
        PasswordField inputPassword = new PasswordField();
        inputPassword.setPromptText("Enter your password");

        //Setting tooltips for log in window
        Tooltip passwordTooltip = new Tooltip("Contact administrator if you want to change your data.");
        passwordTooltip.setShowDelay(Duration.millis(200));
        inputPassword.setTooltip(passwordTooltip);

        //Creating buttons
        Button logInButton = new Button("Log in");
        Button createUserButton = new Button("Create User");

        //Setting button actions
        logInButton.setOnAction(e -> {
            AdminUserGui userGui = new AdminUserGui();
            primaryStage.getScene().setRoot(userGui.getRootPane());
            });
        createUserButton.setOnAction(e->{
            StudentUser student = new StudentUser();
            student.addStudentWindow();
        });

        //Creating GridPane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(800,600);

        //Setting the padding
        gridPane.setPadding(new Insets(10,10,10,10));

        //Setting horizontal and vertical gap
        gridPane.setVgap(8);
        gridPane.setHgap(20);

        //Setting the grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all nodes in the grid
        gridPane.add(textId,0,0);
        gridPane.add(textPassword,0,1);
        gridPane.add(inputId,1,0);
        gridPane.add(inputPassword,1,1);
        gridPane.add(logInButton,1,2);
        gridPane.add(createUserButton,0,2);

        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting scene title
        window.setTitle("Toy University Management System");

        //Preventing for too small window
        window.setMinWidth(800);
        window.setMinHeight(600);


        //Setting alert on exit program
        window.setOnCloseRequest(e->{
            e.consume();
            closeProgram();
        });

        //Adding scene to the stage
        window.setScene(scene);

        window.show();

    }

    private void closeProgram() {
        boolean result = ConfirmBox.showConfirmation("Alert","Confirm exiting the program");
        if(result) {
            window.close();
        }
    }
}