module com.example.demo2fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo2fx to javafx.fxml;
    exports com.example.demo2fx;
}