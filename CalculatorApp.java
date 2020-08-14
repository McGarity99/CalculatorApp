import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
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

public class CalculatorApp extends Stage {

	HBox container;
	HBox textHolder;
	HBox firstRow;
	HBox secondRow;
	HBox thirdRow;
	HBox fourthRow;
	VBox root;
	Scene mainScene;
	GridPane thePane;
	Text numberBox;
	Text nameBox;
	String inputStr = "";
	long num1 = 0;
	String operatorChar = "";
	boolean start = true;
	boolean numEntered = false;
	boolean calculated = false;
	
	EventHandler<ActionEvent> numClick, clearClick, operatorClick;
	
	Button zeroB, oneB, twoB, threeB, fourB, fiveB, sixB, sevenB, eightB, nineB, clearB,
	plusB, minusB, equalsB, divB, multB;
	
	/**
	 * This method is the default constructor
	 * and initializes the {@code CalculatorApp} object by
	 * calling all necessary methods in order to build the
	 * scene and set up action events, etc.
	 */
	
	CalculatorApp() {
		setUpEvents();
		setUpButtons();
		setUpOther();
		setUpScene();
	} //constructor
	
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
		
		nameBox = new Text("Hunter McGarity | v1.0 | 8-2020");
		nameBox.setFill(Color.AQUA);
		
		root = new VBox(12);
		root.getChildren().addAll(textHolder, fourthRow, thirdRow, secondRow, firstRow, nameBox);
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
		this.setTitle("Calculator App");
		this.setScene(mainScene);
		this.show();
		
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
		
		clearClick = event -> {
			inputStr = "";
			numEntered = false;
			numberBox.setText(inputStr);
		};
		
		operatorClick = event -> {
			inputOperators(event);
		};
		
	} //setUpEvents
	
	/**
	 * This method performs the actual calculation specified by the user's
	 * interation with the calculator. It uses a switch statement to differentiate between
	 * the different operator buttons the user may select.
	 * 
	 * @param num1 the double representing the first number entered by the user
	 * @param num2 the double representing the second number entered by the user (after the operator)
	 * @param operation the String representing the mathematical operation the user wishes to carry out
	 * between num1 & num2
	 */
	
	private double calculate(double num1, double num2, String operation) {
		switch(operation) {
		
		case ("-"):
			return num1 - num2;
		
		case ("+"):
			return num1 + num2;
		
		case ("*"):return num1 * num2;
		
		case ("/"):
			if (num2 == 0) {
				return 0;
			} //if num2 is zero
			return num1 / num2;
		
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
		if (start == true) {
			numberBox.setText("");
			start = false;
		} //if
		String numValue = ((Button)numInput.getSource()).getText();
		numberBox.setText(numberBox.getText() + numValue);
		numEntered = true;
	} //inputNumbers
	
	/**
	 * This method is executed by the ActionEvent assigned to all operator
	 * buttons ont the calculator, and is responsible for "logging" the user's
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
			num1 = Long.parseLong(numberBox.getText());
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
			start = true;
			numEntered = false;
		} //else (if user clicked "=")
		} //if there is an actual number on which to perform calculations
	} //inputOperators
	
} //class
