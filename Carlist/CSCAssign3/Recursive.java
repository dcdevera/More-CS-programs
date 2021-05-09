
/**
 * Write a description of class Recursive here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Recursive
{
    public static void main(String[] args)
    {
       System.out.println("Stutter method");
       System.out.println(stutter("hello"));
       System.out.println("Search for letter method");
       System.out.println(search("hello","h"));
    }
    
    public static String stutter(String s)
    {
        if(s.equals(null) || s.length() < 1)
        {
            return "";
        }
        else
        {
            return s.charAt(0) + "" + s.charAt(0) + "" + stutter(s.substring(1));
        }
    }
    
    public static String search(String s, String l)
    {
        if(s.equals(null) || s.length() == 0)
        {
            return "not a string";
        }
        else
        {
            String next = s.substring(1);
            search(next,l);
            return l + " is found in " + s;
        }
    }
    
}
