/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Test
{
   public static void main(String[] args)
   {
       //Creation of linked list
       singleLList<Node> myList = new singleLList<Node>();
       //Creation of nodes
       Node<String> s1 = new Node<String>("Bob");
       Node<String> s2 = new Node<String>("Sara");
       Node<String> s3 = new Node<String>("Ann");
       Node<String> s4 = new Node<String>("Jim");
       Node<String> s5 = new Node<String>("Billy");
       int i = 0;
       //Adding nodes to linked list using addFirst
       myList.addFirst(s1);
       myList.addFirst(s2);
       myList.addFirst(s3);
       myList.addFirst(s4);
       while(i < myList.size())
       {
           System.out.println(myList.get(i).data);
           i++;
       }
       System.out.println("");
       //Removing using removerFirst
       myList.removeFirst();
       for(i = 0; i < myList.size();i++)
       {
           System.out.println(myList.get(i).data);
           i++;
       }
       System.out.println("");
       //Using addAfter
       myList.addAfter(s5,s2);
       for(i = 0; i < myList.size();i++)
       {
           System.out.println(myList.get(i).data);
           i++;
       }
       System.out.println("");
       //Using removeAfter
       myList.removeAfter(s5);
       for(i = 0; i < myList.size();i++)
       {
           System.out.println(myList.get(i).data);
           i++;
       }
       
       
    }
}
