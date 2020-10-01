import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

/**
 * 
 * @author Hunter McGarity
 * This class represents a {@code CalculatorApp} object
 * and possesses all necessary methods and variables for
 * carrying out execution of the application.
 */

public class CalculatorApp extends Application {

	HBox container;
	HBox textHolder;
	HBox firstRow;
	HBox secondRow;
	HBox thirdRow;
	HBox fourthRow;
	HBox fifthRow;
	VBox root;
	Scene mainScene;
	GridPane thePane;
	Text numberBox;
	Text nameBox;
	String inputStr = "";
	double num1 = 0.0; //represents user's first or only numeric input for operation
	String operatorChar = "";
	boolean start = true;
	boolean numEntered = false;
	boolean calculated = false;
	CalculatorApp theApp;
	Stage theStage = new Stage();
	
	EventHandler<ActionEvent> numClick, clearClick, operatorClick, unaryClick;
	
	Button zeroB, oneB, twoB, threeB, fourB, fiveB, sixB, sevenB, eightB, nineB, clearB,
	plusB, minusB, equalsB, divB, multB, pwrB, lnB, factorB, sqRootB;
	
	public static void main(String[] args) {
		launch(args);
	} //main method
	
	/**
	 * This is the overrided start method inherited from the {@code Application} class.
	 */
	
	@Override public void start(Stage stage) {
		setUpEvents();
		setUpButtons();
		setUpOther();
		setUpScene();
	} //sart
	
	/**
	 * This method is responsible for creating all the {@code Button} objects
	 * of the calculator and initializing them with appropriate text,
	 * {@code ActionEvents}, and background colors.
	 */
	
	private void setUpButtons() {
		
		zeroB = new Button("0");
		zeroB.setMinWidth(50);
		zeroB.setOnAction(numClick);
		zeroB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		zeroB.setTextFill(Color.AQUA);
		
		oneB = new Button("1");
		oneB.setMinWidth(50);
		oneB.setOnAction(numClick);
		oneB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		oneB.setTextFill(Color.AQUA);

		twoB = new Button("2");
		twoB.setMinWidth(50);
		twoB.setOnAction(numClick);
		twoB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		twoB.setTextFill(Color.AQUA);

		threeB = new Button("3");
		threeB.setMinWidth(50);
		threeB.setOnAction(numClick);
		threeB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		threeB.setTextFill(Color.AQUA);

		fourB = new Button("4");
		fourB.setMinWidth(50);
		fourB.setOnAction(numClick);
		fourB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		fourB.setTextFill(Color.AQUA);

		fiveB = new Button("5");
		fiveB.setMinWidth(50);
		fiveB.setOnAction(numClick);
		fiveB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		fiveB.setTextFill(Color.AQUA);

		sixB = new Button("6");
		sixB.setMinWidth(50);
		sixB.setOnAction(numClick);
		sixB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		sixB.setTextFill(Color.AQUA);

		sevenB = new Button("7");
		sevenB.setMinWidth(50);
		sevenB.setOnAction(numClick);
		sevenB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		sevenB.setTextFill(Color.AQUA);

		eightB = new Button("8");
		eightB.setMinWidth(50);
		eightB.setOnAction(numClick);
		eightB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		eightB.setTextFill(Color.AQUA);

		nineB = new Button("9");
		nineB.setMinWidth(50);
		nineB.setOnAction(numClick);
		nineB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		nineB.setTextFill(Color.AQUA);

		clearB = new Button("C");
		clearB.setMinWidth(50);
		clearB.setOnAction(clearClick);
		clearB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		clearB.setTextFill(Color.LIMEGREEN);

		plusB = new Button("+");
		plusB.setMinWidth(50);
		plusB.setOnAction(operatorClick);
		plusB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		plusB.setTextFill(Color.LIMEGREEN);

		minusB = new Button("-");
		minusB.setMinWidth(50);
		minusB.setOnAction(operatorClick);
		minusB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		minusB.setTextFill(Color.LIMEGREEN);

		equalsB = new Button("=");
		equalsB.setMinWidth(50);
		equalsB.setOnAction(operatorClick);
		equalsB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		equalsB.setTextFill(Color.LIMEGREEN);

		divB = new Button("/");
		divB.setMinWidth(50);
		divB.setOnAction(operatorClick);
		divB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		divB.setTextFill(Color.LIMEGREEN);

		multB = new Button("*");
		multB.setMinWidth(50);
		multB.setOnAction(operatorClick);
		multB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		multB.setTextFill(Color.LIMEGREEN);
		
		pwrB = new Button("^");
		pwrB.setMinWidth(50);
		pwrB.setOnAction(operatorClick);
		pwrB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		pwrB.setTextFill(Color.LIMEGREEN);
		
		factorB = new Button("!");
		factorB.setMinWidth(50);
		factorB.setOnAction(unaryClick);
		factorB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		factorB.setTextFill(Color.LIMEGREEN);
		
		lnB = new Button("ln(x)");
		lnB.setMinWidth(50);
		lnB.setOnAction(unaryClick);
		lnB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		lnB.setTextFill(Color.LIMEGREEN);
		
		sqRootB = new Button("√x");
		sqRootB.setMinWidth(50);
		sqRootB.setOnAction(unaryClick);
		sqRootB.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		sqRootB.setTextFill(Color.LIMEGREEN);

	} //setUpButtons
	
