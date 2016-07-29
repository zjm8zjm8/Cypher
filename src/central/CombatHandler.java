package central;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CombatHandler {
	private List<Person> heroes;
	private List<Person> baddies;
	private LinkedList<Person> turnOrder;
	private List<String> thingsToSay;
	private boolean Initialized = false;
	private boolean isRunning = false;
	private int TurnNumber;
	private String phase;
	private boolean isHeroesTurn = true;
	private GameState gs;
	private Comparator<Person> speedCompare = new Comparator<Person>() { 
		@Override
		public int compare(Person o1, Person o2)
		{
			if (o1.getSP() > o2.getSP()) return 1;
			if (o1.getSP() < o2.getSP()) return -1;
			else
			{
				if (o1.getLK() > o2.getLK()) return 1;
				if (o1.getLK() < o2.getLK()) return -1;
				else return 0;
			}
		}
	};
	
	public void initialize(GameState gms, List<Person> h, List<Person> b)
	{
		heroes = h;
		baddies = b;
		gs = gms;
		Initialized = true;
		isRunning = true;
		getTurnOrder();
		phase = "Beginning";
		TurnNumber = 0;
		
	}
	
	public boolean isStillRunning()
	{
		return isRunning;
	}
	
	public void getTurnOrder()
	{
		turnOrder = new LinkedList<Person>();
		turnOrder.addAll(heroes);
		turnOrder.addAll(baddies);
		turnOrder.sort(speedCompare);
	}
	
	//Returns true if the battle is ongoing.
	public boolean receiveInput(int number)
	{
		if (!Initialized)
			return false;
		if (phase == "Beginning" || phase == "Ready")
		{
			phase = "Decision";
			gs.getTitleUpdate("What will you do?");
			gs.getMenuUpdates("Fight", "Defend", "Item", "Magic", "Status", "Run", "", "");
			return true;
		}
		if (phase == "Decision")
		{	
			if (number == 1)
			{
				gs.getTitleUpdate("You fight.");
				gs.getMenuUpdates("Okay","","","","","","","");
				phase = "Ready";
			}
			else if (number == 2)
			{
				gs.getTitleUpdate("You defend.");
				gs.getMenuUpdates("Okay","","","","","","","");
				phase = "Ready";
			}
			else if (number == 3)
			{
				gs.getTitleUpdate("You have no items.");
				gs.getMenuUpdates("Okay","","","","","","","");
				phase = "Ready";
			}
			else if (number == 4)
			{
				gs.getTitleUpdate("You have no magic.");
				gs.getMenuUpdates("Okay","","","","","","","");
				phase = "Ready";
			}
			else if (number == 5)
			{
				gs.getTitleUpdate("You have no status.");
				gs.getMenuUpdates("Okay","","","","","","","");
				phase = "Ready";
			}
			else if (number == 6)
			{
				gs.getTitleUpdate("You run away.");
				gs.getMenuUpdates("Okay","","","","","","",""); 
				return false;
			}
			return true;
		}
		else
		{
			gs.getTitleUpdate("ILLEGAL STATE");
			return true;
		}
	}
}
