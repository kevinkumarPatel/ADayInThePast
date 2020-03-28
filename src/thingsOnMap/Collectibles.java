package thingsOnMap;

public class Collectibles extends Position{
	public Collectibles(String charName, String charGender) {
		super(charName, charGender);
	}
	
	//checks if evidence is picked up, if so calls gotCollectible()
	//function from character to signal that a collectible was collected
	public void gotEvidence(){
		if (this.charPosition == player1.returnEvidence()){
			player1.setBlock(player1.getX(), player1.getY(), player1.returnOpen());
			player1.gotCollectible();
		}
		else {
			System.out.println("Nothing but dirt...");
		}
	}

	//checks if a power up is picked up, is so calls powerUp() 
	//method from character to raise character stats
	public void gotPowerUp(){
		if (this.charPosition == player1.returnPowerUp()){
			player1.setBlock(player1.getX(), player1.getY(), player1.returnOpen());
			player1.powerUp();
		}
	}
	
	public int getEvidenceCount() {
		return player1.getEvidenceCount();
	}
	
	public void cutTree() {
		player1.cutTree();
	}
}