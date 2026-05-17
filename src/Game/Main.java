package Game;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Board b = new Board();
		b.initBoard();
		b.displayBoard();
		
		Thread.sleep(2000);
		b.clearBoard();
		b.displayFaceDown();
	}

}
