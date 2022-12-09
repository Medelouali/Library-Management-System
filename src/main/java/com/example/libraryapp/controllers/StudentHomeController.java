package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentHomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button booksId;

    @FXML
    private Text browserId;

    @FXML
    private Button logoutId;

    @FXML
    private Button searchButtonId;

    @FXML
    private TextField searchId;

    @FXML
    private HBox vBoxBodyId;

    @FXML
    void onBooks(ActionEvent event) {

    }

    @FXML
    void onLogout(ActionEvent event) {
        try{
            this.switchPage(event, "welcome-page-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onSearch(ActionEvent event) {

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
