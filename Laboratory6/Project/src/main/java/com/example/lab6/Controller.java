package com.example.lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Spinner;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class Controller {
    @FXML private Pane canvasID;
    @FXML private Spinner<Integer> leftSpinner;
    @FXML private Spinner<Integer> rightSpinner;
    private final int panelWidth = 600;
    private final int panelHeight = 550;

    protected void setCircleFeatures(Circle circle) {
        circle.setRadius(15);
        circle.setFill(Color.WHITE);
        circle.setStrokeWidth(2.0);
        circle.setStroke(Color.LIGHTGREY);
    }

    protected void generateCircles() {
        int leftSpVal = leftSpinner.getValue();
        int rightSpVal = rightSpinner.getValue();
        System.out.println("L&R values" + leftSpVal + " " + rightSpVal);

        int segmentX = panelWidth / rightSpVal;
        int segmentY = panelHeight / leftSpVal;

        System.out.println(segmentX + " " + segmentY);

        int startValueX;
        int startValueY = segmentY / 2;

        for(int line = 0; line < leftSpVal; line++) {
            startValueX = segmentX / 2;

            for(int column = 0; column < rightSpVal; column++) {
                Circle circle = new Circle();
                circle.setCenterX(startValueX);
                circle.setCenterY(startValueY);
                setCircleFeatures(circle);

                canvasID.getChildren().add(circle);
                startValueX += segmentX;
            }
            startValueY += segmentY;
        }
    }

    @FXML
    protected void onCreateButtonClick() {
        System.out.println("Create button");
        canvasID.getChildren().clear();

        generateCircles();
    }

    @FXML
    protected void onSaveButtonClick() {
        System.out.println("Save button");
        /*
        try {
            BufferedImage image = new BufferedImage(600,550,TYPE_INT_RGB);

            ImageIO.write(image, "PNG", new File("target/images/img.png"));
            System.out.println("Saved an image.");
        }
        catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
        */
    }

    @FXML
    protected void onLoadButtonClick() {
        System.out.println("Load button");
    }
}