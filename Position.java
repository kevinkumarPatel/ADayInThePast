import java.util.ArrayList;

//position class has variables about enemy and player positions
public class Position extends Character{
	int[][] charPosition = super.Map[charX][charY];
	int[][] foePosition = super.Map[foeX][foeY];

	//checks if position above is open, if so moves character up
	public void isOpenUp(){
		if ((charPosition[super.charX][super.charY + 1]).equals(super.OPEN)){
			player.moveUp();
		}
		else{
			super.y--;
		}
	}

	//checks if position below is open, if so moves character down
	public void isOpenDown(){
		if ((charPosition[super.charX][super.charY - 1]).equals(super.OPEN)){
			player.moveDown();
		}
		else{
			super.y++;
		}
	}

	//checks if position to the right is opem, if so moves character right
	public void isOpenRight(){
		if ((charPosition[super.charX + 1][super.charY]).equals(super.OPEN)){
			player.moveRight();
		}
		else{
			super.x--;
		}
	}

	//checks if position to the left is open, if so moves character left
	public void isOpenLeft(){
		if ((charPosition[super.charX - 1][super.charY]).equals(super.OPEN)){
			player.moveLeft();
		}
		else{
			super.x++;
		}
	}

	//checks if the character has exited the level, is so changes isDone variable
	//in game class to be true, loading the next map
	public void isDone(){
		if ((charPosition[super.charX][super.charY]).equals(super.EXIT) && super.levelCount == 5){
			super.gameOver = true;
		}
		else if((charPosition[super.charX][super.charY]).equals(super.EXIT)){
			super.isDone = true;
		}
	}
}