/**
 * Write a description of class SetsNHash here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class SetsNHash
{
    public static void main(String[] args)
    {
        String[] listA = {"Sam","Norman","Bridget","Mads"};
        String[] listB = {"Sam","Mads","Kelly","Toro"};
        Set<String> a = new HashSet<String>();
        Set<String> b = new HashSet<String>();
        
        for(String s: listA)
        {
            a.add(s);
        }
        
        for(String s: listB)
        {
            b.add(s);
        }
        
        a.addAll(b);
        System.out.println("c = (a U b)");
        System.out.println(a);
        
        //Problem 2 in PDF
        //Problem 3
        Hashtable ht = new Hashtable();
        int index = ht.hashCode() % ht.size();
        String[] table = new String[index];
        if(table[index].equals(null))
        {
            System.out.println("Object not in table");
        }
        else if(table[index].equals(table[index]))
        {
            System.out.println("Object is in table");
        }
        else
        {
            index++;
        }
    }
}
