package com.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("src/main/java/resources/main.fxml"));
        primaryStage.setTitle("Корвертер");
        primaryStage.setScene(new Scene(root, 800, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

