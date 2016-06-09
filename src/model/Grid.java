package model;

import java.awt.Point;
import java.util.HashSet;
import java.util.Random;

public class Grid {
	private static Grid grid = null;
	public static final int xDimension = 25;
	public static final int yDimension = 18;
	Random rand;;
	
	HashSet<String> blockedCells = new HashSet<String>(); 
	
	public static Grid getInstance(){
		if (grid == null){
			grid = new Grid();
		}
		return grid;	
	}
	
	private Grid(){
		rand = new Random();
	}	
	
	public int getXDimension(){
		return xDimension;		
	}
	
	public int getYDimension(){
		return yDimension;
	}
	
	public String buildHashString(int x, int y){
		return ((Integer)x).toString() + "-" + ((Integer)y).toString();		
	}
	
	public void blockCells(int blockCount)
	{
		for(int j = 0; j < blockCount; j++){
			String blockedCell = buildHashString(rand.nextInt(xDimension)+1, rand.nextInt(yDimension));
			if(!blockedCells.contains(blockedCell))
				blockedCells.add(blockedCell);
			else
				j--;   
		}
	}
	
	public Point findFreeCell(){
		Point p = null;
		while (true) {
			int newX = rand.nextInt(xDimension);
			int newY = rand.nextInt(yDimension);
			if(!isBlocked(newX, newY)){
				p = new Point(newX, newY);
				break;
			}			
		}
		return p; 
	}
	
	public boolean inBounds(int x, int y){
		if((x>=0 && x < xDimension)&& (y >=0 && y < yDimension)) 
			return true;
		else
			return false;
	}
	
	public Point findFreeNeighbor(Point currentPoint){
		Point newPoint = null;
		int counter = 6; 
		while (true) {
			int moveX = rand.nextInt(2);
			if(moveX == 0)
				moveX--;
			int moveY = rand.nextInt(2);
			if (moveY == 0)
				moveY--;
			int currentX = currentPoint.x + moveX;
			int currentY = currentPoint.y + moveY;
			if(!isBlocked(currentX,currentY) && inBounds(currentX, currentY)){
				newPoint = new Point(currentX,currentY);
				break;
			}			
			if(counter++ > 6)
				break;
		}
		if (newPoint == null)
			return currentPoint;
		else
			return newPoint;  
	}
	
	public Boolean isBlocked(int x, int y)
	{
		if(blockedCells.contains(buildHashString(x,y)))
			return true;
		else
			return false;
	}	
}
