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
	private CombatHandler ch;
	
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
					BeginBattle();
				else if (position == 2)
					System.exit(0);
			}
			if (state == States.BATTLE)
			{
				if(!ch.isStillRunning())
				{
					state = States.MENU;
					return;
				}
				ch.receiveInput(position);
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
	
	public void BeginBattle()
	{
		ch = new CombatHandler();
		ch.initialize(this, heroes, baddies);
		state = States.BATTLE;
		
	}
	public void getTitleUpdate(String title)
	{
		pv.updateTitle(title);
	}
	public void getMenuUpdates(String menu1, String menu2, String menu3, String menu4, String menu5, String menu6, String menu7, String menu8)
	{
		pv.updateMenu(menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8);
	}
}
