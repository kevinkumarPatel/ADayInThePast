package characterMovement;

/**
 * @author Filip Cotra, Theodore Lun. G08, T02
 * Enemy class is player 2 character that can interact with the map
 * and is tasked with impeding progress. Can do all the same actions
 * as character class, but cannot transition levels.
 */
public class Enemy extends Map{
	/**
	 * instance variables set initial enemy coordinates and
	 * direction, initial enemy delay, and create a character object
	 */
	int enemyX = 1;
	int enemyY = 2;
	int[][] currentMap;
	String enemyDirection = "Up";
	int enemyDelay = 200;
	int enemyPos;
	Character protag;
	
	/**
	 * reduces enemy delay as powerups
	 */
	public void powerUp() {
		this.enemyDelay -= 10;
	}
	
	/**
	 * method to set block of map to be a certain value
	 * @param xPos - x coordinate to be set
	 * @param yPos - y coordinate to be set
	 * @param status - status (OPEN, TREE) to set position to 
	 */
	public void setBlock(int xPos, int yPos, int status) {
		protag.currentMap[xPos][yPos] = status;
	}
	
	/**
	 * returns enemy controller delay value
	 * @return
	 */
	public int getEnemyDelay() {
		return this.enemyDelay;
	}
	
	/**
	 * sets enemy position value based on current coordinates
	 */
	public void setEnemyPos() {
		this.enemyPos = protag.currentMap[this.getEnemyX()][this.getEnemyY()];
	}
	
	/**
	 * returns enemy position value
	 * @return
	 */
	public int getEnemyPos() {
		return this.enemyPos;
	}
	
	/**
	 * constructor that creates map object and character object
	 * @param aMap - current map to be used
	 * @param player1 - associated character object
	 */
	public Enemy(int[][] aMap, Character player1) {
		protag = player1;
		this.currentMap = aMap;
		this.setEnemyPos();
	}
	
	/**
	 * returns enemy position
	 * @return
	 */
	public String getEnemyDirection() {
		return this.enemyDirection;
	}
	
	/**
	 * checks if there is a tree to be cut in the direction the enemy 
	 * is facing, if so adjusts position on map to be open 
	 */
	public void enemyCutTree(){
		/**
		 * if enemy is facing up, checks if tree is above enemy,
		 * changing positional value to OPEN if so
		 */
		if ((this.getEnemyDirection()).equalsIgnoreCase("Up")){
			if (protag.currentMap[this.getEnemyX()][this.getEnemyY() - 1] == this.TREE){
				protag.currentMap[this.getEnemyX()][this.getEnemyY() - 1] = this.OPEN;
			}
		}
		
		/**
		 * if enemy is facing down, checks if tree is below enemy,
		 * changing positional value to OPEN if so
		 */
		else if ((this.getEnemyDirection()).equalsIgnoreCase("Down")){
			if (protag.currentMap[this.getEnemyX()][this.getEnemyY() + 1] == this.TREE){
				protag.currentMap[this.getEnemyX()][this.getEnemyY() + 1] = this.OPEN;
			}
		}
		
		/**
		 * if enemy is facing left, checks if tree is to the left of enemy,
		 * changing positional value to OPEN if so
		 */
		else if ((this.getEnemyDirection()).equalsIgnoreCase("Left")){
			if (protag.currentMap[this.getEnemyX() - 1][this.getEnemyY()] == this.TREE){
				protag.currentMap[this.getEnemyX() - 1][this.getEnemyY()] = this.OPEN;
			}
		}
		
		/**
		 * if enemy is facing right, checks if tree is to the right of enemy,
		 * changing positional value to OPEN if so
		 */
		else if ((this.getEnemyDirection()).equalsIgnoreCase("Right")){
			if (protag.currentMap[this.getEnemyX() + 1][this.getEnemyY()] == this.TREE){
				protag.currentMap[this.getEnemyX() + 1][this.getEnemyY()] = this. OPEN;
			}
		}
	}
	
	/**
	 * moves enemy up by lowering y coordinate
	 */
	public void enemyMoveUp() {
		this.enemyY--;
	}
	
	/**
	 * moves enemy down by raising y coordinate
	 */
	public void enemyMoveDown() {
		this.enemyY++;
	}
	
	/**
	 * moves enemy left by lowering x coordinate
	 */
	public void enemyMoveLeft() {
		this.enemyX--;
	}
	
	/**
	 * moves enemy right by raising x coordinate
	 */
	public void enemyMoveRight() {
		this.enemyX++;
	}
	
	/**
	 * return open status
	 * @return
	 */
	public int returnOpen() {
		return this.OPEN;
	}
	
	/**
	 * returns evidence status
	 * @return
	 */
	public int returnEvidence() {
		return this.EVIDENCE;
	}
	
	/** 
	 * returns powerup status
	 * @return
	 */
	public int returnPowerUp() {
		return this.POWERUP;
	}
	
	/**
	 * returns exit status
	 * @return
	 */
	public int returnExit() {
		return this.EXIT;
	}
	
	/**
	 * returns finished status
	 * @return
	 */
	public int returnFinished() {
		return this.FINISHED;
	}
	
	/**
	 * sets enemy direction faced
	 * @param direction - String for direction faced
	 */
	public void setDirection(String direction) {
		this.enemyDirection = direction;
	}
	
	/**
	 * returns enemy x coordinate
	 * @return
	 */
	public int getEnemyX() {
		return this.enemyX;
	}
	
	/**
	 * returns enemy y coordinate
	 * @return
	 */
	public int getEnemyY() {
		return this.enemyY;
	}
	
	/**
	 * sets enemy x coordinate
	 * @param anX - x coordinate to be set
	 */
	public void setEnemyX(int anX) {
		this.enemyX = anX;
	}
	
	/**
	 * sets enemy y coordinate
	 * @param aY - y coordinate to be set
	 */
	public void setEnemyY(int aY) {
		this.enemyY = aY;
	}
	
	/**
	 * returns map that enemy is currently traversing
	 * by taking map from player1
	 * @return
	 */
	public int[][] getEnemyMap() {
		return protag.currentMap;
	}
	
	/**
	 * checks position on map for enemy
	 * @param checkX - x coordinate to be checked
	 * @param checkY - y coordinate to be checked
	 * @return
	 */
	public int checkEnemyPos(int checkX, int checkY) {
		/**
		 * try block to attempt to check position on the map and return
		 * positional value (Status) associated with coordinates
		 */
		try {
			int[][] tempMap = protag.currentMap;
			return tempMap[checkX][checkY];
		}
		/**
		 * catch block to return useless value if the coordinates
		 * to be checked fall outside of the map
		 */
		catch(Exception ArrayIndexOutOfBounds) {
			return 20;
		}
	}
}
