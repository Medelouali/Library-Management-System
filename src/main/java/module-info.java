module com.example.libraryapp {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
//    requires dotenv.java;

    opens com.example.libraryapp to javafx.fxml;
    exports com.example.libraryapp;
    exports com.example.libraryapp.controllers;
    opens com.example.libraryapp.controllers to javafx.fxml;
    exports com.example.libraryapp.dao;
    opens com.example.libraryapp.dao to javafx.fxml;

    opens com.example.libraryapp.models to javafx.base ;
    exports com.example.libraryapp.utils;
    opens com.example.libraryapp.utils to javafx.fxml;

}