import java.util.ArrayList;
import java.util.Scanner;


public class Player {
	String[][] ocean = new String[10][10];
	String[][] radar = new String [10][10];
	//ClassName<dType> ourName = new ClassName<dType>();
	ArrayList<Ship> deployedShips = new ArrayList<Ship>();
	ArrayList<Shot> myShots = new ArrayList<Shot>();
	ArrayList<Shot> opShots = new ArrayList<Shot>();
	Player opponent;
	
	public Player() {
		init();
		//debug code here
		// Ship [name] = new Ship(length, [name], letter);
		/*
		 * 	Ship ac = new Ship(5,"Aircraft Carrier","A");
		//shipName.placeShip(new Shot(row(A-J), col(1-10), orientation);
		ac.placeShip(new Shot(0,0), false);
		deployedShips.add(ac);
		
		Ship battle = new Ship(4,"BattleShip","B");
		battle.placeShip(new Shot(1,0), false);
		deployedShips.add(battle);
		
		Ship cruiser = new Ship(3,"Cruiser","C");
		cruiser.placeShip(new Shot(2,1), true);
		deployedShips.add(cruiser);
		
		Ship sub = new Ship(3,"Submarine","S");
		sub.placeShip(new Shot(6,1), false);
		deployedShips.add(sub);
		
		Ship destroyer = new Ship(2,"Destroyer","D");
		destroyer.placeShip(new Shot(6,6), false);
		deployedShips.add(destroyer);
		 */
	

		}	
	
	private void deployShips() {
		ArrayList<Ship> dryDock = new ArrayList<Ship>();
		Ship ac = new Ship(5,"Aircraft Carrier","A");
		Ship battle = new Ship(4,"BattleShip","B");
		Ship cruiser = new Ship(3,"Cruiser","C");
		Ship sub = new Ship(3,"Submarine","S");
		Ship destroyer = new Ship(2,"Destroyer","D");
		dryDock.add(ac);
		dryDock.add(battle);
		dryDock.add(cruiser);
		dryDock.add(sub);
		dryDock.add(destroyer);
		//loop through dryDock and place each ship
		for (Ship s : dryDock)
		{
			renderOcean();
			boolean validate = true;
			while(validate)
			{
				//Get location
				Shot loc = getLocation("Enter the placement for " + s.name);
				//Get orientation
				boolean orientation = getOrientation();
				//check for ship in bounds
				validate = checkMapBounds(s, orientation, loc);
				//check for collisions
				if(validate) 
				{
					validate = checkCollisions(s, orientation, loc);
					if (validate) 
					{
						System.out.println(s.name + " has been placed.");
						s.placeShip(loc, orientation);
						deployedShips.add(s);
						validate = false;
					} else 
					{
						System.out.println("This ship will collide with another ship, try again.");
						validate = true;
					}
				} else
				{
					System.out.println("The ship will not fit in this location, try again.");
					validate = true;
				}
			}
		}
		//we are done with setup. Change state to play
		for(Ship s : deployedShips)
		{
			s.setup=false;
		}
	}
	
	

	private boolean getOrientation() {
		Scanner scan = new Scanner(System.in);
		System.out.println("[0] Vertical \n[1] Horizontal");
		int response = scan.nextInt();
		return response % 2 == 0;
	}

	private boolean checkMapBounds(Ship s, boolean orientation, Shot loc) {
		if(orientation) 
		{
			//vertical
			int endPoint = loc.getY()+s.size - 1;
			return endPoint<10;
		}
		else 
		{
			//horizontal
			int endPoint = loc.getX()+s.size - 1;
			return endPoint<10;
		}
	}
	
	private boolean checkCollisions(Ship s, boolean orientation, Shot loc) {
		//if deployed ships is empty return true
		if(deployedShips.isEmpty())
		{
			return true;
		} else 	//If we have ships deployed, then loop through the possible locations 
				//to see if we hit
		{
			for(Ship a : deployedShips)
			{
				if(orientation) // is vertical
				{
					for(int b = loc.getY(); b < loc.getY() + s.size; b++) 
					{
						if(s.checkHit(new Shot(loc.getX(), b)))
						{
							return false;
						}
					}
				} else //if horizontal
				{
					for(int b = loc.getX(); b < loc.getX() + s.size; b++) 
					{
						if(s.checkHit(new Shot(b, loc.getY())))
						{
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}

	private Shot getLocation(String text) {
		String choice = null;
		Scanner input = new Scanner(System.in);
		System.out.println(text);
		try 
		{
			choice = input.nextLine();
			choice = choice.toUpperCase();
		}catch(Exception e) {
			e.printStackTrace();
		}
		char letter = choice.charAt(0);
		int row = (int)(letter - 'A');
		int col=-1;
		try 
		{
			col = Integer.parseInt(choice.substring(1))-1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		Shot loc = new Shot(col,row);
		return loc;
	}
	
	private boolean checkGuess(Shot opfor) {
		for(Ship s : deployedShips) 
		{
			if(s.checkHit(opfor)) 
			{
				opfor.resolve(true);
				opShots.add(opfor);
				if(!s.isAlive()) 
				{
					System.out.println(s.name+" is sunk!");
				}else 
				{
					System.out.println(s.name+" is hit!");
				}
				return true;
			}
		}
		System.out.println("Shot missed");
		opfor.resolve(false);
		opShots.add(opfor);
		return false;
	}
	
	public void playTurn() {
	//Display UI
	renderRadar();
	renderOcean();
	System.out.println(" Radar:");
	displayBoard(radar);
	System.out.println(" Ocean:");
	displayBoard(ocean);
	//Ask for Shot
	Shot s = getLocation("Enter your guess: ");
	//Check the Shot
	s.resolve(opponent.checkGuess(s));
	myShots.add(s);
	//Display results
	renderRadar();
	renderOcean();
	System.out.println(" Radar:");
	displayBoard(radar);
	System.out.println(" Ocean:");
	displayBoard(ocean);
	}
	
	public boolean stillAlive() {
		for(Ship s : deployedShips)
		{
			if(s.isAlive()) 
			{
				return true;
			}
		}
		return false;
	}
	
	public void setOpfor(Player p) {
		opponent = p;

	}
	
	private void init() {
		initBoard(radar);
		initBoard(ocean);
	}
	private void initBoard(String[][] board) {
		for(int y = 0; y < 10; y++) {
			for(int x = 0; x < 10; x++) {
				board[y][x] = " ";
			}
		}
		
	}
	private void renderRadar() {
		//for each loop
		//collection: something like an ArrayList, an item in a collection, a definition in a dictionary.
		//for(dType yourName : collectionName){}
		for(Shot s : myShots)
		{
			s.display(radar);
		}
	}
	private void renderOcean() {
		for(Ship s : deployedShips) {
			s.renderShip(ocean);
		}
		for(Shot s : opShots) {
			s.display(ocean);
		}
	}
	private void displayBoard(String[][] board) {
		// display this board
		char letter = 'A';
		System.out.println("  1 2 3 4 5 6 7 8 9 10");	
		for(int y = 0; y < 10; y++) {
			System.out.print((char)((short)letter+y));
			
			for(int x = 0; x < 10; x++) {
				System.out.print(board[y][x]);
			}
			System.out.print("\n");
		}
	}
}