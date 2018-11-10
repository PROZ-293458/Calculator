package com.kaczmii.calculator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
/**
 * Klasa zajmujaca sie obsluga plikow fxml
 */
public class ViewLoader<T,U>
{
	private T fxmlLayout = null;
	private U fxmlController = null;
	/**
	 * Konstruktor klasy przypisuje adresy do pol
	 * @param fxml Zadana sciezka do pliku fxml
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
	/**
	 * Metoda zwraca Layout
	 * @return Zwraca Layout
	 */
	public T getLayout()
	{
		return fxmlLayout;
	}
	/**
	 * Metoda zwraca Controller
	 * @return Zwraca Controller
	 */
	public U getController()
	{
		return fxmlController;
	}
}
