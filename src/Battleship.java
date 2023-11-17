import java.util.Scanner;

public class Battleship {
	public static int numRows = 10;
    public static int numCols = 10;
    public static String[][] grid = new String[numRows][numCols];
    public static int shipLength = 0;
	public static void main(String[] args) {
		
		Ship.createOceanMap();
		/*
		 * ITS KIND OF DUMB BUT x = vertical AND y = horizontal
		 */
		//initializes the ships
		Ship Carrier = new Ship();
		Ship Battleship = new Ship();
		Ship Cruiser = new Ship();
		Ship Submarine = new Ship();
		Ship Destroyer = new Ship();
		// A list of the ships in string format for printing in the loop
		String[] stringShipList = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
		//A list of the actual ships for calculation in the loop
		Ship[] shipList = {Carrier, Battleship, Cruiser, Submarine, Destroyer};
		// A list of ship lengths corresponding to the ships position in the arrays above ^ for calculations
		int[] shipLengths = {5, 4, 3, 3, 2};
		
		//For loop that deploys ships as it runs down the list of 5 ships
		for (int i = 0; i <= 4; i++) {
			Ship.shipLength = shipLengths[i];
			// while loop that is supposed to loop back if hit == true, but it doesn't work
			do
			{
				System.out.println("Deploying " + stringShipList[i]);
				shipList[i].isHit();
				System.out.println(stringShipList[i] +" hit == "+ shipList[i].hit + " @ " + shipList[i].y +", "+ shipList[i].x);
				if (shipList[i].hit==false) 
				{
					shipList[i].deployShips();
				}
			} while (shipList[i].hit == true);
		}
		
		
		
		
	
	}
	

	
public static String getInput(String text) {
	Scanner input = new Scanner(System.in);
	String choice = ""; 
	try 
	{
		System.out.println(text);
		choice = input.nextLine();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return choice;
}

private static boolean isInputInteger(String input)	{
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