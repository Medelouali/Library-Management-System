package com.example.libraryapp.utils;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ImageSelector {
    public String selectAndStoreImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                Files.copy(selectedFile.toPath(), new File("sources/" + selectedFile.getName()).toPath());
                return "sources/" + selectedFile.getName();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
