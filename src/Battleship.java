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
	
	public static void deployShip() {
		Scanner input = new Scanner(System.in);
		boolean orientation = false;
		String choice = "";
		//false = horizontal
		//true = vertical
		System.out.println("Ship length is: " + shipLength);
		System.out.println("What orientation do you want your ship to be placed in? \n[H] Horizontal \n[V] Vertical");
		choice = getInput(choice);
		if ("horizontal".equalsIgnoreCase(choice) || "h".equalsIgnoreCase(choice)) {
			orientation = false;
		}
		if ("vertical".equalsIgnoreCase(choice) || "v".equalsIgnoreCase(choice)) {
			orientation = true;
		}
		if (orientation == false) {
			System.out.println("The ship's orientation is: Horizontal");
		} else {
			System.out.println("The ship's orientation is: Vertical");
		}

		System.out.print("Enter X coordinate for your ship: ");
		int x = input.nextInt();
		System.out.print("Enter Y coordinate for your ship: ");
		int y = input.nextInt();
				
		//For loop based on shipLength
		for (int i = 1; i <= shipLength; i++) {
			//makes the ship placed vertically
			if (orientation == true) {
				if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y].equals(" "))) //makes ship take up space on grid if empty
			        {
					//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
					grid[x][y] =   "@";
			        }
			        else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@")
			        	//if there isn't a valid spot because there is already an "@"
			        	System.out.println("You can't place two or more ships on the same location");
			        else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
			        	//if there isn't a valid spot because it's out of bounds
			        	System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
			x++;
			
			} 
			if (orientation == false) {
			if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " ")) //makes ship take up space on grid if empty
			        {
					//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
					grid[x][y] =   "@";
			        }
			        else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@")
			        	//if there isn't a valid spot because there is already an "@"
			        	System.out.println("You can't place two or more ships on the same location");
			        else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
			        	//if there isn't a valid spot because it's out of bounds
			        	System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
			y++;
			}
		}
		printOceanMap();
		
	}
	
	public static void createOceanMap(){
        //Top section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
                System.out.print(i);
        System.out.println();

        //Middle section of Ocean Map
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                if (j == 0)
                    System.out.print(i + "|" + grid[i][j]);
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i);
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        //Bottom section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();
    }
    public static void printOceanMap(){
        System.out.println();
        //First section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

        //Middle section of Ocean Map
        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x][y]);
            }

            System.out.println("|" + x);
        }

        //Last section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();
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