package com.kaczmii.calculator.view;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.kaczmii.calculator.model.Calculator;

public class InterfaceController
{
	private Calculator calc = new Calculator();
	
    @FXML
    private TextField textField;

    @FXML
    private Button sqrt;

    @FXML
    private Button percent;

    @FXML
    private Button square;

    @FXML
    private Button cube;

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
    private Button plusminus;

    @FXML
    private Button zero;

    @FXML
    private Button dot;

    @FXML
    private Button equal;

    @FXML
    void Button_Clear(ActionEvent event) 
    {
    	if ( textField.getText().length() != 0 )
    	{
    		String temporary = new String (textField.getText() );
    		temporary = temporary.substring(0, temporary.length()-1 );
    		textField.setText( temporary );
    	}
    	else
    	{
    		//AlertBox
    		System.out.println("Alert");
    	}
    }

    @FXML
    void Button_Clear_Everything(ActionEvent event) 
    {
    	textField.setText("");
    }

    @FXML
    void Button_Cube(ActionEvent event) 
    {
    	
    }

    @FXML
    void Button_Equals(ActionEvent event) 
    {
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

    }

    @FXML
    void Button_Plus_Minus(ActionEvent event) 
    {

    }

    @FXML
    void Button_Square_Root(ActionEvent event) 
    {

    }

    @FXML
    void Button_Times(ActionEvent event) 
    {

    }

    @FXML
    void Button_operator(ActionEvent event)
    {
    	
    	Button temporary = (Button) event.getSource();
    	textField.setText(textField.getText() + temporary.getText());
    }

    @FXML
    void Button_square(ActionEvent event) 
    {
    	
    }


}
