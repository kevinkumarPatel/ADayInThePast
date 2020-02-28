import Character;
import Game;

public class Position extends Character{
	int[][] charPosition = super.Map[charX][charY];
	int[][] foePosition = super.Map[foeX][foeY];

	public void isOpenUp(){
		if ((charPosition[super.charX][super.charY + 1]).equals(super.OPEN)){
			player.moveUp();
		}
		else{
			super.y--;
		}
	}

	public void isOpenDown(){
		if ((charPosition[super.charX][super.charY - 1]).equals(super.OPEN)){
			player.moveDown();
		}
		else{
			super.y++;
		}
	}

	public void isOpenRight(){
		if ((charPosition[super.charX + 1][super.charY]).equals(super.OPEN)){
			player.moveRight();
		}
		else{
			super.x--;
		}
	}

	public void isOpenLeft(){
		if ((charPosition[super.charX - 1][super.charY]).equals(super.OPEN)){
			player.moveLeft();
		}
		else{
			super.x++;
		}
	}

	public void isDone(){
		if ((charPosition[super.charX][super.charY]).equals(super.EXIT) && super.levelCount == 5){
			super.gameOver = true;
		}
		else if((charPosition[super.charX][super.charY]).equals(super.EXIT)){
			super.isDone = true;
		}
	}
}