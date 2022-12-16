package com.example.libraryapp;

import com.example.libraryapp.models.Admin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Admin user = new Admin();

    public static void setUser(Admin user) {
        Main.user = user;
    }
    public static void unsetUser() {
        Main.user = new Admin();
    }
    public static Admin getUser() {
        return user;
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/welcome-page-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Java Library Management System");
        stage.setScene(scene);
        stage.setWidth(700);
        stage.setHeight(550);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}