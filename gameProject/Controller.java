package gameProject;

import java.util.ArrayList;
import java.util.Scanner;

//Game class has all map constants through object m,
//map is assigned to map1 so that the first level if played
//first
public class Controller extends Collectibles{
	boolean characterDone = false;
	String charGender;
	String charName;

	public Controller(String name, String gender) {
		super(name, gender);
	}
	
	//loop that the game will go through, repeatedly
	//asking for input from the plater to move until the level is finished,
	//at which point a new map will be loaded
	
	public void gameLoop() {
		Scanner keyBoard = new Scanner(System.in);
		String command;
		System.out.println("Name: " + this.getName() + " Gender: " + this.getGender());
		while (!this.isDone()) {
			command = "";
			System.out.println("Enter command: ");
			command = keyBoard.nextLine();
			if (command.equalsIgnoreCase("Move up")) {
				this.isOpenUp();
				this.gotPowerUp();
			}
			else if (command.equalsIgnoreCase("Move down")) {
				this.isOpenDown();
				this.gotPowerUp();
			}
			else if (command.equalsIgnoreCase("Move right")) {
				this.isOpenRight();
				this.gotPowerUp();
			}
			else if (command.equalsIgnoreCase("Move left")) {
				this.isOpenLeft();
				this.gotPowerUp();
			}
			else if (command.equalsIgnoreCase("Dig")) {
				this.gotEvidence();
			}
			else if(command.equalsIgnoreCase("Cut")) {
				try {
					this.cutTree();
				}
				catch(Exception ArrayIndexOutOfBounds) {
				}
			}
			else {
			}
		}
	}
	
	public String getName() {
		return this.charName;
	}
	
	public String getGender() {
		return this.charGender;
	}
	
	public void setName(String aName) {
		this.charName = aName;
	}
	
	public void setGender(String aGender) {
		this.charGender = aGender;
	}
}
	
