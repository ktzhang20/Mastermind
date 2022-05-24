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

public class Player extends Game{

	public Player(boolean testing, Scanner keyboard) {
		super(testing, keyboard);
		// TODO Auto-generated constructor stub
	}
	
	static int[] setBlack(String key) {
		//creates an int array of length 27, that converts each character in the secret code to uppercase, and then
		// subtracts by 'A' to go from 0 to 25. The Array increments the value at that location, representing how
		// many of that character are in the secret code.
		// this is called once per game, at the beginning of runGame.
		int[] blackpeg = new int[27];
		for(int x = 0; x < key.length(); x++) {
			blackpeg[Character.toUpperCase(key.charAt(x))-'A'] += 1;
		}
		return blackpeg;
	}
	
	static int[] setWhite(String output) {
		////creates an int array of length 27, that converts each character in the userinput to uppercase, and then
		// subtracts by 'A' to go from 0 to 25. The Array increments the value at that location, representing how
		// many of that character are in the userinput.
		// this is called each time a userInput is deemed valid.
		int[] whitepeg = new int[27];
		for(int x = 0; x < output.length(); x++) {
			whitepeg[Character.toUpperCase(output.charAt(x))-'A'] += 1;
		}
		return whitepeg;
	}

}