	/**
	 * This method sets up the scene graph by initializing several
	 * visual objects such as {@code HBox} and {@code VBox}. It then
	 * adds all children to their appropriate parent node in preparation 
	 * for the showing of the scene.
	 */
	
	private void setUpOther() {
		textHolder = new HBox();
		numberBox = new Text(inputStr);
		numberBox.setFill(Color.AQUA);
		HBox.setHgrow(numberBox, Priority.ALWAYS);
		numberBox.setTextAlignment(TextAlignment.RIGHT);
		textHolder.getChildren().add(numberBox);
		
		firstRow = new HBox(2);
		firstRow.getChildren().addAll(clearB, zeroB, equalsB, plusB);
		
		secondRow = new HBox(2);
		secondRow.getChildren().addAll(oneB, twoB, threeB, minusB);
		
		thirdRow = new HBox(2);
		thirdRow.getChildren().addAll(fourB, fiveB, sixB, divB);
		
		fourthRow = new HBox(2);
		fourthRow.getChildren().addAll(sevenB, eightB, nineB, multB);
		
		fifthRow = new HBox(2);
		fifthRow.getChildren().addAll(pwrB, factorB, lnB, sqRootB);
		
		nameBox = new Text("Hunter McGarity | v1.1 | 10-2020");
		nameBox.setFill(Color.AQUA);
		
		root = new VBox(8);
		root.getChildren().addAll(textHolder, fifthRow, fourthRow, thirdRow, secondRow, firstRow, nameBox);
		root.setPrefWidth(180);
		root.setPrefHeight(180);
		root.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
	} //setUpOther
	
	/**
	 * This method initializes the {@code Scene} and sets its title before showing it and thus 
	 * beginning the application's user-interaction.
	 */
	
	private void setUpScene() {
		
		mainScene = new Scene(root);
		theStage.setTitle("Calculator App");
		theStage.setScene(mainScene);
		theStage.show();
		
	} //setUpScene
	
	/**
	 * This method initializes all the {@code ActionEvent} objects that are
	 * assigned to the {@code Button}s on the calculator.
	 */
	
	private void setUpEvents() {
		numClick = event -> { 
			if (calculated) {
				numberBox.setText("");
				calculated = false;
			} //if previous answer is still on display
			inputNumbers(event);
		};
		
		clearClick = event -> { //special-case event for when the user clicks the clear button
			inputStr = "";
			numEntered = false;
			numberBox.setText(inputStr);
		};
		
		operatorClick = event -> { //event for when the user clicks any of the binary operator buttons
			inputOperators(event);
		};
		
		unaryClick = event -> { //event for when the user clicks any of the unary operator buttons
			inputOperatorsUnary(event);
		};
		
	} //setUpEvents
	
	/**
	 * This method performs the actual calculation specified by the user's
	 * interation with the calculator. It uses a switch statement to differentiate between
	 * the different operator buttons the user may select. This method is associated with
	 * all the calculator's binary operations.
	 * 
	 * @param num1 the double representing the first number entered by the user
	 * @param num2 the double representing the second number entered by the user (after the operator)
	 * @param operation the String representing the mathematical operation the user wishes to carry out
	 * between num1 & num2
	 */
	
	private double calculate(double num1, double num2, String operation) {
		double result;
		switch(operation) {
		
		case ("^"): //user clicked the power button
			result = Math.pow(num1, num2);
			numberBox.setText(Double.toString(result));
			numEntered = true;
			return result;
		
		case ("-"): //user clicked the subtraction button
			result = num1 - num2;
			numberBox.setText(Double.toString(result));
			numEntered = true;
			return result;
		
		case ("+"): //user clicked the addition button
			result = num1 + num2;
			numberBox.setText(Double.toString(result));
			numEntered = true;
			return result;
			
		case ("*"): //user clicked the multiplication button
			result = num1 * num2;
			numberBox.setText(Double.toString(result));
			numEntered = true;
			return result;
		
		case ("/"): //user clicked the division button
			if (num2 == 0) {
				return 0;
			} //if num2 is zero
			result = num1 / num2;
			numberBox.setText(Double.toString(result));
			numEntered = true;
			return result;
		
			default:
				return 0;
			
		} //switch statement for user-entered operation
	} //calculate
	
