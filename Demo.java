import java.util.Scanner;

public class Demo{
	int x = 1;
	int y = 1;
	String gender;
	String name;
	int map[][] = {{0, 1, 2}, {0, 1, -1}, {0, 1, 2}};
	int collectible[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 1}};
	int[] position = {1, map[1][1]};
	int count = 0;

	public Demo(String charGender, String charName){
		this.gender = charGender;
		this.name = charName;
	}

	public void moveUp(){
		this.y++;
		try{
			int[] newPosition = {x, map[x][y]};
			if (isOpen(newPosition)){
				this.position = newPosition;
			}		
			else{
				System.out.println("The way is blocked by a tree");
				this.y--;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException){
			this.y--;
			System.out.println("Cannot go further");
		}
	}

	public void moveDown(){
		this.y--;
		try{
				int[] newPosition = {x, map[x][y]};
			if (isOpen(newPosition)){
				this.position = newPosition;
			}
			else{
				System.out.println("The way is blocked by a tree");
				this.y++;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException){
			System.out.println("Cannot go further");
			this.y++;
		}

	}

	public void moveRight(){
		this.x++;
		try{
			int[] newPosition = {x, map[x][y]};
			if (isOpen(newPosition)){
				this.position = newPosition;
			}
			else{
				System.out.println("The way is blocked by a tree");
				this.x--;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException){
			System.out.println("Cannot go further");
			this.x--;
		}
	}

	public void moveLeft(){
		this.x--;
		try{
			int[] newPosition = {x, map[x][y]};
			if (isOpen(newPosition)){
				this.position = newPosition;
			}
			else{
				System.out.println("The way is blocked by a tree");
				this.x++;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException){
			System.out.println("Cannot go further");
			this.x++;
		}
	}

	public boolean isOpen(int[] positionToCheck){
		if (positionToCheck[1] == -1) {
			return false;
		}
		else{
			return true;
		}
	}

	public boolean isCollectible(int[] positionToCheck){
		if (collectible[positionToCheck[0]][positionToCheck[1]] == 1){
			System.out.println("Congratualtions, you have found a piece of evidence!");
			collectible[positionToCheck[0]][positionToCheck[1]] = 0;
			count++;
			return true;
		}
		else{
			return false;
		}
	}

	public void dig(){
		if (!isCollectible(this.position)){
			System.out.println("Nothing but dirt...");
		}

	}

	public String getPosition(){
		String stringPos = position[0] + "," + position[1];

		return stringPos;
	}

	public Integer getCollectibleProgress(){
		return count;
	}

	public static void main(String[] args){
		String doContinue = "no";
		String charGender = null;
		String charName = null;
		Scanner keyboard = new Scanner(System.in);

		while (doContinue.equalsIgnoreCase("no")){

			System.out.println("Is your character Male or Female? ");

			charGender = keyboard.nextLine();
			System.out.println("What is your characters name? ");

			charName = keyboard.nextLine();
			System.out.println("Are you finished creating your character? ");

			doContinue = keyboard.nextLine();
		}

		Demo player1 = new Demo(charGender, charName);
		System.out.println("Your character\'s name is " + player1.name + " and you are a " + player1.gender);
		System.out.println("Your character\'s position is " + player1.getPosition());

		String command = "none";
		while (!command.equalsIgnoreCase("quit")){
			System.out.println("Enter command: ");
			command = keyboard.nextLine();
			if (command.equalsIgnoreCase("move up")){
				player1.moveUp();
			}
			if (command.equalsIgnoreCase("move left")){
				player1.moveLeft();
			}
			if (command.equalsIgnoreCase("move down")){
				player1.moveDown();
			}
			if (command.equalsIgnoreCase("move right")){
				player1.moveRight();
			}
			if (command.equalsIgnoreCase("get position")){
				System.out.println(player1.getPosition());
			}
			if (command.equalsIgnoreCase("dig")){
				player1.dig();
			}
			if (command.equalsIgnoreCase("get collectible progress")){
				System.out.println("You have found " + player1.getCollectibleProgress() + " of 1 pieces of evidence");
			}
		}
	}
}