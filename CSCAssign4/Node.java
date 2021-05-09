
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class Node<E> implements Serializable
{
    public E data;
    public Node<E> left;
    public Node<E> right;
    
    public Node(E data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public String toString()
    {
        return data.toString();
    }
}
