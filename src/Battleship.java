import java.util.Scanner;

public class Battleship {
	public static int numRows = 10;
    public static int numCols = 10;
    public static String[][] grid = new String[numRows][numCols];
    public static int shipLength = 0;
    public static boolean orientation;
    
	public static void main(String[] args) {
		//make ship placement for battleship
		// grid is 10x10 (A-J and 1-10)		
		
		//initializes variables
		createOceanMap();
		String choice = "";
		int number = 0;
		int tempX;
		int tempY;
	
		//Carrier Ship
		Ship Carrier = new Ship();
		shipLength = 5;
		//Actually deploys the ship
		System.out.println("Deploying Carrier");
		deployShip();
		
		//Battleship Ship
		Ship Battleship = new Ship(); // the ship object is supposed to be used for checking if it can fit but I honestly don't know how to do it
		shipLength = 4;
		//Actually deploys the ship
		System.out.println("Deploying Battleship");
		deployShip();
		
		//Cruiser Ship
		Ship Cruiser = new Ship();
		shipLength = 3;
		//Actually deploys the ship
		System.out.println("Deploying Cruiser");
		deployShip();
		
		//Submarine Ship
		Ship Submarine = new Ship();
		shipLength = 3;
		//Actually deploys the ship
		System.out.println("Deploying Submarine");
		deployShip();
		
		//Destroyer Ship
		Ship Destroyer = new Ship();
		shipLength = 2;
		//Actually deploys the ship
		System.out.println("Deploying Destroyer");
		deployShip();
		
		}
	public static void deployShip() {
		Scanner input = new Scanner(System.in);
		boolean orientation = false;
		String choice = "";
		//false = horizontal
		//true = vertical
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
		System.out.println(orientation);
		System.out.println(shipLength);

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
		System.out.println("x = "+x + "\ny = " + y);
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
public static int getInput2(int number) {
	Scanner input2 = new Scanner(System.in);
	int choice2 = 0; 
	try 
	{
		choice2 = input2.nextInt();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return choice2; 
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