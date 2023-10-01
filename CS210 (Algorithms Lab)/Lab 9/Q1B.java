import java.util.*;

public class Q1B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        int vertices;
        System.out.println("Enter the number of vertices:");
        vertices = sc.nextInt();
        for(int i=0;i<vertices;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<vertices;i++){
            System.out.println("Enter number edges connected with vertex " +i);
            int edges = sc.nextInt();
            int j=0;
            do{
                while(true){
                    System.out.println("Enter vertex connected to vertex "+ i);
                    int v = sc.nextInt();
                    if( v > vertices){
                        System.out.println("Invalid vertex!");
                        continue;
                    }
                    adjList.get(i).add(v);
                    break;
                }
                j++;
            } while(j < edges);
        }
        System.out.println("Input Adjcacency list:");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("\nAdjacency list of vertex "+ i);
            System.out.print("head");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" -> "+ adjList.get(i).get(j));
            }
            System.out.println();
        }
        int [][] adjMatrix = new int[vertices][vertices];

        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                adjMatrix[i][j] = 0;
            }
        }

        for(int i=0;i<vertices;i++){
            for(int j=0;j<adjList.get(i).size();j++){
                adjMatrix[i][adjList.get(i).get(j)] = 1;
            }
        }

        System.out.println("The adjacency matrix is:");
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.printf("%d\t",adjMatrix[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
