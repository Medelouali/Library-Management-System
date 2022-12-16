package com.example.libraryapp.controllers;

import com.example.libraryapp.dao.impls.BookDao;
import com.example.libraryapp.models.Book;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentSearchPageController extends HomeController implements Initializable {
    private static String searchField;

    public static String getSearchField() {
        return searchField;
    }

    public static void setSearchField(String searchField) {
        StudentSearchPageController.searchField = searchField;
    }

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
                this.BookLayout.getChildren().add(cardboard);
            }
        }catch (IOException e){
            e.printStackTrace();

        }
    }

    public List<Book> books(){
        BookDao dao= new BookDao();
        List<Book> ls = dao.SearchBook(getSearchField());
        return ls;

    }
}
