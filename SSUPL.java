import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class SSUPL
{
    public int[] SSUPL(GraphADT graph, Vertex source)
    {
        int[] out = new int[graph.vert.size()];
        Queue<Vertex> bfs = new LinkedList<Vertex>();
        bfs.add(source);
        graph.vert.get(graph.getPosition(source)).setPath(0);

        while (bfs.peek() != null)
        {
            Vertex current = bfs.remove();
            graph.vert.get(graph.getPosition(current)).setVisited();
            graph.vert.get(graph.getPosition(current)).setPath(current.getPath());
            
            ArrayList<Integer> neighbors = graph.getNeighbor(current);


            for (int i = 0; i < neighbors.size(); i ++)
            {
                if (graph.vert.get(neighbors.get(i)).hasVisited())
                {
                    continue;
                }

                else
                {
                    if (graph.vert.get(neighbors.get(i)).getPath() == -1)
                    {
                        graph.vert.get(neighbors.get(i)).setPath(current.getPath()+1);
                    }
                    bfs.add(graph.vert.get(neighbors.get(i)));
                }
            }
        }

        for (int i = 0 ; i < out.length; i++)
        {
            if (graph.vert.get(i).getPath() == -1)
                out[i] = 0;
            else
                out[i] = graph.vert.get(i).getPath();
        }

        return out;
    }
}