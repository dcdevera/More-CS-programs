
/**
 * Write a description of class Graph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Graph
{
    int size;
    LinkedList<Integer> BFS[];
    
    public static void main(String[] args)
    {
        ArrayList<Node> nodeList = new ArrayList<Node>(0);
        ArrayList<Edge> edgeList = new ArrayList<Edge>(0);
        
        System.out.println("How many vertices will the graph have?");
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        Graph BFS = new Graph(v);
        for(int i = 0; i < v; i++)
        {
            nodeList.add(new Node(i));
        }
        //make random graph
        Random rand = new Random();
        int min = 1;
        int max = 5 * v;    //used to make the random weights larger
        for(int i = 0; i < v; i++)
        {
            for(int j = i + 1; j < v; j++)
            {
                double x = Math.random();
                if(x <= 0.25)
                {
                    int randomWeight = rand.nextInt((max - min) + 1) + min;
                    nodeList.get(i).addEdge(j,randomWeight);
                    nodeList.get(j).addEdge(i,randomWeight);
                    edgeList.add(new Edge(i,j,randomWeight));
                }
            }
        }
        System.out.println("");
        //print nodes
        System.out.print("Node list: {");
        for(int i = 0; i < v; i++)
        {
            System.out.print(nodeList.get(i).getNID() + ",");
        }
        System.out.print("}");
        System.out.println("");
        //print edges
        System.out.println("");
        System.out.print("Edge list: {");
        for(int i = 0; i < edgeList.size(); i++)
        {
            System.out.print(edgeList.get(i).toString() + ",");
        }
        
        System.out.print("}");
        System.out.println("");
        
        System.out.println("Enter Start Node: ");
        int startNode = input.nextInt();
        //add nodes to BFS
        for(int i = 0; i < v; i++)
        {
            for(int j = i+1; j < v; j++)
            {
                BFS.addEdge(BFS,nodeList.get(i).getNID(),nodeList.get(j).getNID());
            }
        }
        System.out.println("");
        //print BFS
        BFS.printList(BFS);
        
    }
    
    public Graph(int size)
    {
        this.size = size;
        BFS = new LinkedList[size];
        
        for(int i = 0;i < size;i++)
        {
            BFS[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(Graph graph, int src, int dest)
    {
        graph.BFS[src].add(dest);
        graph.BFS[dest].add(src);
    }
    
    public void printList(Graph graph)
    {
        for(int i = 0;i < graph.size;i++)
        {
            System.out.println("Nodes connected to node " + i);
            System.out.print(i);
            for(Integer ii: graph.BFS[i])
            {
                System.out.print(" -> " + ii);
            }
            System.out.println("\n");
        }
    }
}
