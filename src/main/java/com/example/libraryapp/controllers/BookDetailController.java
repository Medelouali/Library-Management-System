package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import com.example.libraryapp.dao.impls.BookDao;
import com.example.libraryapp.models.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class BookDetailController implements Initializable {
    private Stage stage;

    @FXML
    private ImageView BookImg;
    @FXML
    private Label ISBN;

    @FXML
    private Label author;

    @FXML
    private Label copyamount;

    @FXML
    private Label edition;

    @FXML
    private Label genre;

    @FXML
    private Label language;

    @FXML
    private Label pubyear;

    @FXML
    private Label title;

    @FXML
    void back(ActionEvent event) {
        try{
            this.switchPage(event, "books-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }}


        public void switchPage(ActionEvent event, String pageName) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/"+pageName));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setWidth(700);
            stage.setHeight(550);
            stage.show();
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BookDao bookdao=new BookDao();
        Book book=bookdao.getBookById(CardBookController.id_button);
        Image image= new Image(getClass().getResourceAsStream(book.getImgSrc()));
        BookImg.setImage(image);
        ISBN.setText(book.getIsbn());
        author.setText(book.getAuthorName());
        edition.setText(book.getEdition());
        copyamount.setText(Long.toString(book.getCopiesNumber()));
        genre.setText(book.getGenre());
        language.setText(book.getLanguage());
        title.setText(book.getTitle());
        pubyear.setText(book.getDatePub());

    }
}
