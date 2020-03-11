package gameProject;

public class Collectibles extends Position{
	public Collectibles(String charName, String charGender) {
		super(charName, charGender);
	}
	//checks if evidence is picked up, if so calls gotCollectible()
	//function from character to signal that a collectible was collected
	public void gotEvidence(){
		if (this.currentMap[this.getX()][this.getY()] == this.EVIDENCE){
			this.currentMap[this.getX()][this.getY()] = this.OPEN;
			super.gotCollectible();
		}
		else {
			System.out.println("Nothing but dirt...");
		}
	}

	//checks if a power up is picked up, is so calls powerUp() 
	//method from character to raise character stats
	public void gotPowerUp(){
		if (this.currentMap[this.getX()][this.getY()] == this.POWERUP){
			this.currentMap[this.getX()][this.getY()] = this.OPEN;
			super.powerUp();
		}
	}
}