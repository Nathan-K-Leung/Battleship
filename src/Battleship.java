
//public class Battleship {
//	public static boolean playerTurn = true;
//	static int deadShipCounterOne = 1;
//	static int deadShipCounterTwo = 5;
//	public static void main(String[] args) {
	
		//Clear screen, player 1/2 ready? 
		
		
		
		
		

public class Battleship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.run();
		
		}
}
	
	




		
		
		
		
		
		/*Turn Order:
		 * 1. Check if someone lost.
		 * 2. Current player (from playerTurn boolean) inputs an x and y to hit a ship.
		 * 	2.1 If out of bounds, let them shoot again.
		 *  2.2 If hit a spot they already fired at, let them shoot again. Use ShotRecord. 
		 * 3. Ask ships if x y hit. Use orientation boolean to determine loop through ship length.
		 * 	   Repeat for all ships. If hit any, print, "'You hit the '+ship name+!" 
		 * 	   Add to ShotRecord. 
		 * 4. If miss, add to ShotRecord.
		 * 5. Check ShotRecord to ships 
		 * 
		 */

		
	
	 // 	if (loseCheck()==true) {
	 
	//		if (deadShipCounterOne == 5) {
	//			System.out.println("Player 2 hit all ships! Player 2 wins!");
	//		}else 
	//			System.out.println("Player 1 hit all ships! Player 1 wins!");
	//		}
	//	}

	
	//public static boolean loseCheck(){
		//	if (deadShipCounterOne == 5 || deadShipCounterTwo == 5) {
		//		return true;
		//	}else
		//		return false; 
	//	}
	//}

	


