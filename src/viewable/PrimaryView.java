package viewable;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;
import central.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrimaryView extends JPanel implements KeyListener{

	private JFrame jf = new JFrame();
	private JLabel titleLabel;
	private JLabel Option1;
	private JLabel Option2;
	private JLabel Option3;
	private JLabel Option4;
	private JLabel Option5;
	private JLabel Option6;
	private JLabel Option7;
	private JLabel Option8;
	private String titleLabeltext = "Text";
	private String Option1text = "1";
	private String Option2text = "2";
	private String Option3text = "3";
	private String Option4text = "4";
	private String Option5text = "5";
	private String Option6text = "6";
	private String Option7text = "7";
	private String Option8text = "8";
	private int pos = 1;
	private int frames = 0;
	private int coolDownTicks = 0;
	private String cursor = "-->";
	private BitSet inputs = new BitSet(5);
	private static final long serialVersionUID = 1L;
	
	public PrimaryView(){
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500,500);
		jf.setMinimumSize(new Dimension(500,500));
		Container mainPane = jf.getContentPane();
		mainPane.setLayout(new GridLayout(2,1));
		Container visiblePane = new Container();
		Container menuPane = new Container();
		mainPane.add(visiblePane);
		mainPane.add(menuPane);;
		
		menuPane.setLayout(new GridLayout(5,2));
		Option1 = new JLabel("Option1text");
		Option2 = new JLabel("Option2text");
		Option3 = new JLabel("Option3text");
		Option4 = new JLabel("Option4text");
		Option5 = new JLabel("Option5text");
		Option6 = new JLabel("Option6text");
		Option7 = new JLabel("Option7text");
		Option8 = new JLabel("Option8text");
		titleLabel = new JLabel(titleLabeltext);
		
		menuPane.add(titleLabel);
		menuPane.add(new JLabel(" "));
		menuPane.add(Option1);
		menuPane.add(Option5);
		menuPane.add(Option2);
		menuPane.add(Option6);
		menuPane.add(Option3);
		menuPane.add(Option7);
		menuPane.add(Option4);
		menuPane.add(Option8);
		
		visiblePane.setLayout(new GridLayout(1,1));
		//visiblePane.add(titleLabel);
		//label = new JLabel("Inputs: Left " + inputs.get(0) + ", Right "  + inputs.get(1) +" Up, "  + inputs.get(2) +" Down, " + inputs.get(3) );

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
	
	public boolean getOutput(BitSet inputs2)
	{
		if (inputs.get(4) && coolDownTicks < 0)
		{
			coolDownTicks = 10;
			return true;
		}
		return false;
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

	public int getPosition()
	{
		return pos;
	}
	
	public void updateTitle(String what)
	{
		titleLabeltext = what;
	}
	
	public void updateMenu(String one, String two, String three, String four, String five, String six, String seven, String eight)
	{
		Option1text = one;
		Option2text = two;
		Option3text = three;
		Option4text = four;
		Option5text = five;
		Option6text = six;
		Option7text = seven;
		Option8text = eight;
	}
	
	public String arrowText(int label)
	{
		if (label == pos)
			return "--> ";
		return "";
	}
	
	public boolean isAvailableLabel(int position)
	{
		switch(position)
		{
		case 1:
			return Option1text.length() > 0;
		case 2:
			return Option2text.length() > 0;
		case 3:
			return Option3text.length() > 0;
		case 4:
			return Option4text.length() > 0;
		case 5:
			return Option5text.length() > 0;
		case 6:
			return Option6text.length() > 0;
		case 7:
			return Option7text.length() > 0;
		case 8:
			return Option8text.length() > 0;
		default:
			return false;
		}
	}
	public int nextAvailableLabel(int position)
	{
		int wraps = 0;
		while (wraps < 10)
		{
			if (position == 8)
				position = 0;
			position++;
			if (isAvailableLabel(position))
			{
				return position;
			}
			wraps++;
		}
		return -1;
	}
	
	public int previousAvailableLabel(int position)
	{
		int wraps = 0;
		while (wraps < 10)
		{
			if (position == 1)
				position = 9;
			position--;
			if (isAvailableLabel(position))
			{
				return position;
			}
			wraps++;
		}
		return -1;
	}
	
	public void tick(BitSet inputs2) {
		//titleLabel.setText("Frames: " + frames + " Inputs: Left-" + inputs2.get(2) + ", Right-"  + inputs2.get(3) +", Up-"  + inputs2.get(0) +", Down-" + inputs2.get(1) );
		titleLabel.setText(titleLabeltext);
		Option1.setText(arrowText(1)+Option1text);
		Option2.setText(arrowText(2)+Option2text);
		Option3.setText(arrowText(3)+Option3text);
		Option4.setText(arrowText(4)+Option4text);
		Option5.setText(arrowText(5)+Option5text);
		Option6.setText(arrowText(6)+Option6text);
		Option7.setText(arrowText(7)+Option7text);
		Option8.setText(arrowText(8)+Option8text);
		
		String direction = "";
		
		if (inputs2.get(0) && !(coolDownTicks > 0)) //Up!
		{
			direction = "UP";
			coolDownTicks = 10;
		}
		if (inputs2.get(1) && !(coolDownTicks > 0)) //Down!
		{
			direction = "DOWN";
			coolDownTicks = 10;
		}
		if (inputs2.get(2) && !(coolDownTicks > 0)) //Left!
		{
			
			direction = "LEFT";
			coolDownTicks = 10;
		}
		if (inputs2.get(3) && !(coolDownTicks > 0)) //Right!
		{
			direction = "RIGHT";
			coolDownTicks = 10;
		}
		switch (direction)
		{
		case "DOWN":
			pos = nextAvailableLabel(pos);
			break;
		case "UP":
			pos = previousAvailableLabel(pos);
			break;
		case "LEFT":
			if (isAvailableLabel(pos-4))
				pos -= 4;
			else if (isAvailableLabel(pos+4))
				pos += 4;
			else
				pos = previousAvailableLabel(pos);
			break;
		case "RIGHT":
			if (isAvailableLabel(pos+4))
				pos += 4;
			else if (isAvailableLabel(pos-4))
				pos -=4;
			else 
				pos = nextAvailableLabel(pos);
			break;
		default:
			break;
		}
		/*if (inputs2.get(4) && !(coolDownTicks > 0)) //Enter!
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
		}*/
		coolDownTicks--; //For efficiency's sake, I'm not making any checks to ensure that coolDown doesn't overflow negatively.  
						 //With my current scheme, this shouldn't be an issue unless no inputs are received for over 1 year, 1 month.
		frames++;
	}
}
