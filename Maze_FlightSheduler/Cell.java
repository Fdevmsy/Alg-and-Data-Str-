import java.nio.charset.*;
import java.text.*;
import java.beans.*;

public class Cell 
{
	private int x;
	private int y;
	public boolean isVisited ;
	public boolean north;
	public boolean south;
	public boolean east;
	public boolean west;

	
	public Cell(int x, int y, boolean isVisited)
	{
		this.x = x;
		this.y = y;
		this.isVisited = isVisited;
		this.north = true;
		this.south = true;
		this.east = true;
		this.west = true;

	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public boolean isVisited(){
		return this.isVisited;
	}

}