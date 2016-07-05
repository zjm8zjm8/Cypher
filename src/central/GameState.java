package central;

import java.util.BitSet;
import java.util.ArrayList;

import viewable.PrimaryView;

public class GameState {
	private PrimaryView pv;
	private ArrayList<Person> heroes;
	private ArrayList<Person> baddies;
	
	public GameState (PrimaryView pov)
	{
		pv = pov;
	}
	
	public void tick(BitSet inputs)
	{
		/*if (inputs.get(2))
			pv.updateLabel2("+");
		if (inputs.get(3))
			pv.updateLabel2("-");*/
	}
	public void init()
	{
		heroes = new ArrayList<Person>();
		baddies = new ArrayList<Person>();
		heroes.add(new Person(5,5,5,5,5,5));
		baddies.add(new Person(10,10,10,10,10,10));
	}
}
