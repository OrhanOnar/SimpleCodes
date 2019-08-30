

public class  Words
{

	private int Frekans;
	private String name;


	public int getId()
	{
		return Frekans;
	}


	public String getName()
	{
		return name;
	}


	public void setFrekans(int freko)       //Frekansi arttiran metodum
	{
		freko++; 
	   Frekans = freko;
	}
	
	public void setFrekans2(int freko)
	{
		
	   Frekans = freko;
	}
	public void Frekans()
	{
	
	   Frekans = 1;
	}

	public void setName(String newName)
	{
		name = newName;
	}

	
	public String toString()
	{
		return  name  +Frekans +",";
	}
}
