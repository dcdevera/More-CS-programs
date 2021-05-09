
/**
 * Write a description of class nfadfa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class nfadfa
{
    static String line = null;
    static String line1 = null;
    static String line2 = null;
    static String line3 = null;
    static String[] state1;
    static String[] state2;
    static String[] state3;
    static String[] state4;
    static String[] empty;
    public static void main(String[] args) throws IOException
    {
        File nfa = new File("nfa.txt");
        String read;
        String transitionTable;
        List<Integer> states = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new FileReader("nfa.txt"));
        while((read = br.readLine()) != null)
        {
            transitionTable = read;
            System.out.println(transitionTable);
            
            line = br.readLine();
            line1 = br.readLine();
            line2 = br.readLine();
            line3 = br.readLine();
            
            state1 = line.split(",");
            state2 = line1.split(",");
            state3 = line2.split(",");
            //state4 = line3.split(",");
            
            System.out.println("State set of equivalent DFA");
            for(int i = 1; i < transitionTable.length(); i++)
            {
                states.add(i);
                System.out.print(states);
            }
        }
    }
}
