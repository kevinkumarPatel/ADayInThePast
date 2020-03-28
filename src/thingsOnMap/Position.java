package thingsOnMap;

import java.util.ArrayList;
import characterMovement.Character;

//position class has variables about enemy and player positions
public class Position{
	int charPosition;
	Character player1;
	int[][] charMap;
	
	public Position(String charName, String charGender) {
		player1 = new Character(charName, charGender);
		this.setPos();
	}

	public int checkPos(int checkX, int checkY) {
		try {
			return (player1.getMap())[checkX][checkY];
		}
		catch(Exception ArrayIndexOutOfBounds) {
			return 20;
		}
	}
	
	public void setPos() {
		this.charMap = player1.getMap();
		this.charPosition = charMap[player1.getX()][player1.getY()];
	}
	
	//checks if position above is open, if so moves character up
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
				player1.setMap(player1.reachedExit());
				System.out.println(player1.getMap());
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}

	//checks if position below is open, if so moves character down
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
				player1.setMap(player1.reachedExit());
				System.out.println(player1.getMap());
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}

	//checks if position to the right is open, if so moves character right
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
				player1.setMap(player1.reachedExit());
				System.out.println(player1.getMap());
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}

	//checks if position to the left is open, if so moves character left
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
				player1.setMap(player1.reachedExit());
				System.out.println(player1.getMap());
			}
		}
		catch(Exception ArrayIndexOutOfBounds){
		}
	}

	//checks if the character has exited the level, is so changes isDone variable
	//in game class to be true, loading the next map
	public boolean isDone(){
		if(this.charPosition == player1.returnExit()){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFinished(){
		if(this.charPosition == player1.returnFinished()){
			return true;
		}
		else {
			return false;
		}
	}
	
	public int[][] getMap(){
		return player1.getMap();
	}
	
	public void setX(int xPos) {
		player1.setX(xPos);
	}
	
	public int getX() {
		return player1.getX();
	}
	
	public void setY(int yPos) {
		player1.setY(yPos);
	}
	
	public int getY() {
		return player1.getY();
	}
}

