package com.example.libraryapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane loginPageID;

    @FXML
    void onBack(ActionEvent event) {
        try{
            this.switchPage(event, "welcome-page-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void onGuestLink(ActionEvent event) {

    }

    @FXML
    void onLogin(ActionEvent event) {
        try{
            this.switchPage(event, "home-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void onRegisterLink(ActionEvent event) {
        try{
            this.switchPage(event, "register-page-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void switchPage(ActionEvent event, String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LmsApplication.class.getResource(pageName));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setWidth(700);
        stage.setHeight(550);
        stage.show();
    }

}
