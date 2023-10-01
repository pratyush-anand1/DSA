import java.util.*;

public class Q1 {

    boolean checkPos(int board[][], int row, int col,int n)
    {
        int i, j;
  
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
  
        for (i = row, j = col; j >= 0 && i < n; i++, j--)
            if (board[i][j] == 1)
                return false;
  
        return true;
    }

    boolean solveNQ(int[][] soln, int col,int n) {
        if (col >= n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (checkPos(soln, i, col,n)) {
                soln[i][col] = 1;

                if (solveNQ(soln, col + 1,n) == true) {
                    return true;
                }
                soln[i][col] = 0;
            }
        }
        return false;
    }

    boolean solveNQueens(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimensions of board");
        int n = sc.nextInt();
        int[][] soln = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                soln[i][j] = 0;
            }
        }

        if (solveNQ(soln, 0,n) == false) {
            System.out.println("No solution exists!");
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d\t", soln[i][j]);
            }
            System.out.printf("\n");
        }
        return true;
    }

    public static void main(String[] args) {
        Q1 nqueen = new Q1();
        nqueen.solveNQueens();
    }
}