
public class Battleship {
	int deadShipCounterOne = 0;
	int deadShipCounterTwo = 0;
	boolean playerTurn = true;
	public void main(String[] args) {

	
		
	
		if(deadShipCounterOne == 5){ 
			System.out.println("Player 2 has sunk all of Player 1's battleships!\nPlayer 1 wins!" );
		}
	}

	public boolean loseCheck(){
		if (playerTurn == false) {
			if (deadShipCounterOne == 5) {
				return true;
			}else
				return false;
		}else
			if (deadShipCounterTwo == 5) {
				return true;
			}else 
				return false;    
		}
	}
	


