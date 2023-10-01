//Prims without using heap data structure

import java.util.*;

public class Q1 {

	
	static int vertices;

	int minKey(int key[], Boolean mstMatrix[])
	{
		
		int min = 1000000000, minIdx = -1;

		for (int j = 0; j < vertices; j++)
			if (mstMatrix[j] == false && key[j] < min) {
				min = key[j];
				minIdx = j;
			}

		return minIdx;
	}
	void printMST(int prev[], int matrix[][])
	{
		System.out.println("MINIMUM SPANNING TREE:");
		for (int i = 1; i < vertices; i++)
		System.out.println("Edge from " + i + " to " + prev[i] + " with weight " + matrix[i][prev[i]]);
	}


	void primMST(int matrix[][])
	{
		int prev[] = new int[vertices];

		int key[] = new int[vertices];

		Boolean mstMatrix[] = new Boolean[vertices];

		for (int i = 0; i < vertices; i++) {
			key[i] = 100000000;
			mstMatrix[i] = false;
		}

		key[0] = 0; 
		prev[0] = -1; 
		for (int i = 0; i < vertices - 1; i++) {

			int u = minKey(key, mstMatrix);
			mstMatrix[u] = true;
			for (int j = 0; j < vertices; j++)
				
				if (matrix[u][j] != 0 && mstMatrix[j] == false && matrix[u][j] < key[j]) {
					prev[j] = u;
					key[j] = matrix[u][j];
				}
		}
		printMST(prev, matrix);
	}

	public static void main(String[] args)
	{

        Scanner sc = new Scanner(System.in);
		Q1 t = new Q1();

        System.out.println("Enter the number of vertices:");
        vertices = sc.nextInt();
		
        int[][] matrix = new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.printf("Enter [%d][%d] matrix entry(to denote weight of edge):",i,j);
                matrix[i][j] = sc.nextInt();
            }
        }
		t.primMST(matrix);
	}
}