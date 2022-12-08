package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.impls.BookDao;
import com.example.libraryapp.dao.impls.StudentDao;
import com.example.libraryapp.models.Book;
import com.example.libraryapp.models.Student;
import com.example.libraryapp.utils.AlertMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
    private TextField bookNameId;
    @FXML
    private TextField isbnId;
    @FXML
    private TextField copiesNumberId;

    @FXML
    private Button settingsId;

    @FXML
    private Button statisticsId;

    @FXML
    private Button studentsId;

    @FXML
    private Button transactionsId;

    //comment
    @FXML
    private Button ReturnBookSubmitId;

    @FXML
    private TextField returnBookAuthorId;
    @FXML
    private TextField returnStudentCinId;


    @FXML
    private TextField returnBookTitleId;

    @FXML
    private TextField returnIsbnNumberId;

    @FXML
    private DatePicker returnReturnDateId;

    @FXML
    private RadioButton returnStateId;

    @FXML
    private TextField returnStudentNameId;

    @FXML
    private HBox vBoxBodyId;
    @FXML
    void onAddCopies(ActionEvent event) {
        try{
            this.switchPage(event, "add-copies-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
            //addCopiesSubmit
        }
    }

    @FXML
    void onAddCopiesSubmit(ActionEvent event) {
        System.out.println("Submitting the data:");

        System.out.println(bookNameId.getText());
        System.out.println(isbnId.getText());
        System.out.println(copiesNumberId.getText());

        //adding copies to copyAmount in books
        long copiesToAdd=0;
        try{
            copiesToAdd=Long.parseLong(copiesNumberId.getText());
        }catch (Exception e){
            AlertMessage msg=new AlertMessage("Whoops!", "", "Please the number of copies to add should be an integer like 10 for example");
            msg.displayWarning();
            return;
        }
        Dao<Book> bookDao=new BookDao();
        ((BookDao)bookDao).addCopies(new Book(7, bookNameId.getText(), copiesToAdd));

        //generating copies a n x times
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
            this.switchPage(event, "welcome-page-view.fxml");
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

    //steps(after submission of the onReturnBookSubmit is triggered):
    //1-check if the given user has already actually borrowed a book
    // if yes: delete borrowed book and make the copy available again for use
    // if not display a popup message.
    @FXML
    void onReturnBookSubmit(ActionEvent event) {
        // Just for testing these souts
        System.out.println("Submitting the data:");
        System.out.println("returnStudentNameId: " + returnStudentNameId.getText());
        System.out.println("returnStudentCinId: " + returnStudentCinId.getText());
        System.out.println("returnBookTitleId: " + returnBookTitleId.getText());
        System.out.println("returnBookAuthorId: " + returnBookAuthorId.getText());
        System.out.println("returnIsbnNumberId: " + returnIsbnNumberId.getText());
        System.out.println("returnReturnDateId: " + returnReturnDateId.getEditor().getText());
        System.out.println("returnStateId: " + returnStateId.isSelected());

        Dao<Student> daoSt=new StudentDao();
        String msg=((StudentDao)daoSt).hasAlreadyBorrowedBook(
                new Student(returnStudentNameId.getText(), returnStudentCinId.getText()),
                returnBookTitleId.getText(),
                returnBookAuthorId.getText(),
                returnIsbnNumberId.getText(),
                returnStateId.isSelected(),
                returnReturnDateId.getEditor().getText());
        if(msg.isEmpty()){
            AlertMessage alertMessage=new AlertMessage("Congrats", "",
                    "The book has been saved back successfully, hope someone would come to get it:)");
            alertMessage.displayConfirmation();
        }else{
            AlertMessage alertMessage=new AlertMessage("Whoops!", "", msg);
            alertMessage.displayWarning();
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/"+pageName));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setWidth(700);
        stage.setHeight(550);
        stage.show();
    }

}
