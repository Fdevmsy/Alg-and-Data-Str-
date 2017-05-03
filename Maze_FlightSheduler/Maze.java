
import java.util.Stack;
public class Maze {
	
	public static Cell[][] maze;
	// stack to maintain the visited items. When go back to previous cell, just pop()
	public static Stack<Cell> visited = new Stack(); 
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		generateMaze(n);
		drawMaze(n);		
	}
	
	public static void initMaze(int n)
	{
		maze = new Cell[n+2][n+2];
		/*for (int x=0;x<n+2;x++) {
			for (int y=0;y<n+2;y++) {
				maze[x][y] = new Cell(x, y, false);
			}
		}*/
		// set border to be unreachable
		for (int x=0;x<n+2;x++) {
			for (int y=0;y<n+2;y++) {
				if (x==0 || x==n+1 || y==0 || y==n+1) {
					maze[x][y] = new Cell(x, y, true);
					}
				else {
					maze[x][y] = new Cell(x, y, false);
				}
			}
		}
	}

	public static void generateMaze(int n)
	{
		initMaze(n);
		visited.push(maze[1][1]);
		generate(1,1);
//		for (int i=1;i<n+1;i++) {
//			for (int j=1;j<n+1;j++) {
//				if(maze[i][j].isVisited == true)
//				{System.out.print("(");
//				System.out.print(i);
//				System.out.print(",");
//				System.out.print(j);
//				System.out.print(")");
//				System.out.print("  ");}
//				
//			}			
//		}
		
		
	}
	
	public static void generate(int x, int y)
	{
		maze[x][y].isVisited = true;
		
		if (hasPath(x, y))
		{
			int[] nextCell = getDirection(x, y);
			int nextX = nextCell[0];
			int nextY = nextCell[1];
			
			while (maze[nextX][nextY].isVisited()) // if next cell has already been visited, then keep finding
			{
				nextCell = getDirection(x, y);
				nextX = nextCell[0]; 
				nextY = nextCell[1];
			}
			
			int direction = nextCell[2]; // 0 - north, 1- south, 2 - east, 3 - west
			knock(x, y, direction);
//			maze[nextX][nextY].isVisited = true;
			visited.push(maze[x][y]);
			generate(nextX, nextY);			
		}
		else 
		{
			if(!visited.isEmpty()) {
				Cell previousCell = visited.pop();
				generate(previousCell.getX(), previousCell.getY());
			}
			else {}
		}
		
		
	}	
	
	public static void knock(int x, int y, int direction)
	{
		if(direction==0){maze[x][y].north = false; maze[x][y+1].south = false;} 
		// break down north of x,y and south of x,y+1
		if(direction==1){maze[x][y].south = false; maze[x][y-1].north = false;}
		if(direction==2){maze[x][y].east = false; maze[x+1][y].west = false;}
		if(direction==3){maze[x][y].west = false; maze[x-1][y].east = false;}
	}
	public static boolean hasPath(int x, int y)
	{
		return (!maze[x][y + 1].isVisited() || !maze[x + 1][y].isVisited() 
								 || !maze[x][y - 1].isVisited() || !maze[x - 1][y].isVisited());
	}
	
	public static int[] getDirection(int x, int y)
	{
		int rand = (int)(Math.random()*4.0);
		if(rand ==0)		return new int[]{x,y+1,0}; // north
		else if(rand ==1) return new int[]{x,y-1,1}; // south
		else if(rand ==2)	return new int[]{x+1,y,2}; // east
		else 				return new int[]{x-1,y,3}; // west
	}
	
	private static void drawMaze(int n) 
	{
		StdDraw.setScale(0,n+1);
		StdDraw.setPenColor(StdDraw.RED);
		
		for(int i = 1; i<n+1;i++)
		{
			for(int j = 1; j<n+1;j++)
			{
				if(maze[i][j].north)StdDraw.line(i-0.5,j+0.5,i+0.5,j+0.5);
				if(maze[i][j].south)StdDraw.line(i-0.5,j-0.5,i+0.5,j-0.5);
				if(maze[i][j].east) StdDraw.line(i+0.5,j-0.5,i+0.5,j+0.5);
				if(maze[i][j].west)StdDraw.line(i-0.5,j-0.5,i-0.5,j+0.5);

			}
		}
	}
	
}

