
import java.util.*;

public class Q3 {

    static int totalSol;
    public static boolean checkPos(int[][] board, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 1) {
                return false;
            }
        }
        return true;
    }

    static void printSolution(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.printf("%d\t",board[i][j]);
            }
            System.out.println("\n");
        }
        totalSol ++;
        System.out.println("-------------------------------");
    }
    
    static void nQueens(int[][] board, int r) {
        if (r == board.length) {
            printSolution(board);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            
            if (checkPos(board, r, i)) {
               
                board[r][i] = 1;

               
                nQueens(board, r + 1);

    
                board[r][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dimensions;
        System.out.println("Enter dimensions of the board:");
        dimensions = sc.nextInt();

        int[][] board = new int[dimensions][dimensions];

        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                board[i][j] = 0;
            }
        }

        nQueens(board, 0);

        System.out.println("Total solutions:" + totalSol);
    }
}
