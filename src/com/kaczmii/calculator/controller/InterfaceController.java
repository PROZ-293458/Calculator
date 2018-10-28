package com.kaczmii.calculator.controller;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import com.kaczmii.calculator.model.AlertBox;
import com.kaczmii.calculator.model.Calculator;

public class InterfaceController implements Initializable 
{
	private Calculator calc = new Calculator();
	private AlertBox alert = new AlertBox();
	
    @FXML
    private TextField textField;

    @FXML
    private Button sqrt;

    @FXML
    private Button percent;

    @FXML
    private Button square;

    @FXML
    private Button ce;

    @FXML
    private Button clear;

    @FXML
    private Button factorial;

    @FXML
    private Button divided;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button times;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button minus;

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button plus;

    @FXML
    private Button zero;

    @FXML
    private Button dot;

    @FXML
    private Button equal;

    @FXML
    private Button left_bracket;

    @FXML
    private Button right_bracket;

    @FXML
    void Button_Bracket(ActionEvent event) 
    {
    	int counter = 0;
    	if ( event.getSource() == right_bracket )
    	{
    		for ( int i = textField.getText().length()  - 1 ; i >= 0 ; --i )
        	{
        		if ( textField.getText().charAt(i) == ')' )
        		{
        			counter--;
        		}
        		else if ( textField.getText().charAt(i) == '(' )
        		{
        			counter++;
        		}
        	}
    		if ( counter >= 1)
    		{
    			Button_Numbers( event);
    		}
    		else
    		{
    			alert.show( AlertType.WARNING, "OSTRZEZENIE", "Brak mozliwosci dodania prawego nawiasu, za mala ilosc lewych nawiasow.", "Liczba nawiasow musi sie zgadzac.", ButtonType.OK);
    		}
    	}
    	else
    	{
    		if ( textField.getText().length() == 0 )
    			Button_Numbers ( event );
    		else if ( isOperator( textField.getText().charAt(textField.getText().length() - 1 ) ) )
    		{
    			Button_Numbers( event );
    		}
    		else
    		{
    			alert.show( AlertType.WARNING, "OSTRZEZENIE", "Brak mozliwosci dodania nawiasu, gdy nie ma przed operatora.", "Dodaj wczesniej operator algebraiczny.", ButtonType.OK);
    		}
    	}
    		
    }
    
    @FXML
    void Button_Clear(ActionEvent event) 
    {
    	if ( textField.getText().length() != 0 )
    	{
    		String temporary = new String (textField.getText() );
    		temporary = temporary.substring(0, temporary.length()-1 );
    		textField.setText( temporary );
    	}
    }

    @FXML
    void Button_Clear_Everything(ActionEvent event) 
    {
    	textField.setText("");
    }

    @FXML
    void Button_Equals(ActionEvent event) 
    {
    	
    	textField.setText( textField.getText().replaceAll( (String) "%", (String) "/100.0"));
    	if ( calc.Load(textField.getText() ) )
    	{
    		textField.setText( calc.Calculate() );
    	}
    	else
    		System.out.println( "nie dziala");
    }

    @FXML
    void Button_Factorial(ActionEvent event) 
    {
    	
    }

    @FXML
    void Button_Numbers(ActionEvent event) 
    {
    	Button temporary = (Button) event.getSource();
    	textField.setText(textField.getText() + temporary.getText());
    }

    @FXML
    void Button_Percent(ActionEvent event) 
    {
    	char last = textField.getText().charAt( textField.getText().length() -1 );
    	if ( ( last == '%' || !isNumber(last) ) && last != ')' )
    	{
    		alert.show(AlertType.WARNING, "OSTRZEZENIE", "Znaku procentu nie mozna uzyc w tym miejscu", "Mozna go uzyc tylko po opeartorach albo po nawiasie", ButtonType.OK);
    	}
    	else
    	{
        	Button temporary = (Button) event.getSource();
        	textField.setText(textField.getText() + temporary.getText() );
    	}

    }

    @FXML
    void Button_Square_Root(ActionEvent event) 
    {
    	
    }

    @FXML
    void Button_Times(ActionEvent event) 
    {
    	if ( isOperator( textField.getText().charAt( textField.getText().length() - 1 ) ) )
    	{
    		alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozesz dodawac po sobie dwoch operatorow.", "", ButtonType.OK);
    	}
    	else
    		textField.setText(textField.getText() + "*");
    }

    @FXML
    void Button_operator(ActionEvent event)
    {
    	Button temporary = (Button) event.getSource();
    	if ( textField.getText().length() == 0 )
    	{
    		textField.setText(textField.getText() + temporary.getText());
    	}
    	else if ( isOperator( textField.getText().charAt( textField.getText().length() - 1 ) ) )
    	{
    		alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozesz dodawac po sobie dwoch operatorow.", "", ButtonType.OK);
    	}
    	else
    		textField.setText(textField.getText() + temporary.getText());
    }

    @FXML
    void Button_square(ActionEvent event) 
    {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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
	private boolean isOperator( char a )
	{
		char[] operators = { '+', '-', '*', '/', '.' };
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
