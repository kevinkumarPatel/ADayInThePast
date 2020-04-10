package thingsOnMap;

import java.util.ArrayList;
import characterMovement.Character;
import characterMovement.Enemy;

/**
 * @author Filip Cotra, Theodore Lun
 * Position class has information about character position
 * on map, as well as ability to check the status of every
 * position on the map 
 */
public class Position{
	int charPosition;
	Character player1;
	Enemy player2;
	int[][] charMap;
	
	/**
	 * constructor creates character object in order
	 * to access character methods. Also sets initial 
	 * position on the map
	 * @param charName
	 * @param charGender
	 */
	
	public Position(String charName, String charGender) {
		player1 = new Character(charName, charGender);
		this.setPos();
	}

	public Position(Collectibles player1) {
		player2 = new Enemy(player1.getMap(), player1.player1);
	}

	/**
	 * checks position of a certain grid point. If an 
	 * exception is thrown due to leaving array bounds,
	 * returns useless value (20)
	 * @param checkX - x coordinate to be checked
	 * @param checkY - y coordinate to be checked
	 * @return
	 */
	public int checkPos(int checkX, int checkY) {
		try {
			int[][] tempMap = this.getMap();
			return tempMap[checkX][checkY];
		}
		catch(Exception ArrayIndexOutOfBounds) {
			return 20;
		}
	}
	
	/**
	 * overloads checkPos method to include map to check,
	 * used for checking enemy position due to solve null 
	 * pointer exceptions when using previous method
	 * @param checkX - x coordinate to be checked
	 * @param checkY - y coordinate to be checked
	 * @param aMap - map to check space on
	 * @return
	 */
	public int checkPos(int checkX, int checkY, int[][] aMap) {
		try {
			int[][] tempMap = aMap;
			return tempMap[checkX][checkY];
		}
		catch(Exception ArrayIndexOutOfBounds) {
			return 20;
		}
	}
	
	/**
	 * sets charMap to be initial map from character
	 * class, creates charPosition on this map
	 */
	public void setPos() {
		this.charMap = player1.getMap();
		this.charPosition = this.charMap[player1.getX()][player1.getY()];
	}
	
	/**
	 * sets enemy x coordinate
	 * @param X - x coordinate to be set
	 */
	public void setEnemyX(int X) {
		player2.setEnemyX(X);
	}
	
	/**
	 * sets enemy y coordinate
	 * @param Y - y coordinate to be set
	 */
	public void setEnemyY(int Y) {
		player2.setEnemyY(Y);
	}
	
