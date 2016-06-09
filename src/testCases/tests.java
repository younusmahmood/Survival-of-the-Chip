package testCases;

import static org.junit.Assert.*;

import java.awt.Color;

import controller.ChipsPuzzle;
import controller.Painter;
import controller.KeyPressed;
import model.Chip;
import model.Grid;
import model.enemy.Enemy;
import model.enemy.ExplosiveMine;
import model.enemy.MineWorld;
import view.ChipsPanel;
import view.ScorePanel;
import view.ChipWindowMaker;

import org.junit.Test;


public class tests {

	@Test
	public void test1() {		
		try {
			ChipsPuzzle puzzle = new ChipsPuzzle();
			puzzle.createEnemies(40);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		Chip chip;
		try {
			chip = new Chip();
			assertNotNull(chip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		Grid grid = null;
		try {
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
