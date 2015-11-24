package central;

import java.util.BitSet;
import java.util.List;

import viewable.PrimaryView;

public class GameState {
	private PrimaryView pv;
	private List<Person> heroes;
	private List<Person> baddies;
	
	public GameState (PrimaryView pov)
	{
		pv = pov;
	}
	
	public void tick(BitSet inputs)
	{
		if (inputs.get(2))
			pv.updateLabel2("+");
		if (inputs.get(3))
			pv.updateLabel2("-");
	}
	public void init()
	{
		
		
	}
}
