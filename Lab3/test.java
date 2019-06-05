import java.util.Scanner;
class Test {
	private static final char x = 'X';
	private static final char o = 'O';
	private static final char s = ' ';
	private static char[][] deadLocked = {{x,o,x},{x,o,x},{o,x,o}};
	private static char[][] hasWinner = {{x,x,x},{o,x,o},{x,o,x}};
	private static char[][] isNotFull = {{s,o,x},{s,s,o},{s,o,o}};
	private static char[][] empty = {{s,s,s},{s,s,s},{s,s,s}};
	private static String xWin = "A1\nB2\nA2\nB1\nA3\n"; //X wins on turn 5
	private static String oWin = "A1\nB1\nC1\nB2\nA2\nB3\nA3\n"; //O wins on turn 6
	private static String illegalMove = "A1\nA1\nB2\nA2\nB1\nA3\n"; //prevents the game from hanging indefinately by supplying a winning series.
	public static char[][] array2dDeepCopy(char[][] input){
		char[][] temp = new char[input.length][1];
		for(int i = 0; i<temp.length; i++){
			temp[i] = input[i].clone();
		}
		return temp;
	}
	private static String stalemate = "B2\nA1\nA2\nA3\nB1\nB3\nC1\nC2\nC3\n"; //Stalemate Game.
	public static void main(String[] args){
		TicTacToe xWinGame = new TicTacToe(array2dDeepCopy(empty), x, new Scanner(xWin));
		TicTacToe oWinGame = new TicTacToe(array2dDeepCopy(empty), x, new Scanner(oWin));
		TicTacToe illegalMoveGame = new TicTacToe(array2dDeepCopy(empty), x, new Scanner(illegalMove));
		TicTacToe stalemateGame = new TicTacToe(array2dDeepCopy(empty), x, new Scanner(stalemate));
		TicTacToe deadlocked = new TicTacToe(deadLocked,x);
		TicTacToe notFull = new TicTacToe(isNotFull,x);
		TicTacToe allEmpty = new TicTacToe(empty,x);
		TicTacToe win = new TicTacToe(hasWinner,x);
		assert (deadlocked.isGameStalled()):"Failed to identify deadlock";
		System.out.println("Deadlocked game correctly identified.");
		deadlocked.drawBoard();
		assert !(notFull.isGameStalled()):"Erroneously identified a deadlock";
		System.out.println("Successfully excluded a non-full board from deadlock check");
		notFull.drawBoard();
		assert (win.hasWinner()):"Failed to correctly identify a winner";
		System.out.println("Successfully identified a board that has a winner.");
		win.drawBoard();
		assert !(allEmpty.isGameStalled()):"Failed to exclude empty board from deadlock";
		System.out.println("Successfully excluded an empty board from deadlock");
		allEmpty.drawBoard();
		assert !(allEmpty.hasWinner()):"Failed to exclude empty board from winner check";
		System.out.println("Successfully excluded empty board from having a winner.");
		allEmpty.drawBoard();
		xWinGame.playGame();
		xWinGame.drawBoard();
		System.out.println("Completed xWinGame");
		if(TicTacToe.debugMode) System.out.println("[DEBUG] Printing the upcoming game board");
		if(TicTacToe.debugMode) oWinGame.drawBoard();
		oWinGame.playGame();
		oWinGame.drawBoard();
		System.out.println("Completed oWinGame");
		illegalMoveGame.playGame();
		illegalMoveGame.drawBoard();
		System.out.println("Completed illegalMoveGame");
		stalemateGame.playGame();
		stalemateGame.drawBoard();
		System.out.println("Completed stalemateGame");

		
	}
	

}	
