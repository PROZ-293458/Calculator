package com.kaczmii.calculator.model;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import com.kaczmii.calculator.model.StringOperations;
import com.kaczmii.calculator.view.AlertBox;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * Klasa zajmujaca sie kalkulowaniem zadanego stringu za pomoca JShell'a. Sprawdza takze poprawnosc stringu.
 */
public class Calculator 
{
	
	private String algebric_Expression;
	private final JShell jshell;
	/**
	 * Kontruktor klasy Calculator zajmujacy sie zainicjalizowaniem jshell'a oraz ustawieniem algebric_Expression na null
	 */
	public Calculator() 
	{
			jshell = JShell.create();
			algebric_Expression = null;
	}
	/**
	 * Meotda zaladowuje string do zmiennej algebric_Expression i sprawdza jego poprawnosc
	 * @param string String do sprawdzenia
	 * @return prawda lub falsz w zaleznosci czy string jest poprawny do zaladowania
	 */
	public boolean Load( String string )
	{
		int counter = 0;
		AlertBox alertBox = new AlertBox();
		for ( int i = 0 ; i < string.length() ; i ++ )
		{
			if ( string.charAt(i) == '(' )
				counter++;
			if ( string.charAt(i) == ')' )
				counter--;
		}
		if ( counter != 0 )
		{
			alertBox.show(AlertType.ERROR, "BLAD", "Nie mozna policzyc wyrazenia", "Nie zgadza sie ilosc nawiasow", ButtonType.OK);
			return false;
		}
		else
		{
			string = new String( StringOperations.Repair_Percent(string) );
			string = new String( StringOperations.Repair_Square(string) );
			string = new String( StringOperations.Repair_Square_Root(string) );
			string = new String( StringOperations.Repair_Factorial(string) );
			algebric_Expression = new String(string);
			return true;
		}
		
		
	}
	/**
	 * Metoda kalkuluje algebric_Expression za pomoca jshella
	 * @return Metoda zwraca string, ktory jest wynikiem obliczen zadanych algebric_Expression
	 */
	public String Calculate( )
	{
		try
		{
			AlertBox alertBox = new AlertBox();
			List<SnippetEvent> events = jshell.eval(algebric_Expression);
			for (SnippetEvent e : events) 
			{
				if (e.causeSnippet() == null) 
				{
					switch (e.status()) 
					{
					case VALID:
						if (e.value() != null) 
						{
							return e.value();
						}
						break;
					default: 
						alertBox.show(AlertType.ERROR, "BLAD", "Nie mozna policzyc wyrazenia", "Wprowadzone wyrazenie jest nieprawidlowe", ButtonType.OK);
						return algebric_Expression;
					} 
				}
				else
				{
					alertBox.show(AlertType.ERROR, "BLAD", "Nie mozna policzyc wyrazenia", "Wprowadzone wyrazenie jest nieprawidlowe", ButtonType.OK);
					return algebric_Expression;
				}
			} 
		}
		finally
		{
			
		}
		return new String("");
	}
}
