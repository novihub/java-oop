package com.novikoff.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");
        stage.setResizable(false);
        Pane load = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("Calculator.fxml")));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}
