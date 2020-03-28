package keyBindController;

import GUI.MapVisual;
import thingsOnMap.Collectibles;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

//Game class has all map constants through object m,
//map is assigned to map1 so that the first level if played
//first
public class Controller{
	boolean characterDone = false;
	String charGender;
	String charName;
	MapVisual showMap = new MapVisual();
	Collectibles player1;
	
	public Controller(String name, String gender) {
		this.player1 = new Collectibles(name, gender);
	}
	
	public void startMap() {
		showMap.setInitialMap(player1.getMap());
		showMap.start(new Stage());
	}
	//loop that the game will go through, repeatedly
	//asking for input from the player to move until the level is finished,
	//at which point a new map will be loaded
	
	public void gameLoop() {
		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
		if (player1.isFinished()) {
			if (player1.getEvidenceCount() >= 3) {
				showMap.gameOver("Congratulations, You Win!");
			}
			else {
				showMap.gameOver("You Lose! Remember: Evidence Is Key!");
			}
			
		}
		else {
	    	//gamescene.setOnKeyPressed(event -> text.setText(event.getCode().toString()));
		    (showMap.getScene()).setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {		
			    	if(event.getCode() == KeyCode.D) {
			    		player1.isOpenRight();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
						//if (player1.isDone()) {
							//player1.charX = 2;
							//player1.charY = 2;
							//player1.currentMap = player1.reachedExit(); 
						//}
			    		try{
			    			Thread.sleep(200);
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			    	}
			    	else if(event.getCode() == KeyCode.A){
			    		player1.isOpenLeft();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
						//if (player1.isDone()) {
							//player1.charX = 2;
							//player1.charY = 2;
							//player1.currentMap = player1.reachedExit();
						//}
			    		try{
			    			Thread.sleep(200);
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			        }
			    	else if(event.getCode() == KeyCode.W) {
			    		player1.isOpenUp();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
						//if (player1.isDone()) {
							//player1.charX = 2;
							//player1.charY = 2;
							//player1.currentMap = player1.reachedExit();
						//}
			    		try{
			    			Thread.sleep(200);
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			        }
			    	else if(event.getCode() == KeyCode.S){
			    		player1.isOpenDown();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
						//if (player1.isDone()) {
							///player1.setX(2);
							//player1.setY(2);
							//player1.setMap(player1.reachedExit());
				    		//showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
						//}
			    		try{
			    			Thread.sleep(200);
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			        }
			    	else if(event.getCode() == KeyCode.K) {
			    		player1.cutTree();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
			    		gameLoop();
			    	}
			    	else if(event.getCode() == KeyCode.SPACE) {
			    		player1.gotEvidence();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
			    		gameLoop();
			    	}
				} 	  
		    });
		}
	}
	
	public String getName() {
		return this.charName;
	}
	
	public String getGender() {
		return this.charGender;
	}
	
	public void setName(String aName) {
		this.charName = aName;
	}
	
	public void setGender(String aGender) {
		this.charGender = aGender;
	}
	
	public static void main(String[] args) {
		Controller player1 = new Controller(null, null);
		player1.gameLoop();
	}
}
	