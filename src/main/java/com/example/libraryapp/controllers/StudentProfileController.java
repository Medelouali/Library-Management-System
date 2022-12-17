package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import com.example.libraryapp.dao.impls.StudentDao;
import com.example.libraryapp.models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentProfileController implements Initializable {

    private Stage stage;
    @FXML
    private Label cin;

    @FXML
    private Label date;

    @FXML
    private Label description;
    @FXML
    private Label username;
    @FXML
    private Label maxborrowed;

    @FXML
    private Label email;

    @FXML
    private ImageView studentImg;



    @FXML
    void back(ActionEvent event) {
        try{
            this.switchPage(event, "students-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }}


    public void switchPage(ActionEvent event, String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/"+pageName));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setWidth(1034);
        stage.setHeight(600);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StudentDao studentDao=new StudentDao();
        Student student=studentDao.getStudentById(StudentCard.id_profile_button);
        Image image= new Image(getClass().getResourceAsStream(student.getImgsrc()));
        studentImg.setImage(image);
        cin.setText(student.getCin());
        username.setText(student.getUsername());
        date.setText(String.valueOf(student.getTimeStamp()));
        maxborrowed.setText(String.valueOf(student.getBooksNumber()));
        description.setText(student.getDescription());
        email.setText(student.getEmail());




    }
}
