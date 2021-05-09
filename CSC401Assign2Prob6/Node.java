
/**
 * node class, uses arraylist as edge class to connect nodes
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Node
{
    private ArrayList<Edge> nodeList = new ArrayList<Edge>(0);
    
    private int nodeID;
    private boolean nodeVisit = false;
    private Node nodeParent = null;
    
    public Node(int nID)
    {
        this.nodeID = nID;
    }
    
    public int getNID()
    {
        return nodeID;
    }
    
    public void setNID(int nID)
    {
        this.nodeID = nID;
    }
    
    public void addEdge(int x, int w)
    {
        nodeList.add(new Edge(nodeID,x,w));
    }
    
    public Edge getEdge(int x)
    {
        return nodeList.get(x);
    }
    
    public int getNodeWeight(Node n)
    {
        int nID =n.getNID();
        int weight = 0;
        for(int i = 0; i < nodeList.size(); i++)
        {
            if(nodeList.get(i).getDest() == nID)
            {
                weight = nodeList.get(i).getWeight();
            }
        }
        return weight;
    }
}
