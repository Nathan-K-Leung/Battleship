import java.util.Scanner;

public class Battleship {
	public static int numRows = 10;
    public static int numCols = 10;
    public static String[][] grid = new String[numRows][numCols];
    
	public static void main(String[] args) {
		//make ship placement for battleship
		// grid is 10x10 (A-J and 1-10)		
		
		//initializes variables
		createOceanMap();
		String choice = "";
		int number = 0;
		int shipLength = 0;
		boolean orientation = false;
		int tempX = 0;
		int tempY = 0;
		boolean canFit = false;
		
		
		//Carrier Ship
		Ship Carrier = new Ship();
		Carrier.shipLength = 5;
		//input for orientation of the ship. false = Horizontal || true = Vertical. Default is horizontal.
		orientation = Carrier.shipOrientation(choice = getInput("What orientation do you want your Carrier to be placed in? \n[H] Horizontal \n[V] Vertical"));
		if (orientation == false) {
			System.out.println("The ship's orientation is: Horizontal");
			} else {
			System.out.println("The ship's orientation is: Vertical");
		}
				
		//Actually deploys the ship
		System.out.println("Place down your Carrier at coordinates:");
		System.out.print("Enter X coordinate for your ship: ");
		Carrier.x = getInput2(number);
		System.out.print("Enter Y coordinate for your ship: ");
		Carrier.y = getInput2(number);
		System.out.println("Start position: "+Carrier.toString());
			
		//For loop based on shipLength
		for (int i = 1; i <= Carrier.shipLength; i++) {
			//makes the ship placed vertically
			if (orientation == true) {
				if((Carrier.x >= 0 && Carrier.x < numRows) && (Carrier.y >= 0 && Carrier.y < numCols) && (grid[Carrier.x][Carrier.y] == " ")) //makes ship take up space on grid if empty
			        {
					//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
					grid[Carrier.x][Carrier.y] =   "@";
			        }
			        else if((Carrier.x >= 0 && Carrier.x < numRows) && (Carrier.y >= 0 && Carrier.y < numCols) && grid[Carrier.x][Carrier.y] == "@")
			        	//if there isn't a valid spot because there is already an "@"
			        	System.out.println("You can't place two or more ships on the same location");
			        else if((Carrier.x < 0 || Carrier.x >= numRows) || (Carrier.y < 0 || Carrier.y >= numCols))
			        	//if there isn't a valid spot because it's out of bounds
			        	System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
			Carrier.x++;
			}
				//Same as above but for horizontal
				if (orientation == false) {
					if((Carrier.x >= 0 && Carrier.x < numRows) && (Carrier.y >= 0 && Carrier.y < numCols) && (grid[Carrier.x][Carrier.y] == " ")) //makes ship take up space on grid if empty
			           {
			               grid[Carrier.x][Carrier.y] =   "@";
			            
			           }
			           else if((Carrier.x >= 0 && Carrier.x < numRows) && (Carrier.y >= 0 && Carrier.y < numCols) && grid[Carrier.x][Carrier.y] == "@")
			               System.out.println("You can't place two or more ships on the same location");
			           else if((Carrier.x < 0 || Carrier.x >= numRows) || (Carrier.y < 0 || Carrier.y >= numCols))
			               System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
			Carrier.y++;
				}
			}
		printOceanMap();

		//Battleship Ship
				Ship Battleship = new Ship();
				Battleship.shipLength = 4;
				//input for orientation of the ship. false = Horizontal || true = Vertical. Default is horizontal.
				orientation = Battleship.shipOrientation(choice = getInput("What orientation do you want your Battleship to be placed in? \n[H] Horizontal \n[V] Vertical"));
				if (orientation == false) {
					System.out.println("The ship's orientation is: Horizontal");
					} else {
					System.out.println("The ship's orientation is: Vertical");
				}
						
				//Actually deploys the ship
				System.out.println("Place down your Battleship at coordinates:");
				System.out.print("Enter X coordinate for your ship: ");
				Battleship.x = getInput2(number);
				System.out.print("Enter Y coordinate for your ship: ");
				Battleship.y = getInput2(number);
				System.out.println("Start position: "+Battleship.toString());
						
				//For loop based on shipLength
				for (int i = 1; i <= Battleship.shipLength; i++) {
					//makes the ship placed vertically
					if (orientation == true) {
						if((Battleship.x >= 0 && Battleship.x < numRows) && (Battleship.y >= 0 && Battleship.y < numCols) && (grid[Battleship.x][Battleship.y] == " ")) //makes ship take up space on grid if empty
					        {
							//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
							grid[Battleship.x][Battleship.y] =   "@";
					        }
					        else if((Battleship.x >= 0 && Battleship.x < numRows) && (Battleship.y >= 0 && Battleship.y < numCols) && grid[Battleship.x][Battleship.y] == "@")
					        	//if there isn't a valid spot because there is already an "@"
					        	System.out.println("You can't place two or more ships on the same location");
					        else if((Battleship.x < 0 || Battleship.x >= numRows) || (Battleship.y < 0 || Battleship.y >= numCols))
					        	//if there isn't a valid spot because it's out of bounds
					        	System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
					Battleship.x++;
					}
						//Same as above but for horizontal
						if (orientation == false) {
							if((Battleship.x >= 0 && Battleship.x < numRows) && (Battleship.y >= 0 && Battleship.y < numCols) && (grid[Battleship.x][Battleship.y] == " ")) //makes ship take up space on grid if empty
					           {
					               grid[Battleship.x][Battleship.y] =   "@";
					            
					           }
					           else if((Battleship.x >= 0 && Battleship.x < numRows) && (Battleship.y >= 0 && Battleship.y < numCols) && grid[Battleship.x][Battleship.y] == "@")
					               System.out.println("You can't place two or more ships on the same location");
					           else if((Battleship.x < 0 || Battleship.x >= numRows) || (Battleship.y < 0 || Battleship.y >= numCols))
					               System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
					Battleship.y++;
						}
					}
				printOceanMap();	

		//Cruiser Ship
				Ship Cruiser = new Ship();
				Cruiser.shipLength = 3;
				//input for orientation of the ship. false = Horizontal || true = Vertical. Default is horizontal.
				orientation = Cruiser.shipOrientation(choice = getInput("What orientation do you want your Cruiser to be placed in? \n[H] Horizontal \n[V] Vertical"));
				if (orientation == false) {
					System.out.println("The ship's orientation is: Horizontal");
					} else {
					System.out.println("The ship's orientation is: Vertical");
				}
						
				//Actually deploys the ship
				System.out.println("Place down your Cruiser at coordinates:");
				System.out.print("Enter X coordinate for your ship: ");
				Cruiser.x = getInput2(number);
				System.out.print("Enter Y coordinate for your ship: ");
				Cruiser.y = getInput2(number);
				System.out.println("Start position: "+Cruiser.toString());
						
				//For loop based on shipLength
				for (int i = 1; i <= Cruiser.shipLength; i++) {
					//makes the ship placed vertically
					if (orientation == true) {
						if((Cruiser.x >= 0 && Cruiser.x < numRows) && (Cruiser.y >= 0 && Cruiser.y < numCols) && (grid[Cruiser.x][Cruiser.y] == " ")) //makes ship take up space on grid if empty
					        {
							//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
							grid[Cruiser.x][Cruiser.y] =   "@";
					        }
					        else if((Cruiser.x >= 0 && Cruiser.x < numRows) && (Cruiser.y >= 0 && Cruiser.y < numCols) && grid[Cruiser.x][Cruiser.y] == "@")
					        	//if there isn't a valid spot because there is already an "@"
					        	System.out.println("You can't place two or more ships on the same location");
					        else if((Cruiser.x < 0 || Cruiser.x >= numRows) || (Cruiser.y < 0 || Cruiser.y >= numCols))
					        	//if there isn't a valid spot because it's out of bounds
					        	System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
					Cruiser.x++;
					}
						//Same as above but for horizontal
						if (orientation == false) {
							if((Cruiser.x >= 0 && Cruiser.x < numRows) && (Cruiser.y >= 0 && Cruiser.y < numCols) && (grid[Cruiser.x][Cruiser.y] == " ")) //makes ship take up space on grid if empty
					           {
					               grid[Cruiser.x][Cruiser.y] =   "@";
					            
					           }
					           else if((Cruiser.x >= 0 && Cruiser.x < numRows) && (Cruiser.y >= 0 && Cruiser.y < numCols) && grid[Cruiser.x][Cruiser.y] == "@")
					               System.out.println("You can't place two or more ships on the same location");
					           else if((Cruiser.x < 0 || Cruiser.x >= numRows) || (Cruiser.y < 0 || Cruiser.y >= numCols))
					               System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
					Cruiser.y++;
						}
					}
				printOceanMap();
		
			//Submarine Ship
			Ship Submarine = new Ship();
			Submarine.shipLength = 3;
				//input for orientation of the ship. false = Horizontal || true = Vertical. Default is horizontal.
				orientation = Submarine.shipOrientation(choice = getInput("What orientation do you want your Submarine to be placed in? \n[H] Horizontal \n[V] Vertical"));
				
				if (orientation == false) {
				System.out.println("The ship's orientation is: Horizontal");
				} else {
					System.out.println("The ship's orientation is: Vertical");

				}
				
				//Actually deploys the ship
				System.out.println("Place down your Submarine at coordinates:");
				System.out.print("Enter X coordinate for your ship: ");
		        Submarine.x = getInput2(number);
		        System.out.print("Enter Y coordinate for your ship: ");
		        Submarine.y = getInput2(number);
				System.out.println("Start position: "+Submarine.toString());
				
				//For loop based on shipLength
				for (int i = 1; i <= Submarine.shipLength; i++) {
					//makes the ship placed vertically
					if (orientation == true) {
					if((Submarine.x >= 0 && Submarine.x < numRows) && (Submarine.y >= 0 && Submarine.y < numCols) && (grid[Submarine.x][Submarine.y] == " ")) //makes ship take up space on grid if empty
			           {
						//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
						grid[Submarine.x][Submarine.y] =   "@";
			           }
			           else if((Submarine.x >= 0 && Submarine.x < numRows) && (Submarine.y >= 0 && Submarine.y < numCols) && grid[Submarine.x][Submarine.y] == "@")
			               //if there isn't a valid spot because there is already an "@"
			        	   System.out.println("You can't place two or more ships on the same location");
			           else if((Submarine.x < 0 || Submarine.x >= numRows) || (Submarine.y < 0 || Submarine.y >= numCols))
			        	 //if there isn't a valid spot because it's out of bounds
			        	   System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
					Submarine.x++;
					}
				//Same as above but for horizontal
				if (orientation == false) {
					if((Submarine.x >= 0 && Submarine.x < numRows) && (Submarine.y >= 0 && Submarine.y < numCols) && (grid[Submarine.x][Submarine.y] == " ")) //makes ship take up space on grid if empty
			           {
			               grid[Submarine.x][Submarine.y] =   "@";
			            
			           }
			           else if((Submarine.x >= 0 && Submarine.x < numRows) && (Submarine.y >= 0 && Submarine.y < numCols) && grid[Submarine.x][Submarine.y] == "@")
			               System.out.println("You can't place two or more ships on the same location");
			           else if((Submarine.x < 0 || Submarine.x >= numRows) || (Submarine.y < 0 || Submarine.y >= numCols))
			               System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
					Submarine.y++;
					}
				}
				printOceanMap();
		
		// creates Destroyer. take input for orientation, starting position, sets shipLength to length of ship (2 in this case)
		Ship Destroyer = new Ship();
		Destroyer.shipLength = 2;
		//input for orientation of the ship. false = Horizontal || true = Vertical. Default is horizontal.
		orientation = Destroyer.shipOrientation(choice = getInput("What orientation do you want your Destroyer to be placed in? \n[H] Horizontal \n[V] Vertical"));
		
		if (orientation == false) {
		System.out.println("The ship's orientation is: Horizontal");
		} else {
			System.out.println("The ship's orientation is: Vertical");

		}
		
		//Actually deploys the ship
		System.out.println("Place down your Destroyer at coordinates:");
		System.out.print("Enter X coordinate for your ship: ");
        Destroyer.x = getInput2(number);
        System.out.print("Enter Y coordinate for your ship: ");
        Destroyer.y = getInput2(number);
		System.out.println("Start position: "+Destroyer.toString());
		
		//For loop based on shipLength
		for (int i = 1; i <= Destroyer.shipLength; i++) {
			//makes the ship placed vertically
			if (orientation == true) {
			if((Destroyer.x >= 0 && Destroyer.x < numRows) && (Destroyer.y >= 0 && Destroyer.y < numCols) && (grid[Destroyer.x][Destroyer.y] == " ")) //makes ship take up space on grid if empty
	           {
				//if there is a valid spot, places an "@" in the point on the grid to show it's occupied
				grid[Destroyer.x][Destroyer.y] =   "@";
	           }
	           else if((Destroyer.x >= 0 && Destroyer.x < numRows) && (Destroyer.y >= 0 && Destroyer.y < numCols) && grid[Destroyer.x][Destroyer.y] == "@")
	               //if there isn't a valid spot because there is already an "@"
	        	   System.out.println("You can't place two or more ships on the same location");
	           else if((Destroyer.x < 0 || Destroyer.x >= numRows) || (Destroyer.y < 0 || Destroyer.y >= numCols))
	        	 //if there isn't a valid spot because it's out of bounds
	        	   System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
			Destroyer.x++;
			}
		//Same as above but for horizontal
		if (orientation == false) {
			if((Destroyer.x >= 0 && Destroyer.x < numRows) && (Destroyer.y >= 0 && Destroyer.y < numCols) && (grid[Destroyer.x][Destroyer.y] == " ")) //makes ship take up space on grid if empty
	           {
	               grid[Destroyer.x][Destroyer.y] =   "@";
	            
	           }
	           else if((Destroyer.x >= 0 && Destroyer.x < numRows) && (Destroyer.y >= 0 && Destroyer.y < numCols) && grid[Destroyer.x][Destroyer.y] == "@")
	               System.out.println("You can't place two or more ships on the same location");
	           else if((Destroyer.x < 0 || Destroyer.x >= numRows) || (Destroyer.y < 0 || Destroyer.y >= numCols))
	               System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
			Destroyer.y++;
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
/*
 * 		// creates Carrier. take input for orientation, starting position, checks if it can fit.
		Ship Carrier = new Ship();
		shipLength = 5;
		canFit = false;
		while(canFit == false) {
		orientation = Carrier.shipOrientation(choice = getInput("What orientation do you want your Destroyer to be placed in? \n[H] Horizontal \n[V] Vertical"));
			if (orientation == false) {
				System.out.println("The ship's orientation is: Horizontal");
				} else {
					System.out.println("The ship's orientation is: Vertical");

				}
		System.out.println("Place down your Carrier at coordinates:");
		System.out.println("Enter a start coordinate");
		Carrier.x = getInput2(number);
		tempX = Carrier.x;
		Carrier.y = getInput2(number);
		tempY = Carrier.y;
		System.out.println("Start position: "+Carrier.toString());
		System.out.println("Fits? "+Carrier.canIFit(shipLength, orientation, tempX, tempY, Grid));
		
		
			Carrier.x = tempX;
			Carrier.y = tempY;
			for(int count = 0; count<shipLength; count++) {
				//updates grid position based on shipLength. TODO: make canFit check for other ships
				if (orientation == false) {
					System.out.println(Carrier.coordinate(Grid));
					Grid[0][Carrier.x-1] = Carrier.x;
					Grid[0][Carrier.x-1] = 0;
					Carrier.x=Carrier.x+1; //increments carrier.x for loop purposes
					if (Carrier.x >= 10 || Carrier.y >= 10 || Grid [0][Carrier.x-1] < 1 || Grid [1][Carrier.y-1] < 1 || Grid [0][Carrier.x-1] >= 10 || Grid [1][Carrier.y-1] >= 10){
						canFit = false;
					} 
					else {
						canFit = true;
						}
					} 
				else {
						System.out.println(Carrier.coordinate(Grid));
						Grid[1][Carrier.y-1] = Carrier.y;
						Carrier.coordinate(Grid);
						Carrier.y=Carrier.y+1;
						}
					}
				
		}
 */
}