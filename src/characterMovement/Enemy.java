package characterMovement;

public class Enemy extends Map{
	int enemyX = 1;
	int enemyY = 2;
	int[][] currentMap;
	String enemyDirection = "Up";
	int enemyDelay = 200;
	int enemyPos;
	Character protag;
	
	public void powerUp() {
		this.enemyDelay -= 10;
	}
	
	public void setBlock(int xPos, int yPos, int status) {
		protag.currentMap[xPos][yPos] = status;
	}
	
	public int getEnemyDelay() {
		return this.enemyDelay;
	}
	
	public void setEnemyPos() {
		this.enemyPos = protag.currentMap[this.getEnemyX()][this.getEnemyY()];
	}
	
	public int getEnemyPos() {
		return this.enemyPos;
	}
	
	public Enemy(int[][] aMap, Character player1) {
		protag = player1;
		this.currentMap = aMap;
		this.setEnemyPos();
	}
	
	public String getEnemyDirection() {
		return this.enemyDirection;
	}
	
	public void enemyCutTree(){
		if ((this.getEnemyDirection()).equalsIgnoreCase("Up")){
			if (protag.currentMap[this.getEnemyX()][this.getEnemyY() - 1] == this.TREE){
				protag.currentMap[this.getEnemyX()][this.getEnemyY() - 1] = this.OPEN;
			}
		}
		else if ((this.getEnemyDirection()).equalsIgnoreCase("Down")){
			if (protag.currentMap[this.getEnemyX()][this.getEnemyY() + 1] == this.TREE){
				protag.currentMap[this.getEnemyX()][this.getEnemyY() + 1] = this.OPEN;
			}
		}
		else if ((this.getEnemyDirection()).equalsIgnoreCase("Left")){
			if (protag.currentMap[this.getEnemyX() - 1][this.getEnemyY()] == this.TREE){
				protag.currentMap[this.getEnemyX() - 1][this.getEnemyY()] = this.OPEN;
			}
		}
		else if ((this.getEnemyDirection()).equalsIgnoreCase("Right")){
			if (protag.currentMap[this.getEnemyX() + 1][this.getEnemyY()] == this.TREE){
				protag.currentMap[this.getEnemyX() + 1][this.getEnemyY()] = this. OPEN;
			}
		}
	}
	
	public void enemyMoveUp() {
		this.enemyY--;
	}
	
	public void enemyMoveDown() {
		this.enemyY++;
	}
	
	public void enemyMoveLeft() {
		this.enemyX--;
	}
	
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
	
	public void setDirection(String direction) {
		this.enemyDirection = direction;
	}
	
	public int getEnemyX() {
		return this.enemyX;
	}
	
	public int getEnemyY() {
		return this.enemyY;
	}
	
	public void setEnemyX(int anX) {
		this.enemyX = anX;
	}
	
	public void setEnemyY(int aY) {
		this.enemyY = aY;
	}
	
	public int[][] getEnemyMap() {
		return protag.currentMap;
	}
	
	public int checkEnemyPos(int checkX, int checkY) {
		try {
			int[][] tempMap = protag.currentMap;
			return tempMap[checkX][checkY];
		}
		catch(Exception ArrayIndexOutOfBounds) {
			return 20;
		}
	}
}
