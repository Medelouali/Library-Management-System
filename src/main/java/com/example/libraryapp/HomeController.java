package com.example.libraryapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button addCopiesId;

    @FXML
    private Button booksId;

    @FXML
    private Text browserId;

    @FXML
    private Button issueBookId;

    @FXML
    private Button logoutId;

    @FXML
    private Button newBookId;

    @FXML
    private Button newStudentId;

    @FXML
    private Button returnBookId;

    @FXML
    private Button searchButtonId;

    @FXML
    private TextField searchId;

    @FXML
    private Button settingsId;

    @FXML
    private Button statisticsId;

    @FXML
    private Button studentsId;

    @FXML
    private Button transactionsId;

    @FXML
    void onAddCopies(ActionEvent event) {
        try{
            this.switchPage(event, "add-copies-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onBooks(ActionEvent event) {
        try{
            this.switchPage(event, "books-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onIssueBook(ActionEvent event) {
        try{
            this.switchPage(event, "issue-book-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onLogout(ActionEvent event) {
        try{
            this.switchPage(event, "logout-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onNewBook(ActionEvent event) {
        try{
            this.switchPage(event, "new-book-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onNewStudent(ActionEvent event) {
        try{
            this.switchPage(event, "new-student-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onReturnBook(ActionEvent event) {
        try{
            this.switchPage(event, "return-book-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onSearch(ActionEvent event) {
        try{
            this.switchPage(event, "search-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onSettings(ActionEvent event) {
        try{
            this.switchPage(event, "settings-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onStatistics(ActionEvent event) {
        try{
            this.switchPage(event, "statistics-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onStudents(ActionEvent event) {
        try{
            this.switchPage(event, "students-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onTransactions(ActionEvent event) {
        try{
            this.switchPage(event, "transactions-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void switchPage(ActionEvent event, String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LmsApplication.class.getResource(pageName));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setWidth(700);
        stage.setHeight(550);
        stage.show();
    }

}
