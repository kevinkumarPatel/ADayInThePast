package thingsOnMap;

/**
 * @author Filip Cotra, Theodore Lun
 * Collectibles class has methods to signify collectible 
 * collection, and calls methods from character class to 
 * update collectible collection statistics. This class extends 
 * position as the collectible represents a position reached
 * on the map 
 */
public class Collectibles extends Position{
	
	public Collectibles(String charName, String charGender) {
		super(charName, charGender);
	}
	
	/**
	 * checks if evidence is picked up, if so calls gotCollectible()
	 * function from character to update count
	 */
	public void gotEvidence(){
		if (this.charPosition == player1.returnEvidence()){
			player1.setBlock(player1.getX(), player1.getY(), player1.returnOpen());
			player1.gotCollectible();
		}
		else {
			System.out.println("Nothing but dirt...");
		}
	}

	/**
	 * checks if a power up is picked up, is so calls powerUp() 
	 * method from character to raise character stats
	 */
	public void gotPowerUp(){
		if (this.charPosition == player1.returnPowerUp()){
			player1.setBlock(player1.getX(), player1.getY(), player1.returnOpen());
			player1.powerUp();
		}
	}
	
	/**
	 * returns delay from character class
	 * @return
	 */
	public int getDelay() {
		return player1.getDelay();
	}
	
	/**
	 * returns character collectible count to be used
	 * in progress updates
	 * @return
	 */
	public int getEvidenceCount() {
		return player1.getEvidenceCount();
	}
	
	/**
	 * calls cutTree() method from character class
	 */
	public void cutTree() {
		player1.cutTree();
	}
}