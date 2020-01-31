import java.util.Scanner;

public class Tester01
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Boolean bool = true;
        int choice;

        GraphADT graph = new GraphADT();

        while(bool = true)
        {
            // System.out.println ("bool = " + bool);
            System.out.println("\nUndirected, unweighted graph has a total of " + graph.getVertices() + " vertices and " + graph.getEdges() + " edges.");
            System.out.println("Choose (1-7 only): ");
            System.out.print("1. Add Vertex\n2. Remove Vertex\n3. Add edge \n4. Remove edge \n5. Show Adjacency Matrix\n6. Show adjacency list\n7. Show weight of an edge\n8. Depth First Search\nInput Selection: "); 
            choice = scan.nextInt();

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
                    String reName = scan.next();
                
                    graph.removeVertex(reName);
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
                    
                    graph.addEdge(fa, ta);
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
                    graph.printMatrix();
                    break;
                case 6:
                    graph.printAdjList();
                    break; 
                case 7:
                    System.out.println("PRINTING WEIGHT ");
                    System.out.print("Vertex 1: ");
                    int fw = scan.nextInt();
                    System.out.print("Vertex 2: ");
                    int tw = scan.nextInt();

                    graph.printWeights(fw, tw);
                    break;
                case 8:
                    System.out.println("\nPRINTING: DFS");

                    graph.depthTraverse();
                    break;
            }

        }
    }
}