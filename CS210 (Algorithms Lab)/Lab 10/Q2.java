//prims using heap data strcuture

import java.util.*;

class Node implements Comparator<Node> {
    int v;
    int weight;

    public int compare(Node n1, Node n2) {
        if (n1.weight < n2.weight)
            return -1;
        if (n1.weight > n2.weight)
            return 1;
        return 0;
    }

    Node() {
    };

    Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}

class Graph {
    ArrayList<ArrayList<Node>> A;
    int n;

    void setgraph() {
        System.out.println("Enter the number of nodes:");
        Scanner sc = new Scanner(System.in);
        this.n = sc.nextInt();
        this.A = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < this.n; i++) {
            this.A.add(new ArrayList<Node>());
        }

        for (int i = 0; i < this.n; i++)

        {
            System.out.println("Enter number of elements in adjacency list of " + i);
            int total = 0;
            total = sc.nextInt();
            int v = 0, w = 0;
            int count = 0;
            System.out.println("Enter the adjacency list of vertex " + i);
            while (count != total) {
                System.out.println("Enter the vertex");
                v = sc.nextInt();
                System.out.println("Enter the corresponding weight");
                int b = sc.nextInt();
                Node n = new Node(v, b);
                this.A.get(i).add(n);
                count++;

            }
        }
    }

    public void prims() {
        Scanner sc = new Scanner(System.in);

        int parent[] = new int[this.n];
        boolean MST[] = new boolean[this.n];
        int key[] = new int[this.n];
        int w = 0;
        PriorityQueue<Node> p = new PriorityQueue<Node>(n, new Node());
        for (int i = 0; i < n; i++) {
            MST[i] = false;
            parent[i] = -1;
            key[i] = Integer.MAX_VALUE;
        }
        key[0] = 0;
        p.add(new Node(0, key[0]));
        for (int i = 0; i < n - 1; i++) {
            int u = p.poll().v;
            MST[u] = true;
            for (Node n : A.get(u)) {
                if (MST[n.v] == false && key[n.v] > n.weight) {
                    key[n.v] = n.weight;
                    parent[n.v] = u;
                    p.add(new Node(n.v, key[n.v]));
                }
            }
        }
        System.out.println("MINIMUM SPANNING TREE");
        for (int i = 0; i < parent.length; i++) {
            System.out.println("Edge from " + i + " to " + parent[i]);
        }

        System.out.println("-1 indicates root");

        for (int i = 0; i < key.length; i++) {
            w = w + key[i];
        }
        System.out.println("The toatl weight is " + w);

    }
}

public class Q2 {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.setgraph();
        g.prims();
    }
}
