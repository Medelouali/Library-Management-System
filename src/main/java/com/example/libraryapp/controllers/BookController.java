package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import com.example.libraryapp.dao.impls.BookDao;
import com.example.libraryapp.models.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BookController extends HomeController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Books = new ArrayList<>(books());
        try {
            for(int i =0 ;i<Books.size();i++){
                FXMLLoader fxmlLoader= new FXMLLoader();
                //fxmlLoader.setLocation(getClass().getResource("views/CardBook.fxml"));
                fxmlLoader.setLocation(getClass().getResource("/com/example/libraryapp/views/CardBook.fxml"));
                HBox cardboard =fxmlLoader.load();
                CardBookController cardBookController =fxmlLoader.getController();
                cardBookController.SetData(Books.get(i));
                BookLayout.getChildren().add(cardboard);



            }
        }catch (IOException e){
            e.printStackTrace();

        }

    }

    private List<Book> books(){
        List<Book> ls = new ArrayList<>();

        BookDao dao= new BookDao();
        List<List<String>> BookList = dao.getBooks();

        for (List<String> strings : BookList) {
            Book book = new Book();
            book.setTitle(strings.get(0));
            book.setAuthorName(strings.get(1));
            book.setImgSrc(strings.get(2));
            book.setDatePub(strings.get(3));
            ls.add(book);
        }

        return ls;

    }



}
