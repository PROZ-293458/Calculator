package com.kaczmii.calculator;

import com.kaczmii.calculator.controller.InterfaceController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Klasa Main zajmujaca sie wyswietlaniem okienka kalkulatora
 * @author Kaczmarek Kacper / kkaczma5@stud.elka.pw.edu.pl
 * @version final(?)
 */
public class Main extends Application
{
	/**
	 * Konstruktor klasy Main, nie ma zadnego zadania
	 */
	public Main()
	{
		
	}
	/**
	 * Metoda main, ktora wyswietla okienko
	 * @param args[] Tablica stringow argumentow z konsoli
	 */
	public static void main(String args[] )
	{
		launch(args);
	}
	
	/**
	 * Metoda zajmuje sie zaladowaniem fxml a takze wyswietleniem go
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
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

	    e.printStackTrace();
		}
	}
}
