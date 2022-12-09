module com.example.libraryapp {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
<<<<<<< HEAD
=======
    requires dotenv.java;
    requires mysql.connector.j;
>>>>>>> 126240187485abde2285cee03a9f8ae1540ba9b7


    opens com.example.libraryapp to javafx.fxml;
    exports com.example.libraryapp;
    exports com.example.libraryapp.controllers;
    opens com.example.libraryapp.controllers to javafx.fxml;
    exports com.example.libraryapp.dao;
    opens com.example.libraryapp.dao to javafx.fxml;

}