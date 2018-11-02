package com.kaczmii.calculator.model;


import java.lang.Math;
import com.kaczmii.calculator.model.Calculator;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import com.kaczmii.calculator.model.AlertBox;

public class StringOperations 
{
	public static String Repair_Percent( String string)
	{
		string = new String(string.replaceAll("%", "/100.0"));
		return string;
	}
	
	public static String Repair_Square_Root ( String string )
	{
		AlertBox alertBox = new AlertBox();
		if ( string.contains("sqrt") )
		{
			Calculator calc = new Calculator();
			int begin = 0, end = 0;
			String toSqrt;
			double Sqrt;
			for ( int i = 0, j = 0; i < string.length() ; i++ )
			{
				if ( string.charAt(i) == 't' )
				{
					begin = i + 2;
					int counter = 1;
					for ( j = begin ; j < string.length() ; j++ )
					{
						if ( string.charAt(j) == '(' )
							++counter;
						if ( string.charAt(j) != ')' )
							continue;
						--counter;
						if ( counter == 0 )
						{
							end = j - 1;
							break;
						}
					}
					if ( begin == end )
						toSqrt = Character.toString(string.charAt(end) );
					else
						toSqrt = string.substring(begin, end + 1);
					if ( toSqrt.contains("sqrt") )
						toSqrt = Repair_Square_Root ( toSqrt );
					if ( calc.Load(toSqrt) )
					{
						toSqrt = calc.Calculate();
						Sqrt = Math.sqrt( Double.parseDouble( toSqrt ) );
						toSqrt = string.substring(begin - 5, end + 2);
						string = new String(string.replace(toSqrt, Double.toString(Sqrt)));
						break;
					}
					else
					{
						alertBox.show(AlertType.ERROR , "BLAD", "Nie mozna policzyc wyrazenia.", "Cos poszlo nie tak.", ButtonType.OK);
						break;
					}
				}
			}
		}
		return string;
	}
	
	public static String Repair_Square ( String string )
	{
		AlertBox alertBox = new AlertBox();
		if ( string.contains("^2") )
		{
			Calculator calc = new Calculator();
			int begin = 0, end = 0;
			boolean flag = false;
			String toSq;
			double Sq;
			for ( int i = (string.length()-1), j = 0; i >= 0 ; i-- )
			{
				if ( string.charAt(i) == '^'  )
				{
					if ( string.charAt( i - 1 ) == ')' )
					{
						flag = true;
						end = i - 2;
						int counter = 1;
						for ( j = end ; j >= 0 ; j-- )
						{
							if ( string.charAt(j) == ')' )
								++counter;
							if ( string.charAt(j) != '(' )
								continue;
							--counter;
							if ( counter == 0 )
							{
								begin = j + 1;
								break;
							}
						}
					}
					else
					{
						end = i - 1;
						for ( j = end ; j >= 0 ; j-- )
						{
							if ( isNumber(string.charAt(j)) || string.charAt(j) == '.' )
								continue;
							begin = j + 1;
							break;
						}
					}
					if ( begin == end )
						toSq = Character.toString(string.charAt(end) );
					else
						toSq = string.substring(begin, end + 1);
					if ( toSq.contains("sqrt") )
						toSq = Repair_Square_Root( toSq );
					if ( toSq.contains("^2") )
						toSq = Repair_Square( toSq );
					if ( toSq.contains("!"))
						toSq = Repair_Factorial ( toSq );;
					if ( calc.Load(toSq) )
					{
						toSq = calc.Calculate();
						Sq = Math.pow( Double.parseDouble( toSq ), 2 );
						if ( flag )
							toSq = string.substring(begin - 1, end + 4);
						else
							toSq = string.substring(begin, end + 3);
						string = new String(string.replace(toSq, Double.toString(Sq)));
						break;
					}
					else
					{
						alertBox.show(AlertType.ERROR , "BLAD", "Nie mozna policzyc wyrazenia.", "Cos poszlo nie tak.", ButtonType.OK);
						break;
					}

				}
			}
		}
		return string;
	}
	
	public static String Repair_Factorial ( String string )
	{
		AlertBox alertBox = new AlertBox();
		if ( string.contains("!") )
		{
			Calculator calc = new Calculator();
			int begin = 0, end = 0;
			boolean flag = false;
			String toFctr;
			double Fctr;
			for ( int i = string.length() - 1, j = 0; i >= 0 ; i-- )
			{
				if ( string.charAt(i) == '!' )
				{
					if ( string.charAt( i - 1 ) == ')' )
					{
						flag = true;
						end = i - 2;
						int counter = 1;
						for ( j = end ; j >= 0 ; j-- )
						{
							if ( string.charAt(j) == ')' )
								++counter;
							if ( string.charAt(j) != '(' )
								continue;
							--counter;
							if ( counter == 0 )
							{
								begin = j + 1;
								break;
							}
						}
					}
					else
					{
						end = i - 1;
						for ( j = end ; j >= 0 ; j-- )
						{
							if ( isNumber(string.charAt(j)) || string.charAt(j) == '.' )
								continue;
							begin = j + 1;
							break;
						}
					}
					if ( begin == end )
						toFctr = Character.toString(string.charAt(end) );
					else
						toFctr = string.substring(begin, end + 1);;
					if ( toFctr.contains("sqrt") )
						toFctr = Repair_Square_Root( toFctr );
					if ( toFctr.contains("^2") )
						toFctr = Repair_Square( toFctr );
					if ( toFctr.contains("!"))
						toFctr = Repair_Factorial ( toFctr );
					if ( calc.Load(toFctr) )
					{
						toFctr = calc.Calculate();
						Fctr = Factorial( Double.parseDouble( toFctr ));
						if ( flag )
							toFctr = string.substring(begin - 1, end + 3);
						else
							toFctr = string.substring(begin, end + 2);
						string = new String(string.replace(toFctr, Double.toString(Fctr)));
						break;
					}
					else
					{
						alertBox.show(AlertType.ERROR , "BLAD", "Nie mozna policzyc wyrazenia.", "Cos poszlo nie tak.", ButtonType.OK);
						break;
					}
					
				}
			}
		}
		return string;
	}
	
	private static double Factorial( double n )
	{
		if ( n - (int) n == 0 )
		{
			if ( n != 0 )
			{
				for ( int i = (int) n-1 ; i > 0 ; i--)
					n = n*i;
			}
			else
				n = 1;
			
		}
		else
			n = Math.sqrt(2*Math.PI*n)*Math.pow( n/Math.E, n)*Math.pow(Math.E, 1/(12*n) );
		return n;
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
	
}
