import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConnectFour {

    char[][] board;
    int boardColumns;
    int boardRows;
    int movesCounter;
    int lastMoveX;
    int lastMoveY;

    ConnectFour(int boardColumns, int boardRows){
        board=new char[boardRows][boardColumns];
        this.boardColumns = boardColumns;
        this.boardRows = boardRows;
    }

    ConnectFour(){
        this(7,6);
    }

    public static void main(String args[]) throws IOException {
        System.out.println("Connect 4 to win a game.");
        ConnectFour connectFour = new ConnectFour();
        connectFour.printBoard();
        somebodyWon:
        while(true) {
            int column;
            while (true) {
                System.out.println("\nX player turn:");
                column = columnInput();
                if (connectFour.emptySpace(column)) {
                    if (connectFour.move(column, (char) 88)) {
                        connectFour.printBoard();
                        System.out.println("\nPlayer X won!");
                        break somebodyWon;
                    }
                    break;
                } else
                    System.out.println("Column number:" + column + " is full.");
            }
            connectFour.printBoard();
            while (true) {
                System.out.println("\nO player turn:");
                column = columnInput();
                if (connectFour.emptySpace(column)) {
                    if (connectFour.move(column, (char) 79)) {
                        connectFour.printBoard();
                        System.out.println("\nPlayer O won!");
                        break somebodyWon;
                    }
                    break;
                } else
                    System.out.println("Column number:" + column + " is full.");
            }
            connectFour.printBoard();
            connectFour.isTie();
        }
    }

    public static int columnInput() throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }


    public boolean emptySpace(int column){
        return board[0][column] == 0;
    }


    public void printBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 0)
                    System.out.print("|_");
                else
                    System.out.print("|" +board[i][j]);
            }
            System.out.print("\n");
        }

        for(int i=0;i<boardColumns;i++)
            System.out.print("|=");
        System.out.print("\n");

        for(int i=0;i<boardColumns;i++)
            System.out.print("|"+i);
        System.out.print("\n");
    }

    public boolean move(int column, char sign) throws IOException {
        int i=0;
        for(i=0;i<boardRows;i++){
            if(board[i][column] == 88 || board[i][column] == 79){
                board[i-1][column]=sign;
                lastMoveX = i-1;
                lastMoveY = column;
                break;
            }
        }
        if(i == boardRows) {
            board[i - 1][column] = sign;
            lastMoveX = i-1;
            lastMoveY = column;
        }

        movesCounter++;
        if(isWon(i-1,column))
            return true;
        else {
            printBoard();
            reverse();
            return false;
        }
    }

    public boolean isWon(int x,int y) {
        char sign = board[x][y];
        return (horizontal(x,y,sign) || vertical(x,y,sign)|| firstDiagonal(x,y,sign) || secondDiagonal(x,y,sign));
    }

    public boolean horizontal(int x, int y, char sign){
        int connected = 0;
        int i = y;
        while (i < boardColumns && board[x][i] == sign) {
            connected++;
            i++;
        }
        i = y - 1;
        while (i >= 0 && board[x][i] == sign) {
            connected++;
            i--;
        }
        return connected == 4;
    }

    public boolean vertical(int x, int y, char sign){
        int connected = 0;
        int j = x;
        while (j < boardRows && board[j][y] == sign) {
            connected++;
            j++;
        }
        return connected == 4;
    }

    public boolean firstDiagonal(int x, int y, char sign){
        int connected = 0;
        int i = x;
        int j = y;
        while (i < boardRows && j >= 0 && board[i][j] == sign) {
            connected++;
            i++;
            j--;
        }
        i = x - 1;
        j = y + 1;
        while (i >= 0 && j < boardColumns && board[i][j] == sign) {
            connected++;
            i--;
            j++;
        }
        return connected == 4;
    }

    public boolean secondDiagonal(int x, int y, char sign){
        int connected = 0;
        int i = x;
        int j = y;
        while (i < boardRows && j < boardColumns && board[i][j] == sign) {
            connected++;
            i++;
            j++;
        }
        i = x - 1;
        j = y - 1;
        while (i >= 0 && j >= 0 && board[i][j] == sign) {
            connected++;
            i--;
            j--;
        }
        return connected == 4;
    }

    public void isTie(){
        if(movesCounter == (boardColumns*boardRows)){
            System.out.println("tie");
        }
    }

    public void reverse() throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any Integer if u want to reverse your move. Press enter to continue.");
        if (isInteger(reader.readLine())) {
            board[lastMoveX][lastMoveY] = 0;
            System.out.println("You reversed. Turn lost.");
        }
    }
    public boolean isInteger(String string) {
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}