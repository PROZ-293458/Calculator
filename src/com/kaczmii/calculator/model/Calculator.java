package com.kaczmii.calculator.model;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import java.lang.Math;
import com.kaczmii.calculator.model.StringOperations;;

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
		algebric_Expression = new String(string);
	}
	
	public String Calculate( )
	{
		try
		{
			System.out.println( algebric_Expression );
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
						System.out.printf("Error\n");
						return new String("");
					} 
				}
				else
				{
					return new String("");
				}
			} 
		}
		finally
		{
			
		}
		return new String("");
	}
}
