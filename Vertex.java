import java.util.ArrayList;

public class Vertex
{
    private String vertexName;
    private boolean hasEdge;
    private String weight;
    public ArrayList<Vertex> adjList = new ArrayList<Vertex>();

    public Vertex(String name)
    {
        this.vertexName = name;
    }

    public Vertex()
    {
    }

    public void addAdjV(Vertex add)
    {
        System.out.println("To add: " + add);
        this.adjList.add(add);
    }

    public void setName(String name)
    {
        this.vertexName = name;
    }

    public String getName()
    {
        return this.vertexName;
    }

    public void setWeight(String in)
    {
        this.weight = in;
    }

    public String getWeight()
    {
        return this.weight;
    }

    public void addEdge()
    {
        this.hasEdge = true;
    }

    public boolean removeEdge()
    {
        this.hasEdge = false;
        return this.hasEdge;
    }

    public boolean hasEdge()
    {
        return this.hasEdge;
    }
}