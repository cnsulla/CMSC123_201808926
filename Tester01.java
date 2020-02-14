import java.util.Scanner;

public class Tester01
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Boolean bool = true;
        int choice;
        

        GraphADT graph = new GraphADT();
        //0-1,1-3,1-2,0-2,2-3,0-4,4-7,7-8,8-6,6-4,4-2,2-5
        graph.addVertex("A");//0
        graph.addVertex("B");//1
        graph.addVertex("C");//2
        graph.addVertex("D");//3
        graph.addVertex("E");//4
        graph.addVertex("F");//5
        graph.addVertex("G");//6
        graph.addVertex("H");//7
        graph.addVertex("I");//8
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(0,4);
        graph.addEdge(4,7);
        graph.addEdge(7,8);
        graph.addEdge(8,6);
        graph.addEdge(6,4);
        graph.addEdge(4,2);
        graph.addEdge(2,5);

        while(bool = true)
        {
            System.out.println("-------------------------------------------------------------------------");
            graph.printMatrix();
            graph.printBinaryRelation();
            System.out.println("Undirected, unweighted graph has " + graph.getVertices() + " vertices and " + graph.getEdges() + " unique edges.");
            System.out.println("Choose (1-7 only): ");
            System.out.print("MODIFICATIONS:\n1. Add Vertex\n2. Remove Vertex\n3. Add edge \n4. Remove edge \n\nQUERIES: \n5. Show Adjacency Matrix\n6. Show adjacency list\n7. Check connectedness\n\nInput Selection: "); 
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
                    System.out.println("CHECKING CONNECTEDNESS ");
                    System.out.print("Vertex 1: ");
                    int fw = scan.nextInt();
                    System.out.print("Vertex 2: ");
                    int tw = scan.nextInt();

                    
                    if (graph.checkConnected(fw, tw))
                        System.out.println(graph.vert.get(fw).getName() + " and " + graph.vert.get(tw).getName() +" are connected.");
                    else 
                        System.out.println(graph.vert.get(fw).getName() + " and " + graph.vert.get(tw).getName() +" are not connected.");
                    break;
            }

        }
    }
}