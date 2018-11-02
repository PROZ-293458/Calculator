package com.kaczmii.calculator.model;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import com.kaczmii.calculator.model.StringOperations;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import com.kaczmii.calculator.model.AlertBox;

public class Calculator 
{
	
	private String algebric_Expression;
	private final JShell jshell;
	
	public Calculator() 
	{
			jshell = JShell.create();
			algebric_Expression = null;
	}
	
	public void Load( String string )
	{
		string = new String( StringOperations.Repair_Percent(string) );
		string = new String( StringOperations.Repair_Square(string) );
		string = new String( StringOperations.Repair_Square_Root(string) );
		string = new String( StringOperations.Repair_Factorial(string) );
		algebric_Expression = new String(string);
	}
	
	public String Calculate( )
	{
		try
		{
			int counter = 0;
			AlertBox alertBox = new AlertBox();
			for ( int i = 0 ; i < algebric_Expression.length() ; i ++ )
			{
				if ( algebric_Expression.charAt(i) == '(' )
					counter++;
				if ( algebric_Expression.charAt(i) == ')' )
					counter--;
			}
			if ( counter != 0 )
			{
				alertBox.show(AlertType.ERROR, "BLAD", "Nie mozna policzyc wyrazenia", "Nie zgadza sie ilosc nawiasow", ButtonType.OK);
				return algebric_Expression;
			}
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
