package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.KeyPressed;
import model.Chip;
import model.Grid;
import model.enemy.Enemy;
import view.ScorePanel;

public class ChipsPanel extends JPanel {
	private static ChipsPanel chipsPanel;
	public static int lives = 3;
	ScorePanel panel;
	private static final long serialVersionUID = 1L;
	KeyPressed keyPressed;
	Chip chip;
	Grid grid;
	int cellSize = 20;
	ArrayList<Enemy> enemies;
	Image chipImg, lost, won;
	public boolean lostGame = false;
	boolean wonGame = false;
	int levels = 0;

	public static ChipsPanel getInstance(Grid grid, Chip chip,
			ArrayList<Enemy> enemies, int blockCount) {
		if (chipsPanel == null)
			chipsPanel = new ChipsPanel(grid, chip, enemies, blockCount);
		return chipsPanel;
	}

	private ChipsPanel(Grid grid, Chip chip, ArrayList<Enemy> enemies,
			int blockCount) {

		this.chip = chip;
		this.grid = grid;
		this.enemies = enemies;
		keyPressed = new KeyPressed(this, grid, chip, enemies);
		this.addKeyListener(keyPressed);
		this.setFocusable(true);
		

		grid.blockCells(blockCount);
		setBackground(Color.BLACK);

		try {
			chipImg = ImageIO.read(new File("src/images/chip.png"));
			chipImg = chipImg.getScaledInstance(22, 22, Image.SCALE_SMOOTH);

		} catch (IOException e) {
			System.out.println("Can't find Chip image");
		}
		try {
			lost = ImageIO.read(new File("src/images/dead.png"));
			lost = lost.getScaledInstance(400, 400, Image.SCALE_SMOOTH);

		} catch (IOException e) {
			System.out.println("Can't find Dead image");
		}
		try {
			won = ImageIO.read(new File("src/images/win.png"));
			won = won.getScaledInstance(400, 400, Image.SCALE_SMOOTH);

		} catch (IOException e) {
			System.out.println("Can't find Win image");
		}
	}

	public void drawGrid(Graphics2D g2) {
		// Draw horizontal lines
		for (int j = 1; j <= grid.getYDimension() + 1; j++)
			g2.drawLine(cellSize, j * cellSize,
					cellSize + (grid.getXDimension() * cellSize), j * cellSize);

		// Draw vertical lines
		for (int j = 0; j <= grid.getXDimension(); j++)
			g2.drawLine(j * cellSize + cellSize, cellSize, j * cellSize
					+ cellSize, cellSize + grid.getYDimension() * cellSize);

		// Draw blocked cells
		g2.setPaint(Color.WHITE);
		for (int i = 0; i < grid.getXDimension(); i++) {
			for (int j = 0; j < grid.getYDimension(); j++) {
				if (grid.isBlocked(i, j))
					g2.fillRect(i * cellSize + cellSize, j * cellSize
							+ cellSize, cellSize, cellSize);
			}
		}
	}

	public void drawEnemies(Graphics2D g2) {
		// Draw Enemies
		for (Enemy enemy : enemies) {
			int x = enemy.getX();
			int y = enemy.getY();
			g2.setPaint(enemy.getColor());
			g2.fillRect(x * cellSize + cellSize, y * cellSize + cellSize,
					cellSize, cellSize);
		}
	}

	@SuppressWarnings("deprecation")
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		drawGrid(g2);
		drawEnemies(g2);

		for (Enemy enemy : enemies) {
			if (enemy.getX() == chip.getX() && enemy.getY() == chip.getY() && lives != 0) {
				this.lives = this.lives - 1;
			}
			if (lives == 0) { // Checking if game is lost
				lostGame = true;
			}
		}

		g2.drawImage(chipImg, chip.getX() * cellSize + cellSize, chip.getY()
				* cellSize + cellSize, null);

		if (lostGame) {
			chipsPanel.disable();
			g2.drawImage(lost, 90, 90, this);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
	
	public boolean getLost(){
		return this.lostGame;
	}
	
}
