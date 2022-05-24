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

public class Driver {
	static boolean Correct = false;
    public static void main(String[] args) {
    	String arg[] = {"R", "O", "Y", "G", "B", "I", "V"};
        GameConfiguration config = new GameConfiguration(5, arg, 5);
        SecretCodeGenerator generator = new SecretCodeGenerator(config);
        start(false, config, generator);
        
    }

    public static void start(Boolean isTesting, GameConfiguration config, SecretCodeGenerator generator)  {
    	// start sets up the scanner, the code, and is mainly used to play the game over and over again.
    	// runGame returns a boolean that is used to play the game, and once runGame returns false, the scanner is closed.
    	Boolean again = false;
    	Scanner keyboard = new Scanner(System.in);
    	String code = generator.getNewSecretCode();
    	Game game = new Game(isTesting, keyboard);
    	
    	
    	System.out.println("Do you want to play a new game? (Y/N):");
        String output = keyboard.next();
        System.out.println();
    	
    	if(output.toLowerCase().equals("y")) {
    		again = game.runGame(isTesting, config, code, keyboard);
    		while(again) {
    			code = generator.getNewSecretCode();
        		again = game.runGame(isTesting, config, code, keyboard);
    		}
    	}
    	keyboard.close();
    	
    
    }
}
