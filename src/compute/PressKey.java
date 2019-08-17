package compute;

public class PressKey {
	
	/*waiting for the user to reach the checkpoint*/
	
	public void pressAnyKeyToContinue()
	{	try
		{
	    	System.in.read();
		}  
		catch(Exception e)
		{
		}  
	}
}
