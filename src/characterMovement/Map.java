package characterMovement;

//class map contains constants for all items that will be on the map,
//as well as 2d arrays for maps themselves. 3d array contains these maps
//so that the Game class can iterate through them
public abstract class Map{
	final static int BOULDER = -1;
	final static int TREE = -2;
	final static int WALL = -3;
	final static int OPEN = 0;
	final static int EVIDENCE = 1;
	final static int POWERUP = 2;
	final static int EXIT = 3;
	final static int FINISHED = 4;
	final static int[][] map1 = 
					{{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}, 
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL}, 
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL}, 
					{WALL, TREE, TREE, TREE, OPEN, OPEN, OPEN, OPEN, OPEN, WALL}, 
					{WALL, TREE, EVIDENCE, TREE, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, TREE, TREE, TREE, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, BOULDER, OPEN, BOULDER, WALL},
					{WALL, POWERUP, OPEN, OPEN, OPEN, OPEN, BOULDER, OPEN, BOULDER, WALL},
					{WALL, WALL, WALL, WALL, WALL, WALL, WALL, EXIT, WALL, WALL}};
	
	final static int[][] map2 = 
					{{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EXIT, WALL}, 
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL}, 
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, BOULDER, OPEN, OPEN, WALL}, 
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, WALL, WALL, WALL, WALL}, 
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, TREE, OPEN, EVIDENCE, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, WALL, OPEN, POWERUP, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, WALL, WALL, WALL, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, BOULDER, OPEN, OPEN, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, BOULDER, OPEN, OPEN, WALL},
					{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}};
	
	final static int[][] map3 = 
					{{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EXIT, WALL}, 
					{WALL, WALL, WALL, WALL, EVIDENCE, OPEN, OPEN, WALL, OPEN, WALL}, 
					{WALL, WALL, OPEN, WALL, WALL, WALL, OPEN, WALL, OPEN, WALL}, 
					{WALL, WALL, OPEN, OPEN, OPEN, WALL, OPEN, WALL, OPEN, WALL}, 
					{WALL, WALL, OPEN, WALL, OPEN, WALL, OPEN, WALL, OPEN, WALL},
					{WALL, OPEN, OPEN, WALL, OPEN, WALL, OPEN, WALL, OPEN, WALL},
					{WALL, OPEN, WALL, WALL, OPEN, WALL, OPEN, WALL, OPEN, WALL},
					{WALL, OPEN, WALL, WALL, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, POWERUP, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
					{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}};
	
	final static int[][] map4 = 
					{{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}, 
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL, POWERUP, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL, OPEN, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL, TREE, WALL},
					{EXIT, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, OPEN, OPEN, TREE, TREE, TREE, TREE, TREE, WALL},
					{WALL, OPEN, OPEN, OPEN, TREE, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, BOULDER, OPEN, TREE, OPEN, TREE, TREE, OPEN, WALL},
					{WALL, POWERUP, BOULDER, OPEN, OPEN, OPEN, OPEN, TREE, EVIDENCE, WALL},
					{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}};
	
	final static int[][] map5 = 
					{{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}, 
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, TREE, OPEN, TREE, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, TREE, OPEN, TREE, TREE, TREE, TREE, TREE, WALL},
					{WALL, OPEN, TREE, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, TREE, TREE, TREE, TREE, TREE, TREE, OPEN, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, EVIDENCE, TREE, OPEN, WALL},
					{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, FINISHED, WALL}};
	
	final static int[][][] maps = {map1, map2, map3, map4, map5};
	
	int levelCount = 0;
	
	public int[][] getMap(){
		return maps[levelCount];
	}
	
	public int[][] reachedExit(){
		this.levelCount++;
		return maps[levelCount];
	}
}
