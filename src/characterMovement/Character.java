package characterMovement;

//class contains instance variables relating to 
//information about player, as well as Game object
//so that functions and variables from game can be used
public class Character extends Map{
	int[][] currentMap = super.getMap();
	String charDirection = "Up";
	int evidenceCount = 0;
	String charName;
	String charGender;
	int health = 7;
	int charY = 2;
	int charX = 2;

	//constructor to assign name and gender to character
	//based on previous input
	public Character(String name, String gender){
		super();
		this.charName = this.charName;
		this.charGender = this.charGender;
	}

	//makes character move up
	public void moveUp(){
		this.charY--;
	}

	//makes character move down
	public void moveDown(){
		this.charY++;
	}

	//makes character move left
	public void moveLeft(){
		this.charX--;
	}

	//makes character move right
	public void moveRight(){
		this.charX++;
	}

	//increases player health when called. Checks if
	//cutFlag is false, to ensure it only happens once,
	//and that the character has powered up 3 times, and if 
	//both conditions are true, cutFlag will be made true so
	//the character can now cut
	public void powerUp(){
		System.out.println("You've powered up!");
		this.health++;
	}

	//increases collectible count when called
	public void gotCollectible(){
		this.evidenceCount++;
		System.out.println("You have found " + this.evidenceCount + " piece(s) of evidence!");
	}

	//checks if the player can cut. If so, checks direction
	//that player is facing, and if valid, cuts down a tree
	public void cutTree(){
		if ((this.getDirection()).equalsIgnoreCase("Up")){
			if (this.currentMap[this.getX()][this.getY() - 1] == this.TREE){
				this.currentMap[this.getX()][this.getY() - 1] = this.OPEN;
			}
		}
		else if ((this.getDirection()).equalsIgnoreCase("Down")){
			if (this.currentMap[this.getX()][this.getY() + 1] == this.TREE){
				this.currentMap[this.getX()][this.getY() + 1] = this.OPEN;
			}
		}
		else if ((this.getDirection()).equalsIgnoreCase("Left")){
			if (this.currentMap[this.getX() - 1][this.getY()] == this.TREE){
				this.currentMap[this.getX() - 1][this.getY()] = this.OPEN;
			}
		}
		else if ((this.getDirection()).equalsIgnoreCase("Right")){
			if (this.currentMap[this.getX() + 1][this.getY()] == this.TREE){
				this.currentMap[this.getX() + 1][this.getY()] = this. OPEN;
			}
		}
	}
	
	public void setBlock(int xPos, int yPos, int status) {
		this.currentMap[xPos][yPos] = status;
	}
	
	public String getDirection() {
		return this.charDirection;
	}
	
	public void setDirection(String direction) {
		this.charDirection = direction;
	}
	
	public int returnOpen() {
		return this.OPEN;
	}
	
	public int returnEvidence() {
		return this.EVIDENCE;
	}
	
	public int returnPowerUp() {
		return this.POWERUP;
	}
	
	public int returnExit() {
		return this.EXIT;
	}
	
	public int returnFinished() {
		return this.FINISHED;
	}
	
	public int getY() {
		return this.charY;
	}
	
	public void setY(int yPos) {
		this.charY = yPos;
	}
	
	public int getX() {
		return this.charX;
	}
	
	public void setX(int xPos) {
		this.charX = xPos;
	}
	
	public int getEvidenceCount() {
		return this.evidenceCount;
	}
	
	@Override
	public int[][] getMap(){
		return this.currentMap;
	}
	
	public void setMap(int[][] aMap) {
		this.currentMap = aMap;
	}
}
