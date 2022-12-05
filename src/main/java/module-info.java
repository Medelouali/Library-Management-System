module com.example.libraryapp {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires dotenv.java;
    requires mysql.connector.j;


    opens com.example.libraryapp to javafx.fxml;
    exports com.example.libraryapp;
    exports com.example.libraryapp.controllers;
    opens com.example.libraryapp.controllers to javafx.fxml;
    exports com.example.libraryapp.dao;
    opens com.example.libraryapp.dao to javafx.fxml;

}