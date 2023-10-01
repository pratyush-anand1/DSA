import java.util.Scanner;

public class Q1C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalMatrices;
        System.out.print("Enter total matrices:");
        totalMatrices = sc.nextInt();
        int[] p = new int[totalMatrices + 1];
        System.out.println("Enter size of matrix 1:");
        p[0] = sc.nextInt();
        p[1] = sc.nextInt();
        for (int i = 2; i <= totalMatrices; i++) {
            System.out.println("Enter size of matrix " + i + ":");
            System.out.print(p[i - 1] + "X");
            p[i] = sc.nextInt();
        }

        sc.close();
        int mul = MCMiterative(p, 1, totalMatrices, totalMatrices);
        System.out.println("Minimum number of multiplications: " + mul);
    }

    public static int MCMiterative(int[] p, int i, int j, int totalMatrices) {
        int[][] table = new int[totalMatrices + 1][totalMatrices + 1];
        for(int c=0;c<=totalMatrices;c++){
            table[c][c]=0;
        }
        for (int len = 1; len <= totalMatrices - 1; len++) {
            for (int x = 1; x <= totalMatrices - 1; x++) {
                int y = x + len;
                if (y <= totalMatrices) {
                    table[x][y] = 1000000;
                    for (int k = x; k < y; k++) {
                        int q = table[x][k] + table[k + 1][y] + (p[x - 1] * p[k] * p[y]);
                        if (q < table[x][y]) {
                            table[x][y] = q;
                        }
                    }
                }
            }
        }
        for (int d = 1; d <= totalMatrices; d++) {
            for (int m = 1; m <= totalMatrices; m++) {
                System.out.printf("m[%d][%d]:%d\n", d, m, table[d][m]); // +1 beacuse of its own computation for first time

            }
        }
        return table[1][totalMatrices];
    }
}