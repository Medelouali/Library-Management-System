package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomePageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button guestID;

    @FXML
    private Button loginID;

    @FXML
    private Button registerID;

    @FXML
    private AnchorPane welcomeID;

    @FXML
    void onGuest(ActionEvent event) {
        try{
            this.switchPage(event, "guest-home-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    void onLogin(ActionEvent event) {
        try{
            this.switchPage(event, "login-page-view.fxml");
            //for testing
//            this.switchPage(event, "home-view.fxml");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    void onRegister(ActionEvent event) {
        try{
            this.switchPage(event, "register-page-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void switchPage(ActionEvent event, String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/"+pageName));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setWidth(1034);
        stage.setHeight(600);
        stage.show();
    }
}
