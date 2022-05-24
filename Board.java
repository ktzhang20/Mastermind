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

public class Board extends Game{
	private static String output = "";

	
	public Board(boolean testing, Scanner keyboard) {
		super(testing, keyboard);
		// TODO Auto-generated constructor stub
	}

	
	static boolean checkOutput(GameConfiguration config, Scanner keyboard, String code) {
		//code to make sure that userInput is valid.
		System.out.println("You have "+guess+" guess(es) left.");
		System.out.println("Enter guess: ");
		String output = keyboard.next();
		
		if(output.toLowerCase().equals("history")) {
    		//arr stores each valid userInput and it's corresponding black/white pegs, to be printed.
    		for(int x = 0; x < count; x++) {
    			System.out.println(""+arr[x]);
    		}
    		System.out.println();
    		return false;
    		
    	}
    	
    	//if length mismatch
    	if(output.length() != code.length()) {
    		
    		System.out.println("INVALID_GUESS");
    		System.out.println();
    		return false;
    		
    	}
    	
    	
    	for(int x = 0; x < code.length(); x++) {
    		
    		//if answer contains a character not included in config.colors
    		if(new String(arg).indexOf( output.charAt(x)) == -1) {
    			
    			System.out.println("INVALID_GUESS");
    			System.out.println();
    			return false;
    			
    		}
    		
    		//if character is lowercase
    		if(code.toLowerCase().charAt(x) == output.toLowerCase().charAt(x) && code.charAt(x) != output.charAt(x)) {
    			
    			System.out.println("INVALID_GUESS");
    			System.out.println();
    			return false;
    			
    		}
    		

    	}
    	setString(output);
    	guess -= 1;
    	return true;
		
		
		
		
		
	}
	//sets global string output to string to be used in Game
	public static void setString(String string) {
		output = string;
	}
	//for Game to get the string value out of Board to circumvent the need to return 2 values from one method.
	public static String getString() {
		return output;
	}
	
	

}
