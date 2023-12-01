import java.util.ArrayList;

public class Player {
	String[][] ocean = new String[10][10];
	String[][] radar = new String [10][10];
	//ClassName<dType> ourName = new ClassName<dType>();
	ArrayList<Ship> deployedShips = new ArrayList<Ship>();
	ArrayList<Shot> myShots = new ArrayList<Shot>();
	ArrayList<Shot> opShots = new ArrayList<Shot>();
	
	public Player() {
		init();
		Shot s = new Shot(0, 0);
		s.resolve(false);
		//adding to a collection
		myShots.add(s);
		renderRadar();
		displayBoard(radar,false);
		myShots.add(s);
		
		opShots.add(s);
		Ship battle = new Ship(4, "BattleShip", "B");
		battle.placeShips(new Shot s);
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
	private void displayBoard(String[][] board, boolean ocean) {
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