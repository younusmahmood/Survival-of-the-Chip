package model.enemy;

import java.awt.Color;

public class Mine extends Enemy{
	
	public Mine(){
		super();
		name = "Mine";
		setColor();
	
	}

	public void setColor() {
		color = Color.RED;		
	}
	
}
