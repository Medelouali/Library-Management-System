package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;

import com.example.libraryapp.dao.impls.AdminDao;
import com.example.libraryapp.models.Admin;

import com.example.libraryapp.utils.AlertMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private TextField email;

    @FXML
    private PasswordField password;

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

            String passwordHash = PasswordHash.encrypte(password.getText());
            AdminDao dao = new AdminDao();
            Admin admin = dao.checkLogin(new Admin(email.getText(),passwordHash));
            int exists = admin.getPrivileges();
            if (exists!=0)
            {
                Main.setUser(admin);
                switch (exists) {
                    case 1 -> this.switchPage(event, "student-home-view.fxml");
                    case 2, 3 -> this.switchPage(event, "home-view.fxml");
                }
            }
            else {
                AlertMessage alertMessage=new AlertMessage("Holy Molly!", "", "You do not have an account please sign up first:)");
                alertMessage.displayWarning();
            }

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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/"+pageName));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setWidth(700);
        stage.setHeight(550);
        stage.show();
    }

}