	/**
	 * This method is carried out by the ActionEvent assigned to all numeral
	 * buttons on the calculator, and is responsible for "logging" the user's
	 * clicked-number for calculations to be performed later.
	 * 
	 * @param numInput the ActionEvent that signals a numeral has been clicked by the user
	 */
	
	private void inputNumbers(ActionEvent numInput) {
		/*if (start == true) {
			numberBox.setText("");
			start = false;
		} //if*/
		String numValue = ((Button)numInput.getSource()).getText();
		numberBox.setText(numberBox.getText() + numValue);
		numEntered = true;
	} //inputNumbers
	
	/**
	 * This method is executed by the ActionEvent assigned to all operator (binary)
	 * buttons on the calculator, and is responsible for "logging" the user's
	 * clicked-operator for calculations to be performed later.
	 * 
	 * @param opInput the ActionEvent that signals an operator button has been clicked by the user
	 */
	
	private void inputOperators(ActionEvent opInput) {
		if (numEntered) {
		String opValue = ((Button)opInput.getSource()).getText();
		
		if (!opValue.contentEquals("=")) {
			if (!operatorChar.isEmpty()) {
				return;
			} //if an operator was clicked
			operatorChar = opValue;
			num1 = Double.parseDouble(numberBox.getText());
			numberBox.setText("");
		} //if equals button was not clicked
		
		else {
			if (operatorChar.isEmpty()) {
				return;
			} //if operatorChar is empty
			long num2 = Long.parseLong(numberBox.getText());
			double answer = calculate(num1, num2, operatorChar);
			numberBox.setText(String.valueOf(answer));
			calculated = true;
			operatorChar = "";
			//numEntered = false;
		} //else (if user clicked "=")
		} //if there is an actual number on which to perform calculations
	} //inputOperators
	
	/**
	 * This method calculates the factorial value of a specified double
	 * supplied as input.
	 */
	private double factorial(double input) {
		if (input < 0) {
			return 0;
		} //if user entered a negative number
		if (input == 0) {
		return 1;	
		} //base case
		else {
			return (input * factorial(input - 1));
		} //else (recursive case)
	} //factorial
	
	/**
	 * This method is executed by the ActionEvent assigned to all operator (unary)
	 * buttons on the calculator, and is responsible for "logging" the user's
	 * clicked-operator for calculations to be performed later.
	 * 
	 * @param opInput the ActionEvent that signals an operator button has been clicked by the user
	 */
	
	private void inputOperatorsUnary(ActionEvent opInput) {
		if (numEntered) {
		String opValue = ((Button)opInput.getSource()).getText();
		operatorChar = opValue;
			if (operatorChar.isEmpty()) {
				return;
			} //if operatorChar is empty
			num1 = Double.parseDouble(numberBox.getText());
			double answer = calculateUnary(num1, operatorChar);
			numberBox.setText(String.valueOf(answer));
			calculated = true;
			operatorChar = "";
			//numEntered = false;
		} //if there is an actual number on which to perform calculations
	} //inputOperatorsUnary
	
	/**
	 * This method performs the actual calculation specified by the user's
	 * interation with the calculator. It uses a switch statement to differentiate between
	 * the different operator buttons the user may select. This method is associated with
	 * all the calculator's unary operations.
	 * 
	 * @param num1 the double representing the first number entered by the user
	 * @param num2 the double representing the second number entered by the user (after the operator)
	 * @param operation the String representing the mathematical operation the user wishes to carry out
	 * between num1 & num2
	 */
	
	private double calculateUnary(double num, String operation) {
		double result;
		switch(operation) {
		
		case ("!"):
			result = factorial(num);
			numberBox.setText(Double.toString(result));
			numEntered = true;
			return result;
		
		case ("ln(x)"):
			result = Math.log(num);
			numberBox.setText(Double.toString(result));
			numEntered = true;
			return result;
		
		case ("√x"):
			result = Math.pow(num, 0.5);
			numberBox.setText(Double.toString(result));
			numEntered = true;
			return result;
		
			default:
				return 0;
			
		} //switch statement for user-entered operation
	} //calculate
	
} //class


