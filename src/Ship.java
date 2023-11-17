import java.util.Scanner;

public class Ship {
public int x = 0;
public int y = 0;
public boolean hit = false;
public static int numRows = 10;
public static int numCols = 10;
public static int shipLength = 0;
public static boolean orientation = false;
public static String[][] grid = new String[numRows][numCols];
public static String choice = "";
public static int tempX;
public static int tempY;

public String toString() {
	return "("+ x +", "+ y +")";
	}

public boolean isHit() {
	//this Ship method checks if the ship is overlapping with another ship or is out of bounds (hit=true, else false) and returns the boolean hit
	Scanner input = new Scanner(System.in);
	System.out.println("Ship length is: " + shipLength);
	System.out.println("What orientation do you want your ship to be placed in? \n[H] Horizontal \n[V] Vertical");
	choice = input.nextLine();
	if ("horizontal".equalsIgnoreCase(choice) || "h".equalsIgnoreCase(choice)) {
		orientation = false;
	}
	if ("vertical".equalsIgnoreCase(choice) || "v".equalsIgnoreCase(choice)) {
		orientation = true;
	}
	if (orientation == false) {
		System.out.println("The ship's orientation is: Horizontal");
	} 
	if (orientation == true) {
		System.out.println("The ship's orientation is: Vertical");
	}

	System.out.print("Enter X coordinate for your ship: ");
	x = input.nextInt();
	tempX = x;
	System.out.print("Enter Y coordinate for your ship: ");
	y = input.nextInt();
	tempY = y;
	// false orientation = horizontal(y). true orientation = vertical(x).
	

	if (orientation == true) {
		for (int i = 1; i <= shipLength; i++) 
		{
			if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y].equals(" "))) //makes ship take up space on grid if empty
	        {
			//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
				hit = false;
	        } 
			else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@") 
			{
	        	System.out.println("You can't place ships at " + y + ", " + x);
				hit = true;
			}else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) 
			{
	        	//if there isn't a valid spot because it's out of bounds
	        	System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
				hit = true;
			}
			x++;
			
		}
	}
	if (orientation == false) 
	{
		for (int i = 1; i <= shipLength; i++) 
		{
			if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y].equals(" "))) //makes ship take up space on grid if empty
	        {
			//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
				hit = false;
	        } 
			else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@") 
			{
	        	System.out.println("You can't place ships at " + y + ", " + x);
				hit = true;
			}else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) 
			{
	        	//if there isn't a valid spot because it's out of bounds
	        	System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
				hit = true;
			}
			y++;
		}
	}
	
	return hit;
}

//The following methods are identical to the ones in the battleship class but reformatted for the Ship class
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

public void deployShips() {
	x = tempX;
	y = tempY;
	for (int i = 1; i <= shipLength; i++) {
		//makes the ship placed vertically
		if (orientation == true) {
			if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y].equals(" "))) //makes ship take up space on grid if empty
		        {
				//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
				grid[x][y] =   "@";
		        }

		x++;
		
		} 
		if (orientation == false) {
			if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y].equals(" "))) //makes ship take up space on grid if empty
		        {
				//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
				grid[x][y] =   "@";
		        }
		        
		y++;
		}
	}
	printOceanMap();
}
}