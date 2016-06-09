package model.enemy;

import java.awt.Color;
import java.awt.Point;
import model.Grid;


public class Enemy implements Runnable {

	Grid grid;
	Point p;
	String name;
	Color color;

	public Enemy() {
		grid = Grid.getInstance();
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return p.x;
	}

	public int getY() {
		return p.y;
	}

	public void setPoint(int x, int y) {
		if (p == null) {
			p = new Point(x, y); //Setting point for new enemy
		} else {
			p.x = x;
			p.y = y;
		}

	}

	public Color getColor() {
		return color;
	}

	public void run() {
		while (true) {
			p = grid.findFreeNeighbor(p);
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void setColor() {
		color = Color.CYAN; // default
	}
}
