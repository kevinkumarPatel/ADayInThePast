package GUI;

import characterMovement.Character;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.ImagePattern;

/**
 * @author Filip Cotra, Theodore Lun
 * MapVisual class is an application that displays the character
 * map being used, reflecting the current position being loaded through
 * scenes. New scenes are created to reflect changes in the map
 */
public class MapVisual extends Application
{	
	/**
	 * instance variables including a character object,
	 * starting position coordinate values, status constants, and
	 * grids, panes, scenes, and images
	 */
	Character charStartPos = new Character(null, null);	
	int charX = charStartPos.getX();
	int charY = charStartPos.getY();
	int enemyX = 1;
	int enemyY = 2;
	int[][] loadedMap;
	public Stage mainStage;
	GridPane mainGrid;
	Pane backGroundPane;
	StackPane gamePane;
	Scene mainScene;
	int BOULDER = -1;
	int TREE = -2;
	int WALL = -3;
	int OPEN = 0;
	int EVIDENCE = 1;
	int POWERUP = 2;
	int EXIT = 3;
	Image charSprite = new Image("CHARACTER.png");
	Image groundSprite = new Image("GRASS.png");
	Image powerUpSprite = new Image("POWERUP.png");
	Image wallSprite = new Image("WALL.jpg");
	Image treeSprite = new Image("TREE.png");
	Image boulderSprite = new Image("BOULDER.png");
	Image evidenceSprite = new Image("EVIDENCE.png");
	Image exitSprite = new Image("EXIT.png");
	Image enemySprite = new Image("ENEMY.png");
	
	/**
	 * set map method to be specifically used to set the map
	 * to its initial state
	 * @param map - double array representing a map
	 */
	public void setInitialMap(int[][] map) {
		this.loadedMap = map;
	}
	
	/**
	 * start method for application, creates stage and calls
	 * methods to make scenes
	 */
	@Override
	public void start(Stage primaryStage) {
		this.mainStage = primaryStage;
		this.mainStage.setTitle("Grid World"); 
		this.mainStage.setScene(this.makeScene(this.charX, this.charY, this.enemyX, this.enemyY));
		this.mainStage.show();        
	}

	/**
	 * to be called when an action is taken in order to load a new map,
	 * will call appropriate methods to update scene on the 
	 * main stage
	 * @param currentMap - double array for map in its current state
	 * @param charX - character x coordinate
	 * @param charY - character y coordinate
	 */
	public void loadMap(int[][] currentMap, int charX, int charY, int enemyX, int enemyY) {
		this.charY = charY;
		this.charX = charX;
		this.enemyX = enemyX;
		this.enemyY = enemyY;
		this.loadedMap = currentMap;
		(this.getStage()).setScene(this.makeScene(this.charX, this.charY, this.enemyX, this.enemyY));
	}
	
	/**
	 * signifies ending of game, sets scene to be appropriate game 
	 * over message
	 * @param message - string for appropriate ending message
	 */
	public void gameOver(String message) {
		(this.getStage()).setScene(this.makeScene(message));
	}
	
	/**
	 * returns new stack pane
	 * @return
	 */
	public StackPane getPane() {
		return new StackPane();
	}
	
	/**
	 * returns main stage to allow modifications
	 * @return
	 */
	public Stage getStage() {
		return this.mainStage;
	}
	
	/**
	 * returns mainScene
	 * @return
	 */
	public Scene getScene() {
		return this.mainScene;
	}
	
	/**
	 * make scene message, used for game over screen
	 * @param message - string for message to be displayed
	 * @return
	 */
	public Scene makeScene(String message) {
		System.out.println(message);
		return new Scene(new Pane(), 300, 300, Color.BLACK);
	}
	
