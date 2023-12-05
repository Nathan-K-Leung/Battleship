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
		Shot s = new Shot(3,0);
		s.resolve(false);
		//adding to a collection
		myShots.add(s);
		
		opShots.add(s);
		Ship battle = new Ship(4,"BattleShip","B");
		battle.placeShip(new Shot(4,3), false);
		deployedShips.add(battle);
		renderOcean();
		displayBoard(ocean);
	}	
	
	private Shot getLocation(String text) {
		String choice = null;
		Scanner input = new Scanner(System.in);
		System.out.println(text);
		try
		{
			choice = input.nextLine();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//cuts off the first char of input, converts using ASCII
		char letter = choice.charAt(0);
		int row = (int)(letter - 'A');
		int col = -1;
		// parses the int part of the input
		try
		{
			col = Integer.parseInt(choice.substring(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//String.charAt(#);
		//String.subString(#);
		Shot loc = new Shot (col, row);
		return loc;
	}
	
	private boolean checkGuess(Shot opfor) {
		for(Ship s : deployedShips) 
		{
			if (s.checkHit(opfor))
			{
				opfor.resolve(true);
				opShots.add(opfor);
				if(s.isAlive()) 
				{
				System.out.println(s.name+" is sunk");
				} 
				else
				{
				System.out.println(s.name+" is hit");
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
	
	public void setOpforPlayer() {
		
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
				System.out.print(board[y][x] + " ");
			}
			System.out.print("\n");
		}
	}
}