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
	private double moveX, moveY = 45;
	private double newX, newY = 45;
	

	    @Override
	    public void start(Stage primaryStage) {
	    	Text text = new Text();
	    	primaryStage.setTitle("Grid World");
	    	GridPane grid = new GridPane();
	    	Pane backgroundcolor = new Pane();
	    	Rectangle tree = new Rectangle(90, 45, 45, 90);
	    	Rectangle character = new Rectangle(135, 180, 45, 45);
	    	Circle boulder = new Circle(0,0,45);
	    	
	    	character.setFill(Color.DARKSALMON);
	        tree.setFill(Color.BROWN);
	        boulder.setFill(Color.GREY);
	        
	        //https://stackoverflow.com/questions/42417123/player-character-not-adding-to-gridpane-javafx
            int columns = 6;
            int rows = 6;
            grid.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));

            for (int i = 0; i < columns; i++) {
                ColumnConstraints columnn = new ColumnConstraints(45);
                grid.getColumnConstraints().add(columnn);
            }
            for (int i = 0; i < rows; i++) {
                RowConstraints row = new RowConstraints(45);
                grid.getRowConstraints().add(row);
            }
            
            backgroundcolor.getChildren().addAll(tree, character, boulder);
	    	grid.setGridLinesVisible(true);
	    	
	    	StackPane gamepane = new StackPane();
	    	gamepane.getChildren().addAll(backgroundcolor,grid,text);
	    	Scene gamescene = new Scene(gamepane, 400,400, Color.GREEN);
	    	
	    	
	    	//gamescene.setOnKeyPressed(event -> text.setText(event.getCode().toString()));
	      
	    	gamescene.setOnKeyPressed(event -> {
	    		if(event.getCode() == KeyCode.RIGHT) {
	                newX = character.getX() - moveX;
	    			character.setTranslateX(newX);
	    		}
	    		if(event.getCode() == KeyCode.LEFT){
	                newX = character.getX() + moveX;
	                character.setTranslateX(newX);
	            }
	            if(event.getCode() == KeyCode.UP) {
	                newY = character.getY() - moveY;
	                character.setTranslateY(newY);
	            }
	            if(event.getCode() == KeyCode.DOWN){
	                newY = character.getY() + moveY;
	                character.setTranslateY(newY);
	            }
	    		
	    	});
	    	
	    	gamescene.setOnKeyReleased(event -> text.setText(""));
	    	
	        primaryStage.setScene(gamescene);
	        primaryStage.show();
	        
	    }

	    public int [][] mapdesign(){
	    	int[][] mapoutline = {{1,1,1,1,1,1},
	    			{1,0,0,0,0,1},
	    			{1,0,0,0,0,1},
	    			{1,0,0,0,0,1},
	    			{1,0,0,0,0,1},
	    			{1,1,1,1,1,1}};
	    	return mapoutline;
	    }
	    
	    public static void main(String[] args) {
	        launch(args);
	    }


	
}

