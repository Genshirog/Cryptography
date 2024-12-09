import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class Login {
    private final StackPane root;

    public Login(SceneManager sceneManager){
        root = new StackPane();
        root.getStyleClass().add("root_form");
        //Main VBox
        root.getChildren().add(login(sceneManager));
    }

    public Scene getScene() {
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        return scene;
    }

    public StackPane getRoot() {
        return root;
    }

    public VBox login(SceneManager sceneManager){
        Pane overlay = new Pane();
        overlay.getStyleClass().add("overlay");
        root.getChildren().add(overlay);
        VBox login_form = new VBox(10);
        login_form.getStyleClass().add("login_form");

        VBox logo_title_placement = new VBox();
        logo_title_placement.setAlignment(Pos.CENTER);
        logo_title_placement.setPrefHeight(200);
        logo_title_placement.setMaxWidth(600);

        HBox logo_title = new HBox(30);
        logo_title.setAlignment(Pos.CENTER);

        Pane logo = new Pane();
        logo.getStyleClass().add("logo");

        Label title = new Label("Cryptography Game");
        title.getStyleClass().add("title");
        logo_title.getChildren().addAll(logo,title);

        logo_title_placement.getChildren().add(logo_title);

        VBox input_detail = new VBox();
        input_detail.setMaxWidth(600);
        input_detail.setPrefHeight(250);

        VBox email_label = new VBox();
        email_label.setAlignment(Pos.CENTER_LEFT);
        email_label.setMaxWidth(600);
        Label email = new Label("Email:");
        email.getStyleClass().add("labels");
        email_label.getChildren().add(email);

        VBox textfield_email = new VBox();
        textfield_email.setAlignment(Pos.CENTER);
        textfield_email.setMaxWidth(600);
        TextField email_text = new TextField();
        email_text.setPromptText("Enter Email: ");
        email_text.getStyleClass().add("textField");
        textfield_email.getChildren().add(email_text);

        VBox password_label = new VBox();
        password_label.setAlignment(Pos.CENTER_LEFT);
        password_label.setMaxWidth(600);
        Label passwordLabel = new Label("Password:");
        passwordLabel.getStyleClass().add("labels");
        password_label.getChildren().add(passwordLabel);

        VBox textfield_password = new VBox();
        textfield_password.setAlignment(Pos.CENTER);
        textfield_password.setMaxWidth(600);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password: ");
        passwordField.getStyleClass().add("textField");
        textfield_password.getChildren().add(passwordField);

        input_detail.getChildren().addAll(email_label,textfield_email,password_label,textfield_password);

        VBox buttonArea = new VBox();
        buttonArea.setMaxWidth(600);
        buttonArea.setPrefHeight(250);

        HBox buttons = new HBox(30);  // 15px space between buttons
        buttons.setAlignment(Pos.CENTER);
        Button loginButton = new Button("Login");
        loginButton.getStyleClass().add("buttons");
        loginButton.setOnAction(event ->{
            sceneManager.show_main_app();
        });

        Button registerButton = new Button("Register");
        registerButton.setOnAction(event ->{
            root.getChildren().clear();
            root.getChildren().add(register(sceneManager));
        });

        registerButton.getStyleClass().add("buttons");
        buttons.getChildren().addAll(loginButton, registerButton);

        buttonArea.getChildren().add(buttons);
        login_form.getChildren().addAll(logo_title_placement,input_detail,buttonArea);
        return login_form;
    }

    public VBox register(SceneManager sceneManager){
        Pane overlay = new Pane();
        overlay.getStyleClass().add("overlay");
        root.getChildren().add(overlay);
        VBox login_form = new VBox(10);
        login_form.getStyleClass().add("login_form");

        VBox logo_title_placement = new VBox();
        logo_title_placement.setAlignment(Pos.CENTER);
        logo_title_placement.setPrefHeight(200);
        logo_title_placement.setMaxWidth(600);

        HBox logo_title = new HBox(30);
        logo_title.setAlignment(Pos.CENTER);

        Pane logo = new Pane();
        logo.getStyleClass().add("logo");

        Label title = new Label("Cryptography Game");
        title.getStyleClass().add("title");
        logo_title.getChildren().addAll(logo,title);

        logo_title_placement.getChildren().add(logo_title);

        VBox input_detail = new VBox(20);
        input_detail.setMaxWidth(600);
        input_detail.setPrefHeight(400);

        HBox fullname_container = new HBox(100);
        Label fullname = new Label("FULL NAME: ");
        fullname.getStyleClass().add("labels");
        TextField fullname_text = new TextField();
        fullname_text.getStyleClass().add("textField");
        HBox.setHgrow(fullname_text,Priority.ALWAYS);
        fullname_container.getChildren().addAll(fullname,fullname_text);

        HBox username_container = new HBox(100);
        Label username = new Label("USERNAME: ");
        username.getStyleClass().add("labels");
        TextField username_text = new TextField();
        username_text.getStyleClass().add("textField");
        HBox.setHgrow(username_text,Priority.ALWAYS);
        username_container.getChildren().addAll(username,username_text);

        HBox email_container = new HBox(150);
        Label email = new Label("EMAIL: ");
        email.getStyleClass().add("labels");
        TextField email_text = new TextField();
        email_text.getStyleClass().add("textField");
        HBox.setHgrow(email_text,Priority.ALWAYS);
        email_container.getChildren().addAll(email,email_text);

        HBox password_container = new HBox(100);
        Label password = new Label("PASSWORD: ");
        password.getStyleClass().add("labels");
        PasswordField password_field = new PasswordField();
        password_field.getStyleClass().add("textField");
        HBox.setHgrow(password_field,Priority.ALWAYS);
        password_container.getChildren().addAll(password,password_field);

        HBox re_password_container = new HBox();
        Label re_password = new Label("RE-ENTER PASSWORD: ");
        re_password.getStyleClass().add("labels");
        PasswordField re_password_field = new PasswordField();
        re_password_field.getStyleClass().add("textField");
        HBox.setHgrow(re_password_field,Priority.ALWAYS);
        re_password_container.getChildren().addAll(re_password,re_password_field);

        input_detail.getChildren().addAll(fullname_container,username_container,email_container,password_container,re_password_container);

        VBox buttonArea = new VBox();
        buttonArea.setMaxWidth(600);
        buttonArea.setPrefHeight(100);

        HBox buttons = new HBox(30);  // 15px space between buttons
        buttons.setAlignment(Pos.CENTER);
        Button loginButton = new Button("Sign-in");
        loginButton.setOnAction(event ->{
            root.getChildren().clear();
            root.getChildren().add(login(sceneManager));
        });
        loginButton.getStyleClass().add("buttons");

        Button registerButton = new Button("Sign-up");
        registerButton.setOnAction(event -> {
            //Create a database here
        });

        registerButton.getStyleClass().add("buttons");
        buttons.getChildren().addAll(loginButton, registerButton);

        buttonArea.getChildren().add(buttons);
        login_form.getChildren().addAll(logo_title_placement,input_detail,buttonArea);
        return login_form;
    }
}
