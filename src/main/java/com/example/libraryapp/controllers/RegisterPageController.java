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

import java.util.regex.Pattern;

public class RegisterPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField cin;

    @FXML
    private TextField description;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private AnchorPane registerPageID;

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
    void onLoginLink(ActionEvent event) {
        try{
            this.switchPage(event, "login-page-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    void onRegister(ActionEvent event) {
        try{
            boolean isMatching=patternMatches(email.getText());
            boolean isSixDigits = password.getLength()>=6;
            if (isMatching && isSixDigits)
            {
                String passwordHash = PasswordHash.encrypte(password.getText());
                Admin s = new Admin(username.getText(),email.getText(),passwordHash,cin.getText(),description.getText());
                AdminDao dao=new AdminDao();
                boolean isRegistered = dao.save(s);
                if (isRegistered) {
                    this.switchPage(event, "home-view.fxml");
                }
                else  {
                    AlertMessage alertMessage=new AlertMessage("Whoops!", "", "Could not save your credentials, try again please");
                    alertMessage.displayWarning();
                }
            }
            else if (!isMatching){
                AlertMessage alertMessage=new AlertMessage("Whoops!", "", "Wrong email, please enter a valid one");
                alertMessage.displayWarning();
            }
            else {
                AlertMessage alertMessage=new AlertMessage("Whoops!", "", "The password should be at least characters, attackers are after us:(");
                alertMessage.displayWarning();
            }

        }catch (Exception e){
            AlertMessage alertMessage=new AlertMessage("Whoops!", "", "Something went wrong please try again");
            alertMessage.displayError();

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

    public static boolean patternMatches(String emailAddress) {
        String regexPattern = "^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

}
