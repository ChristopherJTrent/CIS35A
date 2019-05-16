import java.util.Scanner;

public class TicTacToe {
	private char[][] board = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
	private char currentPlayer = 'X';
	public void drawBoard(){
		char[][] inputBoard = this.board;
		for(int i = 0; i<3;i++){
			System.out.printf("%c|%c|%c\n"+ (i==2?"":"______\n"), inputBoard[0][0], inputBoard[0][1], inputBoard[0][2]);
		}
	}
	public void doMove(String location){
		Scanner S = new Scanner(System.in);
		location = location.toUpperCase();
		char row = location.charAt(0);
		char col = location.charAt(1);
		if(row > 'C' || col > '3' || row < 'A'|| col < '1'){
			System.out.println("That is an invalid move, please input a move in format RC (Row, Column).");
		        doMove(S.nextLine());
			s.close();
			return;
		} else {
			int x, y;
			x = row-'A';
			y = ((col=='1')?1:(col==2)?2:3);
			if(board[x][y]==' '){
				board[x][y] = currentPlayer;
				currentPlayer = (currentPlayer=='X'?'O':'X');
				drawBoard();
			} else {
				System.out.println("That space is already filled. Please choose an empty space.");
				drawBoard();

				doMove(s.nextLine());
				s.close();
				return;
			}
		}

	}
	public static void main(String[] args){
		TicTacToe ttc = new TicTacToe();
		ttc.drawBoard();
	}

}
