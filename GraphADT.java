import java.util.Scanner;
public class GraphADT
{
    private Vertex[][] adjV;
    private int edges = 0;

    public GraphADT(int vertices)
    {
        adjV = new Vertex[vertices][vertices];
        for (int i = 0 ; i < vertices; i++)
        {
            for (int x = 0; x < vertices; x++)
            {
                Vertex y = new Vertex();
                adjV[i][x] = y;
            }
        }
    }

    public void addEdge(int from, int to)
    {
        adjV[from][to].addEdge();
        adjV[to][from].addEdge();
        edges += 1;
    }

    public boolean removeEdge(int from, int to)
    {
        edges -= 1;
        return adjV[from][to].removeEdge();
    }

    public int getEdges()
    {
        return edges;
    }

    public int getVertices()
    {
        return adjV.length;
    }

    public void printGraph()
    {
        System.out.print("\n   ");
        for (int i = 0 ; i < adjV.length ; i++)
        {
            System.out.print((i) + " ");
        }
        System.out.print("\n  ");
        for (int i = 0; i < adjV.length*2; i++)
        {
            System.out.print("-");
        }
        System.out.print("\n");
        for (int i = 0; i < adjV.length ; i++)
        {
            System.out.print((i) + "| ");
            for (int x = 0; x < adjV.length ; x++)
            {
                if (adjV[i][x].hasEdge())
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Boolean bool = true;
        System.out.println ("Input number of vertices: ");
        int size = scan.nextInt();
        GraphADT graph = new GraphADT(size);
        while(bool = true)
        {
            System.out.println("Graph has a total of " + graph.getVertices() + " vertices and " + graph.getEdges() + " edges.");
            System.out.println("Choose: ");
            System.out.println("1. Add edge \n2. Remove edge \n3. Show Adjacency Matrix\n4. Exit\nInput Selection: "); 
            int choice = scan.nextInt();

            switch (choice)
            {
                case 1: 
                    System.out.println("ADDING AN EDGE");
                    System.out.println("From: ");
                    int from = scan.nextInt();
                    System.out.println("To: ");
                    int to = scan.nextInt();
                    graph.addEdge(from, to);
                    break;
                case 2:
                    System.out.println("REMOVING AN EDGE");
                    System.out.println("From: ");
                    int fr = scan.nextInt();
                    System.out.println("To: ");
                    int t = scan.nextInt();
                    graph.removeEdge(fr, t);
                    break;
                case 3:
                    graph.printGraph();
                    break;
                case 4: 
                    bool = false;
                    break;
            }

        }
    }
}