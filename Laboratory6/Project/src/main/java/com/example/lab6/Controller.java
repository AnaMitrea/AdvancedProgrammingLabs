package com.example.lab6;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;

public class Controller {
    @FXML private Spinner<Integer> leftSpinner;
    @FXML private Spinner<Integer> rightSpinner;
    private final int panelWidth = 600;
    private final int panelHeight = 550;

    @FXML
    protected void onCreateButtonClick() {
        System.out.println("Create button");
        System.out.println(leftSpinner.getValue());
        int leftSpVal = leftSpinner.getValue();
        System.out.println(rightSpinner.getValue());
        int rightSpVal = rightSpinner.getValue();

        for(int line = 1; line <= leftSpVal; line++) {
            for(int column = 1; column <= rightSpVal; column++) {

            }
        }
    }

    @FXML
    protected void onSaveButtonClick() {
        System.out.println("Save button");
    }

    @FXML
    protected void onLoadButtonClick() {
        System.out.println("Load button");
    }
}