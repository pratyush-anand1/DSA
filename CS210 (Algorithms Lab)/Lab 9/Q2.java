import java.util.*;
public class Q2 {
	static int V;
	ArrayList<ArrayList<Integer> > adjListArray;
    static int count;

	Q2(int V)
	{
		this.V = V;

		adjListArray = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adjListArray.add(i, new ArrayList<>());
		}
	}

	void addEdge(int src, int dest)
	{

		adjListArray.get(src).add(dest);
		adjListArray.get(dest).add(src);
	}

	void DFSUtil(int v, boolean[] visited)
	{

		visited[v] = true;
		System.out.print(v + " ");
		for (int x : adjListArray.get(v)) {
			if (!visited[x])
				DFSUtil(x, visited);
		}
	}

	void connectedComponents(int[] connectivity)
	{
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; ++v) {
			if (!visited[v]) {
				DFSUtil(v, visited);
                connectivity[v] = count;
                count++;
				System.out.println();
			}
		}
	}

	
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int v;
        System.out.println("Enter number of vertices");
        v = sc.nextInt();
        int[] connectivity = new int[v];
        Q2 g = new Q2(v);

        int edges;
        System.out.println("Enter number of edges:");
        edges = sc.nextInt();

        int c=0;
        while(c < edges){
            System.out.println("Enter source and destination vertex:");
            int src = sc.nextInt();
            int dest = sc.nextInt();
            g.addEdge(src, dest);
            c++;
        }

        System.out.println("Following are connected components");
        g.connectedComponents(connectivity);
        System.out.println("Total connected components: " + count);

        System.out.println("Enter both the vertices:");
        int v1 = sc.nextInt();
        int v2= sc.nextInt();
        if(connectivity[v1] == connectivity[v2]){
            System.out.println("Parts of same component");
        }
        else{
            System.out.println("Parts of different components");
        }
    }
}
