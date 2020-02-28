public class Map{
	int BOULDER = -1;
	int TREE = -2;
	int WALL = -3;
	int OPEN = 0;
	int EVIDENCE = 1;
	int POWERUP = 2;
	int EXIT = 3;

	public Map(){
		int[][] map1 = {{OPEN, OPEN, OPEN, BOULDER, BOULDER}, {TREE, POWERUP, OPEN, BOULDER, BOULDER}, {TREE, TREE, OPEN, EVIDENCE, EXIT}}
		int[int[][]] maps = {map1, map2, map3, map4, map5};
	}
}