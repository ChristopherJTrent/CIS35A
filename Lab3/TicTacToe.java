import java.util.Scanner;

public class TicTacToe {
	private char[/*row*/][/*col*/] board = new char[3][3];
	private char[][] defaultBoard = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
	private char currentPlayer = ' ';
	private Scanner input;
	public static final boolean debugMode = false;
	public TicTacToe(char[][] board, char startingPlayer){
		this.board = board;
		this.currentPlayer = startingPlayer;
		this.input = new Scanner(System.in);
	}
	public TicTacToe(char[][] board, char startingPlayer, Scanner s){
		this.board = board;
		if(debugMode) System.out.println(this.board);
		this.currentPlayer = startingPlayer;
		this.input = s;
	}
	public TicTacToe(){
		board = defaultBoard;
		currentPlayer = 'X'; 
		this.input = new Scanner(System.in);
	}
	public void drawBoard(){
		char[][] inputBoard = this.board;
		if (debugMode) System.out.println(inputBoard);
		for(int i = 0; i<3;i++){
			System.out.printf("%c|%c|%c\n", inputBoard[i][0], inputBoard[i][1], inputBoard[i][2]);
			if(i!=2){
				System.out.println("-----");
			}
		}
	}
	public void doMove(String location, Scanner s){
		location = location.toUpperCase();
		if(debugMode) System.out.println(location);
		char row = location.charAt(0);
		char col = location.charAt(1);
		if(row > 'C' || col > '3' || row < 'A'|| col < '1'){
			System.out.println("That is an invalid move, please input a move in format RC (Row, Column).");
		        String next = s.nextLine();
			if(debugMode)System.out.println(next);
			doMove(next, s);
			return;
		} else {
			int x, y;
			x = ((row=='A')?0:(row=='B')?1:2);
			y = ((col=='1')?0:(col=='2')?1:2);
			if(board[x][y]==' '){
				board[x][y] = currentPlayer;
				currentPlayer = (currentPlayer=='X'?'O':'X');
				drawBoard();
			} else {
				System.out.println("That space is already filled. Please choose an empty space.");
				drawBoard();
				doMove(s.nextLine(), s);
				return;
			}
		}
	}
	public void doMove(Scanner in){
		System.out.printf("Player %c, please input your move in format RC (Row, Column)\n",this.currentPlayer);
		doMove(in.nextLine(), in);
	}
	public void doMove(){
		System.out.printf("Player %c, please input your move in format RC (Row, Column)", this.currentPlayer);
		Scanner s = new Scanner(System.in);
		doMove(s.nextLine(), s);
	}
	public boolean isNonSpace(int col, int row){
		return board[row][col]==' '?false:true;
	}
	public boolean hasWinner(){	
		char[][] board = this.board;
		for(int row = 0; row<3;row++){
			if(board[row][0]==board[row][1] && board[row][1]==board[row][2]){
				return isNonSpace(0,row);
			}
		}
		for(int col = 0; col < 3; col++){
			if(board[0][col]==board[1][col]&&board[1][col]==board[2][col]){
				return isNonSpace(col,0);
			}
		}
		if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]){
			return isNonSpace(0,0);
		} else if (board[0][2]==board[1][1]&&board[1][1]==board[2][0]){
			return isNonSpace(2,0);
		} else {
			return false;
		}
	}
	public boolean isGameStalled(){
		boolean found = false;
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				if(this.board[row][column]==' '){
					found = true;
				}
			}
		}
		if(found){
			return false;
		} else {
			return true;
		}
	}
	public void playGame(){
		TicTacToe gameState = this;
		boolean continueGame = true;
		while(continueGame){
			gameState.doMove(gameState.input);
			if(gameState.hasWinner()){
				System.out.printf("We have a winner! They are playing as %c\n",gameState.currentPlayer=='X'?'O':'X');
				continueGame = false;
			}
			else if(gameState.isGameStalled()){
				System.out.println("Game Over, no player can make a legal move.");
				continueGame = false;
			}
		}
	}
	public static void main(String[] args){
		TicTacToe ttc = new TicTacToe();
		ttc.playGame();
	}
}

