/*
 * Author: Younus Mahmood
 * ChipsPuzzle.java
 */

package controller;

import java.util.ArrayList;

import view.*;

import javax.swing.JFrame;

import model.Chip;
import model.Grid;
import model.enemy.Enemy;
import model.enemy.ExplosiveMine;
import model.enemy.MineWorld;
import view.ChipsPanel;

public class ChipsPuzzle { //Main game

	ChipsPanel chipsPanel;
	ScorePanel scorePanel;
	
	Chip chip;
	Grid gameGrid;
	ArrayList<Enemy> enemy = new ArrayList<Enemy>();
	ArrayList<Thread> threads = new ArrayList<Thread>();
	int blockCount = 50;
		
	public ChipsPuzzle(){
		this.chip = new Chip();
		this.gameGrid = Grid.getInstance();
		createEnemies(15);
	}
	
	public void startGUI(){		
		int windowWidth = 525;
		int windowHeight = 430;
	    chipsPanel = ChipsPanel.getInstance(gameGrid,chip, enemy, blockCount);   // Getting the instance for grid
	    scorePanel = new ScorePanel();
		ChipWindowMaker w= new ChipWindowMaker(chipsPanel, scorePanel);  //Creating the window display
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    w.setSize(windowWidth, windowHeight); //Setting size
	    w.setVisible(true);
	    w.setResizable(false);
	}
	
	public void createEnemies(int count){ //Creating enemies: Chip MUST avoid these to survive
		MineWorld mineFactory = new ExplosiveMine();
		for(int j = 0; j < count; j++){
			enemy.add(mineFactory.createEnemy());
		}
	}
	
	public void alternateStartThreads(){ // Creating threads for smoother process
		Painter paintController = new Painter(chipsPanel);
		(new Thread(paintController)).start();
		for(Enemy enemy:enemy){
			(new Thread(enemy)).start();
		}
	}
	
	public void startThreads(){ //Starting threads
		Painter paintController = new Painter(chipsPanel);
		(new Thread(paintController)).start();
		for(Enemy enemy : enemy){
	    	threads.add(new Thread(enemy)); 
	    }
		for(Thread thread:threads){
	          thread.start();
	    }
	}
	
	public static void main(String[] args){
		ChipsPuzzle chipsPuzzle = new ChipsPuzzle(); //Creating new instance of ChipsPuzzle
	 	chipsPuzzle.startGUI();  // Start up the view
	 	chipsPuzzle.startThreads(); //Starting threads
	    
	}
}