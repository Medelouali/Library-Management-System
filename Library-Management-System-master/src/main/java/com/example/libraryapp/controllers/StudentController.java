package com.example.libraryapp.controllers;

import com.example.libraryapp.models.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController extends HomeController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        students = new ArrayList<>(students());
        try {
            for(int i =0 ;i<students.size();i++){
                FXMLLoader fxmlLoader= new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/libraryapp/views/StudentCard.fxml"));

                VBox Cardbox =fxmlLoader.load();
                StudentCard cardBookController =fxmlLoader.getController();
                cardBookController.SetData(students.get(i));
                StudentLayout.getChildren().add(Cardbox);



            }
        }catch (IOException e){
            e.printStackTrace();

        }

    }


    private List<Student> students(){
        List<Student> ls = new ArrayList<>();
        Student student =new Student();
        student.setImgsrc("/com/example/libraryapp/assets/profile.png");
        student.setUsername("VICTOR HUGO");
        student.setIntro("intro wil be here .....");
        ls.add(student);

        student =new Student();
        student.setImgsrc("/com/example/libraryapp/assets/profile.png");
        student.setUsername("VICTOR HUGO");
        student.setIntro("intro wil be here .....");
        ls.add(student);

        student =new Student();
        student.setImgsrc("/com/example/libraryapp/assets/profile.png");
        student.setUsername("VICTOR HUGO");
        student.setIntro("intro wil be here .....");
        ls.add(student);


        return ls;

    }
}
