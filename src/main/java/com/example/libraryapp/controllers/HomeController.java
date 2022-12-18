package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.impls.*;
import com.example.libraryapp.models.Book;
import com.example.libraryapp.models.Borrowings;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HomeController {
    protected Stage stage;

    private Scene scene;
    private Parent root;
    @FXML
    private Button addCopiesId;

    @FXML
    protected VBox TransactionsLayout;
    @FXML
    protected VBox BookLayout;
    protected List<Book> Books;
    @FXML
    protected VBox StudentLayout;
    protected List<Student> students;

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
    protected TextField searchId;


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
    private TextField newStudentCinId;

    @FXML
    private TextField newStudentDescriptionId;

    @FXML
    private TextField newStudentEmailId;


    @FXML
    private TextField newStudentPasswordId;

    @FXML
    private TextField newStudentUsernameId;



    @FXML
    private TextField newBookAuthorId;

    @FXML
    private TextField newBookGenreId;

    @FXML
    private TextField newBookTitleId;

    @FXML
    private TextField newCopiesNumberId;

    @FXML
    private TextField newDatePubId;

    @FXML
    private TextField newIsbnId;

    @FXML
    private TextField newLanguageId;

    @FXML
    private TextField newRatingId;


    // --------- Issue Book Element ---------- //
    @FXML
    private Button IssueBookSubmitId;
    @FXML
    private DatePicker issueBorrowDateId;
    @FXML
    private TextField issueCinStudentId;
    @FXML
    private TextField issueIsbnNumberId;
    @FXML
    private DatePicker issueReturnDateId;
    // ------------------------------------- //

    @FXML
    void onAddCopies(ActionEvent event) {
        try{
            this.switchPage(event, "add-copies-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
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


    }

    @FXML
    void onBooks(ActionEvent event) {
        int privileges = Main.getUser().getPrivileges();
        try{
            switch (privileges){
                case 1 -> this.switchPage(event, "student-book-view.fxml");
                case 2, 3 -> this.switchPage(event, "books-view.fxml");
            }

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

    // -----  button Issue Book Submit ----- //
    @FXML
    void onIssueBookSubmit(ActionEvent event) {
        // -------------- just to see if there's a return ------------------- //
        String isbnID= issueIsbnNumberId.getText();//isbn of the book
        String cinID= issueCinStudentId.getText();//cin of the student

        String BrDate = issueBorrowDateId.getEditor().getText();//date of borrow

        String RtDate = issueReturnDateId.getEditor().getText();//date of return


        // the connection to BD and save into DB //
        BorrowingsDao DaoBr=new BorrowingsDao();



        Borrowings Br=new Borrowings(BrDate, RtDate, isbnID, cinID);
        Boolean h= DaoBr.save(Br);
        // ------------------------------------ //


    }
    // ------------------------------------ //

    @FXML
    void onLogout(ActionEvent event) {
        try{
            Main.unsetUser();
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
            int privileges = Main.getUser().getPrivileges();
            switch (privileges) {
                case 1 -> {
                    StudentSearchPageController.setSearchField(searchId.getText());
                    this.switchPage(event, "student-search-view.fxml");
                }
                case 2, 3 -> {
                    SearchController.setSearchField(searchId.getText());
                    this.switchPage(event, "search-view.fxml");
                }
                default -> {
                    SearchController.setSearchField(searchId.getText());
                    this.switchPage(event, "guest-search-view.fxml");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onSearchTyping(KeyEvent event) {
        System.out.println("Typing");
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
            this.switchPage(event, "statistics-books-view.fxml");

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

    @FXML
    void onSaveNewBook(ActionEvent event) {
        System.out.println("Hii new book");
        //we ll check for parsing int exception later!
        try{
            Book book = new Book(Double.parseDouble(newRatingId.getText()), newBookTitleId.getText(),
                    newBookAuthorId.getText(), newBookGenreId.getText(), newIsbnId.getText(),
                    newLanguageId.getText(), Long.parseLong(newCopiesNumberId.getText()), newDatePubId.getText());
            Dao<Book> da = new BookDaoImpl();
            da.save(book);
        }catch (Exception e){
            AlertMessage alertMessage=new AlertMessage("Whoops:(", "", "The rating should be a decimal value like 2.5, please try again");
            alertMessage.displayWarning();
        }

    }

    @FXML
    void onSaveNewStudent(ActionEvent event) {
        System.out.println("Hii New Student");
        Student student = new Student(newStudentUsernameId.getText(),
                newStudentEmailId.getText(), newStudentPasswordId.getText(),
                newStudentCinId.getText(), newStudentDescriptionId.getText());
        Dao<Student> dao = new StudentDaoImpl();
        if ( ((StudentDaoImpl)dao).validateEmail(student)){
            dao.save(student);
        }else{
            AlertMessage alertMessage=new AlertMessage("Whoops!", "", "Wrong email, please enter a valid one");
            alertMessage.displayWarning();
        }
    }

    public void switchPage(ActionEvent event, String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/"+pageName));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setWidth(1034);
        stage.setHeight(600);

        stage.show();
    }



}
