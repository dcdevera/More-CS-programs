
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node<E>
{
    public E data;
    public Node next;
    
    public Node(E dataItem)
    {
        data = dataItem;
        next = null;
    }
    
    public Node(E dataItem, Node<E> nodeRef)
    {
        data = dataItem;
        next = nodeRef;
    }
    
}    
