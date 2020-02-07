import java.util.Scanner;
import java.util.ArrayList;

public class Tester04
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Boolean bool = true;
        int choice;
        
        SSUPL sup = new SSUPL();
        GraphADT graph = new GraphADT();

        while(bool = true)
        {
            System.out.println("-------------------------------------------------------------------------");
            graph.printAdjList();
            // System.out.println ("bool = " + bool);
            System.out.println("\nDirected, unweighted graph has a total of " + graph.getVertices() + " vertices and " + graph.getEdges() + " edges.");
            System.out.println("Choose (1-7 only): ");
            System.out.print("1. Add Vertex\n2. Remove Vertex\n3. Add directed edge \n4. Remove edge \n5. Depth First Search\n6. SSUPL\n7. Topological Sort\n\nInput Selection: "); 
            choice = scan.nextInt();
            System.out.println("-------------------------------------------------------------------------");
            switch (choice)
            {
                case 1:
                    System.out.println("ADDING A VERTEX");
                    System.out.print("Vertex Name:");
                    String inName = scan.next();
                    
                    graph.addVertex(inName);
                    break;
                case 2:
                    System.out.println("REMOVING A VERTEX");
                    System.out.print("Vertex Name:");
                    graph.printVertexList();
                    int reVertex = scan.nextInt();
                
                    graph.removeVertex(reVertex);
                    break;
                case 3: 
                    System.out.println("ADDING AN EDGE (From 0 to " + (graph.vert.size()-1) + " only.)");
                    graph.printVertexList();
                    System.out.print("Vertex 1: ");
                    int fa = scan.nextInt();
                    System.out.print("Vertex 2: ");
                    int ta = scan.nextInt();
                    // System.out.print("Weight: ");
                    // String wgt = scan.next();
                    
                    graph.addOneWayEdge(fa, ta);
                    break;
                case 4:
                    System.out.println("REMOVING AN EDGE");
                    System.out.print("Vertex 1: ");
                    int fr = scan.nextInt();
                    System.out.print("Vertex 2: ");
                    int tr = scan.nextInt();
                    
                    graph.removeEdge(fr, tr);
                    break;
                case 5:
                    System.out.println("\nPRINTING: DFS");

                    graph.depthTraverse();
                    break;
                case 6:
                    System.out.println("FINDING PATHS TO ALL VERTICES");
                    graph.printVertexList();
                    System.out.print("Source Vertex: ");
                    int dimen = scan.nextInt();
                    int[] arrout = sup.SSUPL(graph, graph.vert.get(dimen));

                    System.out.print("Paths:\t");
                    for (int i = 0; i < arrout.length; i++){
                        System.out.print(arrout[i]+"\t ");
                    }
                    System.out.println();
                    System.out.print("Vertices:\t");
                    for (int i = 0; i < graph.vert.size(); i++){
                        System.out.print(graph.vert.get(i).getName()+"\t ");
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.println("GETTING TOPOLOGICAL SORT");
                    try 
                    {
                        TSort tsort = new TSort();
                        tsort.topologicalSort(graph);
                    }
                    catch (InputNotDAGException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;
            }

        }
    }
}