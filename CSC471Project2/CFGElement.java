
/**
 * Write a description of class CFGElement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class CFGElement
{
    private String var;
    private List<String> rules;
    
    public CFGElement()
    {
        var = "";
        rules = new ArrayList<>();
    }
    public CFGElement(String v)
    {
        var = v;
        rules = new ArrayList<>();
    }
    public CFGElement(String v, List<String> list)
    {
        var = v;
        rules = list;
    }
    public String getVar()
    {
        return var;
    }
    public void setVar(String v)
    {
        var = v;
    }
    public List<String> getRules()
    {
        return rules;
    }
    public void addRule(String rule)
    {
          rules.add(rule);
    }
    public void setRules(List<String> list)
    {
        rules = list;
    }
    public int checkContains(String v)
    {
        int index = -1;
        
        for(int i = 0;i < rules.size();i++)
        {
            String temp = rules.get(i);
            if(temp.contains(var))
            {
                index = i;
            }
        }
        return index;
    }
    public String toString()
    {
        String result = var + " -> ";
        for(int i = 0;i < rules.size();i++)
        {
            if(i == rules.size() - 1)
            {
                result += rules.get(i);
            }
            else
            {
                result += rules.get(i) + " | ";
            }
        }
        return result;
    }
}
