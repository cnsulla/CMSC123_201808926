import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class TSort
{
    private double[] critPath;
    private Queue<Vertex> unsettled = new LinkedList<Vertex>();
    private Queue<Vertex> settled = new LinkedList<Vertex>();

    public void topologicalSort(GraphADT graph) throws InputNotDAGException, 
                                                    CloneNotSupportedException
    {
        if (isDAG(graph))
            System.out.println("Topological Sort Exists.");

        else
            throw new InputNotDAGException("Threw InputNotDAGException: Input is not a Directed Acyclic Graph!");
    }

    public double[] criticalPath(GraphADT graph) throws InputNotDAGException, 
                                                    CloneNotSupportedException
    {
        if (isDAG(graph))
            return critPath;

        else
            throw new InputNotDAGException("Threw InputNotDAGException: Input is not a Directed Acyclic Graph!");
    }

    ///FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFIX THIS TO NOT DELETE ALL VERTICES
    //CHECKS IF GRAPH IS A DAG, OTHERWISE RETURNS FALSE
    public boolean isDAG(GraphADT graph) throws CloneNotSupportedException 
    {
        int source = getSrc(graph);

        //INITIALIZED GRAPH SHITS
        boolean[] visited = new boolean[graph.vert.size()];
        int[] indeg = new int[graph.vert.size()];
        for (int i = 0; i < indeg.length; i++)
        {
            for (int j = 0; j < indeg.length; j++)
            {
                if (graph.adjM[i][j] != Double.POSITIVE_INFINITY && i != j)
                {
                    indeg[j] += 1;
                }
            }
        }

        ArrayList<Integer> listOfTopSorts = new ArrayList<Integer>();

        findTopologicalSorts(graph, visited, indeg, listOfTopSorts);

        if (graph.vert.size() == 0)
        {
            return true;
        }

        else
        {
            if (source == -1)
            {
                return false;
            }

            else if (source >= 0)
            {
                // System.out.println(graph.vert.get(source).getName() + " has length: " + graph.vert.get(source).getCPath());
                
                graph.removeVertex(source);
                
                return isDAG(graph);
            }
        }

        return false;
    }
    // FINDS ALL TOPOLOGICAL SORTS OF A GIVEN GRAPH
    public void findTopologicalSorts(GraphADT graph, boolean[] visited, int[] indeg, ArrayList<Integer> listOfTopSorts) throws CloneNotSupportedException 
    {
        boolean foundall = true;
        
        for (int i = 0; i < graph.vert.size(); i ++)
        {

            if (!visited[i] && indeg[i] == 0)
            {
                listOfTopSorts.add(i);
                visited[i] = true;

                //FINDS ALL ADJACENT VERTICES TO CURRENT
                boolean[] adjacents = findAdjacent(i, graph);

                //REDUCES INDEGREE OF ALL VERTICES ADJACENT 
                for (int x = 0; x < adjacents.length; x++)
                {
                    if (adjacents[x])
                        indeg[x]--;
                }
                
                findTopologicalSorts(graph, visited, indeg, listOfTopSorts);

                //RESETS PARAMETERS
                visited[i] = false;
                listOfTopSorts.remove(listOfTopSorts.size()-1);
                for (int x = 0; x < adjacents.length; x++)
                {
                    if (adjacents[x])
                        indeg[x]++;
                }

                foundall = false;
            }
        }
        
        if (foundall)
        {
            listOfTopSorts.forEach(i -> System.out.print(graph.vert.get(i).getName() + " ")); 
            System.out.println();
        }
    }

    //FINDS ADJACENT VERTICES TO CURRENT NODE
    public boolean[] findAdjacent(int v, GraphADT graph)
    {
        boolean[] adjacents = new boolean[graph.vert.size()];
        
        for (int i = 0; i < graph.adjM.length; i++)
        {
            if (graph.adjM[v][i] != Double.POSITIVE_INFINITY && i != v)
                {
                    adjacents[i] = true; 
                }
        }
        return adjacents;
    }

    //RETURNS INDEX OF LEAF (zero indegree) IN GRAPH IF EXISTS
    public int getSrc(GraphADT gt)
    {
        for (int i = 0; i < gt.vert.size(); i ++)
        {
            if (isSource(gt.vert.get(i), gt))
            {
                return i;
            }
        }
        return -1;
    }

    //CHECKS IF GIVEN VERTEX IS A LEAF (zero indegree)
    public boolean isSource(Vertex v, GraphADT gx)
    {
        int vLoc = gx.getPosition(v);
        
        for (int i = 0; i < gx.adjM.length; i++)
        {
            if (gx.adjM[i][vLoc] != Double.POSITIVE_INFINITY && i != vLoc)
            {
                return false;
            }
        }
        return true;
    }
}