import java.util.Scanner;

public class TicTacToe {
	private char[/*row*/][/*col*/] board = new char[3][3];
	private char[][] defaultBoard = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
	private char currentPlayer = ' ';
	public TicTacToe(char[][] board, char startingPlayer){
		this.board = board;
		this.currentPlayer = startingPlayer;
	}
	public TicTacToe(){
		board = defaultBoard;
		currentPlayer = 'X'; 
	}
	public void drawBoard(){
		char[][] inputBoard = this.board;
		for(int i = 0; i<3;i++){
			System.out.printf("%c|%c|%c\n"+ (i<=2?"":"______\n"), inputBoard[i][0], inputBoard[i][1], inputBoard[i][2]);
		}
	}
	public void doMove(String location, Scanner s){
		location = location.toUpperCase();
		char row = location.charAt(0);
		char col = location.charAt(1);
		if(row > 'C' || col > '3' || row < 'A'|| col < '1'){
			System.out.println("That is an invalid move, please input a move in format RC (Row, Column).");
		        doMove(s.nextLine(), s);
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
			//System.out.print(row);
			for(int column = 0; column < 3; column++){
				//System.out.print(column);
				if(this.board[row][column]==' '){
					found = true;
				}
			}
			//System.out.print("\n");
		}
		if(found){
			return false;
		} else {
			return true;
		}
	}
	public static void main(String[] args){
		TicTacToe ttc = new TicTacToe();
		while(true){
			ttc.doMove();
			if(ttc.hasWinner()){
				System.out.printf("We have a winner! they are playing as %c",ttc.currentPlayer=='X'?'O':'X');
				break;
			}
			if(ttc.isGameStalled()){
				System.out.println("Game Over, no player can make any more moves.");
				break;
			}

		}
	}

}

