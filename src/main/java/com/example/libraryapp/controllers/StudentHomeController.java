package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StudentHomeController extends BookController {
    @FXML
    void onBooks(ActionEvent event) {
        try{
            this.switchPage(event, "student-book-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
