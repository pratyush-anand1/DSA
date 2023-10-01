import java.util.*;

class Node {
    int v;
    int weight;
}

class edge implements Comparable<edge> {
    int v;
    int u;
    int value;

    edge(int v, int u, int value) {
        this.v = v;
        this.u = u;
        this.value = value;
    }

    public int compareTo(edge e1) {
        return this.value - e1.value;
    }
}

class Graph {
    ArrayList<ArrayList<Node>> A;
    int n;

    void setgraph() {
        System.out.println("enter number of nodes");
        Scanner sc = new Scanner(System.in);
        this.n = sc.nextInt();
        this.A = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < this.n; i++) {
            this.A.add(new ArrayList<Node>());
        }
        for (int i = 0; i < this.n; i++) {
            System.out.println("enter adjacency list of " + i);
            int v = 0, w = 0;
            while (v != -1) {
                v = sc.nextInt();
                if (v == -1)
                    break;
                System.out.println("enter weight");

                int b = sc.nextInt();
                Node n = new Node();
                n.v = v;
                n.weight = b;
                this.A.get(i).add(n);

            }
        }
    }

    ArrayList<edge> setEdge() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of edges");
        int m = sc.nextInt();
        ArrayList<edge> E = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            System.out.println("Enter first vertex connected:");
            int a = sc.nextInt();
            System.out.println("Enter second vertex connected:");
            int b = sc.nextInt();
            System.out.println("Enter weight of the corresponding edge:");
            int c = sc.nextInt();
            edge e = new edge(a, b, c);
            E.add(e);
        }
        Collections.sort(E);

        return E;

    }

    public void Kruskal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        this.n = sc.nextInt();
        ArrayList<ArrayList<Node>> lList = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Node> a = new ArrayList<>();
            lList.add(a);
        }
        for (int i = 0; i < n; i++) {
            Node nd = new Node();
            nd.v = i;
            lList.get(i).add(nd);
        }
        ArrayList<edge> E = new ArrayList<>();
        E = setEdge();
        ArrayList<edge> MST = new ArrayList<>();
        int b = 0;
        int w = 0;
        for (int i = 0; b < this.n - 1; i++) {
            int p = E.get(i).u;
            int q = E.get(i).v;
            if (!Find(p, q, lList)) {
                Union(p, q, lList);
                b++;
                w = w + E.get(i).value;
                MST.add(E.get(i));

                System.out.println("counted " + p + " " + q);
            }

        }
        System.out.println("MINIMUM SPANNING TREE");
        for (int i = 0; i < MST.size(); i++) {
            System.out.println("Edge between " + MST.get(i).u + " and " + MST.get(i).v);
        }
        System.out.println("The total weight is " + w);
    }

    boolean Find(int u, int v, ArrayList<ArrayList<Node>> E) {
        if (E.get(u).get(0).v == E.get(v).get(0).v)
            return true;
        else
            return false;
    }

    void Union(int u, int v, ArrayList<ArrayList<Node>> E) {

        if (!Find(u, v, E)) {
            for (Node n : E.get(u)) {
                E.get(v).add(n);
            }
            for (Node n : E.get(v)) {
                E.get(u).add(n);
            }
            E.get(v).get(0).v = u;
        }

    }
}
    public class Q5 {
        public static void main(String[] args) {
            Graph g = new Graph();
            g.Kruskal();
        }
    }
