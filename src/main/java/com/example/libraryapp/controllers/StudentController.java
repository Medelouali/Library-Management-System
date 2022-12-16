package com.example.libraryapp.controllers;

import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Student;
import com.example.libraryapp.utils.AlertMessage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController extends HomeController implements Initializable {
    @FXML
    private VBox StudentLayout;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        students = new ArrayList<>(students());
        try {
            for(int i =0 ;i<students.size();i++){
                FXMLLoader fxmlLoader= new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/libraryapp/views/StudentCard.fxml"));

                VBox cardBox =fxmlLoader.load();
                StudentCard cardBookController =fxmlLoader.getController();
                cardBookController.SetData(students.get(i));
                StudentLayout.getChildren().add(cardBox);
            }
        }catch (IOException e){
            e.printStackTrace();

        }

    }

    private List<Student> students(){
        List<Student> ls = new ArrayList<>();
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            String req="select * from students;";
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                Student student =new Student();
                student.setImgsrc(rs.getString("picture"));
                student.setUsername(rs.getString("username"));
                student.setIntro(rs.getString("description"));
                student.setId(Long.parseLong(rs.getString("id")));

                ls.add(student);
            }
            conDb.getCon().close();
            return ls;
        }catch (Exception ec){
            ec.printStackTrace();
            AlertMessage alertMessage=new AlertMessage("Whoops!", "", "Could fetch the books from the database, plz try again");
            alertMessage.displayWarning();
            return ls;
        }
    }
}
