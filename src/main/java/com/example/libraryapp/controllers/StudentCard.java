package com.example.libraryapp.controllers;

import com.example.libraryapp.Main;
import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.impls.StudentDaoImpl;

import com.example.libraryapp.models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;


public class StudentCard {
    private Stage stage;
    private Scene scene;
    private Parent root;
    static public long id_profile_button;
    @FXML
    private HBox Box;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private ImageView studentImg;

    @FXML
    private Label studentIntro;

    @FXML
    private Label studentName;
@FXML
    void onprofile(ActionEvent event) {

        id_profile_button=Long.parseLong(ProfileButton.getId());

        try{
            this.switchPage(event, "profile.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }}
    @FXML
    void onDelete(ActionEvent event) {
        Dao<Student> dao=new StudentDaoImpl();
        ((StudentDaoImpl)(dao)).deleteByUsername(studentName.getText());

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


    public void SetData(Student student){
        Image image= new Image(getClass().getResourceAsStream(student.getImgsrc()));

        studentImg.setImage(image);
        studentName.setText(student.getUsername());
        studentIntro.setText(student.getIntro());

        ProfileButton.setId(Long.toString(student.getId()));


    }


}
