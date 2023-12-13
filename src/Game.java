import java.util.Random;
import java.util.Scanner;
public class Game {
	public void run() {
		//Player array
		Player[] players = new Player [2];
		System.out.println("Player 1 deploy your ship");
		players[0] = new Player();
		waitHere();
		clearScreen();
		System.out.println("Player 2 deploy your ship");
		players[1] = new Player();
		players[0].setOpfor(players[1]);
		players[1].setOpfor(players[0]);

		int turn;
		Random start = new Random();
		//TODO place ship code here
		turn = start.nextInt(16);
		
		
		
		while(players[0].stillAlive()&&players[1].stillAlive()) 
		{
			//game loop here
			clearScreen();
			System.out.println("Player : " + (turn % 2 + 1) + " 's turn");
			waitHere();
			players[turn%2].playTurn();
			waitHere();
			turn++;
		}
		if (players[0].stillAlive())
		{
			System.out.println("Player 2 wins!");
		}
		if (players[1].stillAlive())
		{
			System.out.println("Player 1 wins!");
		}
	}
	
	private void clearScreen() {
		for(int c = 0; c<300; c++)
		{
			System.out.println("");
			System.out.println("");
		}
		System.out.flush();
	}
	
	private void waitHere() {
		Scanner wait = new Scanner(System.in);
		System.out.println("Press Enter when ready");
		try 
		{
			wait.nextLine();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}