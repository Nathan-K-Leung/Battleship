import java.util.Scanner;

public class Battleship {

	public static void main(String[] args) {
		//make ship placement for battleship
		// grid is 10x10 (A-J and 1-10)
		String choice = "";
		int number = 0;
		boolean isAnInteger = true;
		Ship Destroyer = new Ship();
		
			System.out.println("Place down your Destoryer at coordinates:");
			System.out.println("Enter a start coordinate");
			Destroyer.x = getInput2(number);
			int tempX = Destroyer.x;
			Destroyer.y = getInput2(number);
			int tempY = Destroyer.y;
			System.out.println(Destroyer.toString());
			
			System.out.println("Enter an end coordinate");
			Destroyer.x = getInput2(number);
			Destroyer.y = getInput2(number);
			System.out.println(Destroyer.toString());
			System.out.println(Destroyer.canIFit(Destroyer, tempX, tempY));
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
}