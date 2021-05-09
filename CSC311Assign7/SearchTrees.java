
/**
 * Write a description of class SearchTrees here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class SearchTrees
{
    private int vertex;
    private LinkedList<Integer> adjBFS[];
    private LinkedList<Integer> adjDFS[];
    
    public SearchTrees(int v)
    {
        vertex = v;
        adjBFS = new LinkedList[v];
        adjDFS = new LinkedList[v];
        
        for(int i = 0;i < v;i++)
        {
            adjBFS[i] = new LinkedList();
            adjDFS[i] = new LinkedList();
        }
    }
    
    public void addEdge(int x, int y)
    {
        adjBFS[x].add(y);
        adjDFS[x].add(y);
    }
    
    public void BFS(int x)
    {
        boolean visited[] = new boolean[vertex];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[x] = true;
        queue.add(x);
        
        while(queue.size() != 0)
        {
            x = queue.poll();
            System.out.print(x + " ");
            Iterator<Integer> iter = adjBFS[x].listIterator();
            
            while(iter.hasNext())
            {
                int nextVertex = iter.next();
                if(!visited[nextVertex])
                {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
    }
    
    public void DFSRecursive(int x)
    {
        boolean visited[] = new boolean[vertex];
        visited[x] = true;
        System.out.println(x + " ");
        Iterator<Integer> iter = adjDFS[x].listIterator();
        
        while(iter.hasNext())
        {
            int nextVertex = iter.next();
            if(!visited[nextVertex])
            {
                DFSRecursive(nextVertex);
            }
        }
    }
    
    public void DFS(int x)
    {
        boolean visited[] = new boolean[x];
        DFSRecursive(x);
    }
    
    public static void main(String[] args)
    {
        SearchTrees tree = new SearchTrees(5);
        
        tree.addEdge(0,1);
        tree.addEdge(0,4);
        tree.addEdge(1,2);
        tree.addEdge(1,3);
        tree.addEdge(1,4);
        tree.addEdge(2,3);
        tree.addEdge(3,4);
        
        System.out.println("Breadth First Search Tree");
        tree.BFS(0);
        System.out.println("");
        System.out.println("Depth First Search Tree");
        tree.DFS(0);
    }
}
