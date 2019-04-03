import java.io.BufferedReader;


public class ConnectFour {

    char[][] board;
    int boardColumns =7;
    int boardRows = 6;

    ConnectFour(){
        board=new char[boardRows][boardColumns];
    }

    public static void main(String args[]){
        System.out.println("Connect 4 to win a game.");
        ConnectFour connectFour = new ConnectFour();
        connectFour.board[5][0] = 88;
        connectFour.board[5][1] = 79;
        connectFour.board[5][2] = 88;
        connectFour.printBoard();
    }

    public void printBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 0)
                    System.out.print("|_");
                else
                    System.out.print("|" +board[i][j]);
            }
            System.out.println();
        }

        for(int i=0;i<boardColumns;i++)
            System.out.print("|=");
        System.out.println();

        for(int i=0;i<boardColumns;i++)
            System.out.print("|"+i);
        System.out.println();
    }

}