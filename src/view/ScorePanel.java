package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Font font = new Font("ComicSans", Font.PLAIN, 12);
	private static int level = 1;
	static JLabel textLabel2 = new JLabel("Level: " + level);
	ScorePanel panel;

	public ScorePanel() {
		setBackground(Color.DARK_GRAY);
		textLabel2.setFont(font);
		textLabel2.setForeground(Color.CYAN);
		this.add(textLabel2);
		setVisible(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		@SuppressWarnings("unused")
		Graphics2D g2 = (Graphics2D) g;
	}

	public Dimension getPreferredSize() {
		return new Dimension(20, 20);
	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	public void setLevel(int level) {
		// System.out.println("Level: " + this.level);
		this.level += level;
		ScorePanel.changeText(Integer.toString(level));
		textLabel2.setText("   Level: " + this.level);
	}

	public static void changeText(String text) {
		textLabel2.setText(text);

	}

}
