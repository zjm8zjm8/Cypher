package central;

import java.util.BitSet;
import java.util.ArrayList;

import viewable.PrimaryView;

public class GameState {
	private enum States { MENU, BATTLE}
	private PrimaryView pv;
	private ArrayList<Person> heroes;
	private ArrayList<Person> baddies;
	private States state = States.MENU;
	
	public GameState (PrimaryView pov)
	{
		pv = pov;
	}
	
	public void tick(BitSet inputs, int position)
	{
		if (inputs.get(4))
		{
			if (state == States.MENU)
			{
				if (position == 1)
					pv.updateTitle("Begin Fight");
				else if (position == 2)
					System.exit(0);
			}
		}
	}
	public void init()
	{
		heroes = new ArrayList<Person>();
		baddies = new ArrayList<Person>();
		heroes.add(new Person(15,15,15,15,15,15));
		baddies.add(new Person(10,10,10,10,10,10));
		pv.updateTitle("Start");
		
		pv.updateMenu("Fight", "Quit", "", "", "", "", "", "");
	}
}
