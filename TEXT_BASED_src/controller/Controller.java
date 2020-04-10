package controller;

import thingsOnMap.Collectibles;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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
	Collectibles player1;
	
	/**
	 * Constructor creates object of collectibles to allow
	 * access to other methods
	 */
	public Controller(String name, String gender) {
		this.player1 = new Collectibles(name, gender);
	}
	
	
	/**loop that the game will go through, repeatedly
	 *asking for input from the player to move until the level is finished,
	 *at which point a new map will be loaded
	 */
	public void gameLoop() {
		if (player1.isFinished()) {
			if (player1.getEvidenceCount() >= 3) {
				System.out.println("Congratulations, You Win!");
			}
			else {
				System.out.println("You Lose! Remember: Evidence Is Key!");
			}
			
		}
		else {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter command: ");
			String command = keyboard.nextLine();
			if(command.equalsIgnoreCase("move right")) {
				player1.isOpenRight();
				player1.gotPowerUp();
				try{
				    Thread.sleep(player1.getDelay());
				    gameLoop();
				}
			    catch(InterruptedException ex) {
			    }
			}
			else if(command.equalsIgnoreCase("move left")){
			    player1.isOpenLeft();
			    player1.gotPowerUp();
			    try{
			    	Thread.sleep(player1.getDelay());
			    	gameLoop();
			    }
			    catch(InterruptedException ex) {
			    }
			}
			else if(command.equalsIgnoreCase("move up")) {
			    player1.isOpenUp();
			    player1.gotPowerUp();
			   	try{
			    	Thread.sleep(player1.getDelay());
			    	gameLoop();
			    }
			    catch(InterruptedException ex) {
			    }
			}
			else if(command.equals("move down")){
			    player1.isOpenDown();
			    player1.gotPowerUp();
			    try{
			    	Thread.sleep(player1.getDelay());
			    	gameLoop();
			    }
			    catch(InterruptedException ex) {
			    }
			}
			else if(command.equalsIgnoreCase("cut")) {
			    player1.cutTree();
			    gameLoop();
			}
			else if(command.equalsIgnoreCase("dig")) {
			    player1.gotEvidence();
			    gameLoop();
			}
			else {
				System.out.println("Invalid command");
				gameLoop();
			}
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
	
