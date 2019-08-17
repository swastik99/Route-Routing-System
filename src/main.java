/*Route Routing System
 * Authors:
 * Aditi Thapliyal
 * Swastik Shrivastava
 * An application intended to enhance security of the vehicles on road by randomizing their path*/

//declarations
import compute.Randomize;
import compute.PressKey;
import java.awt.AWTException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


//calling main class
//declaration of variables
	
public class main{ 
	public static int chpts;
	static int outnum,i;
	static int check=0;
	static int a[]=new int[50];
	static String name[][]=new String[100][100], name2;
	static String checkpointname[]=new String[50], destination, source;
	public static void displayroute(int c, int a)
	{	PressKey ob3 = new PressKey();
		int b = a + 1;
		ob3.pressAnyKeyToContinue(); 
		System.out.println("The route needs to be taken to reach checkpoint "+checkpointname[c]+" is : " +name[c][b]);
		System.out.println("As soon as you reach checkpoint, Press Enter to continue...");
		ob3.pressAnyKeyToContinue();
	}
	
	
	public static void main(final String[] args) throws AWTException {
		// TODO Auto-generated method stub
		Randomize ob=new Randomize();
		PressKey ob3 = new PressKey();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the source and Destination Location");
		System.out.print("Source:-");
		String source = sc.next();
		System.out.print("Destination:-");
		String destination = sc.next();
		
		System.out.println("Enter the number of Checkpoints on the way");
		chpts = sc.nextInt();
		
		for (int i=1; i<=chpts; i++)
		{	
			System.out.println("Enter the name of Checkpoint "+i);
			checkpointname[i] = sc.next();
		}
		
		for (int i=1; i<=chpts; i++)
		{
			System.out.println("Enter the number of paths leading to checkpoint named "+checkpointname[i]);
			a[i] = sc.nextInt();
		}
		
		/*fetching the names of paths for checkpoints*/
		for (int i=1; i<=chpts; i++)
		{
			for (int j=1; j<=a[i]; j++)
			{
				System.out.println("Enter the name of path "+j+" leading to Checkpoint named "+checkpointname[i]);
				name2=sc.next();
				name[i][j]=name2;
			}
		}
		
		System.out.println("Path has been analysed and ready to be traced");
		try {
			TimeUnit.SECONDS.sleep(3);
			} 
		catch (InterruptedException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		System.out.println("Please press enter to get the direction");
		ob3.pressAnyKeyToContinue();
		System.out.print("Please wait data is synchronizing");
		for(int k=1; k<=5; k++)
		{				
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("");
		/*calling the randomized function to randomize the checkpoints*/
		for (int i=1; i<=chpts; i++)
		{
			int number = a[i];
			int out1 = ob.randomize(number);
//			while (out1 ==0)
//			{
//				out1 = randomize(number);
//			}
			/*calling display function to display randomized routes*/
			displayroute(i,out1);
			//System.out.println("To reach checkpoint "+i+", take path number"+out1 );
			//System.out.println("As soon as you reach checkpoint "+i+", enter ok");
					
		}
		System.out.println("You have reached " +destination+" from "+source+". Good Luck.");
	}
}
