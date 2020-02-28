import Position;
import Character;
import Game;

public class Collectibles extends Position{
	public void gotEvidence{
		if ((charPosition[charX][charY]).equals(super.EVIDENCE)){
			if (super.Dig()){
				super.gotCollectible();
				super.Map[charX][charY] == super.OPEN;
			}
		}
	}

	public void gotPowerUp{
		if ((charPosition[charX][charY]).equals(super.POWERUP)){
			super.powerUp();
			super.Map[charX][charY] == super.OPEN;
		}
	}
}