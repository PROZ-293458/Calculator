/**
 * 
 */
/**
 * @author Kaczmii
 *
 */
module CalculatorApp11
{
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.base;
	opens com.kaczmii.calculator to javafx.graphics;
	opens com.kaczmii.calculator.view to javafx.fxml;
}