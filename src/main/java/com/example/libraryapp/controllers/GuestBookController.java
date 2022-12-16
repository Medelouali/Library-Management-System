package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import com.example.libraryapp.dao.impls.BookDao;
import com.example.libraryapp.models.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GuestBookController extends BookController {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Book> books= new ArrayList<>(books());
        try {
            for(int i =0 ;i<books.size();i++){
                FXMLLoader fxmlLoader= new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/libraryapp/views/GuestCardBook.fxml"));
//                fxmlLoader.setLocation(getClass().getResource("views/CardBook.fxml"));
                HBox cardboard =fxmlLoader.load();
                CardBookController cardBookController = fxmlLoader.getController();
                cardBookController.SetData(books.get(i));
                BookLayout.getChildren().add(cardboard);
            }
        }catch (IOException e){
            e.printStackTrace();

        }

    }


}
