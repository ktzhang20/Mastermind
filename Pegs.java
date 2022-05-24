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

public class Pegs extends Game{

	public Pegs(boolean testing, Scanner keyboard) {
		super(testing, keyboard);
		// TODO Auto-generated constructor stub
	}
	
	public static int whitePegs(int[] wpeg, int[] keypeg, int bpeg ) {
		
		//finds the number of white pegs by counting the total number of pegs (white+black) minus the number of black pegs.
		int w = 0;
		for(int x = 0; x < 27; x++) {
			w += min(keypeg[x], wpeg[x]);
		}
		w -= bpeg;
		return w;
	}
	
	static int blackPegs(String output, String key) {
		// counts the number of black pegs by comparing each character of user input and the answer.
		int bpeg = 0;
		
		for(int x = 0; x < output.length(); x++) {
			if(output.charAt(x) == key.charAt(x))
				bpeg+= 1;
		}
		
		
		return bpeg;
	}
	
	
	private static int min(int i, int j) {
		//gets the minimum value between two integers.
		if(i < j) {
			return i;
		}
		return j;
	}


}
