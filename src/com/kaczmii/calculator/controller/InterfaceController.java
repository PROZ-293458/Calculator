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
    		char last = textField.getText().charAt( textField.getText().length() - 1 );
    		if ( last == '(' )
    		{
    			alert.show(AlertType.WARNING, "OSTRZEZENIE", "Brak mozliwosci dodania prawego nawiasu", "Nie ma nic pomiedzy lewym a prawym nawiasem", ButtonType.OK);
    			return;
    		}
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
    			Button temporary = (Button) event.getSource();
    	        textField.setText(textField.getText() + temporary.getText());
    		}
    		else
    		{
    			alert.show( AlertType.WARNING, "OSTRZEZENIE", "Brak mozliwosci dodania prawego nawiasu, za mala ilosc lewych nawiasow.", "Liczba nawiasow musi sie zgadzac.", ButtonType.OK);
    		}
    	}
    	else
    	{
    		if ( textField.getText().length() != 0 )
        	{
        		char last = textField.getText().charAt( textField.getText().length() - 1 );
            	if ( textField.getText().length() > 1 )
            	{
            		char prelast = textField.getText().charAt( textField.getText().length() - 2 );
            		if ( last == '2' && prelast == '^' )
            		{
            			alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna wykonac tej operacji", "Po znaku potegi mozna dac tylko opeartory", ButtonType.OK);
            			return;
            		}
            	}
        	}
    		if ( textField.getText().length() == 0 )
    		{
    	    	Button temporary = (Button) event.getSource();
    	        textField.setText(textField.getText() + temporary.getText());
    		}
    		else if ( isOperator( textField.getText().charAt(textField.getText().length() - 1 )) || textField.getText().charAt(textField.getText().length() - 1) == '(' )
    		{
    			Button temporary = (Button) event.getSource();
    	        textField.setText(textField.getText() + temporary.getText());
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
    		char last = textField.getText().charAt( textField.getText().length() - 1 );
    		if ( textField.getText().length() > 1)
    		{
    			// usuwanie kwadratu
    			if ( last == '2')
    			{
    				char prelast = textField.getText().charAt( textField.getText().length() - 2 );
        			if ( prelast == '^' )
        			{
        				String temporary = new String (textField.getText() );
        	    		temporary = temporary.substring(0, temporary.length()-2 );
        	    		textField.setText( temporary );
        	    		return;
        			}
    			}
    			// uswanie potegi
    			if ( last == '(')
    			{
    				char prelast = textField.getText().charAt( textField.getText().length() - 2 );
        			if ( prelast == 't' )
        			{
        				String temporary = new String (textField.getText() );
        	    		temporary = temporary.substring(0, temporary.length()-5 );
        	    		textField.setText( temporary );
        	    		return;
        			}
    			}
    			
    		}
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
    	calc.Load(textField.getText() );
    	textField.setText( calc.Calculate() );
    }

    @FXML
    void Button_Factorial(ActionEvent event) 
    {
    	if ( textField.getText().length() == 0 )
    	{
    		alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna uzyc w tym miejscu znaku silni", "Znak silni nie moze zostac uzyty na poczatu", ButtonType.OK);
    		return;
    	}
    	char last = textField.getText().charAt( textField.getText().length() - 1 );
    	if ( textField.getText().length() > 1 )
    	{
    		char prelast = textField.getText().charAt( textField.getText().length() - 2 );
    		if ( last == '2' && prelast == '^' )
    			alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna wykonac tej operacji", "Po znaku potegi mozna dac tylko opeartory", ButtonType.OK);
    	}
    	if ( textField.getText().length() != 0 )
    	{
        	if ( last == ')' || isNumber(last) )
        	{
            	textField.setText(textField.getText() + "!" );
            	return;
        	}
    	}
    	alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna uzywac silni w tej sytuacji.", "Silnia jest dozwolona tylko za ')' i za liczbami", ButtonType.OK);
    
    }

    @FXML
    void Button_Numbers(ActionEvent event) 
    {
    	if ( textField.getText().length() != 0 )
    	{
    		char last = textField.getText().charAt( textField.getText().length() - 1 );
        	if ( textField.getText().length() > 1 )
        	{
        		char prelast = textField.getText().charAt( textField.getText().length() - 2 );
        		if ( last == '2' && prelast == '^' )
        		{
        			alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna wykonac tej operacji", "Po znaku potegi mozna dac tylko opeartory", ButtonType.OK);
        			return;
        		}
        	}
    		if ( isOperator(last) || isNumber(last) || last == '.' || last == '(' )
    		{
        		if ( textField.getText().length() > 1 )
        		{
            		char prelast = textField.getText().charAt(textField.getText().length() - 2);
            		if ( last == '0' && isOperator(prelast))
            		{
            			Button_Clear( event );
            		}
        		}
        		if ( textField.getText().length() == 1 && textField.getText().charAt(0) == '0' )
        		{
        			Button_Clear( event );
        		}
    		}
    		else
    		{
    			alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna uzywac liczb w tej sytuacji.", "Liczby s¹ dozwolone tylko po opeatorach i innych liczbach", ButtonType.OK);
    			return;
    		}
    	}
    	Button temporary = (Button) event.getSource();
        textField.setText(textField.getText() + temporary.getText());
    }

    @FXML
    void Button_Percent(ActionEvent event) 
    {
    	if ( textField.getText().length() == 0 )
    	{
    		alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna uzyc w tym miejscu znaku procentu", "Znak procentu nie moze zostac uzyty na poczatu", ButtonType.OK);
    		return;
    	}
    	char last = textField.getText().charAt( textField.getText().length() - 1 );
    	if ( textField.getText().length() > 1 )
    	{
    		char prelast = textField.getText().charAt( textField.getText().length() - 2 );
    		if ( last == '2' && prelast == '^' )
    		{
    			alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna wykonac tej operacji", "Po znaku potegi mozna dac tylko opeartory", ButtonType.OK);
    			return;
    		}
    	}
    	if ( ( last == '%' || !isNumber(last) ) && last != ')' )
    	{
    		alert.show(AlertType.WARNING, "OSTRZEZENIE", "Znaku procentu nie mozna uzyc w tym miejscu", "Mozna go uzyc tylko po opeartorach albo po nawiasie", ButtonType.OK);
    	}
    	else
    	{
        	textField.setText(textField.getText() + "%" );
    	}
    }

    @FXML
    void Button_Square_Root(ActionEvent event) 
    {
        {
        	if ( textField.getText().length() != 0 )
        	{
            	char last = textField.getText().charAt( textField.getText().length() -1 );
            	if ( isOperator(last) || last == '('  )
            	{
                	textField.setText(textField.getText() + "sqrt" + '(' );
            	}
            	else
            		alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna uzywac pierwiastka w tej sytuacji.", "Pierwiastek jest dozwolony tylko po operatorach", ButtonType.OK);
        	}
        	else
        	{
            	textField.setText(textField.getText() +"sqrt" + '(' );
        	}
        		

        }
    }

    @FXML
    void Button_Times(ActionEvent event) 
    {
    	if ( textField.getText().length() == 0 )
    	{
    		alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozesz rozpoczac od operatora.", "", ButtonType.OK);
    	}
    	else if ( isOperator( textField.getText().charAt( textField.getText().length() - 1 ) ) )
    	{
    		String temporary2 = new String (textField.getText() );
    		temporary2 = temporary2.substring(0, temporary2.length()-1 );
    		textField.setText( temporary2 );
    		textField.setText(textField.getText() + "*");
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
    		alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozesz rozpoczac od operatora.", "", ButtonType.OK);
    	}
    	else if ( isOperator( textField.getText().charAt( textField.getText().length() - 1 ) ) )
    	{
    		String temporary2 = new String (textField.getText() );
    		temporary2 = temporary2.substring(0, temporary2.length()-1 );
    		textField.setText( temporary2 );
    		textField.setText(textField.getText() + temporary.getText());
    	}
    	else
    		textField.setText(textField.getText() + temporary.getText());
    }

    @FXML
    void Button_square(ActionEvent event) 
    {
    	
    	if ( textField.getText().length() != 0 )
    	{
    		char last = textField.getText().charAt( textField.getText().length() - 1 );
        	if ( textField.getText().length() > 1 )
        	{
        		char prelast = textField.getText().charAt( textField.getText().length() - 2 );
        		if ( last == '2' && prelast == '^' )
        		{
        			alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna wykonac tej operacji", "Po znaku potegi mozna dac tylko opeartory", ButtonType.OK);
        			return;
        		}
        	}
        	if ( last == ')' || isNumber(last) )
        	{
            	textField.setText(textField.getText() + "^2" );
            	return;
        	}
    	}
    	alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna uzywac kwadratu w tej sytuacji.", "Kwadrat jest dozwolona tylko za ')' i za liczbami", ButtonType.OK);
    
    }
    
    @FXML
    void Button_dot(ActionEvent event) 
    {
    	if ( textField.getText().length() != 0 )
    	{
    		char last = textField.getText().charAt( textField.getText().length() - 1 );
        	if ( textField.getText().length() > 1 )
        	{
        		char prelast = textField.getText().charAt( textField.getText().length() - 2 );
        		if ( last == '2' && prelast == '^' )
        		{
        			alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna wykonac tej operacji", "Po znaku potegi mozna dac tylko opeartory", ButtonType.OK);
        			return;
        		}
        	}
    		int flag=0;
    		for ( int counter = textField.getText().length()-1 ; counter >= 0  ; counter-- )
    		{
    			if ( isNumber (textField.getText().charAt( counter ) ) )
    				continue;
    			if ( textField.getText().charAt( counter ) == '.' )
    				flag = 1;
    			if ( isOperator (textField.getText().charAt( counter ) ) )
    				break;
    		}
        	if ( !isOperator(last) && (last != '(' && last != ')' && last != '!' && last != '%') )
        	{
        		if ( flag == 0 )
        		{
                	Button temporary = (Button) event.getSource();
                	textField.setText(textField.getText() + temporary.getText() );
                	return;
        		}
        	}
        	alert.show(AlertType.WARNING, "OSTRZEZENIE", "Nie mozna uzywac kropki w tej sytuacji.", "Kropka jest dozwolona tylko raz w liczbie", ButtonType.OK);
    			
    	}
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
