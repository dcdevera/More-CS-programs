
/**
 * Write a description of class Edge here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Edge
{
    private int dest;
    private int source;
    private int weight;
    
    //Constructors
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
        weight = 1;
    }
    
    public Edge(int source, int dest, int w)
    {
        this.source = source;
        this.dest = dest;
        weight = w;
    }
    
    public boolean equals(Object o)
    {
        if(o instanceof Edge)
        {
            Edge edge = (Edge) o;
            return(source == edge.source && dest == edge.dest);
        }
        else
        {
            return false;
        }
    }
    
    public int getDest()
    {
        return dest;
    }
    
    public int getSource()
    {
        return source;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[(");
        sb.append(Integer.toString(source));
        sb.append(", ");
        sb.append(Integer.toString(dest));
        sb.append(")");
        sb.append(Double.toString(weight));
        sb.append("]");
        return sb.toString();
    }
}
