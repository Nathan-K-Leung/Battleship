import java.util.Scanner;

public class Battleship {

	public static void main(String[] args) {
		
		Ship.createOceanMap();

		//initializes the ships

		Ship Carrier = new Ship ("Carrier", 0, 0, 5);
		Ship Battleship = new Ship ("Battleship", 0, 0, 4);
		Ship Cruiser = new Ship ("Cruiser", 0, 0, 3);
		Ship Submarine = new Ship ("Submarine", 0, 0, 3);
		Ship Destroyer = new Ship ("Destroyer", 0, 0, 2);


		// A list of the ships in string format for printing in the loop
		//A list of the actual ships for calculation in the loop
		
		Ship[] shipList = {Carrier, Battleship, Cruiser, Submarine, Destroyer};
		// A list of ship lengths corresponding to the ships position in the arrays above ^ for calculations
		//For loop that deploys ships as it runs down the list of 5 ships
		
		for (int i = 0; i <= 4; i++) {

			// while loop that is supposed to loop back if hit == true, but it doesn't work
			do
			{
				System.out.println("Deploying " + shipList[i].shipName);
				shipList[i].isHit();
				System.out.println(shipList[i].shipName +" hit == "+ shipList[i].hit + " @ (x)" + ((shipList[i].x)) +", (y)"+ ((shipList[i].y)));
				if (shipList[i].hit == false)
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