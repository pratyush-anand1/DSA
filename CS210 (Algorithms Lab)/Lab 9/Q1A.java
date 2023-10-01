import java.util.*;

public class Q1A{

    public static void addList(ArrayList<ArrayList<Integer>> adjList,int v,int u){
        adjList.get(v).add(u);
    }

    public static void printGraph(ArrayList<ArrayList<Integer> > adj){
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex "+ i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "+ adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Enter the number of vertices in the graph");
        
        n=sc.nextInt();

        int [][] adjMatrix = new int[n][n];

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("Enter 0 or 1 to indicate absence or presence of egde at [%d][%d]:",i,j);
                adjMatrix[i][j] = sc.nextInt();
            }
        }   

        System.out.println("Given adjacency matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%d\t",adjMatrix[i][j]);
            }
            System.out.printf("\n");
        }   

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
        }

        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adjMatrix[i][j] == 1){
                    addList(adjList, i, j);
                }
            }
        }
        printGraph(adjList);
    }
}