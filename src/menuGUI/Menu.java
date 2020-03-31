package menuGUI;

import keyBindController.Controller;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * @author Filip Cotra, Theodore Lun
 * GUI application for information menu, buttons and text
 * fields to take in information about character that 
 * player enters
 */
public class Menu extends Application{
	TextField nameField = new TextField("");
	String defaultAttribute = "Default";
	Button genderMale = new Button("Male");
	Button genderFemale = new Button("Female");
	Button continueYes = new Button("Yes");
	Button continueNo = new Button("No");
	Button updateButton = new Button("Enter");
	Label askName = new Label("Enter your name");
	Label genderLabel = new Label("Choose a Gender");
	Label finishedCheck = new Label("Are you finished creating your character?");
	Stage primaryStage = new Stage();
	Controller player1 = new Controller(defaultAttribute, defaultAttribute);
	
	/**
	 * GUI start method to open application. Following code  
	 * was taken and modified from Assignment 6
	 * //https://d2l.ucalgary.ca/d2l/le/content/295245/Home
	 */
	@Override 
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,200);
			
			FlowPane mainPane = new FlowPane();
			mainPane.setPadding(new Insets(10, 10, 10, 10));
			mainPane.setVgap(5);
				
			mainPane.getChildren().add(askName);
			mainPane.getChildren().add(this.buildNameRow());
			mainPane.getChildren().add(genderLabel);
			mainPane.getChildren().add(this.buildGenderRow());
			mainPane.getChildren().add(finishedCheck);
			mainPane.getChildren().add(this.buildContinueRow());
			
			root.getChildren().add(mainPane);
			primaryStage.setTitle("CPSC233_Project");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * builds HBox with buttons to choose character gender,
	 * makes buttons for male and female and handles events
	 * for these buttons to set characteristics of character class
	 * @return
	 */
	public HBox buildGenderRow() {
		HBox genderRow = new HBox();
		genderMale.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				player1.setGender("Male");
			}
		});
		genderFemale.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				player1.setGender("Female");
			}
		});
		genderRow.getChildren().add(genderMale);
		HBox.setMargin(genderMale, new Insets(10,10,10,10));
		genderRow.getChildren().add(genderFemale);
		HBox.setMargin(genderFemale, new Insets(10,10,10,10));
			
		return genderRow;
	}
		
	/**
	 * builds HBox for yes and no buttons asking whether
	 * it is ok for the game to be started. If yes is
	 * pressed, the game will be started by starting the map
	 * GUI and the game loop
	 * @return
	 */
	public HBox buildContinueRow() {
		HBox continueRow = new HBox();
		continueYes.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				player1.startMap();
				player1.gameLoop();
			}
		});
		continueNo.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			}
		});
		continueRow.getChildren().add(continueYes);
		HBox.setMargin(continueYes, new Insets(10,10,10,10));
		continueRow.getChildren().add(continueNo);
		HBox.setMargin(continueNo, new Insets(10,10,10,10));
		
		return continueRow;
	}

	/**
	 * builds HBox with text field for name entry,
	 * sets character name to entered name after presssing
	 * of update button
	 * @return
	 */
	public HBox buildNameRow() {
		HBox nameBox = new HBox();
		updateButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				player1.setName(nameField.getText());
			}
		});
		nameBox.getChildren().add(nameField);
		nameBox.getChildren().add(updateButton);
		
		return nameBox;
	}
}

