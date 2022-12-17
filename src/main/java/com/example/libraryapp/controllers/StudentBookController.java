package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import com.example.libraryapp.dao.impls.BookDao;
import com.example.libraryapp.models.Book;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentBookController extends StudentHomeController{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Book> books= new ArrayList<>(books());
        try {
            for(int i =0 ;i<books.size();i++){
                FXMLLoader fxmlLoader= new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/libraryapp/views/CardBook.fxml"));
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
    List<Book> books(){
        List<Book> ls = new ArrayList<>();

        BookDao dao= new BookDao();
        List<Book> BookList = dao.getBorrowedBooks(Main.getUser().getId());

        return BookList;

    }
}
