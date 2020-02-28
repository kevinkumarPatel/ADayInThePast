package CPSC;

//class contains instance variables relating to 
//information about player, as well as Game object
//so that functions and variables from game can be used
public class Character{
	Game game = new Game();
	String charDirection = "Up";
	int evidenceCount = 0;
	boolean cutFlag = false;
	String charName;
	String charGender;
	int health = 7;
	int attackPower = 1;
	int powerUpCount = 0;
	int charY;
	int charX;

	//constructor to assign name and gender to character
	//based on previous input
	public Character(String name, String gender){
		this.charName = this.charName;
		this.charGender = this.charGender;
	}

	//makes character move up
	public void moveUp(){
		this.charDirection = "Up";
		this.charY++;
	}

	//makes character move down
	public void moveDown(){
		this.charDirection = "Down";
		this.charY--;
	}

	//makes character move left
	public void moveLeft(){
		this.charDirection = "Left";
		this.charX--;
	}

	//makes character move right
	public void moveRight(){
		this.charDirection = "Right";
		this.charX++;
	}

	//increases player stats when called. Checks if
	//cutFlag is false, to ensure it only happens once,
	//and that the character has powered up 3 times, and if 
	//both conditions are true, cutFlag will be made true so
	//the character can now cut
	public void powerUp(){
		this.attackPower++;
		this.health++;
		this.powerUpCount++;
		if (powerUpCount == 3 && cutFlag == false){
			cutFlag == true;
		}
	}

	//increases collectible count when called
	public void gotCollectible(){
		this.evidenceCount++;
	}

	//checks if the player can cut. If so, checks direction
	//that player is facing, and if valid, cuts down a tree
	public void cutTree(){
		if (cutFlag){
			if (charDirection.equals("Up")){
				if (game.map[this.charX][this.charY + 1] == game.TREE){
					game.map[this.charX][this.charY + 1] = game.OPEN;
				}
			}
			else if (charDirection.equals("Down")){
				if (game.map[this.charX][this.charY - 1] == game.TREE){
					game.map[this.charX][this.charY - 1] = game.OPEN;
				}
			}
			else if (charDirection.equals("Left")){
				if (game.map[this.charX - 1][this.charY] == game.TREE){
					game.map[this.charX - 1][this.charY] = game.OPEN;
				}
			}
			else if (charDirection.equals("Right")){
				if (game.map[this.charX + 1][this.charY] == game.TREE){
					game.map[this.charX + 1][this.charY] = game.OPEN;
				}
			}
		}
	}

	//signals that the player is trying to dig
	public boolean Dig(){
		return true;
	}
}