import java.util.*;

class Graph {
    int n;
    ArrayList<ArrayList<Integer>> A;
    int c = 0;
    int cc[];

    void bfs() {

        int[] visited = new int[n];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                c++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                cc[i] = c;
                visited[i] = 1;
                System.out.println("edges of connected component " + c + " are ");
                while (q.size() != 0) {
                    Integer k = q.poll();
                    cc[k] = c;
                    System.out.println(k);
                    for (Integer j : A.get(k)) {
                        if (visited[j] == 0) {
                            q.offer(j);
                            visited[j] = 1;
                        }
                    }

                }

            }
        }
    }

    void setgraph() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of nodes");
        this.n = sc.nextInt();

        this.cc = new int[this.n];
        this.A = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {

            ArrayList<Integer> a = new ArrayList<>();

            this.A.add(a);
        }

        for (int i = 0; i < A.size(); i++) {

            System.out.println("enter adjacent nodes of " + i);
            System.out.println("NOTE : Enter -1 to indiacte absence of edge:");
            Integer a = 0;
            while (a != -1) {
                a = sc.nextInt();
                if (a == -1)
                    break;
                this.A.get(i).add(a);

            }

        }

    }

    ArrayList<ArrayList<Integer>> Transpose() {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < this.n; i++) {
            ArrayList<Integer> b = new ArrayList<>();
            B.add(b);

        }
        for (int i = 0; i < A.size(); i++) {

            for (Integer a : A.get(i)) {
                B.get(a).add(i);
            }

        }
        return B;

    }

    void printGraph() {
        for (int i = 0; i < A.size(); i++) {
            System.out.print(i + "-->");
            for (Integer a : A.get(i)) {
                System.out.print(a + " ");
            }
            System.out.print("\n");
        }
    }

    void DFS(Integer u, ArrayList<Integer> storeDFS, int[] visitedDFS) {
        visitedDFS[u] = 1;
        storeDFS.add(u);

        for (Integer v : A.get(u)) {
            if (visitedDFS[v] == 0) {
                DFS(v, storeDFS, visitedDFS);
            }
        }
    }

    void DFS(Integer u, ArrayList<Integer> storeDFS, int[] visitedDFS, ArrayList<ArrayList<Integer>> B) {
        visitedDFS[u] = 1;
        storeDFS.add(u);

        for (Integer v : B.get(u)) {
            if (visitedDFS[v] == 0) {
                DFS(v, storeDFS, visitedDFS, B);
            }
        }
    }

    boolean path(Integer u, Integer v) {
        int f1 = 0, f2 = 0;
        ArrayList<Integer> storeDFS1 = new ArrayList<>();
        int visitedDFS1[] = new int[this.n];
        DFS(u, storeDFS1, visitedDFS1);

        ArrayList<Integer> storeDFS2 = new ArrayList<>();
        int visitedDFS2[] = new int[this.n];
        DFS(v, storeDFS2, visitedDFS2);

        for (int i = 0; i < storeDFS1.size(); i++) {
            if (storeDFS1.get(i).equals(v))
                f1 = 1;
        }
        for (int i = 0; i < storeDFS2.size(); i++) {
            if (storeDFS2.get(i).equals(u))
                f2 = 1;
        }
        if (f1 == 1 && f2 == 1)
            return true;
        else
            return false;
    }

    void stronglyConnectedCompUtil() {

        int[] visited = new int[this.n];
        for (int i = 0; i < A.size(); i++) {

            ArrayList<Integer> K = new ArrayList<>();
            for (int k = i; k < A.size(); k++) {
                K.add(k);
            }

            for (int j = i + 1; j < A.size(); j++) {

                if (!path(i, j)) {

                    for (int m = 0; m < K.size(); m++) {
                        if (j == K.get(m))
                            K.remove(m);
                    }
                }
            }

            for (int l = 0; l < K.size(); l++) {
                if (visited[K.get(l)] == 0)
                    System.out.print(K.get(l) + " ");
                visited[K.get(l)] = 1;
            }
            System.out.print(" \n");

        }

    }

    void Kosaraju() {
        int vis[] = new int[this.n];
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < this.n; i++) {
            if (vis[i] == 0) {
                dfs(i, s, vis);
            }
        }

        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        B = this.Transpose();
        for (int i = 0; i < n; i++) {
            vis[i] = 0;
        }

        while (s.size() > 0) {
            Integer a = s.peek();
            s.pop();
            if (vis[a] == 0) {
                System.out.print("SCC: ");
                revDFS(a, B, vis);
                System.out.println();
            }
        }
    }

    void revDFS(Integer u, ArrayList<ArrayList<Integer>> B, int vis[]) {
        vis[u] = 1;
        System.out.print(u + " ");
        for (Integer v : B.get(u)) {
            if (vis[v] == 0)
                revDFS(v, B, vis);
        }
    }

    void dfs(Integer u, Stack<Integer> s, int vis[]) {
        vis[u] = 1;
        for (Integer v : A.get(u)) {
            if (vis[v] == 0) {
                dfs(v, s, vis);
            }
        }
        s.push(u);
    }

}

public class Q3B {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.setgraph();
        g.stronglyConnectedCompUtil();
        g.Kosaraju();
    }

}