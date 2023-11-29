import java.util.Scanner;

public class Ship {
public int y = 0;
public int x = 0;
public boolean hit = true;
public static int numRows = 10;
public static int numCols = 10;
public String shipName;
public int shipLength;
public boolean orientation = false;
public static String[][] grid = new String[numRows][numCols];
public static String choice = "";
public static int tempY;
public static int tempX;
public int[] savedPositionX = new int [17];
public int[] savedPositionY = new int [17];


 // use this to store the position of the ship at each location
public Ship(String name, int X, int Y, int size) {
	this.shipName = name;
	this.x = X;
	this.y = Y;
	this.shipLength = size;

}

public String toString() {
	return "("+ x+", "+ y+")";
	}
//isHit doesn't work properly most likely because it checks only the beginning and end. 
//If there is something in the middle, even if it returns hit = true, it will go back to false if the start and end are clear.
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
	x= input.nextInt();
	tempX= x;
	System.out.print("Enter Y coordinate for your ship: ");
	y= input.nextInt();
	tempY= y;

	// false orientation = horizontal(y). true orientation = vertical(x).
	

	if (orientation == true) {
		System.out.println("CHECKING VERTICAL SPACE");
		for (int i = 0; i < shipLength; i++) 
		{
			
			if((y>= 0 && y< numRows) && (x>= 0 && x< numCols) && grid[y][x] == "@" 
					|| (tempY>= 0 && tempY< numRows) && (tempX>= 0 && tempX< numCols) && grid[tempY][tempX] == "@")
			{
	        	System.out.println("You can't place ships at " + x+ ", " + y);
				hit = true;
				break;
			}else if((y< 0 || y>= numRows) || (x< 0 || x>= numCols)) 
			{
	        	//if there isn't a valid spot because it's out of bounds
	        	System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
				hit = true;
				break;
			}
			else if((y>= 0 && y< numRows) && (x>= 0 && x< numCols) && (grid[y][x].equals(" "))
					 && (tempY>= 0 && tempY< numRows) && (tempX>= 0 && tempX< numCols) && (grid[tempY][tempX].equals(" "))) 
				//makes ship take up space on grid if empty
	        {
			//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
				hit = false;
	        } 
// && x== shipPosition[1][i] && y==shipPosition[0][i]
			y++;
			
		}
	}else
	if (orientation == false) 
	{
		System.out.println("CHECKING HORIZONTAL SPACE");
		for (int i = 0; i < shipLength; i++) 
		{
			
			if((y>= 0 && y< numRows) && (x>= 0 && x< numCols) && grid[y][x].equals( "@")
					|| (tempY>= 0 && tempY< numRows) && (tempX>= 0 && tempX< numCols) && grid[tempY][tempX] == "@") 
			{
	        	System.out.println("You can't place ships at " + x+ ", " + y);
				hit = true;
				break;
			}else if((y< 0 || y>= numRows) || (x< 0 || x>= numCols)) 
			{
	        	//if there isn't a valid spot because it's out of bounds
	        	System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
				hit = true;
				break;
			}
			else if((y>= 0 && y< numRows) && (x>= 0 && x< numCols) && (grid[y][x].equals(" "))
					&& (tempY>= 0 && tempY< numRows) && (tempX>= 0 && tempX< numCols) && (grid[tempY][tempX].equals(" "))) 
				//makes ship take up space on grid if empty
	        {
			//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
				hit = false;
	        } 
			x++;
		}
	}
	//System.out.println("hit(inside isHit) == " + hit);

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
    for(int y= 0; y< grid.length; y++) {
        System.out.print(y + "|");

        for (int x= 0; x< grid[y].length; x++){
            System.out.print(grid[y][x]);
        }

        System.out.println("|" + y);
    }

    //Last section of Ocean Map
    System.out.print("  ");
    for(int i = 0; i < numCols; i++)
        System.out.print(i);
    System.out.println();
}

public void deployShips() {
	y= tempY;
	x= tempX;
	System.out.println("DEPLOYING");
	for (int i = 0; i < shipLength; i++) {
		//makes the ship placed vertically
		if (orientation == true) {
			if((y>= 0 && y< numRows) && (x>= 0 && x< numCols) && (grid[y][x].equals(" "))) //makes ship take up space on grid if empty
		        {
				//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
				grid[y][x] =   "@";
				System.out.println("("+ x+", "+ y+")");
				savedPositionX[i] = x;
				savedPositionY[i] = y;
		        }

		y++;
		
		} 
		if (orientation == false) {
			if((y>= 0 && y< numRows) && (x>= 0 && x< numCols) && (grid[y][x].equals(" ")) ) //makes ship take up space on grid if empty
		        {
				//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
				grid[y][x] =   "@";
				System.out.println("("+ x+", "+ y+")");
				savedPositionX[i] = x;
				savedPositionY[i] = y;
		        }
		        
		x++;
		}
	}
	printOceanMap();
}
}