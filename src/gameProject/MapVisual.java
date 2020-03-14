package gameProject;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.paint.ImagePattern;

public class MapVisual extends Application
{	
	Map startMap = new Map();
	Character startPos = new Character(null, null);	
	int charX = startPos.getX();
	int charY = startPos.getY();
	int[][] loadedMap = startMap.getMap();
	public Stage mainStage;
	GridPane mainGrid;
	Pane backGroundPane;
	StackPane gamePane;
	Scene mainScene;
	Image charSprite = new Image("CHARACTER.png");
	Image groundSprite = new Image("GRASS.png");
	Image powerUpSprite = new Image("POWERUP.png");
	Image wallSprite = new Image("WALL.jpg");
	Image treeSprite = new Image("TREE.png");
	Image boulderSprite = new Image("BOULDER.png");
	Image evidenceSprite = new Image("EVIDENCE.png");
	Image exitSprite = new Image("EXIT.png");
	
	@Override
	public void start(Stage primaryStage) {
		this.mainStage = primaryStage;
		this.mainStage.setTitle("Grid World"); 
		this.mainStage.setScene(this.makeScene(this.charX, this.charY));
		this.mainStage.show();        
	}

	int BOULDER = -1;
	int TREE = -2;
	int WALL = -3;
	int OPEN = 0;
	int EVIDENCE = 1;
	int POWERUP = 2;
	int EXIT = 3;
				
	public void loadMap(int[][] currentMap, int charX, int charY) {
		this.charY = charY;
		this.charX = charX;
		this.loadedMap = currentMap;
		(this.getStage()).setScene(this.makeScene(this.charX, this.charY));
	}
	
	public StackPane getPane() {
		return new StackPane();
	}
	
	public Stage getStage() {
		return this.mainStage;
	}
	
	public Scene getScene() {
		return this.mainScene;
	}
	
	public Scene makeScene(int charX, int charY) {
	   	GridPane grid = new GridPane();
	   	mainGrid = grid;
	   	Pane backgroundcolor = new Pane();
	   	backGroundPane = backgroundcolor;
		//https://stackoverflow.com/questions/42417123/player-character-not-adding-to-gridpane-javafx
	    for (int rows = 0; rows < mapdesign().length; rows++) {	        	
	    	for (int columns = 0; columns < mapdesign()[rows].length; columns++) {
	           if (mapdesign()[rows][columns] == TREE) {
	           		Rectangle treeBlock = new Rectangle(rows * 45, columns * 45, 45, 45);
	           		treeBlock.setFill(new ImagePattern(this.treeSprite));
	           		backGroundPane.getChildren().add(treeBlock);
	           }
	           else if (mapdesign()[rows][columns] == EXIT) {
	           		Rectangle exitBlock = new Rectangle(rows * 45, columns * 45, 45, 45);
	           		exitBlock.setFill(new ImagePattern(this.exitSprite));
	           		backGroundPane.getChildren().add(exitBlock);
	           }
	           else if (mapdesign()[rows][columns] == EVIDENCE) {
	           		Rectangle exitBlock = new Rectangle(rows * 45, columns * 45, 45, 45);
	           		exitBlock.setFill(new ImagePattern(this.evidenceSprite));
	           		backGroundPane.getChildren().add(exitBlock);
	           }
	           else if (mapdesign()[rows][columns] == WALL) {
	           		Rectangle wallBlock = new Rectangle(rows * 45, columns * 45, 45, 45);
	           		wallBlock.setFill(new ImagePattern(this.wallSprite));
	           		backGroundPane.getChildren().add(wallBlock);
	           }
	           else if (mapdesign()[rows][columns] == POWERUP) {
	           		Circle powerupBlock = new Circle(rows * 45 + 22.5, columns * 45 + 22.5, 22.5);
	           		powerupBlock.setFill(new ImagePattern(this.powerUpSprite));
	           		backGroundPane.getChildren().add(powerupBlock);
	           }
	           else if (mapdesign()[rows][columns] == BOULDER) {
	           		Circle boulderBlock = new Circle(rows * 45 + 22.5, columns * 45 + 22.5, 22.5);
	           		boulderBlock.setFill(new ImagePattern(this.boulderSprite));
	           		backGroundPane.getChildren().add(boulderBlock);
	           }
	           if (mapdesign()[rows][columns] == OPEN || mapdesign()[rows][columns] == EVIDENCE) {
	            	if (rows == charX && columns == charY) {
	    			   Rectangle character = new Rectangle(rows * 45, columns * 45, 45, 45);	    	
	    			   character.setFill(new ImagePattern(this.charSprite));
	    			   backGroundPane.getChildren().add(character);
	            	}
	            	else {
	            	}
	           }
	    	
	    	}
	    }
	        
	    int rows = mapdesign().length; // row
	    int columns = mapdesign()[0].length; // col
	    mainGrid.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        backGroundPane.setBackground(new Background(new BackgroundFill(new ImagePattern(groundSprite), CornerRadii.EMPTY, Insets.EMPTY)));
            
        for (int i = 0; i < columns; i++) {
            ColumnConstraints columnn = new ColumnConstraints(45);
            mainGrid.getColumnConstraints().add(columnn);    	
        }
        for (int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(45);
            mainGrid.getRowConstraints().add(row);
        }
        
        mainGrid.setGridLinesVisible(false);
        
	   	StackPane gamePane = new StackPane();
	    gamePane.getChildren().addAll(backGroundPane, mainGrid);
        
        Scene gamescene = new Scene(gamePane, 45 * rows, 45 * columns, Color.GREEN);
        mainScene = gamescene;
	    
        return mainScene;
	}
		
	public int [][] mapdesign(){
	    return this.loadedMap;
	}
	    
	public static void main(String[] args) {
		launch(args);
	}
}

