package Game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Board b = new Board();
		b.initBoard();
		b.displayBoard();
		
		Thread.sleep(2000);
		b.clearBoard();
		b.displayFaceDown();
		
		String prev="";
		String curr="";
		int prev_r = -1 ,prev_c = -1;
		while(!b.isComplete()) {
			System.out.println("--- Which card do you wish to flip? ---");
			System.out.println("--- Enter row col (i.g 2 3) ---");
			
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			curr = b.getCard(row, col);
			if(prev.equals("") && prev_r==-1 && prev_c==-1) {
				if(b.getFromFaceDown(row, col).equals("❇️")) {
					b.updateFaceDown(row, col, curr);
					b.clearBoard();
					b.displayFaceDown();
				}
				prev = curr;
				prev_r = row;
				prev_c = col;
			}
			else {
				if(curr.equals(prev)) {
					if(b.getFromFaceDown(row, col).equals("❇️")) {
						b.updateFaceDown(row, col, curr);
						b.clearBoard();
						b.displayFaceDown();
					}
					prev = "";
					prev_r=prev_c=-1;
				}
				else {
					b.updateFaceDown(prev_r, prev_c, "❇️");
					b.clearBoard();
					b.displayFaceDown();
				}
				
			}
			
			
		}
	}

}
