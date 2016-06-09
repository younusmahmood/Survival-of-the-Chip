package model;

import view.ChipsPanel;

public class Chip {
	int x;
	int y;
	
	ChipsPanel panel;

	public Chip() {
		x = 0;
		y = 7;
	}

	public int getX() { //Get X position
		return x;
	}

	public int getY() { //Get Y position
		return y;
	}

	public void setX(int x) {//Set X Position
		this.x = x;
	}

	public void setY(int y) {//Set Y Position
		this.y = y;
	}

}
