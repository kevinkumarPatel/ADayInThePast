package CPSC;

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
	int[][] map1 = {{OPEN, OPEN, OPEN, BOULDER, BOULDER}, {TREE, POWERUP, OPEN, BOULDER, BOULDER}, {TREE, TREE, OPEN, EVIDENCE, EXIT}};
	int[][] map2 = {{TREE, EVIDENCE, BOULDER, OPEN, TREE}, {TREE, OPEN, BOULDER, OPEN, POWERUP}, {OPEN, EXIT, BOULDER, BOULDER, BOULDER}};
	int[][] map3 = {{OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, TREE, OPEN, OPEN, BOULDER}, {BOULDER, TREE, POWERUP, OPEN, BOULDER}};
	int[][] map4 = {{BOULDER, BOULDER, OPEN, BOULDER, TREE}, {BOULDER, BOULDER, TREE, BOULDER, TREE}, {BOULDER, OPEN, OPEN, EXIT, TREE}};
	int[][] map5 = {{OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}, {OPEN, OPEN, OPEN, OPEN, OPEN}};
	int[][][] maps = {map1, map2, map3, map4, map5};
}