import Map;

public class Character extends Position{
	int collectibleCount = 0;
	boolean cutFlag = false;
	String charName;
	String charGender;
	int health = 7;
	int attackPower = 1;
	int y;
	int x;

	public Character(String name, String gender){
		this.charName = this.name;
		this.charGender = this.gender;
	}

	public void moveUp(){
		this.y++;
	}

	public void moveDown(){
		this.y--;
	}

	public void moveLeft(){
		this.x--;
	}

	public void moveRight(){
		this.x++;
	}

	public void powerUp(){
		this.attackPower++;
	}

	public void gotCollectible(){
		this.collectibleCount++;
	}

}