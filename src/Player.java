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
		//debug coe here
		// Ship [name] = new Ship(length, [name], letter);
		Ship ac = new Ship(5,"Aircraft Carrier","A");
		//shipName.placeShip(new Shot(row, col), orientation);
		ac.placeShip(new Shot(1,1), false);
		deployedShips.add(ac);
		
		Ship battle = new Ship(4,"BattleShip","B");
		battle.placeShip(new Shot(4,3), false);
		deployedShips.add(battle);
		
		Ship cruiser = new Ship(3,"Cruiser","C");
		cruiser.placeShip(new Shot(6,3), true);
		deployedShips.add(cruiser);
		
		Ship sub = new Ship(3,"Submarine","S");
		sub.placeShip(new Shot(5,5), false);
		deployedShips.add(sub);
		
		Ship destroyer = new Ship(2,"Destroyer","D");
		destroyer.placeShip(new Shot(6,6), false);
		deployedShips.add(destroyer);

		}	
	
	private Shot getLocation(String text) {
		String choice = null;
		Scanner input = new Scanner(System.in);
		System.out.println(text);
		try 
		{
			choice = input.nextLine();
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
	displayBoard(radar);
	displayBoard(ocean);
	//Ask for Shot
	Shot s = getLocation("Enter your guess: ");
	//Check the Shot
	s.resolve(opponent.checkGuess(s));
	myShots.add(s);
	//Display results
	renderRadar();
	renderOcean();
	displayBoard(radar);
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