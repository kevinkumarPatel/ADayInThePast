package characterMovement;

/**
 * @Author Filip Cotra, Theodore Lun. G08 T02
 * Character class is the map explored by character object
 * and movement around this map. Extends map class as it is representative
 * of the current map being explored, tracking where the player is on 
 * said map. Thus, the class has movement methods to explore the 
 * current map, along with general character information to 
 * be displayed on the current map from the character class
 */
public class Character extends Map{
	/**
	 * instance variables include the initial map (level 1) from
	 * the map class, the characters initial direction which is used
	 * in interactive methods, character location information, and 
	 * general (inconsequential) character information well (name and gender)
	 */
	int[][] currentMap = super.getMap();
	String charDirection = "Up";
	int evidenceCount = 0;
	String charName;
	String charGender;
	int charY = 2;
	int charX = 2;
	int delay = 200;

	/**
	 * constructor to assign name and gender to character
	 * @param name is string for character name
	 * @param gender is string for character gender
	 * super constructor initializes Map class instance variables,
	 * default Map constructor
	 */
	public Character(String name, String gender){
		super();
		this.charName = this.charName;
		this.charGender = this.charGender;
	}

	/**
	 * Adjusts character y coordinate down to represent
	 * upwards movement on map
	 */
	public void moveUp(){
		this.charY--;
	}

	/**
	 * Adjusts character y coordinate up to represent
	 * downwards movement on map
	 */
	public void moveDown(){
		this.charY++;
	}

	/**
	 * Adjusts character x coordinate down to represent
	 * left movement on map
	 */
	public void moveLeft(){
		this.charX--;
	}

	/**
	 * Adjusts character x coordinate up to represent
	 * right movement on map
	 */
	public void moveRight(){
		this.charX++;
	}

	/**
	 * increases player movement speed by decreasing input
	 * delay. Called when powerUp is collected
	 */
	public void powerUp(){
		System.out.println("You've powered up!");
		this.delay -= 10;
	}

	/**
	 * increases collectible count when called, signifies collection
	 * of evidence
	 */
	public void gotCollectible(){
		this.evidenceCount++;
		System.out.println("You have found " + this.evidenceCount + " piece(s) of evidence!");
	}

	/**
	 * checks if the player can cut. If so, checks direction
	 * of character. If there is a tree next to the character
	 * in that direction, the tree is removed
	 */
	public void cutTree(){
		if ((this.getDirection()).equalsIgnoreCase("Up")){
			if (this.currentMap[this.getX()][this.getY() - 1] == this.TREE){
				this.currentMap[this.getX()][this.getY() - 1] = this.OPEN;
				System.out.println("You cut a tree!");
			}
		}
		else if ((this.getDirection()).equalsIgnoreCase("Down")){
			if (this.currentMap[this.getX()][this.getY() + 1] == this.TREE){
				this.currentMap[this.getX()][this.getY() + 1] = this.OPEN;
				System.out.println("You cut a tree!");
			}
		}
		else if ((this.getDirection()).equalsIgnoreCase("Left")){
			if (this.currentMap[this.getX() - 1][this.getY()] == this.TREE){
				this.currentMap[this.getX() - 1][this.getY()] = this.OPEN;
				System.out.println("You cut a tree!");
			}
		}
		else if ((this.getDirection()).equalsIgnoreCase("Right")){
			if (this.currentMap[this.getX() + 1][this.getY()] == this.TREE){
				this.currentMap[this.getX() + 1][this.getY()] = this. OPEN;
				System.out.println("You cut a tree!");
			}
		}
	}
	
	/**
	 * Sets part of map to a certain "status" - open, tree, etc.
	 * @param xPos - x coordinate of grid point to change
	 * @param yPos - y coordinate of grid point to change
	 * @param status - status to be changed to  
	 */
	public void setBlock(int xPos, int yPos, int status) {
		this.currentMap[xPos][yPos] = status;
	}
	
	/**
	 * Returns character direction
	 * @return - string for character direction
	 */
	public String getDirection() {
		return this.charDirection;
	}
	
	/**
	 * Sets character direction 
	 * @param direction - string for character direction
	 */
	public void setDirection(String direction) {
		this.charDirection = direction;
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
	 * returns character y coordinate
	 * @return
	 */
	public int getY() {
		return this.charY;
	}
	
	/**
	 * sets character y coordinate
	 * @param yPos
	 */
	public void setY(int yPos) {
		this.charY = yPos;
	}
	
	/**
	 * returns character x coordinate
	 * @return
	 */
	public int getX() {
		return this.charX;
	}
	
	/**
	 * sets character x coordinate
	 * @param xPos
	 */
	public void setX(int xPos) {
		this.charX = xPos;
	}
	
	/**
	 * returns evidence count
	 * @return
	 */
	public int getEvidenceCount() {
		return this.evidenceCount;
	}
	
	/**
	 * overrides getMap() method from Map class to return 
	 * current character map rather than initial maps. in this
	 * way maintains any changed made during gameplay
	 */
	@Override
	public int[][] getMap(){
		return this.currentMap;
	}
	
	/**
	 * sets character map during level changes
	 * @param aMap
	 */
	public void setMap(int[][] aMap) {
		this.currentMap = aMap;
	}
	
	/**
	 * returns delay of character movement
	 * @return
	 */
	public int getDelay() {
		return this.delay;
	}
}
