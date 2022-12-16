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

public class BookController extends HomeController implements Initializable {


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
