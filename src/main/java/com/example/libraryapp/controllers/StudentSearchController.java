package com.example.libraryapp.controllers;

import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Student;
import com.example.libraryapp.utils.AlertMessage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentSearchController extends StudentController{

    @FXML
    private VBox StudentLayout;
    private static String searchField;

    public static void setSearchField(String searchField) {
        StudentSearchController.searchField = searchField;
    }

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
        List<Student> studentList = new ArrayList<>();
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            String req="select * from students where username like'%"+searchField+"%' or description like '%"+searchField+"%';";
            ResultSet rs= st.executeQuery(req);
            if(!rs.next())
            {
                Student student =new Student();
                student.setImgsrc("/com/example/libraryapp/assets/404.png");
                student.setUsername("User Not Found");
                student.setIntro("Try Again please");
                studentList.add(student);
            }
            else {
                do {
                    Student student =new Student();
                    student.setImgsrc(rs.getString("picture"));
                    student.setUsername(rs.getString("username"));
                    student.setIntro(rs.getString("description"));
                    studentList.add(student);
                }while (rs.next());
            }
            conDb.getCon().close();
            return studentList;
        }catch (Exception ec){
            ec.printStackTrace();
            AlertMessage alertMessage=new AlertMessage("Whoops!", "", "Could fetch the books from the database, plz try again");
            alertMessage.displayWarning();
            return studentList;
        }
    }
}
