public class  Ýcerik
{

	private int width;
	private int  height;
	private String isim;

	public int getwidth()
	{
		return width;
	}

	
	public String getisim()
	{
		return isim;
	}
	public void setisim(String i)      
	{
		
		isim = i;
	}
	

	public int getheight()
	{
		return height;
	}


	public void setwidth(int w)      
	{
		
		width = w;
	}
	


	public void setheight(int h)
	{
		height = h;
	}

	
	public String toString()
	{
		return  width  + "" + height ;
	}
}