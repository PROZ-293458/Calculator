package com.kaczmii.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main2 extends Application
{
    
    @Override
    public void start(Stage stage) throws Exception {
    	System.out.println("java version: "+System.getProperty("java.version"));
    	System.out.println("javafx.version: " + System.getProperty("javafx.version"));
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("view/Interface2.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Genuine Coder");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
