public class Collectibles extends Position{

	//checks if evidence is picked up, if so calls gotCollectible()
	//function from character to signal that a collectible was collected
	public void gotEvidence{
		if ((charPosition[charX][charY]).equals(super.EVIDENCE)){
			if (super.Dig()){
				super.gotCollectible();
				super.map[charX][charY] == super.OPEN;
			}
		}
	}

	//checks if a power up is picked up, is so calls powerUp() 
	//method from character to raise character stats
	public void gotPowerUp{
		if ((charPosition[charX][charY]).equals(super.POWERUP)){
			super.powerUp();
			super.map[charX][charY] == super.OPEN;
		}
	}
}