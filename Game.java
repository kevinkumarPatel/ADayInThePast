package CPSC;

import java.util.ArrayList;
import java.util.Scanner;

//Game class has all map constants through object m,
//map is assigned to map1 so that the first level if played
//first
public class Game{
	Map m = new Map();
	int BOULDER = m.BOULDER;
	int TREE = m.TREE;
	int WALL = m.WALL;
	int OPEN = m.OPEN;
	int EVIDENCE = m.EVIDENCE;
	int POWERUP = m.POWERUP;
	int EXIT = m.EXIT;	
	int[][] map = m.map1;
	boolean isDone = false;
	boolean gameOver = false;
	int count = 0;
	
	//loop that the game will go through, repeatedly
	//asking for input from the plater to move until the level is finished,
	//at which point a new map will be loaded
	public void gameLoop(){
		while(!isDone){
			//keybinding input to move, cut, dig, etc
		}
		count++;
		//when a map is completed, load the next one
		map = m.maps[count];
	}

	//collect character information and check for status of game completion,
	//call game loop until game is completed
	public static void Main(String[] args){
		characterDone = false;
		while(!characterDone){
			//GUI, button overlay for gender select, charGender
			//collect input for name
			Scanner keyboard = new Scanner();
			System.out.println("Enter your name");
			charName = keyboard.nextString();
			//GUI, buttons asking if the player is ready to continue
		}
		//create plater with information
		Character player = new Character(charName, charGender);
		//if the game ends, stop gameLoop() - end the game
		while(!gameOver){
			gameLoop();
		}
	}
}