package com.kaczmii.calculator.model;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class AlertBox 
{
	private Alert alert;
	
	public AlertBox()
	{
		
	}
	public AlertBox( AlertType type, String title, String headerText, String text, ButtonType button )
	{
		alert = new Alert( type, text, button );
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}
	
	public void show( AlertType type, String title, String headerText, String text, ButtonType button )
	{
		alert = new Alert( type, text, button );
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}
}
