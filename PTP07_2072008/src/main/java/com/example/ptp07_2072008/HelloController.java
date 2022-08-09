package com.example.ptp07_2072008;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloController {
    public TextArea txtArea;
    public Button btnOpen;
    public Button btnSaveAs;
    public Button btnSave;

    Path path;
    FileChooser chooser;
    FileChooser.ExtensionFilter extFil;
    File file;
    Files files;
    Alert alert;

    public void open() {
        chooser = new FileChooser();
        extFil = new FileChooser.ExtensionFilter("Text Documents", "*.txt");
        chooser.getExtensionFilters().add(extFil);
        chooser.setSelectedExtensionFilter(extFil);
        file = chooser.showOpenDialog(txtArea.getScene().getWindow());
        if(file != null){
            path = Paths.get(file.toURI());
            try {
                String temp = Files.readString(path);
                txtArea.setText(temp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveAs() {
        chooser = new FileChooser();
        extFil = new FileChooser.ExtensionFilter("Text Documents", "*.txt");
        chooser.getExtensionFilters().add(extFil);
        chooser.setSelectedExtensionFilter(extFil);
        file = chooser.showSaveDialog(txtArea.getScene().getWindow());
        if(file != null){
            path = Paths.get(file.toURI());
            try {
                Files.write(path, txtArea.getText().getBytes());
                alert = new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK);
                alert.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void save() {
        if(path != null){
            try {
                Files.write(path, txtArea.getText().getBytes());
                alert = new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK);
                alert.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            saveAs();
        }
    }
}