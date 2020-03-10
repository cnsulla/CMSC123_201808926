import java.util.Queue;
import java.util.LinkedList;

public class CriticalPath
{

    private Vertex[] output;
    private int ctr = 0;
    private Queue<Vertex> paths = new LinkedList<Vertex>();

    public Vertex[] topologicalSort(GraphADT graph) throws InputNotDAGException, 
                                                    CloneNotSupportedException
    {
        output = new Vertex[graph.vert.size()];
        GraphADT graphtemp = (GraphADT)graph.clone();

        if (isDAG(graphtemp))
        {
            System.out.println("Input is a Directed Acyclic Graph!");
            return output;
        }

        else
            throw new InputNotDAGException("Threw InputNotDAGException: Input is not a Directed Acyclic Graph!");
    }
    //CHECKS IF GRAPH IS A DAG, OTHERWISE RETURNS FALSE
    public boolean isDAG(GraphADT graph) throws CloneNotSupportedException 
    {
        GraphADT graphtemp = (GraphADT)graph.clone();
        int leafResult = getLeaf(graphtemp);

        if (graphtemp.vert.size() == 0)
        {
            return true;
        }

        else
        {
            if (leafResult == -1)
            {
                return false;
            }

            else if (leafResult >= 0)
            {
                // System.out.println("will remove " + graphtemp.vert.get(leafResult).getName());
                
                output[ctr] = graphtemp.vert.get(leafResult);
                ctr++;

                graphtemp.removeVertex(leafResult);
                
                return isDAG(graphtemp);
            }
        }

        return false;
    }
    //RETURNS INDEX OF LEAF (zero indegree) IN GEAPH IF EXISTS
    public int getLeaf(GraphADT gt)
    {
        for (int i = 0; i < gt.vert.size(); i ++)
        {
            if (isLeaf(gt.vert.get(i), gt))
            {
                return i;
            }
        }
        return -1;
    }
    //CHECKS IF GIVEN VERTEX IS A LEAF (zero indegree)
    public boolean isLeaf(Vertex v, GraphADT gx)
    {
        int vLoc = gx.getPosition(v);
        
        for (int i = 0; i < gx.adjM.length; i++)
        {
            if (gx.adjM[i][vLoc] >= 1)
            {
                return false;
            }
        }

        return true;
    }
}