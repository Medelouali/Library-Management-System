package com.example.libraryapp.controllers;


import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.Statement;



public class StatisticBookController extends HomeController {

    @FXML
    private TableView<Book> tablebook;
    @FXML
    private TableColumn<Book, String> title;
    @FXML
    private TableColumn<Book, String> language;
    @FXML
    private TableColumn<Book, Long> copiesNumber;
    @FXML
    private TableColumn<Book, Double> rating;

    public ObservableList<Book> datab = FXCollections.observableArrayList();


    @FXML
    void showAllBooks(ActionEvent event) {

        ConnectionDB conDb = new ConnectionDB();

        Statement st;
        try {
            st = conDb.getCon().createStatement();
            String statement = "select * from books ";
            ResultSet rs = st.executeQuery(statement);
            while (rs.next()) {
                datab.add(new Book(rs.getDouble("rating"), rs.getString("title"), rs.getString("language"), rs.getLong("copyAmount"))); //title,language,number of copies,rating
            }
            conDb.getCon().close();
        } catch (Exception ec) {
            ec.printStackTrace();
        }

        title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        language.setCellValueFactory(new PropertyValueFactory<Book, String>("language")); //1 : nom de (id)colonne , 2 est textfield
        copiesNumber.setCellValueFactory(new PropertyValueFactory<Book, Long>("copiesNumber"));
        rating.setCellValueFactory(new PropertyValueFactory<Book, Double>("rating"));
        tablebook.setItems(datab);
    }


    @FXML
    void onStatisticsStudents(ActionEvent event) {
        try {
            this.switchPage(event, "statistics-students-view.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onStatisticsBooks(ActionEvent event) {
        try {
            this.switchPage(event, "statistics-books-view.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}









