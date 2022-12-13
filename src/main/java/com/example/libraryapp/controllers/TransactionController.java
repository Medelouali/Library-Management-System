package com.example.libraryapp.controllers;

import com.example.libraryapp.models.Transaction;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TransactionController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private HBox box;

    @FXML
    private Label transAdminNameId;

    @FXML
    private ImageView transBookImgId;

    @FXML
    private Label transBookTitleId;

    @FXML
    private Label transStudentCinId;

    @FXML
    private Label transStudentNameId;

    @FXML
    private Label transtimestampId;

    public void setData(Transaction transaction){
        Image image= new Image(getClass().getResourceAsStream(transaction.getBookCoverPath()));
        transBookImgId.setImage(image);
        transAdminNameId.setText(transaction.getAdminName());
        transBookTitleId.setText(transaction.getBookTitle());
        transStudentCinId.setText(transaction.getStudentCin());
        transStudentNameId.setText(transaction.getStudentName());
        transtimestampId.setText(transaction.getTimeStamp());

    }

}
