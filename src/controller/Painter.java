package controller;

import view.ChipsPanel;

public class Painter implements Runnable{

	ChipsPanel panel;
	public Painter(ChipsPanel pap){
		this.panel = pap;
	}
	@Override
	public void run() {
		while (true){
			panel.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
