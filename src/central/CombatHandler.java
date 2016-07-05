package central;

import java.util.List;

public class CombatHandler {
	private List<Person> heroes;
	private List<Person> baddies;
	private boolean Initialized = false;
	
	public void initialize(List<Person> h, List<Person> b)
	{
		heroes = h;
		baddies = b;
		Initialized = true;
	}
	public void tick()
	{
		
	}
}