	/**
	 * checks if position above is open, 
	 * if so moves character up
	 */
	public void isOpenUp(){
		player1.setDirection("Up");
		try {
			if (this.checkPos(player1.getX(),  player1.getY() - 1) == player1.returnOpen()|| this.checkPos(player1.getX(), player1.getY() - 1) == player1.returnExit() ||
				this.checkPos(player1.getX(), player1.getY() - 1) == player1.returnPowerUp() || this.checkPos(player1.getX(), player1.getY() - 1) == player1.returnEvidence() ||
				this.checkPos(player1.getX(), player1.getY() - 1) == player1.returnFinished()){
				player1.moveUp();
				this.setPos();
			}
			else {
			}
			if (this.isDone()) {
				player1.setX(2);
				player1.setY(2);
				this.charPosition = player1.returnOpen();
				player1.setMap(player1.reachedExit());
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}

	/**
	 * checks if position below is open, 
	 * if so moves character down
	 */
	public void isOpenDown(){
		player1.setDirection("Down");
		try {
			if (this.checkPos(player1.getX(),  player1.getY() + 1) == player1.returnOpen()|| this.checkPos(player1.getX(), player1.getY() + 1) == player1.returnExit() ||
				this.checkPos(player1.getX(), player1.getY() + 1) == player1.returnPowerUp() || this.checkPos(player1.getX(), player1.getY() + 1) == player1.returnEvidence() ||
				this.checkPos(player1.getX(), player1.getY() + 1) == player1.returnFinished()){
				player1.moveDown();
				this.setPos();
			}
			else {
			}
			if (this.isDone()) {
				player1.setX(2);
				player1.setY(2);
				this.charPosition = player1.returnOpen();
				player1.setMap(player1.reachedExit());
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}

	/**
	 * checks if position to the right is open, 
	 * if so moves character right
	 */
	public void isOpenRight(){
		player1.setDirection("Right");
		try {
			if (this.checkPos(player1.getX() + 1,  player1.getY()) == player1.returnOpen()|| this.checkPos(player1.getX() + 1, player1.getY()) == player1.returnExit() ||
				this.checkPos(player1.getX() + 1, player1.getY()) == player1.returnPowerUp() || this.checkPos(player1.getX() + 1, player1.getY()) == player1.returnEvidence() ||
				this.checkPos(player1.getX() + 1, player1.getY()) == player1.returnFinished()){
				player1.moveRight();
				this.setPos();
			}
			else {
			}
			if (this.isDone()) {
				player1.setX(2);
				player1.setY(2);
				this.charPosition = player1.returnOpen();
				player1.setMap(player1.reachedExit());
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}

	/**
	 * checks if position to the left is open, 
	 * if so moves character left
	 */
	public void isOpenLeft(){
		player1.setDirection("Left");
		try {
			if (this.checkPos(player1.getX() - 1,  player1.getY()) == player1.returnOpen()|| this.checkPos(player1.getX() - 1, player1.getY()) == player1.returnExit() ||
				this.checkPos(player1.getX() - 1, player1.getY()) == player1.returnPowerUp() || this.checkPos(player1.getX() - 1, player1.getY()) == player1.returnEvidence() ||
				this.checkPos(player1.getX() - 1, player1.getY()) == player1.returnFinished()){
				player1.moveLeft();
				this.setPos();
			}
			else {
			}
			if (this.isDone()) {
				player1.setX(2);
				player1.setY(2);
				this.charPosition = player1.returnOpen();
				player1.setMap(player1.reachedExit());
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}

	/**
	 * checks if the character has exited the level, if so returns
	 * true
	 */
	public boolean isDone(){
		if(this.charPosition == player1.returnExit()){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * checks if the character has finished the game, if so returns
	 * true
	 */
	public boolean isFinished(){
		if(this.charPosition == player1.returnFinished()){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * returns map from character class getMap()
	 * @return
	 */
	public int[][] getMap(){
		return player1.getMap();
	}
	
	/**
	 * calls character setX()
	 * @param xPos - x coordinate to be set
	 */
	public void setX(int xPos) {
		player1.setX(xPos);
	}
	
	/**
	 * returns value from character getX()
	 * @return
	 */
	public int getX() {
		return player1.getX();
	}
	
	/**
	 * calls character setY()
	 * @param xPos - y coordinate to be set
	 */
	public void setY(int yPos) {
		player1.setY(yPos);
	}
	
	/**
	 * returns value from character getY()
	 * @return
	 */
	public int getY() {
		return player1.getY();
	}
	
	/**
	 * checks if space is open, if so calls enemyMoveUp() and setEnemyPos()
	 * to move enemy position and update enemy position value on map
	 */
	public void enemyMoveUp() {
		player2.setDirection("Up");
		try {
			if (this.checkPos(player2.getEnemyX(),  player2.getEnemyY() - 1, player2.getEnemyMap()) == player2.returnOpen()||
				this.checkPos(player2.getEnemyX(), player2.getEnemyY() - 1, player2.getEnemyMap()) == player2.returnPowerUp()|| 
				this.checkPos(player2.getEnemyX(), player2.getEnemyY() - 1, player2.getEnemyMap()) == player2.returnEvidence()){
				player2.enemyMoveUp();
				player2.setEnemyPos();
			}
			else {
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}
	
	/**
	 * checks if space is open, if so calls enemyMoveUp() and setEnemyPos()
	 * to move enemy position and update enemy position value on map
	 */
	public void enemyMoveDown() {
		player2.setDirection("Down");
		try {
			if (this.checkPos(player2.getEnemyX(),  player2.getEnemyY() + 1, player2.getEnemyMap()) == player2.returnOpen()||
				this.checkPos(player2.getEnemyX(), player2.getEnemyY() + 1, player2.getEnemyMap()) == player2.returnPowerUp() || 
				this.checkPos(player2.getEnemyX(), player2.getEnemyY() + 1, player2.getEnemyMap()) == player2.returnEvidence()){
				player2.enemyMoveDown();
				player2.setEnemyPos();
			}
			else {
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}
	
	/**
	 * checks if space is open, if so calls enemyMoveUp() and setEnemyPos()
	 * to move enemy position and update enemy position value on map
	 */
	public void enemyMoveRight() {
		player2.setDirection("Right");
		try {
			if (this.checkPos(player2.getEnemyX() + 1,  player2.getEnemyY(), player2.getEnemyMap()) == player2.returnOpen()||
				this.checkPos(player2.getEnemyX() + 1, player2.getEnemyY(), player2.getEnemyMap()) == player2.returnPowerUp()|| 
				this.checkPos(player2.getEnemyX() + 1, player2.getEnemyY(), player2.getEnemyMap()) == player2.returnEvidence()){
				player2.enemyMoveRight();
				player2.setEnemyPos();
			}
			else {
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}
	
	/**
	 * checks if space is open, if so calls enemyMoveUp() and setEnemyPos()
	 * to move enemy position and update enemy position value on map
	 */
	public void enemyMoveLeft() {
		player2.setDirection("Left");
		try {
			if (this.checkPos(player2.getEnemyX() - 1,  player2.getEnemyY(), player2.getEnemyMap()) == player2.returnOpen()|| 
					this.checkPos(player2.getEnemyX() - 1, player2.getEnemyY(), player2.getEnemyMap()) == player2.returnPowerUp() || 
					this.checkPos(player2.getEnemyX() - 1, player2.getEnemyY(), player2.getEnemyMap()) == player2.returnEvidence()){
				player2.enemyMoveLeft();
				player2.setEnemyPos();
			}
			else {
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}
	
	/**
	 * returns enemy x coordinate
	 * @return
	 */
	public int getEnemyX() {
		return player2.getEnemyX();
	}
	
	/**
	 * returns enemy y coordinate
	 * @return
	 */
	public int getEnemyY() {
		return player2.getEnemyY();
	}
	
	/**
	 * calls enemyCutTree() to allow enemy to cut down
	 * trees
	 */
	public void enemyCutTree() {
		player2.enemyCutTree();
	}
	
	/**
	 * returns enemy position value
	 * @return
	 */
	public int getEnemyPos() {
		return player2.getEnemyPos();
	}
}

