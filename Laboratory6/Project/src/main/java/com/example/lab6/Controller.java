package com.example.lab6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Random;

public class Controller {
    @FXML private Pane canvasID;
    @FXML private Spinner<Integer> leftSpinner;
    @FXML private Spinner<Integer> rightSpinner;
    private final int panelWidth = 600;
    private final int panelHeight = 550;
    private int playerTurn = 0;

    protected void setCircleFeatures(Circle circle) {
        circle.setRadius(15);
        circle.setFill(Color.WHITE);
        circle.setStrokeWidth(2.0);
        circle.setStroke(Color.LIGHTGREY);

        circle.setOnMouseClicked(event -> {
            Color currentFill = (Color) circle.getFill();
            if (Color.WHITE.equals(currentFill)) {
                if(playerTurn == 0) {
                    circle.setFill(Color.RED);
                    playerTurn = 1;
                }
                else {
                    circle.setFill(Color.BLUE);
                    playerTurn = 0;
                }
            }
        });
    }

    /**
     * Method used to generate the circles on the grid.
     */
    protected void generateCircles() {
        int leftSpVal = leftSpinner.getValue();
        int rightSpVal = rightSpinner.getValue();
        int segmentX = panelWidth / rightSpVal;
        int segmentY = panelHeight / leftSpVal;
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

    protected int generateRandomNr() {
        Random r = new Random();
        int low = 0;
        int high = 5;
        int result = r.nextInt(high-low) + low;
        return result;
    }

    /**
     * Method used to generate the grid (matrix form) of the game.
     */
    protected void generateGrid() {
        int leftSpVal = leftSpinner.getValue();
        int rightSpVal = rightSpinner.getValue();
        int segmentX = panelWidth / rightSpVal;
        int segmentY = panelHeight / leftSpVal;
        int startValueX;
        int startValueY = segmentY / 2;

        for(int line = 0; line < leftSpVal; line++) {
            startValueX = segmentX / 2;

            for(int column = 0; column < rightSpVal; column++) {
                if(column < (rightSpVal - 1)) {
                    int probability = generateRandomNr();

                    Line horizontalLine = new Line();
                    horizontalLine.setStartX(startValueX);
                    horizontalLine.setStartY(startValueY);
                    horizontalLine.setEndX(startValueX + segmentX);
                    horizontalLine.setEndY(startValueY);

                    if(probability >= 2) {
                        horizontalLine.setStrokeWidth(7);
                    }
                    else {
                        horizontalLine.setStrokeWidth(0.5);
                    }

                    canvasID.getChildren().add(horizontalLine);
                }
                if(line < (leftSpVal - 1)) {
                    int probability = generateRandomNr();

                    Line verticalLine = new Line();
                    verticalLine.setStartX(startValueX);
                    verticalLine.setStartY(startValueY);
                    verticalLine.setEndX(startValueX);
                    verticalLine.setEndY(startValueY + segmentY);

                    if(probability >= 2) {
                        verticalLine.setStrokeWidth(7);
                    }
                    else {
                        verticalLine.setStrokeWidth(0.5);
                    }
                    canvasID.getChildren().add(verticalLine);
                }
                startValueX += segmentX;
            }
            startValueY += segmentY;
        }
    }

    @FXML
    protected void onCreateButtonClick() {
        System.out.println("Create button");
        canvasID.getChildren().clear();

        generateGrid();
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