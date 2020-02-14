public class TSort
{

    private Vertex[] output;
    private int ctr = 0;

    public TSort()
    {
    }

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

    public boolean isDAG(GraphADT graph) throws CloneNotSupportedException 
    {
        GraphADT graphtemp = (GraphADT)graph.clone();
        int leafResult = getLeaf(graphtemp);

        if (graphtemp.vert.size() == 0)
        {
            // System.out.println("Vertex empty. Thus true.");
            return true;
        }

        else
        {
            if (leafResult == -1)
            {
                // System.out.println("No leaves. Thus false.");
                return false;
            }

            else if (leafResult >= 0)
            {
                // System.out.println("will remove " + graphtemp.vert.get(leafResult).getName());
                
                output[ctr] = graphtemp.vert.get(leafResult);
                ctr++;

                graphtemp.removeVertex(leafResult);
                // graphtemp.printMatrix();
                
                return isDAG(graphtemp);
            }
        }

        return false;
    }

    public int getLeaf(GraphADT gt)
    {
        for (int i = 0; i < gt.vert.size(); i ++)
        {
            if (isLeaf(gt.vert.get(i), gt))
            {
                // System.out.print(gt.vert.get(i).getName()+" is a leaf and ");
                return i;
            }
        }
        return -1;
    }

    public boolean isLeaf(Vertex v, GraphADT gx)
    {
        // System.out.print("Checking if "+v.getName() +" has incoming: ");
        int vLoc = gx.getPosition(v);
        
        for (int i = 0; i < gx.adjM.length; i++)
        {
            if (gx.adjM[i][vLoc] >= 1)
            {
                
                // System.out.print(gx.vert.get(vLoc).getName()+" has indegree ");
                // System.out.println(gx.adjM[i][vLoc]+" ("+i+", "+vLoc+") ");
                return false;
            }
        }
        // System.out.println(v.getName() +" has indegree 0");

        return true;
    }
}