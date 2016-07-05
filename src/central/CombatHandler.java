package central;

import java.util.List;

public class CombatHandler {
	private List<Person> heroes;
	private List<Person> baddies;
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
		gs.getTitleUpdate("What do you do?");
		gs.getMenuUpdates("Fight", "Defend", "Run", "","","","","");
	}
	
	public boolean isStillRunning()
	{
		return isRunning;
	}
	
	
	public void receiveInput(int number)
	{
		if (notExpectingInput)
		{
			notExpectingInput = false;
			gs.getTitleUpdate("What will you do?");
			return;
		}
		if (number == 1)
		{
			gs.getTitleUpdate("You fight.");
		}
		if (number == 2)
		{
			gs.getTitleUpdate("You defend.");
		}
		if (number == 3)
		{
			gs.getTitleUpdate("You run away.");
			isRunning = false;
		}
		notExpectingInput = true;
	}
}
