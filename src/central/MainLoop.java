package central;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import viewable.PrimaryView;

public class MainLoop{
	private final static int FPS = 60;
	private final static int ToNext = 1000/FPS;
	private final static int MaxFrameSkip = 10; // Minimum framerate is FPS/MaxFrameSkip, or in this case, 6.
	private static PrimaryView pv = new PrimaryView();
	private static GameState gs = new GameState(pv);
	private static BitSet inputs = new BitSet(5);
	
	public static void main(String[] args) {
		gs.init();
		int loops = 0;
		long NextTick = System.currentTimeMillis();
		boolean running = true;
		while(running)
		{
			
			loops = 0;
			while( System.currentTimeMillis() > NextTick && loops < MaxFrameSkip)
			{
				updategame();
				
				NextTick += ToNext;
				loops++;
			}
			
			displaygame();
		}

	}
	
	public static void updategame()
	{
		try {
			inputs = pv.getInputs();
			int pos = pv.getPosition();
			boolean select = pv.getOutput(inputs);
			gs.tick(inputs, pos, select);
			pv.tick(inputs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void displaygame()
	{
		pv.repaint();
	}

}