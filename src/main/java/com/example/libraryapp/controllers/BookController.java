package com.example.libraryapp.controllers;

import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Book;

import com.example.libraryapp.utils.AlertMessage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
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
                //fxmlLoader.setLocation(getClass().getResource("views/CardBook.fxml"));
                fxmlLoader.setLocation(getClass().getResource("/com/example/libraryapp/views/CardBook.fxml"));
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
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            String req="select * from books;";
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                Book book =new Book();
                book.setImgSrc(rs.getString("picture"));
                book.setAuthorName(rs.getString("author"));
                book.setDatePub(rs.getString("datePub"));
                book.setTitle(rs.getString("title"));
                ls.add(book);
            }
            conDb.getCon().close();
            return ls;
        }catch (Exception ec){
            ec.printStackTrace();
            AlertMessage alertMessage=new AlertMessage("Whoops!", "", "Could fetch the books from the database, plz try again");
            alertMessage.displayWarning();
            return ls;
        }



    }

}
