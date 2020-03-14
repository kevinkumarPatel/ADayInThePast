package gameProject;

//class map contains constants for all items that will be on the map,
//as well as 2d arrays for maps themselves. 3d array contains these maps
//so that the Game class can iterate through them
public class Map{
	int BOULDER = -1;
	int TREE = -2;
	int WALL = -3;
	int OPEN = 0;
	int EVIDENCE = 1;
	int POWERUP = 2;
	int EXIT = 3;
	int[][] map1 = {{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}, 
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL}, 
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL}, 
					{WALL, TREE, TREE, TREE, OPEN, OPEN, OPEN, OPEN, OPEN, WALL}, 
					{WALL, TREE, EVIDENCE, TREE, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, TREE, TREE, TREE, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, OPEN, WALL},
					{WALL, OPEN, OPEN, OPEN, OPEN, OPEN, BOULDER, OPEN, BOULDER, WALL},
					{WALL, POWERUP, OPEN, OPEN, OPEN, OPEN, BOULDER, OPEN, BOULDER, WALL},
					{WALL, WALL, WALL, WALL, WALL, WALL, WALL, EXIT, WALL, WALL}};
	
	int[][] map2 = {{OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}};
	int[][] map3 = {{OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}};
	int[][] map4 = {{OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}};
	int[][] map5 = {{OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}};
	int[][][] maps = {map1, map2, map3, map4, map5};
	int[][] currentMap;
	int levelCount = 0;
	
	public int[][] getMap(){
		return maps[levelCount];
	}
	
	public int[][] reachedExit(){
		this.levelCount++;
		return maps[levelCount];
	}
}
