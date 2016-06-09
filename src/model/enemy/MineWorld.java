package model.enemy;

import java.awt.Point;

import model.Grid;


public abstract class MineWorld {
	
	Grid grid;
	public MineWorld(){
		grid = Grid.getInstance();
	}
	
	
	public Enemy createEnemy() {
		Enemy enemy = buildEnemy();
		enemy.setColor();
		Point p = grid.findFreeCell();
		enemy.setPoint(p.x,p.y);
		
		return enemy;
	}	
	

    abstract Enemy buildEnemy();
	
}
