
class Test {
	private static final char x = 'X';
	private static final char o = 'O';
	private static final char s = ' ';
	private static char[][] deadLocked = {{x,o,x},{x,o,x},{o,x,o}};
	private static char[][] hasWinner = {{x,x,x},{o,x,o},{x,o,x}};
	private static char[][] isNotFull = {{s,o,x},{s,s,o},{s,o,o}};
	private static char[][] empty = {{s,s,s},{s,s,s},{s,s,s}};
	public static void main(String[] args){
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
	}
	

}	
