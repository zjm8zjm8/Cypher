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
	
	public void tick(BitSet inputs, int position, boolean enterPressed)
	{
		if (enterPressed)
		{
			if (state == States.MENU)
			{
				if (position == 1)
					BeginBattle();
				else if (position == 2)
					System.exit(0);
			}
			else if (state == States.BATTLE)
			{
				if(!ch.receiveInput(position))
				{
					changeState(States.MENU);
				}
			}
		}
	}
	public void init()
	{
		heroes = new ArrayList<Person>();
		baddies = new ArrayList<Person>();
		heroes.add(new Hero(15,15,15,15,15,15));
		baddies.add(new Person(10,10,10,10,10,10));
		pv.updateTitle("Start");
		
		pv.updateMenu("Fight", "Quit", "", "", "", "", "", "");
	}
	
	public void BeginBattle()
	{
		ch = new CombatHandler();
		ch.initialize(this, heroes, baddies);
		changeState(States.BATTLE);
		
	}
	public void getTitleUpdate(String title)
	{
		pv.updateTitle(title);
	}
	public void getMenuUpdates(String menu1, String menu2, String menu3, String menu4, String menu5, String menu6, String menu7, String menu8)
	{
		pv.updateMenu(menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8);
	}
	public void changeState(States stat)
	{
		switch (stat)
		{
		case MENU:
			pv.updateTitle("Back to the menu...");
			pv.updateMenu("Fight", "Quit", "", "", "", "", "", "");
			state = States.MENU;
			break;
		case BATTLE:
			pv.updateTitle("A Battle Begins!");
			pv.updateMenu("Okay", "", "", "","","","","");
			state = States.BATTLE;
			break;
		}
	}
}
