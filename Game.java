/*
 * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Ken Zhang
 * ktz85
 * Slip days used: <0>
 * Fall 2021
 */
package assignment2;
import java.util.Scanner;
public class Game extends Driver {
	
	public static String arr[]; // for history
	public static int guess; // subtract off config.guessnumber
	public static char arg[] = {};
	public static int count = 0;
	
	public Game(boolean testing, Scanner keyboard){
		// initializes count to 0 and prints out the welcome message. Nothing interesting here.
		count = 0;
		System.out.println("Welcome to Mastermind.");
		
		
	}

	public boolean runGame(boolean testing, GameConfiguration config, String code, Scanner keyboard) {
		
		if(testing) {
			System.out.println(code);
		}
		
		//initializes variables and sets global variables to their initial state to play multiple games.
		String output = "";int bpeg = 0; int wpeg = 0; count = 0; Correct = false;
		int blackpeg[];
		String array[] = new String[config.guessNumber];
		arr = array;
		guess = config.guessNumber;
		
		
		//converts string array to char array to use charAt logic in Board.java.
		String s = "";
		for(String n: config.colors) {
			s+= n;
		arg = s.toCharArray();
		}
		
		
		blackpeg = Player.setBlack(code);
		
		//main while loop.
		while(guess > 0) {
		
			//this while loop makes sure that the userInput is valid.
			while(!Board.checkOutput(config, keyboard, code)) {
				
			}
			//count used for history
			count += 1;
			output = Board.getString();
			
			bpeg = Pegs.blackPegs(output, code);
			wpeg = Pegs.whitePegs(blackpeg, Player.setWhite(output), bpeg);
			
			arr[config.guessNumber-guess-1] = output+" -> "+bpeg+"b_"+wpeg+"w";
			System.out.println(output+" -> "+bpeg+"b_"+wpeg+"w");
			
			
	    	
	    	if(output.equals(code)) {
	    		System.out.println("You win!");
	    		System.out.println();
	    		Correct = true;
	    		break;
	    	}
	    	//to avoid the extra println
	    	if(guess == 0)
				break;
	    	System.out.println();
		}
		// Correct used because guess can be 0 and still win, causing it to print win and loss
		if(Correct == false) {
			System.out.println("You lose! The pattern was "+code);
			System.out.println();
		}
		
		System.out.println("Do you want to play a new game? (Y/N):");
    	output = keyboard.next();       
        if(output.toLowerCase().equals("y")) {
        	System.out.println();
        	return true;
        }
        else {
        	return false;
        }
    }
}
