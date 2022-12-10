package com.example.libraryapp.controllers;

import com.example.libraryapp.dao.impls.BookDao;
import com.example.libraryapp.dao.impls.StudentDao;
import com.example.libraryapp.models.Book;
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


    private List<Student> students() {
        List<Student> ls = new ArrayList<>();

        StudentDao dao = new StudentDao();
        List<List<String>> BookList = dao.getStudents();

        for (List<String> strings : BookList) {
            Student student = new Student();
            student.setUsername(strings.get(0));
            student.setDescription(strings.get(1));
            student.setImgsrc(strings.get(2));
            ls.add(student);
        }

        return ls;

    }
}
