package central;

public class Person {
	private int ED;
	private int ST;
	private int IQ;
	private int DX;
	private int SP;
	private int LK;
	private int HP;
	private int HPMax;
	private boolean isAlive = true;
	protected boolean isGood = false;
	
	public Person(int endurance, int strength, int intelligence, int dexterity, int speed, int luck)
	{
		ED = endurance;
		ST = strength;
		IQ = intelligence;
		DX = dexterity;
		SP = speed;
		LK = luck;
	}

	public boolean getIsGood()
	{
		return isGood;
	}
	public boolean isAlive()
	{
		return isAlive;
	}
	public int getED()
	{
		return ED;
	}
	public int getST()
	{
		return ST;
	}
	public int getIQ()
	{
		return IQ;
	}
	public int getDX()
	{
		return DX;
	}
	public int getSP()
	{
		return SP;
	}
	public int getLK()
	{
		return LK;
	}
	public int getHPCurrent()
	{
		return HP;
	}
	public int getHPMax()
	{
		return HPMax;
	}
	public void setED(int x)
	{
		ED = x;
	}
	public void setST(int x)
	{
		ST = x;
	}
	public void setIQ(int x)
	{
		IQ = x;
	}
	public void setDX(int x)
	{
		DX = x;
	}
	public void setSP(int x)
	{
		SP = x;
	}
	public void setLK(int x)
	{
		LK = x;
	}
	public void setHPCurrent(int x)
	{
		HP = x;
	}
	public void setHPMax(int x)
	{
		HPMax = x;
	}
	public void loseHP(int amount)
	{
		HP = HP - amount;
		if (HP <=0)
		{
			isAlive = false;
			HP = 0;
		}
	}
	public void restoreHP(int amount)
	{
		HP = HP + amount;
		if (HP > HPMax)
			HP = HPMax;
	}
	public void gainHP(int amount)
	{
		HP = HP + amount;
	}
}
