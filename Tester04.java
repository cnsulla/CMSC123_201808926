import java.util.Scanner;

public class Tester04
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Boolean bool = true;
        int choice;
        
        SSUPL sup = new SSUPL();
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
        graph.addDirEdge(0,1);
        graph.addDirEdge(1,3);
        graph.addDirEdge(1,2);
        graph.addDirEdge(0,2);
        graph.addDirEdge(2,3);
        graph.addDirEdge(0,4);
        graph.addDirEdge(4,7);
        graph.addDirEdge(7,8);
        graph.addDirEdge(8,6);
        graph.addDirEdge(4,6);
        graph.addDirEdge(4,2);
        graph.addDirEdge(2,5);

        while(bool = true)
        {
            System.out.println("-------------------------------------------------------------------------");
            graph.printMatrix();
            // System.out.println ("bool = " + bool);
            System.out.println("Directed, unweighted graph has " + graph.getVertices() + " vertices and " + graph.getEdges() + " unique edges.");
            System.out.println("Choose (1-5 only): ");
            System.out.print("MODIFICATIONS:\n1. Add Vertex\n2. Remove Vertex\n3. Add directed edge \n4. Remove edge \n\nQUERIES: \n5. Topological Sort\n\nInput Selection: "); 
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
                    
                    graph.addDirEdge(fa, ta);
                    break;
                case 4:
                    System.out.println("REMOVING AN EDGE");
                    System.out.print("Vertex 1: ");
                    int fr = scan.nextInt();
                    System.out.print("Vertex 2: ");
                    int tr = scan.nextInt();
                    
                    graph.removeEdge(fr, tr);
                    break;
                // case 5:
                //     System.out.println("\nPRINTING: DFS");

                //     graph.depthTraverse();
                //     break;
                case 6:
                    System.out.println("FINDING PATHS TO ALL VERTICES");
                    graph.printVertexList();
                    System.out.print("Source Vertex: ");
                    int dimen = scan.nextInt();
                    int[] arrout = sup.SSUPL(graph, graph.vert.get(dimen));

                    System.out.print("Path:\t");
                    for (int i = 0; i < arrout.length; i++){
                        System.out.print(arrout[i]+"\t ");
                    }
                    System.out.println();
                    System.out.print("Vertex:\t");
                    for (int i = 0; i < graph.vert.size(); i++){
                        if (graph.vert.get(i) == graph.vert.get(dimen))
                        {
                            System.out.print("[SRC]\t");
                        }
                        else
                            System.out.print(graph.vert.get(i).getName()+"\t ");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("GETTING TOPOLOGICAL SORT");
                    
                    try 
                    {
                        TSort tsort = new TSort();
                        tsort.topologicalSort(graph);
                    }
                    catch (CloneNotSupportedException | InputNotDAGException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;
            }

        }
    }
}