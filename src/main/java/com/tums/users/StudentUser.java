package com.tums.users;

import com.tums.Database;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class StudentUser extends  BasicUser {
    protected List<StudentUser> studentUserList;
    public StudentUser(int id, String name, String lastName, String email, String password, LocalDate birthdate) {
        super(id, name, lastName, email, password, birthdate);
        this.studentUserList=new LinkedList<>();
    }
    public StudentUser(){
        super();
    }

    public void addStudentWindow() {
        Stage addStudentWindow = new Stage();

        //Making window modal
        addStudentWindow.initModality(Modality.APPLICATION_MODAL);


        //Setting title
        addStudentWindow.setTitle("Adding form");

        //Creating nodes
        Text name = new Text("Name:");

        TextField inputName = new TextField();
        inputName.setPromptText("Enter your name");

        Text lastName = new Text("Last name:");

        TextField inputLastName = new TextField();
        inputLastName.setPromptText("Enter your last name");

        Text email = new Text("E-mail:");

        TextField inputEmail = new TextField();
        inputEmail.setPromptText("Enter your e-mail");

        Text password = new Text("Password:");

        PasswordField inputPassword = new PasswordField();
        inputPassword.setPromptText("Enter your password");

        Text passwordVerification = new Text("Retype your password:");

        PasswordField inputPasswordVerification = new PasswordField();
        inputPasswordVerification.setPromptText("Password verification");

        Text birthDay = new Text("Date of birth:");

        TextField inputBirthDay = new TextField();
        inputBirthDay.setPromptText("Format YYYY-MM-DD");

        //Creating center of layout
        GridPane center = new GridPane();
        center.add(name,0,0);
        center.add(inputName,1,0);
        center.add(lastName,0,1);
        center.add(inputLastName,1,1);
        center.add(email,0,2);
        center.add(inputEmail,1,2);
        center.add(password,0,3);
        center.add(inputPassword,1,3);
        center.add(passwordVerification,0,4);
        center.add(inputPasswordVerification,1,4);
        center.add(birthDay,0,5);
        center.add(inputBirthDay,1,5);
        center.setAlignment(Pos.CENTER);
        center.setPadding(new Insets(10,10,10,10));
        center.setVgap(5);
        center.setHgap(10);


        //Creating bottom of layout
        VBox bottom = new VBox();
        Button add = new Button("Add");
        bottom.getChildren().add(add);
        bottom.setAlignment(Pos.CENTER_RIGHT);
        add.setOnAction(e ->{
            Database.addStudent(
                    inputName.getText().trim(),
                    inputLastName.getText().trim(),
                    inputEmail.getText().trim(),
                    inputPassword.getText().trim(),
                    inputBirthDay.getText().trim());
        });


        //Creating layout
        BorderPane layout = new BorderPane();
        layout.setCenter(center);
        layout.setBottom(bottom);
        layout.setMinWidth(400);
        layout.setMinHeight(600);
        layout.setPadding(new Insets(10,10,10,10));

        //Creating a scene object
        Scene scene = new Scene(layout);
        addStudentWindow.setScene(scene);
        addStudentWindow.showAndWait();

    }
}
