package com.kaczmii.calculator.model;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

public class Calculator 
{
	
	private String algebric_Expression;
	private final JShell jshell;
	
	public Calculator() 
	{
			jshell = JShell.create();
			algebric_Expression = null;
	}
	public boolean Load( String string )
	{
		algebric_Expression = new String (string);
		if ( algebric_Expression.equals(string) )
			return true;
		else
			return false;
	}
	public String Calculate( )
	{
		System.out.println(algebric_Expression);
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
			System.out.println("s");
		}
		return new String("");
	}
}
