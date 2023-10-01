//Kruskal's algorithm using array

import java.util.*;

class Node{
    int m;
    int weight;
}

class Edge implements Comparable<Edge>
{
    int m;
    int n;
    int val;

    Edge(int m,int n, int val)
    {
        this.m=m;
        this.n=n;
        this.val=val;
    }

    public int compareTo(Edge e1)
    {
        return this.val-e1.val;
    }
}

class Graph
{
    ArrayList<ArrayList<Node>> A;
    int n;

    public void setgraph()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        this.n=sc.nextInt();
        this.A=new ArrayList<ArrayList<Node>>();

        for(int i=0;i<this.n;i++)
        {
            this.A.add(new ArrayList<Node>());
        }

        for(int i=0;i<this.n;i++)
        {
			int total = 0;
			System.out.println("Enter the total vertcies adjacent to "+i + ":");
			total = sc.nextInt();
            System.out.println("Enter the adjacent vertices of "+i + ":");
			int m=0,w=0;
			int counter = 0;
            while(counter != total)
            {
                m=sc.nextInt();

                System.out.println("Enter the corresponding weight:");
                
                int b=sc.nextInt();
                Node n=new Node();
                n.m=m;n.weight=b;
                this.A.get(i).add(n);
				counter++;

            }
        }
    }

    public ArrayList<Edge> setEdge()
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter number of edges");
        int edges=sc.nextInt();
        ArrayList<Edge> E =new ArrayList<>();
        for(int i=0;i<edges;i++)
        {
            System.out.printf("First vertex connected to edge %d",i+1);
            int a=sc.nextInt();
            System.out.printf("Second vertex connected to egde %d",i+1);
            int b=sc.nextInt();
            System.out.println("Enter weight of the egde:");
            int c=sc.nextInt();
            Edge e=new Edge(a,b,c);
            E.add(e);
        }
        Collections.sort(E);
        
        return E;
    }

	public void Kruskal()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        this.n=s.nextInt();
        int []matrix =new int [this.n];
        for(int i=0;i<n;i++)
        {
            matrix[i]=i;
        }

        ArrayList<Edge>E =new ArrayList<>();
        ArrayList<Edge> MST=new ArrayList<>();
        E=setEdge();
        int b=0;
        int w=0;
        for(int i=0;b<n-1;i++)
        {
            int p=E.get(i).n;
            int q=E.get(i).m;
            int ind1=Find(p, matrix);

            int ind2=Find(q, matrix);

            if(ind1!=ind2)
            {
                Union(p, q, matrix);
                b++;
                w=w+E.get(i).val;
                MST.add(E.get(i));
            }

        }
		System.out.println("MINMUM SPANNING TREE");
        for(int i=0;i<MST.size();i++)
        {
            System.out.println("Edge between "+ MST.get(i).n+ " and "+MST.get(i).m);
        }
        System.out.println("Total weight is :"+w);     
    }

	int Find(int m,int []matrix){
        return matrix[m];
	}

    public void Union(int n,int m,int matrix[]){
    int c=matrix[n];
    for(int i=0;i<matrix.length;i++){
        if(matrix[i]==c)
        matrix[i]=matrix[m];
    }
   }

   
}

public class Q3 {
    public static void main(String[] args) {
        Graph g=new Graph();
        g.Kruskal();
    }
}
