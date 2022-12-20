package com.example.libraryapp.controllers;

import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.Statement;



public class StatisticStudentController extends HomeController {
    @FXML private TableView<Student> table ;

    @FXML private TableColumn<Student,String> username ;
    @FXML private TableColumn<Student,String> cin ;
    @FXML private TableColumn<Student, Long> num_borrowed ;

    public ObservableList<Student> data = FXCollections.observableArrayList();


    // menu button

    //MenuButton mb =new MenuButton("statistics");
    //MenuItem item1=new MenuItem("student's statistics");
    //MenuItem item2=new MenuItem("book's statistics");

    //mb.getItems().addAll(item1,item2);



    // fin partie menu button

    @FXML
    public void showAllStudents(ActionEvent e){
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            //String statement="select * from students";
            String statement="select s.username,s.cin,COUNT(b.id) as num_borrowed from students s LEFT JOIN borrowings b ON s.id=b.student_id GROUP BY s.id";
            ResultSet rs = st.executeQuery(statement);
            while (rs.next()){
                //Statement stm = conDb.getCon().createStatement();
                //long studentId=rs.getLong("id"); // recuperer id de chaque etudiant
                //String stat="select count(*) from borrowings where student_id='"+ studentId+"'";
                //String stat="select username,cin,count(*) from borrowings,students where borrowings.student_id='"+ studentId+"'";
                // aller vers table borrowings et chercher le nombre de copies empr par cette etudiant
                //Statement stm = conDb.getCon().createStatement();
                //ResultSet rst = stm.executeQuery(stat);
                //while (rst.next()){
                //data.add(new Student(rs.getString("username"), rs.getString("cin"), rst.getLong(1)));}
                data.add(new Student(rs.getString("username"), rs.getString("cin"), rs.getLong("num_borrowed")));
                //username,cin,number of borrowed copies selon ordre en base

            }
            conDb.getCon().close();

        }catch (Exception ec){
            ec.printStackTrace();
        }
        username.setCellValueFactory(new PropertyValueFactory<Student,String>("username"));
        cin.setCellValueFactory(new PropertyValueFactory<Student,String>("cin"));
        num_borrowed.setCellValueFactory(new PropertyValueFactory<Student,Long>("num_borrowed"));
        table.setItems(data);
    }



    @FXML
    void onStatisticsStudents(ActionEvent event) {
        try{
            this.switchPage(event, "statistics-students-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    void onStatisticsBooks(ActionEvent event) {
        try{
            this.switchPage(event, "statistics-books-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }







}
















