package keyBindController;

import GUI.MapVisual;
import thingsOnMap.Collectibles;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	Collectibles player2;
	
	/**
	 * Constructor creates object of collectibles to allow
	 * access to other methods
	 */
	public Controller(String name, String gender) {
		this.player1 = new Collectibles(name, gender);
		this.player2 = new Collectibles(player1);
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
		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
		
		/**
		 * if player is finished, go to game over screen
		 */
		if (player1.isFinished()) {
			if (player1.getEvidenceCount() >= 3) {
				showMap.gameOver("Congratulations, You Win!");
			}
			else {
				showMap.gameOver("You Lose! Remember: Evidence Is Key!");
			}
			
		}
		
		/**
		 * if player is not finished, check for input
		 */
		else {
		    (showMap.getScene()).setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {	
					
					/**
					 * if key input is D, move player 1 (Character) right
					 */
			    	if(event.getCode() == KeyCode.D) {
			    		/**
			    		 * if character enters exit square, set enemy coordinates back to
			    		 * initial ones
			    		 */
			    		if(player1.checkPos(player1.getX() + 1, player1.getY()) == 3) {
			    			player2.setEnemyX(3);
		    				player2.setEnemyY(2);
			    		}
			    		player1.isOpenRight();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		try{
			    			Thread.sleep(player1.getDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			    	}
			    	
					/**
					 * if key input is A, move player 1 (Character) left
					 */
			    	else if(event.getCode() == KeyCode.A){
			    		/**
			    		 * if character enters exit square, set enemy coordinates back to
			    		 * initial ones
			    		 */
			    		if(player1.checkPos(player1.getX() - 1, player1.getY()) == 3) {
			    			player2.setEnemyX(3);
		    				player2.setEnemyY(2);
			    		}
			    		player1.isOpenLeft();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		try{
			    			Thread.sleep(player1.getDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			        }
			    	
					/**
					 * if key input is W, move player 1 (Character) up
					 */
			    	else if(event.getCode() == KeyCode.W) {
			    		/**
			    		 * if character enters exit square, set enemy coordinates back to
			    		 * initial ones
			    		 */
			    		if(player1.checkPos(player1.getX(), player1.getY() - 1) == 3) {
			    			player2.setEnemyX(3);
		    				player2.setEnemyY(2);
			    		}
			    		player1.isOpenUp();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		try{
			    			Thread.sleep(player1.getDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			        }
			    	
					/**
					 * if key input is S, move player 1 (Character) down
					 */
			    	else if(event.getCode() == KeyCode.S){
			    		/**
			    		 * if character enters exit square, set enemy coordinates back to
			    		 * initial ones
			    		 */
			    		if(player1.checkPos(player1.getX(), player1.getY() + 1) == 3) {
			    			player2.setEnemyX(3);
		    				player2.setEnemyY(2);
			    		}
			    		player1.isOpenDown();
			    		player1.gotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		try{
			    			Thread.sleep(player1.getDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			        }
					/**
					 * if key input is Q, player 1 (Character) tries to cut tree
					 */
			    	else if(event.getCode() == KeyCode.Q) {
			    		player1.cutTree();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		gameLoop();
			    	}
					/**
					 * if key input is E, player 1 (Character) tries to dig
					 */
			    	else if(event.getCode() == KeyCode.E) {
			    		player1.gotEvidence();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		gameLoop();
			    	}
					/**
					 * if key input is up key, move player 2 (Enemy) up
					 */
			    	else if(event.getCode() == KeyCode.UP) {
			    		player2.enemyMoveUp();
			    		player2.enemyGotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		try{
			    			Thread.sleep(player2.getEnemyDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			    	}
					/**
					 * if key input is down key, move player 2 (Enemy) down
					 */
			    	else if(event.getCode() == KeyCode.DOWN) {
			    		player2.enemyMoveDown();
			    		player2.enemyGotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		try{
			    			Thread.sleep(player2.getEnemyDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			    	}
					/**
					 * if key input is left key, move player 2 (Enemy) left
					 */
			    	else if(event.getCode() == KeyCode.LEFT) {
			    		player2.enemyMoveLeft();
			    		player2.enemyGotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		try{
			    			Thread.sleep(player2.getEnemyDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			    	}
					/**
					 * if key input is right key, move player 2 (Enemy) right
					 */
			    	else if(event.getCode() == KeyCode.RIGHT) {
			    		player2.enemyMoveRight();
			    		player2.enemyGotPowerUp();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		try{
			    			Thread.sleep(player2.getEnemyDelay());
			    			gameLoop();
			    		}
			    		catch(InterruptedException ex) {
			    		}
			    	}
					/**
					 * if key input is enter key, player 2 (Enemy) tries to cut tree
					 */
			    	else if(event.getCode() == KeyCode.ENTER) {
			    		player2.enemyCutTree();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
			    		gameLoop();
			    	}
					/**
					 * if key input is shift key, player 2 (Enemy) tries to dig
					 */
			    	else if(event.getCode() == KeyCode.SHIFT) {
			    		player2.enemyGotEvidence();
			    		showMap.loadMap(player1.getMap(), player1.getX(), player1.getY(), player2.getEnemyX(), player2.getEnemyY());
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
	
