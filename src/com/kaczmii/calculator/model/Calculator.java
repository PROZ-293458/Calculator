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
			int begin = 0, end = 0;
			String toSqrt;
			double Sqrt;
			for ( int i = 0, j = 0; i < string.length() ; i++, j++ )
			{
				if ( string.charAt(i) == 't' )
				{
					begin = i + 2;
					j = i + 2;
					for ( ; j < string.length() ; j++ )
					{
						if ( string.charAt(j) != ')' )
							continue;
						end = j;
						break;
					}
					toSqrt = string.substring(begin, end);
					Sqrt = Math.sqrt( Double.parseDouble( toSqrt ) );
					toSqrt = string.substring(begin - 5, end + 1);
					string = new String(string.replace(toSqrt, Double.toString(Sqrt)));
				}
			}
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
