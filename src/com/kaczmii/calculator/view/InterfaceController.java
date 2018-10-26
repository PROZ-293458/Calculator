package com.kaczmii.calculator.view;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InterfaceController implements Initializable 
{

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
    private Button coma;

    @FXML
    private Button equal;

    @FXML
    void Button_Clear(ActionEvent event) 
    {
    	
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
    	
    }

    @FXML
    void Button_square(ActionEvent event) 
    {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub
		
	}

}
