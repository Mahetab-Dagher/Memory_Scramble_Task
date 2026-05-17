package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Board {
	int row, col;
	ArrayList<String> board = new ArrayList<>();
	String symbols[] = {"📻", "🎃", "🎄", "⌚", "💡", "👑", "👾", "🎻", "💎", "🧴️", "🧁", "🍰", "🚗", "🚀"};
	String blank = "❇️";
	private Random rand = new Random();
   
    public String getRandSymbol(int len){
        return symbols[rand.nextInt(len)];
    }
    
    public void clearBoard() {
    	for (int i = 0; i < 50; i++) {
    	    System.out.println();
    	}
//    	System.out.print("\033[H\033[2J");
//    	System.out.flush();
    }
	public void initBoard() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---- Enter Board Dimentions----");
		row = sc.nextInt();
		col = sc.nextInt();
		
		int numOfSymbols = (row*col)/2;
		Map<String, Integer> taken = new HashMap<>();
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				String symbol = getRandSymbol(numOfSymbols);
				while(true) {
					if(!taken.containsKey(symbol)) {
						taken.put(symbol, 1);
						board.add(symbol);
						break;
					}
					else if(taken.get(symbol) < 2) {
						taken.replace(symbol, taken.get(symbol)+1);
						board.add(symbol);
						break;
					}
					else
						symbol =getRandSymbol(numOfSymbols);
				}
				
			}
		}
	}
	
	void displayBoard() {
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(board.get(i*col + j));
			}
			System.out.println();
		}
	}
	
	void displayFaceDown() {
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(blank);
			}
			System.out.println();
		}
	}

}
