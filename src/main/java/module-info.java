module com.example.libraryapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.libraryapp to javafx.fxml;
    exports com.example.libraryapp;
}