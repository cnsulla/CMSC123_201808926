import java.util.Scanner;

public class GraphADT
{
    private Vertex[][] adjM;
    private Vertex[] vxList;
    private int edges = 0;

    public GraphADT(int vertices)
    {
        vxList = new Vertex[vertices];
        for (int i = 0 ; i < vertices; i++)
        {
            Vertex z = new Vertex(Integer.toString(i));
            vxList[i] = z;
        }

        adjM = new Vertex[vertices][vertices];
        for (int i = 0 ; i < vertices; i++)
        {
            for (int x = 0; x < vertices; x++)
            {
                Vertex y = new Vertex();
                adjM[i][x] = y;
            }
        }
    }

    public void addEdge(int from, int to, String wght)
    {
        adjM[from][to].addEdge();
        vxList[from].addEdge();
        adjM[from][to].setWeight(wght);
        vxList[from].addAdjV(vxList[to]);

        adjM[to][from].addEdge();
        vxList[to].addEdge();
        adjM[to][from].setWeight(wght);
        vxList[to].addAdjV(vxList[from]);
        edges += 1;
    }

    public void addVertex()
    {

    }

    public boolean removeEdge(int from, int to)
    {
        edges -= 1;
        return adjM[from][to].removeEdge();
    }

    public int getEdges()
    {
        return edges;
    }

    public int getVertices()
    {
        return adjM.length;
    }

    public void depthTraverse()
    {
        // for (int i = 0; i <= ; i ++)
        // {

        // }
    }

    public void printGraph()
    {
        System.out.print("\n   ");
        for (int i = 0 ; i < adjM.length ; i++)
        {
            System.out.print((i) + " ");
        }
        System.out.print("\n  ");
        for (int i = 0; i < adjM.length*2; i++)
        {
            System.out.print("-");
        }
        System.out.print("\n");
        for (int i = 0; i < adjM.length ; i++)
        {
            System.out.print((i) + "| ");
            for (int x = 0; x < adjM.length ; x++)
            {
                if (adjM[i][x].hasEdge())
                {
                    System.out.print("1 ");
                    // printWeights(i, x);
                }
                    
                else
                    System.out.print("0 ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");
    }

    public void printAdjList()
    {
        System.out.print("\n");
        for (int i = 0; i < vxList.length ; i++)
        {
            System.out.print((i+1)+".");

            if (vxList[i].hasEdge())
            {
                for (int x = 0; x < vxList[i].adjList.size(); x++)
                    {
                        System.out.print(" -> " + vxList[i].adjList.get(x).getName());
                    }
            }

            System.out.print("\n");
        }
    }

    public void printWeights(int f, int t)
    {
        if (adjM[f][t].getWeight()==null)
            System.out.println("Edge has no weight.");
        else
            System.out.println("\nEdge adjacent to "+f+" and "+t+" has weight: "+adjM[f][t].getWeight());
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Boolean bool = true;
        int choice;

        System.out.print ("Input number of vertices: ");
        int size = scan.nextInt();
        GraphADT graph = new GraphADT(size);

        while(bool = true)
        {
            // System.out.println ("bool = " + bool);
            System.out.println("Undirected graph has a total of " + graph.getVertices() + " vertices and " + graph.getEdges() + " edges.");
            System.out.println("Choose (1-4 only): ");
            System.out.print("1. Add edge \n2. Remove edge \n3. Show Adjacency Matrix\n4. Show adjacency list\n5. Show weight of an edge\nInput Selection: "); 
            choice = scan.nextInt();

            switch (choice)
            {
                case 1: 
                    System.out.println("ADDING AN EDGE (From 0 to "+(size-1)+" only.)");
                    System.out.print("From: ");
                    int fa = scan.nextInt();
                    System.out.print("To: ");
                    int ta = scan.nextInt();
                    System.out.print("Weight: ");
                    String wgt = scan.nextLine();
                    
                    graph.addEdge(fa, ta, wgt);
                    break;
                case 2:
                    System.out.println("REMOVING AN EDGE");
                    System.out.print("From: ");
                    int fr = scan.nextInt();
                    System.out.print("To: ");
                    int tr = scan.nextInt();
                    
                    graph.removeEdge(fr, tr);
                    break;
                case 3:
                    graph.printGraph();
                    break;
                case 4:
                    graph.printAdjList();
                    break; 
                case 5:
                    System.out.println("PRINTING WEIGHT ");
                    System.out.print("Vertex 1: ");
                    int fw = scan.nextInt();
                    System.out.print("Vertex 2: ");
                    int tw = scan.nextInt();

                    graph.printWeights(fw, tw);
                    bool = false;
                    
            }

        }
    }
}