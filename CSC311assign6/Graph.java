
/**
 * Write a description of class Graph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Graph
{
    int v;
    LinkedList<Integer> adjList[];
    private boolean adjMatrix[][];
    public Graph(int v)
    {
        this.v = v;
        adjList = new LinkedList[v];
        adjMatrix = new boolean[v][v];
        
        for(int i = 0;i < v;i++)
        {
            adjList[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(Graph graph, int src, int dest)
    {
        graph.adjList[src].add(dest);
        graph.adjList[dest].add(src);
        adjMatrix[src][dest] = true;
        adjMatrix[dest][src] = true;
    }
    
    public void printList(Graph graph)
    {
        for(int i = 0;i < graph.v;i++)
        {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for(Integer ii: graph.adjList[i])
            {
                System.out.print(" -> " + ii);
            }
            System.out.println("\n");
        }
    }
    
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for(int i =0;i < v;i++)
        {
            s.append(i + ": ");
            for(boolean j: adjMatrix[i])
            {
                s.append((j?1:0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    
    public static void main(String[] args)
    {
        int v = 7;
        Graph g = new Graph(v);
        g.addEdge(g,0,1);
        g.addEdge(g,0,3);
        g.addEdge(g,0,4);
        g.addEdge(g,0,5);
        g.addEdge(g,1,2);
        g.addEdge(g,1,3);
        g.addEdge(g,1,4);
        g.addEdge(g,1,6);
        g.addEdge(g,2,3);
        g.addEdge(g,2,5);
        g.addEdge(g,2,6);
        g.addEdge(g,3,4);
        g.addEdge(g,3,5);
        g.addEdge(g,3,6);
        g.addEdge(g,4,5);
        g.addEdge(g,5,6);
        
        System.out.println("Adjacency List");
        g.printList(g);
        System.out.println("Adjacency Matrix");
        System.out.println(g.toString());
    }
}
