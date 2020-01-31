import java.util.Stack;
import java.util.ArrayList;

public class GraphADT
{
    private Boolean[][] adjM;
    public ArrayList<Vertex> vert = new ArrayList<Vertex>();
    // private DArray<Vertex> vertices = new DArray<Vertex>();
    private int edges = 0;
    private Stack<Vertex> dfs = new Stack<Vertex>();

    public GraphADT()
    {
    }

    public void addVertex(String name)
    {
        Vertex in = new Vertex();
        in.setName(name);
        vert.add(in);

        adjM = new Boolean[vert.size()][vert.size()];
        for (int i = 0 ; i < vert.size(); i++)
        {
            for (int x = 0; x < vert.size(); x++)
            {
                Boolean bool = false;
                adjM[i][x] = bool;
            }
        }
    }

    public Vertex removeVertex(String remove)
    {
        for (int i = 0; i < vert.size(); i++)
        {
            if (vert.get(i).getName() == remove)
            {
                Vertex removed = vert.get(i);
                vert.remove(i);
                return removed;
            }
        }
        return null;
    }

    public void addEdge(int from, int to)
    {
        vert.get(from).addEdge();
        vert.get(from).addAdjV(vert.get(to));
        adjM[from][to] = true;
        vert.get(to).addEdge();
        vert.get(to).addAdjV(vert.get(from));
        adjM[to][from] = true;

        edges += 1;
    }

    public void removeEdge(int from, int to)
    {
        edges -= 1;
        vert.get(from).removeEdge();
        vert.get(from).removeAdjV(vert.get(to).getName());
        vert.get(to).removeEdge();
        vert.get(to).removeAdjV(vert.get(from).getName());
    }

    public int getEdges()
    {
        return edges;
    }

    public int getVertices()
    {
        return vert.size();
    }

    public void printMatrix()
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
                if (adjM[i][x])
                    System.out.print("1 ");
                    
                else
                    System.out.print("0 ");
            }
            System.out.print("\n");
        }
        printVertexList();

        System.out.print("\n");
    }

    public void printVertexList()
    {
        System.out.println("\nLegend: ");

        for (int i = 0; i < vert.size(); i++)
        {
            System.out.println(i+" - " + vert.get(i).getName());
        }
    }

    public void printAdjList()
    {
        System.out.print("\n");
        for (int i = 0; i < vert.size() ; i++)
        {
            System.out.print(vert.get(i).getName());

            if (vert.get(i).hasEdge())
            {
                for (int x = 0; x < vert.get(i).adjList.size(); x++)
                    {
                        System.out.print(" -> " + vert.get(i).adjList.get(x).getName());
                    }
            }

            else
            {
                System.out.print(" has no adjacent vertices.");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void depthTraverse()
    {
        System.out.print("DFS: [");
        for (int i = 0; i < vert.size(); i ++)
        {
            dfs.push(vert.get(i));
            // System.out.println("Detected: "+dfs.peek().getName());
            dfs.peek().setVisited();
            if (dfs.peek().hasEdge() && !dfs.peek().hasVisited())
            {
                // System.out.println("Has edge.");
                for (int x = 0; x < vert.get(i).adjList.size(); x ++)
                {
                    if (!vert.get(i).adjList.get(x).hasVisited())
                    {
                        // System.out.print("Now pushing: "+vert.get(i).adjList.get(x).getName()+"\n");
                        dfs.push(vert.get(i).adjList.get(x));
                    }
                }
            }
            else
            {
                System.out.print(" "+dfs.pop().getName());
            }
        }
        System.out.println("]");
    }

    public void printWeights(int f, int t)
    {
    }
}