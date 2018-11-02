package com.kaczmii.calculator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
/*
 * Klasa zajmujaca sie plikami fxml
 */
public class ViewLoader<T,U>
{
	private T fxmlLayout = null;
	private U fxmlController = null;
	/*
	 * Konstruktor klasy przypisuje adresy do pol
	 */
	public ViewLoader(String fxml)
	{
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource(fxml) );
			fxmlLayout = fxmlLoader.load();
			fxmlController = fxmlLoader.getController();
		}
		catch (IOException ex)
		{
		}
	}
	/*
	 * Metoda zwraca Layout
	 */
	public T getLayout()
	{
		return fxmlLayout;
	}
	/*
	 * Metoda zwraca Controller
	 */
	public U getController()
	{
		return fxmlController;
	}
}
