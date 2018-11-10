package com.kaczmii.calculator.view;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
/**
 * Klasa zajmujaca sie wyskakujacymi okienkami alertowymi
 */
public class AlertBox 
{
	private Alert alert;
	
	/**
	 * Bezargumnetowy konstrukotr klasy AlertBox nic nie robi
	 */
	public AlertBox()
	{
		
	}
	/**
	 * Argumentowy konstrukotr klasy AlertBox ustawia potrzebne dane na miejsca
	 * @param type Typ alertu
	 * @param title Tytul alertu
	 * @param headerText Tytul naglowka
	 * @param text Tekst alertu
	 * @param button Typ przycisku w alercie
	 */
	public AlertBox( AlertType type, String title, String headerText, String text, ButtonType button )
	{
		alert = new Alert( type, text, button );
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}
	/**
	 * Metoda ustawia parametry alertu i go wyswietla
	 * @param type Typ alertu
	 * @param title Tytul alertu
	 * @param headerText Tytul naglowka
	 * @param text Tekst alertu
	 * @param button Typ przycisku w alercie
	 */
	public void show( AlertType type, String title, String headerText, String text, ButtonType button )
	{
		alert = new Alert( type, text, button );
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}
}
