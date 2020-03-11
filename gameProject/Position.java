package gameProject;

import java.util.ArrayList;

//position class has variables about enemy and player positions
public class Position extends Character{
	int charPosition;
	public Position(String charName, String charGender) {
		super(charName, charGender);
		charPosition = currentMap[super.getX()][super.getY()];
	}

	public int checkPos(int checkX, int checkY) {
		try {
			return currentMap[checkX][checkY];
		}
		catch(Exception ArrayIndexOutOfBounds) {
			return 20;
		}
	}
	
	//checks if position above is open, if so moves character up
	public void isOpenUp(){
		this.charDirection = "Up";
		try {
			if (this.checkPos(this.getX(),  this.getY() + 1) == this.OPEN || this.checkPos(this.getX(), this.getY() + 1) == this.EXIT ||
					this.checkPos(this.getX(), this.getY() + 1) == this.POWERUP || this.checkPos(this.getX(), this.getY() + 1) == this.EVIDENCE){
				this.moveUp();
				this.charPosition = currentMap[this.getX()][this.getY() + 1];
			}
			else {
				System.out.println("Cannot go there!");
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}

	//checks if position below is open, if so moves character down
	public void isOpenDown(){
		this.charDirection = "Down";
		try {
			if (this.checkPos(this.getX(),  this.getY() - 1) == this.OPEN || this.checkPos(this.getX(), this.getY() - 1) == this.EXIT ||
					this.checkPos(this.getX(), this.getY() - 1) == this.POWERUP || this.checkPos(this.getX(), this.getY() - 1) == this.EVIDENCE){
				this.moveDown();
				this.charPosition = currentMap[this.getX()][this.getY() - 1];
			}
			else {
				System.out.println("Cannot go there!");
			}
		}
		catch(Exception ArrayIndexOutOfBounds) {
		}
	}

	//checks if position to the right is open, if so moves character right
	public void isOpenRight(){
		this.charDirection = "Right";
		try {
			if (this.checkPos(this.getX() + 1, this.getY()) == this.OPEN || this.checkPos(this.getX() + 1, this.getY()) == this.EXIT || 
					this.checkPos(this.getX() + 1, this.getY()) == this.POWERUP || this.checkPos(this.getX() + 1, this.getY()) == this.EVIDENCE){
				this.moveRight();
				this.charPosition = currentMap[this.getX()+ 1][this.getY()];
			}
			else {
				System.out.println("Cannot go there!");
			}
		}
		catch(Exception ArrayIndexOutOfBounds) {
		}
	}

	//checks if position to the left is open, if so moves character left
	public void isOpenLeft(){
		this.charDirection = "Left";
		try {
			if (this.checkPos(this.getX() - 1, this.getY()) == this.OPEN || this.checkPos(this.getX() - 1, this.getY()) == this.EXIT || 
					this.checkPos(this.getX() - 1, this.getY()) == this.POWERUP || this.checkPos(this.getX() - 1, this.getY()) == this.EVIDENCE){
				this.moveLeft();
				this.charPosition = currentMap[this.getX() - 1][this.getY()];
			}
			else {
				System.out.println("Cannot go there!");
			}
		}
		catch(Exception ArrayIndexOutOfBounds) {
		}
	}

	//checks if the character has exited the level, is so changes isDone variable
	//in game class to be true, loading the next map
	public boolean isDone(){
		if(this.checkPos(super.getX(), super.getY()) == this.EXIT){
			return true;
		}
		else {
			return false;
		}
	}
}

