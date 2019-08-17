package compute;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.Calendar;
import java.util.Date;

public class Randomize {
	public int randomize(int a)
	{	
		PointerInfo a1 = MouseInfo.getPointerInfo(); //Fetching mouse pointer location
		Point b = a1.getLocation();
		int x = (int) b.getX();
		int y = (int) b.getY();
		
		int year = Calendar.getInstance().get(Calendar.YEAR); //fetch year
		
		java.util.Date date= new Date(); //fetch month
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);

	    int cores = Runtime.getRuntime().availableProcessors(); //fetch no. of cores
	    
	    long memory = Runtime.getRuntime().freeMemory(); //fetch free memory
	 
	    int sum = (int) (a + x + y + year + month + cores + memory);
	    //System.out.println(a);
	    int mod = sum % a;
	    return mod;
	    //System.out.println(sum);
	}
}
