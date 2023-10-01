import java.util.*;

public class Q3
{
    static int count;
	private void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int vis[]) {
		vis[node] = 1;
		for(Integer it : adj.get(node)) {
			if(vis[it] == 0) {
				dfs(it, st, adj, vis); 
			}
		}

		st.push(node); 
	}

	private void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, int vis[]) {
		vis[node] = 1;
		System.out.print(node + " "); 
		for(Integer it : transpose.get(node)) {
			if(vis[it] == 0) {
				revDfs(it, transpose, vis); 
			}
		}
	}

    void SCC(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int vis[] = new int[n]; 
        Stack<Integer> st = new Stack<Integer>(); 
        for(int i = 0;i<n;i++) {
        	if(vis[i] == 0) {
        		dfs(i, st, adj, vis); 
        	}
        }

        ArrayList<ArrayList<Integer> > transpose = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			transpose.add(new ArrayList<Integer>());

		for(int i = 0;i<n;i++) {
			vis[i] = 0; 
			for(Integer it: adj.get(i)) {
				transpose.get(it).add(i); 
			}
		}

		printTranspose(transpose);

		while(st.size() > 0) {
			int node = st.peek(); 
			st.pop(); 
			if(vis[node] == 0) {
				System.out.print("SCC: "); 
                count++;
				revDfs(node, transpose, vis);
				System.out.println(); 
			}
		}

    }

	public void printTranspose(ArrayList<ArrayList<Integer> > transpose){
		System.out.println("Transpose of graph using adjcaency list:");
		for (int i = 0; i < transpose.size(); i++) {
            System.out.println("\nAdjacency list of vertex "+ i);
            System.out.print("head");
            for (int j = 0; j < transpose.get(i).size(); j++) {
                System.out.print(" -> "+ transpose.get(i).get(j));
            }
            System.out.println();
        }
	}
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n ;
        System.out.println("Enter the number of edges");

        n = sc.nextInt();

        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
        }
        int c =0;
        while(c < n){
            System.out.println("Enter source and destination vertex:");
            int src= sc.nextInt();
            int dest = sc.nextInt();
            adj.get(src).add(dest);
            c++;
        }
		Q3 obj = new Q3(); 
		obj.SCC(adj, n); 
		if(count == 1){
            System.out.println("The graph is strongly connected with one single connected component");
        }
        else{
            System.out.println("The graph is not strongly connected and has "+ count +" connected components");
        }
    }
}