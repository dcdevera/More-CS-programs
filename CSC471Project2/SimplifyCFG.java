
/**
 * Write a description of class SimplifyCFG here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class SimplifyCFG
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        List<CFGElement> inputCFG = new ArrayList<>();
        List<String> checkVar = new ArrayList<>();    //check that variables are not repeated

        List<CFGElement> removeEmptyCFG;
        List<String> nullVar = new ArrayList<>();
        List<String> oldNull = new ArrayList<>();
        String input = "";
        
        List<CFGElement> removeUselessCFG;
        List<String> useless = new ArrayList<>();

        //user enters original CFG//

        //first enter all variables
        System.out.println("First enter all variables (non-terminals)");

        while ( !(input.equals("-1")) ) 
        {
            System.out.println("Input a variable. Enter -1 to stop entering variables");
            input = scanner.nextLine();

            if ( !(input.equals("-1")) && !(checkVar.contains(input)) ) 
            {  
                //check that input is not already in CFG
                CFGElement temp = new CFGElement(input);
                inputCFG.add(temp);
                checkVar.add(input);
            }
        }

        //then enter rules for variables
        System.out.println("Now enter the rule(s) for the corresponding variable one at a time. Enter 0 for empty");

        for (CFGElement temp : inputCFG) 
        {
            input = ""; //reset input
            while ( !(input.equals("-1")) ) 
            {
                System.out.println("Enter a rule for " + temp.getVar() + ". Enter -1 to finish entering rules for this variable");
                System.out.print(temp.getVar() + "--> ");
                input = scanner.nextLine();

                if ( !(input.equals("-1")) ) 
                {
                    temp.addRule(input);
                }
            }
        }

        //print input CFG
        for (CFGElement temp : inputCFG) 
        {
            System.out.println(temp);
        }


        //remove e-rules//

        removeEmptyCFG = inputCFG;  //copy original CFG


        //Step 1: For all rules A→ε, put A into V (the set of nullable variables)
        for (CFGElement temp : removeEmptyCFG) 
        {                //for each element in CFG (each variable with its rules)
            List<String> tempRules = temp.getRules();           //get list of rules of the variable
            if (tempRules.contains("0")) 
            {                      //if the rules of a variable contains null
                nullVar.add(temp.getVar());      //add the variable to the set of nullable variables
                tempRules.remove("0");                       //and remove the rule from the variable (this is part of Step 3)
                temp.setRules(tempRules);                       //(save the modified rules back into the variable)
            }
        }

        // (debug) print list of nullable variables
        System.out.println("List of nullable variables part 1");
        for (String var : nullVar) 
        {
            System.out.print(var + " ");
        }
        System.out.println();


        //Step 2: For all rules B → A1, A2,...,An, where A1, A2,...,An are in V, put variable B into V
        for (CFGElement temp : removeEmptyCFG) 
        {                             //for each element in CFG
            for (int j = 0; j < nullVar.size(); j++) 
            {             //for each variable in nullable set
                int nullIndex = temp.checkContains(nullVar.get(j));
                if (nullIndex != -1) 
                {                                       //if rules of current element contain a nullable variable
                    if (!(nullVar.contains(temp.getVar()))) 
                    { 
                        //check if this variable is already in set
                        nullVar.add(temp.getVar());           //add variable to nullable set
                    }
                    List<String> tempRules = temp.getRules();            //get rules of variable
                    oldNull.add(tempRules.get(nullIndex));          //save nullable rule (for later)
                }
            }
        }

        //(debug) print list of nullable variables
        System.out.println("List of nullable variables part 2");
        for (String var : nullVar) 
        {
            System.out.print(var + " ");
        }
        System.out.println();


        //Step 3: Delete all ε-rules (partly done earlier)

        // (debug) print CFG
        for (CFGElement temp : removeEmptyCFG) 
        {
            System.out.println(temp);
        }


        //Step 4: Add rules in which nullable symbols (V) are replaced by ε in all possible combinations
        for (CFGElement temp : removeEmptyCFG) 
        {
            for (int j = 0; j < oldNull.size(); j++) 
            {
                List<String> tempRules = temp.getRules();
                String oldRule = oldNull.get(j);

                if (tempRules.contains(oldRule)) 
                {
                    //makes a char array of a rule so that it can remove nullable variables
                    char[] ruleToChar = oldRule.toCharArray();
                    char[] newRuleToAdd = new char[oldRule.length()-1];
                    int index = 0;

                    for(char c : ruleToChar)
                    {
                        String newChar = Character.toString(c);
                        if(!(nullVar.contains(newChar)))
                        {
                            newRuleToAdd[index] = c;
                            index++;
                        }
                    }

                    String newRule = new String(newRuleToAdd);

                    //add new rule to CFG
                    tempRules.add(newRule);

                    //save modified rules
                    temp.setRules(tempRules);
                }
            }
        }
        System.out.println("");
        removeUselessCFG = removeEmptyCFG;
        System.out.println("Removing Useless rules");
        for (CFGElement temp : removeUselessCFG) 
        {
            System.out.println(temp);
        }
        
        
    }
}
