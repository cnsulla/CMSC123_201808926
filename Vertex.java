public class Vertex
{
    boolean hasEdge;

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