import java.io.BufferedReader;


public class ConnectFour {

    private int[][] board;
    private int boardColumns =7;
    private int boardRows = 6;

    public ConnectFour(){
        board=new int[boardRows][boardColumns];
    }

    public static void main(String args[]){
        System.out.println("Connect 4 to win a game.");
    }

}