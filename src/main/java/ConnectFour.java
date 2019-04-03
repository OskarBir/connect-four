import java.io.BufferedReader;


public class ConnectFour {

    int[][] board;
    int boardColumns =7;
    int boardRows = 6;

    ConnectFour(){
        board=new int[boardRows][boardColumns];
    }

    public static void main(String args[]){
        System.out.println("Connect 4 to win a game.");
    }

}