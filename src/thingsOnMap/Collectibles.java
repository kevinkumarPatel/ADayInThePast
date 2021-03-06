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
	
	/**
	 * constructor
	 * @param charName - String for character name
	 * @param charGender - String for character gender
	 */
	public Collectibles(String charName, String charGender) {
		super(charName, charGender);
	}
	
	/**
	 * constructor
	 * @param player1 - Copy constructor for collectibles object
	 */
	public Collectibles(Collectibles player1) {
		super(player1);
	}
	
	/**
	 * returns enemy delay value from getEnemyDelay() method
	 * @return
	 */
	public int getEnemyDelay() {
		return player2.getEnemyDelay();
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
	 * checks if a power up is picked up, if so calls powerUp() 
	 * method from character to raise character stats
	 */
	public void gotPowerUp(){
		if (this.charPosition == player1.returnPowerUp()){
			player1.setBlock(player1.getX(), player1.getY(), player1.returnOpen());
			this.charPosition = player1.returnOpen();
			player1.powerUp();
		}
	}
	
	/**
	 * checks if a evidence is picked up by enemy, if so 
	 * changes block to empty so that character cannot pick
	 * it up
	 */
	public void enemyGotEvidence() {
		if(this.getEnemyPos() == player2.returnEvidence()) {
			player2.setBlock(player2.getEnemyX(), player2.getEnemyY(), player2.returnOpen());
		}
	}
	
	/**
	 * checks if a power up is picked up by enemy, if so 
	 * changes block to empty so that character cannot pick
	 * it up
	 */
	public void enemyGotPowerUp() {
		if(this.getEnemyPos() == player2.returnPowerUp()) {
			player2.setBlock(player2.getEnemyX(), player2.getEnemyY(), player2.returnOpen());
			player2.powerUp();
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