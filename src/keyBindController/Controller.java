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

/**
 * @author Filip Cotra, Theodore Lun
 * Controller class is key binded control that calls methods 
 * from other classes based on input to allow interaction with
 * and exploration of the map
 */
public class Controller{
	boolean characterDone = false;
	String charGender;
	String charName;
	MapVisual showMap = new MapVisual();
	Collectibles player1;
	
	/**
	 * Constructor creates object of collectibles to allow
	 * access to other methods
	 */
	public Controller(String name, String gender) {
		this.player1 = new Collectibles(name, gender);
	}
	
	/**
	 * sets initial map and starts initial application
	 */
	public void startMap() {
		showMap.setInitialMap(player1.getMap());
		showMap.start(new Stage());
	}
	
	/**loop that the game will go through, repeatedly
	 *asking for input from the player to move until the level is finished,
	 *at which point a new map will be loaded
	 */
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
		    (showMap.getScene()).setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {		
			    	if(event.getCode() == KeyCode.D) {
			    		player1.isOpenRight();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
			    		try{
			    			Thread.sleep(player1.getDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			    	}
			    	else if(event.getCode() == KeyCode.A){
			    		player1.isOpenLeft();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
			    		try{
			    			Thread.sleep(player1.getDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			        }
			    	else if(event.getCode() == KeyCode.W) {
			    		player1.isOpenUp();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
			    		try{
			    			Thread.sleep(player1.getDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			        }
			    	else if(event.getCode() == KeyCode.S){
			    		player1.isOpenDown();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY());
			    		try{
			    			Thread.sleep(player1.getDelay());
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
	
	/**
	 * returns character name entered
	 * @return
	 */
	public String getName() {
		return this.charName;
	}
	
	/**
	 * returns character gender selected
	 * @return
	 */
	public String getGender() {
		return this.charGender;
	}
	
	/**
	 * sets character name
	 * @param aName - string for character name
	 */
	public void setName(String aName) {
		this.charName = aName;
	}
	
	/**
	 * sets character gender
	 * @param aGender - string for character gender
	 */
	public void setGender(String aGender) {
		this.charGender = aGender;
	}
	
	/**
	 * main method, calls gameLoop() method to start
	 * receiving input
	 * @param args
	 */
	public static void main(String[] args) {
		Controller player1 = new Controller(null, null);
		player1.gameLoop();
	}
}
	