	/**
	 * overloads makeScene for non-gameover scenes, updates 
	 * scene to reflect current map with any alterations such as
	 * character position on map
	 * @param charX - character x coordinate
	 * @param charY - character y coordinate
	 * @return
	 */
	public Scene makeScene(int charX, int charY, int enemyX, int enemyY) {
	   	GridPane grid = new GridPane();
	   	mainGrid = grid;
	   	Pane backgroundcolor = new Pane();
	   	backGroundPane = backgroundcolor;
	   	/**
	   	 * loop through every point on the map
	   	 */
	    for (int rows = 0; rows < mapdesign().length; rows++) {	   
	    	for (int columns = 0; columns < mapdesign()[rows].length; columns++) {
	    		/**
	    		 * if map position equals TREE, make a tree rectangle with appropriate image
	    		 * added to that position on the corresponding GUI map
	    		 */
	           if (mapdesign()[rows][columns] == TREE) {
	           		Rectangle treeBlock = new Rectangle(rows * 45, columns * 45, 45, 45);
	           		treeBlock.setFill(new ImagePattern(this.treeSprite));
	           		backGroundPane.getChildren().add(treeBlock);
	           }
	    		/**
	    		 * if map position equals EXIT, make an exit rectangle with appropriate image
	    		 * added to that position on the corresponding GUI map
	    		 */
	           else if (mapdesign()[rows][columns] == EXIT) {
	           		Rectangle exitBlock = new Rectangle(rows * 45, columns * 45, 45, 45);
	           		exitBlock.setFill(new ImagePattern(this.exitSprite));
	           		backGroundPane.getChildren().add(exitBlock);
	           }
	    		/**
	    		 * if map position equals EVIDENCE, make an evidence rectangle added to that
	    		 * position on the corresponding GUI map
	    		 */
	           else if (mapdesign()[rows][columns] == EVIDENCE) {
	           		Rectangle exitBlock = new Rectangle(rows * 45, columns * 45, 45, 45);
	           		exitBlock.setFill(new ImagePattern(this.evidenceSprite));
	           		backGroundPane.getChildren().add(exitBlock);
	           }
	    		/**
	    		 * if map position equals WALL, make a wall rectangle with appropriate image
	    		 * added to that position on the corresponding GUI map
	    		 */
	           else if (mapdesign()[rows][columns] == WALL) {
	           		Rectangle wallBlock = new Rectangle(rows * 45, columns * 45, 45, 45);
	           		wallBlock.setFill(new ImagePattern(this.wallSprite));
	           		backGroundPane.getChildren().add(wallBlock);
	           }
	    		/**
	    		 * if map position equals POWERUP, make a powerup rectangle with appropriate image
	    		 * added to that position on the corresponding GUI map
	    		 */
	           else if (mapdesign()[rows][columns] == POWERUP) {
	           		Circle powerupBlock = new Circle(rows * 45 + 22.5, columns * 45 + 22.5, 22.5);
	           		powerupBlock.setFill(new ImagePattern(this.powerUpSprite));
	           		backGroundPane.getChildren().add(powerupBlock);
	           }
	    		/**
	    		 * if map position equals BOULDER, make a boulder rectangle with appropriate image
	    		 * added to that position on the corresponding GUI map
	    		 */
	           else if (mapdesign()[rows][columns] == BOULDER) {
	           		Circle boulderBlock = new Circle(rows * 45 + 22.5, columns * 45 + 22.5, 22.5);
	           		boulderBlock.setFill(new ImagePattern(this.boulderSprite));
	           		backGroundPane.getChildren().add(boulderBlock);
	           }
	           
	           /**
	            * if map position is equal to OPEN, EVIDENCE, or POWERUP, and character coordinates
	            * match current coordinates iterated through, create character rectangle with
	            * appropriate image and add it to the map
	            */
	           if (mapdesign()[rows][columns] == OPEN || mapdesign()[rows][columns] == EVIDENCE || 
	           	   mapdesign()[rows][columns] == POWERUP) {
	            	if (rows == charX && columns == charY) {
	    			   Rectangle character = new Rectangle(rows * 45, columns * 45, 45, 45);	    	
	    			   character.setFill(new ImagePattern(this.charSprite));
	    			   backGroundPane.getChildren().add(character);
	            	}
	            	else {
	            	}
	           }
	           
	           /**
	            * if map position is equal to OPEN, EVIDENCE, or POWERUP, and enemy coordinates
	            * match current coordinates iterated through, create enemy rectangle with
	            * appropriate image and add it to the map
	            */
	           if (mapdesign()[rows][columns] == OPEN || mapdesign()[rows][columns] == EVIDENCE || 
		           	   mapdesign()[rows][columns] == POWERUP) {
		            	if (rows == enemyX && columns == enemyY) {
		    			   Rectangle enemy = new Rectangle(rows * 45, columns * 45, 45, 45);	    	
		    			   enemy.setFill(new ImagePattern(this.enemySprite));
		    			   backGroundPane.getChildren().add(enemy);
		            	}
	           }
	    	}
	    }
	        
	    int rows = mapdesign().length; // row
	    int columns = mapdesign()[0].length; // col
	    mainGrid.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
	    /**
	     * set background pane background to represent all open positions on the map
	     */
        backGroundPane.setBackground(new Background(new BackgroundFill(new ImagePattern(this.groundSprite), CornerRadii.EMPTY, Insets.EMPTY)));
           
        /**
         * add rows and columns to the main grid
         */
        for (int i = 0; i < columns; i++) {
            ColumnConstraints columnn = new ColumnConstraints(45);
            mainGrid.getColumnConstraints().add(columnn);    	
        }
        for (int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(45);
            mainGrid.getRowConstraints().add(row);
        }
        
        mainGrid.setGridLinesVisible(false);
        
        /**
         * add both background pane and main grid to stackpane with main grid on
         * top
         */
	   	StackPane gamePane = new StackPane();
	    gamePane.getChildren().addAll(backGroundPane, mainGrid);
        
        Scene gamescene = new Scene(gamePane, 45 * rows, 45 * columns, Color.GREEN);
        mainScene = gamescene;
	    
        return mainScene;
	}
		
	/**
	 * returns loaded map
	 * @return
	 */
	public int [][] mapdesign(){
	    return this.loadedMap;
	}
	    
	/**
	 * main method, launches application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

