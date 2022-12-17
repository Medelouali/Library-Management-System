package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import com.example.libraryapp.models.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CardBookController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    static public long id_button;
    @FXML
    private ImageView BookImg;

    @FXML
    private Label BookTitle;

    @FXML
    private Label PubYear;

    @FXML
    private Label bookAuthor;

    @FXML
    private HBox box;

    @FXML
    private Button details;
    private String color ="FFFFFF";
    @FXML
    void ondetails(ActionEvent event) {

        id_button=Long.parseLong(details.getId());
        try{
            this.switchPage(event, "book-details-view.fxml");

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


    public void SetData(Book book){
            Image image= new Image(getClass().getResourceAsStream(book.getImgSrc()));
            BookImg.setImage(image);
            BookTitle.setText(book.getTitle());
            PubYear.setText("PubYear : "+book.getDatePub());
            bookAuthor.setText("Author : " +book.getAuthorName());

            details.setId(Long.toString(book.getId()));
            box.setStyle("-fx-background-color : #"+color);

        }


}
