package controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;

import view.ChipsPanel;
import model.Chip;
import model.Grid;
import model.enemy.Enemy;
import view.ScorePanel;


@SuppressWarnings("serial")
public class KeyPressed extends ScorePanel implements KeyListener{

	ChipsPanel panel;
	Grid grid;
	Chip chip;
	ChipsPuzzle adventure;
	int blockCount = 0 ;
	ArrayList<Enemy> enemy;
	int life = 1;
	int level = 1;
	
	public KeyPressed(ChipsPanel panel, Grid grid, Chip chip, ArrayList<Enemy> enemy){ 	
		this.chip = chip;
		this.grid = grid;
		this.panel = panel;
		this.enemy = enemy;
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int keyPressed = e.getKeyCode();
		
		if (keyPressed < 41 && keyPressed > 36 ){
			switch (keyPressed){
			case 37: //Move chip left
				if(chip.getX() == 23){
					chip.setX(0);
					chip.setY(7);
					
				}
				else if(chip.getX()>0 && !grid.isBlocked(chip.getX()-1,chip.getY()))
				   chip.setX(chip.getX()-1);
			break;
			case 38: //Move chip up
				if(chip.getX() == 23){
					chip.setX(0);
					chip.setY(7);
					
				}
				else if(chip.getY()>0 && !grid.isBlocked(chip.getX(),chip.getY()-1))
					chip.setY(chip.getY()-1);
			break;
			case 39: //Move chip right
				if(chip.getX() == 23){ //Checking to see if he has reached accross
					chip.setX(0);
					chip.setY(7); //Setting restart position
					blockCount += 5;
					grid.blockCells(blockCount); //Creating new level
					//setLives(life); //Increasing lives
					setLevel(level); //Increasing level
				}
				else if(chip.getX()<grid.getXDimension()-1 && !grid.isBlocked(chip.getX()+1,chip.getY()))
			        chip.setX(chip.getX()+1);
			   break;
			case 40: //Move chip down
				if(chip.getX() == 23){
					chip.setX(0);
					chip.setY(7);
					
				}
				else if(chip.getY()<grid.getYDimension()-1 && !grid.isBlocked(chip.getX(),chip.getY()+1))
				    chip.setY(chip.getY()+1);	
			   break;
			}
		}
		
		panel.repaint();
				
	}
	
	public void setLife(int life){
		this.life  = life;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {  
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
