package application;
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

public class map extends Application
{	
	    @Override
	    public void start(Stage primaryStage) {
	    	
	    	Text text = new Text();
	    	primaryStage.setTitle("Grid World");
	    	GridPane grid = new GridPane();
	    	Pane backgroundcolor = new Pane();
	    	Rectangle character = new Rectangle(135, 180, 45, 45);	    	
	    	character.setFill(Color.DARKSALMON);
	        
	        //https://stackoverflow.com/questions/42417123/player-character-not-adding-to-gridpane-javafx
	        for (int rows = 0; rows < mapdesign().length; rows++) {	        	
	            for (int columns = 0; columns < mapdesign()[rows].length; columns++) {
	            	if (mapdesign()[rows][columns] == TREE) {
	            		Rectangle treeBlock = new Rectangle(rows * 45, columns * 45, 45, 45);
	            		treeBlock.setFill(Color.BROWN);
	                    backgroundcolor.getChildren().add(treeBlock);
	            	}
	            	else if (mapdesign()[rows][columns] == EVIDENCE) {
	            		Circle evidenceBlock = new Circle(rows * 45 + 22.5, columns * 45 + 22.5, 22.5);
	            		evidenceBlock.setFill(Color.BLACK);
	                    backgroundcolor.getChildren().add(evidenceBlock);
	            	}
	            	else if (mapdesign()[rows][columns] == POWERUP) {
	            		Circle powerupBlock = new Circle(rows * 45 + 22.5, columns * 45 + 22.5, 22.5);
	            		powerupBlock.setFill(Color.CORNFLOWERBLUE);
	                    backgroundcolor.getChildren().add(powerupBlock);
	            	}
	            	
	            }
	        }
	        
	        int rows = mapdesign().length; // row
	        int columns = mapdesign()[0].length; // col
            grid.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));            
            
            for (int i = 0; i < columns; i++) {
                ColumnConstraints columnn = new ColumnConstraints(45);
                grid.getColumnConstraints().add(columnn);
                	
            }
            for (int i = 0; i < rows; i++) {
                RowConstraints row = new RowConstraints(45);
                grid.getRowConstraints().add(row);
            }
            
            backgroundcolor.getChildren().addAll(character);
	    	grid.setGridLinesVisible(true);
	    	
	    	StackPane gamepane = new StackPane();
	    	gamepane.getChildren().addAll(backgroundcolor,grid,text);
	    	Scene gamescene = new Scene(gamepane, 45 * rows ,45 *columns, Color.GREEN);
	    	
	    	
	    	//gamescene.setOnKeyPressed(event -> text.setText(event.getCode().toString()));
	      gamescene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
	    		if(event.getCode() == KeyCode.RIGHT) {
	    			double moveX = character.getX();
	    			moveX = moveX + 45;
	    			character.setX(moveX);
	    		}
	    		else if(event.getCode() == KeyCode.LEFT){
	    			double moveX = character.getX();
		    		moveX = moveX - 45;	                
		    		character.setX(moveX);
	            }
	    		else if(event.getCode() == KeyCode.UP) {
		    		double moveY = character.getY();
	            	moveY = moveY - 45;
	                character.setY(moveY);
	            }
	    		else if(event.getCode() == KeyCode.DOWN){
		    		double moveY = character.getY();
	            	moveY = moveY + 45;
	                character.setY(moveY);
	            }
			}
	    	  
	      });
	    	
	    	//gamescene.setOnKeyReleased(event -> new EventHandler<KeyEvent>());
	    	
	        primaryStage.setScene(gamescene);
	        primaryStage.show();
	        
	    }
	    
	    int BOULDER = -1;
		int TREE = -2;
		int WALL = -3;
		int OPEN = 0;
		int EVIDENCE = 1;
		int POWERUP = 2;
		int EXIT = 3;
				
	    public int [][] mapdesign(){
	    	int[][] mapoutline = {{1,1,1,1,1,1},
	    			{1,0,0,0,0,1},
	    			{1,0,0,0,0,1},
	    			{1,0,0,0,0,1},
	    			{1,0,0,0,0,1},
	    			{1,1,1,1,1,1}};
	    	int[][] map1 = {{OPEN, OPEN, POWERUP, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, TREE, TREE, TREE, OPEN}, {OPEN, TREE, EVIDENCE, TREE, OPEN}};
	    	return map1;
	    }
	    
	    public static void main(String[] args) {
	        launch(args);
	    }


	
}

