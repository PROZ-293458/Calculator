package com.kaczmii.calculator.model;


import java.lang.Math;

public class StringOperations 
{
	public static String Repair_Percent( String string)
	{
		string = new String(string.replaceAll("%", "/100.0"));
		return string;
	}
	
	public static String Repair_Square_Root ( String string )
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
					if ( toSqrt.contains("sqrt") )
						Repair_Square_Root(toSqrt);
					Sqrt = Math.sqrt( Double.parseDouble( toSqrt ) );
					toSqrt = string.substring(begin - 5, end + 1);
					string = new String(string.replace(toSqrt, Double.toString(Sqrt)));
				}
			}
		}
		return string;
	}
	
	public static String Repair_Square ( String string )
	{
		boolean flag = false;
		if ( string.contains("^2") )
		{
			int begin = 0, end = 0;
			String toSq;
			double Sq;
			for ( int i = 0, j = 0; i < string.length() ; i++ )
			{
				if ( string.charAt(i) == '^' )
				{
					if ( string.charAt(i - 1) == ')')
						end = i - 1;
					else
						end = i;
					
					for ( j = end ; j >= 0 ; j-- )
					{
						if ( j == 0 )
						{
							if ( string.charAt(j) == '(' )
							{
								flag = true;
								begin = j + 1;
							}
							else
								begin = j;
							break;
						}
						if ( string.charAt(j) == '(' )
						{
							begin = j + 1;
							flag = true;
							break;
						}
						if ( isOperator( string.charAt(j) ) )
						{
							begin = j + 1;
							break;
						}
					}
					toSq = string.substring(begin, end);
					System.out.println( begin);//
					System.out.println( end);//
					System.out.println(toSq);//
					if ( toSq.contains("^2") )
						Repair_Square(toSq);
					Sq = Math.pow( Double.parseDouble( toSq ), 2 );
					System.out.println(Sq);//
					if ( flag )
						toSq = string.substring(begin - 1, end + 3);
					else
						toSq = string.substring(begin, end + 2);
					string = new String(string.replace(toSq, Double.toString(Sq)));
				}
			}
		}
		return string;
	}
	
	private static boolean isNumber( char a )
	{
		char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (char number : numbers)
		{
			if ( number == a )
				return true;
		}
		return false;
	}
	
	private static boolean isOperator( char a )
	{
		char[] operators = { '+', '-', '*', '/' };
		for (char operator : operators)
		{
			if ( operator == a )
			{
				return true;
			}
		}
		return false;
	}
}
