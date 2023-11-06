import java.util.Scanner;
public class Battleship {

	public static void main(String[] args) {
		//grid is 10x10 with A-J and 1-10.
		
		Ship aircraftCarrier = new Ship();
		int Position = Integer.valueOf(getInput());
		aircraftCarrier.a = Position; 
		
		
	}
	private static boolean canIFit (Ship aircraftCarrier)	{
		boolean fit = true;
		return fit;
	}
	
	public static String getInput() {
		Scanner input = new Scanner(System.in);
		String choice = ""; 
		try 
		{
			System.out.println(choice);
			choice = input.nextLine();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return choice; 
		}
	
	
	public static boolean isInputInteger(String input)	{ //method checks if input is an integer
		boolean isAnInteger = true;
		//all validation cases set this variable to false.
		//for(Start the looper; condition to loop; steep the looper) {}
		for(int c = 0; c < input.length();c++) {
			char letter = input.charAt(c);
			//'-' is 45 '0 - 9' 48 - 57
			if(c!=0 &&!(letter >= 48 && letter<= 57))
			{
			isAnInteger = false;
			}else if(letter != 45 && !(letter >= 48 && letter <= 57))
			{
			isAnInteger = false;
			}
		}
		return isAnInteger;	
	}
}
