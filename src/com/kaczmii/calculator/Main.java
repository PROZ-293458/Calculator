package com.kaczmii.calculator;

import com.kaczmii.calculator.controller.InterfaceController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application
{

	public Main()
	{
		
	}
	
	public static void main(String args[] )
	{
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception 
	{
		
		try
		{
			ViewLoader<AnchorPane, InterfaceController> viewLoader = new ViewLoader<AnchorPane, InterfaceController>("view/Interface.fxml");
			AnchorPane anchorpane = viewLoader.getLayout();
			Scene scene = new Scene(anchorpane);
			arg0.setScene(scene);
			arg0.setTitle("Calculator");
			arg0.show();
		}
		
		catch (Exception e) 
		{

	    // generic exception handling
	    e.printStackTrace();
		}
	}
	

}
