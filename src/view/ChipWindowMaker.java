package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ChipWindowMaker extends JFrame {

    public ChipWindowMaker(ChipsPanel p, ScorePanel sp){
        super("Survivor Of The Chip");
        final ChipsPanel panel = p; 
        add(panel, BorderLayout.CENTER);
        final ScorePanel scorePanel = sp;
        add(scorePanel, BorderLayout.NORTH);
    }
}

