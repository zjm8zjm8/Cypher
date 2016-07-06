package central;

import java.util.LinkedList;
import java.util.List;

public class CombatHandler {
	private List<Person> heroes;
	private List<Person> baddies;
	private Person[] turnOrder;
	private List<String> thingsToSay;
	private boolean Initialized = false;
	private boolean isRunning = false;
	private boolean notExpectingInput = false;
	private GameState gs;
	
	
	public void initialize(GameState gms, List<Person> h, List<Person> b)
	{
		heroes = h;
		baddies = b;
		gs = gms;
		Initialized = true;
		isRunning = true;
		getTurnOrder();
	}
	
	public boolean isStillRunning()
	{
		return isRunning;
	}
	
	public void getTurnOrder()
	{
		turnOrder = new Person[heroes.size() + baddies.size()];
		
		
	}
	
	public void addToOrder(Person target)
	{
		
	}
	
	public boolean receiveInput(int number)
	{
		if (!Initialized)
			return false;
		if (notExpectingInput)
		{
			notExpectingInput = false;
			gs.getTitleUpdate("What will you do?");
		}
		else if (number == 1)
		{
			gs.getTitleUpdate("You fight.");
			notExpectingInput = true;
		}
		else if (number == 2)
		{
			gs.getTitleUpdate("You defend.");
			notExpectingInput = true;
		}
		else if (number == 3)
		{
			gs.getTitleUpdate("You run away.");
			return false;
		}
		return true;
	}
}
