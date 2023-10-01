import java.util.Scanner;

public class Q2 {

    static int totalSol = 0;

    public boolean checkPos(int board[][], int row, int col, int N) {

        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)

            if (board[i][j] == 1)
                return false;

        return true;

    }

    public void NQueen(int board[][], int col, int N) {
        if (col == N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("----------------------------");
            Q2.totalSol++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (checkPos(board, i, col, N)) {
                board[i][col] = 1;
                NQueen(board, col + 1, N);
                board[i][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int N = 4;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        N = sc.nextInt();
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }
        Q2 obj = new Q2();
        obj.NQueen(board, 0, N);

        System.out.println("Total solutions :" + totalSol);
    }
}