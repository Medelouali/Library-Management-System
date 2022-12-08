package com.example.libraryapp.utils;

import javafx.scene.control.Alert;

public class AlertMessage {

    private String title;
    private String header;
    private String message;

    public AlertMessage(String title, String header, String message) {
        this.title = title;
        this.header = header;
        this.message = message;
    }

    public void displayConfirmation(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }
    public void displayError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }
    public void displayWarning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }

}
