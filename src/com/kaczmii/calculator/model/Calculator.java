package com.kaczmii.calculator.model;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import java.lang.Math;

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
		string = new String( Repair_Percent(string) );
		string = new String( Repair_Square(string) );
		string = new String( Repair_Square_Root(string) );
		algebric_Expression = new String(string);
	}
	
	private String Repair_Percent( String string)
	{
		string = new String(string.replaceAll("%", "/100.0"));
		return string;
	}
	
	private String Repair_Square_Root ( String string )
	{
		if ( string.contains("sqrt") )
		{
			int begin, end;
			for ( int i = 0 ; i < string.length() - 1 ; i++ )
			{
				if ( string.charAt(i) == 't' )
				{
					begin = i + 1;
					for ( int j = 0 ; j <  string.length() - 1 ; j++ )
					{
						if ( isNumber( string.charAt ( j ) ||  )
							continue;
						end = j - 1;
						break;
					}
				}
			}
			System.out.println("pierwiastek");
		}
		return string;
	}
	
	private String Repair_Square ( String string )
	{
		if ( string.contains("^2") )
		{
			System.out.println("kwadrat");
		}
		return string;
	}
	
	private boolean isNumber( char a )
	{
		char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (char number : numbers)
		{
			if ( number == a )
				return true;
		}
		return false;
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
