package viewable;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;
import central.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrimaryView extends JPanel implements KeyListener{

	private JFrame jf = new JFrame();
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private int pos = 10;
	private int frames = 0;
	private int coolDownTicks = 0;
	private String cursor = "--->";
	private String label2defaultText = "-";
	private BitSet inputs = new BitSet(5);
	private static final long serialVersionUID = 1L;
	
	
	public PrimaryView(){
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500,500);
		jf.setMinimumSize(new Dimension(500,500));
		Container ct = jf.getContentPane();
		ct.setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		label = new JLabel("Inputs: Left " + inputs.get(0) + ", Right "  + inputs.get(1) +" Up, "  + inputs.get(2) +" Down, " + inputs.get(3) );
		label2 = new JLabel("2");
		label3 = new JLabel("3");
		label4 = new JLabel("4");
		con.fill = GridBagConstraints.HORIZONTAL;
		con.weighty = 1;
		con.weightx = 1;
		con.gridy = 0;
		con.gridx = 0;
		ct.add(label, con);
		con.gridy = 1;
		con.gridx = 0;
		ct.add(label2, con);
		con.gridy = 2;
		con.gridx = 0;
		ct.add(label3, con);
		con.gridy = 3;
		con.gridx = 0;
		ct.add(label4, con);
		//jf.add(label);
		//jf.add(label2);
		//jf.add(label3);
		//jf.add(label4);
		jf.pack();
		jf.requestFocus();
		jf.setVisible(true);
		jf.setFocusable(true);
		jf.addKeyListener(this);
		
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(500,500);
	}
	
	public BitSet getInputs()
	{
		return inputs;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    if (key == KeyEvent.VK_UP) {
	        inputs.set(0, true);
	    }
	    if (key == KeyEvent.VK_DOWN) {
	        inputs.set(1, true);
	    }
	    if (key == KeyEvent.VK_LEFT) {
	        inputs.set(2, true);
	    }
	    if (key == KeyEvent.VK_RIGHT) {
	        inputs.set(3, true);
	    }
	    if (key == KeyEvent.VK_ENTER) {
	    	inputs.set(4, true);
	    }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
	        inputs.set(0, false);
	    }
	    if (key == KeyEvent.VK_DOWN) {
	        inputs.set(1, false);
	    }
	    if (key == KeyEvent.VK_LEFT) {
	        inputs.set(2, false);
	    }
	    if (key == KeyEvent.VK_RIGHT) {
	        inputs.set(3, false);
	    }
	    if (key == KeyEvent.VK_ENTER) {
	    	inputs.set(4, false);
	    }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void updateLabel2(String what)
	{
		label2defaultText = what;
	}
	
	public void tick(BitSet inputs2) {
		label.setText("Frames: " + frames + " Inputs: Left-" + inputs2.get(2) + ", Right-"  + inputs2.get(3) +", Up-"  + inputs2.get(0) +", Down-" + inputs2.get(1) );
		if (inputs2.get(0) && !(coolDownTicks > 0)) //Up!
		{
			pos--;
			coolDownTicks = 10;
		}
		if (inputs2.get(1) && !(coolDownTicks > 0)) //Down!
		{
			pos++;
			coolDownTicks = 10;
		}
		if (inputs2.get(4) && !(coolDownTicks > 0)) //Enter!
		{
			if (cursor.equals("--->"))
			{
				cursor = "!!!>";
			}
			else
			{
				cursor = "--->";
			}
			coolDownTicks = 10;
		}
		coolDownTicks--; //For efficiency's sake, I'm not making any checks to ensure that coolDown doesn't overflow negatively.  
						 //With my current scheme, this shouldn't be an issue unless no inputs are received for over 1 year, 1 month.
		if (pos < 2)
			pos = 4;
		if (pos > 4)
			pos = 2;
		if (pos == 2)
		{
			label2.setText(cursor);
		}
		else
		{
			label2.setText(label2defaultText);
		}
		if (pos == 3)
		{
			label3.setText(cursor);
		}
		else
		{
			label3.setText("-");
		}
		if (pos == 4)
		{
			label4.setText(cursor);
		}
		else
		{
			label4.setText("-");
		}
		frames++;
	}
}
