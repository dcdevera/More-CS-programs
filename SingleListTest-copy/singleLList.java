
/**
 * Write a description of class singleLList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class singleLList<E>
{
    public Node<E> head = null;
    public int size = 0;
    public void addFirst(E item)
    {
        head = new Node<E>(item, head);
        size++;
    }
    
    public void addAfter(Node node, E item)
    {
        node.next = new Node(item, node.next);
        size++;
    }
    
    public E removeAfter(Node node)
    {
        Node temp = node.next;
        if(temp != null)
        {
            node.next = temp.next;
            size--;
            return (E)temp.data;
        }
        else
        {
            return null;
        }
    }
    
    public E removeFirst()
    {
        Node<E> temp = head;
        if(head != null)
        {
            head = head.next;
        }
        if(temp != null)
        {
            size--;
            return temp.data;
        }
        else
        {
            return null;
        }
        
    }
    
    public Node getNode(int index)
    {
        Node node = head;
        for(int i = 0; i < index && node != null;i++)
        {
            node = node.next;
        }
        return node;
    }
    
    public E get(int index)
    {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }
    
    public int size()
    {
        return size;
    }
    
    
}
