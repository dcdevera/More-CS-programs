public class Delta
{
	private String from;
	private String input;
	private String to;
	
	public Delta(String x, String y, String z)
	{
		from = x;
		input = y;
		to = z;
	}
	
	public Delta(String x, String y)
	{
		from = x;
		input = y;
		to = "";
	}
	
	public void setFrom(String x)
	{
		from = x;
	}
	
	public String getFrom()
	{
		return from;
	}
	
	public void setInput(String y)
	{
		input = y;
	}
	
	public String getInput()
	{
		return input;
	}
	
	public void setTo(String z)
	{
		to = z;
	}
	
	public String getTo()
	{
		return to;
	}
}