package com.kaczmii.calculator.model;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
/*
 * Klasa zajmujaca sie wyskakujacymi okienkami alertowymi
 */
public class AlertBox 
{
	/*
	 * @param alert Obiekt klasy Alert na ktorym bazuje klasa AlertBox
	 */
	private Alert alert;
	
	/*
	 * Bezargumnetowy konstrukotr klasy AlertBox nic nie robi
	 */
	public AlertBox()
	{
		
	}
	/*
	 * Argumentowy konstrukotr klasy AlertBox ustawia potrzebne dane na miejsca
	 */
	public AlertBox( AlertType type, String title, String headerText, String text, ButtonType button )
	{
		alert = new Alert( type, text, button );
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}
	/*
	 * Metoda ustawia parametry alertu i go wyswietla
	 */
	public void show( AlertType type, String title, String headerText, String text, ButtonType button )
	{
		alert = new Alert( type, text, button );
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}
}
