public class TSort
{
    public TSort()
    {   
    }

    public void topologicalSort(GraphADT graph) throws InputNotDAGException
    {
        if (!graph.isDAG())
        {
            throw new InputNotDAGException("Input is not a Directed Acyclic Graph!");
        }

        else
        {
            
        }
    }
}