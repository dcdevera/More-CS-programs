import java.util.*;
public class NFAtoDFA {

	static List<Delta> deltaNFA = new ArrayList<Delta>();
	static List<Delta> deltaDFA = new ArrayList<Delta>();
	
	public static void main(String[] args) 
	{
		Scanner stringInput = new Scanner(System.in);
		Scanner numInput = new Scanner(System.in);
		int stateNum;
		int alphabetNum;
		int alphabetEx;
		String[] stateNFA;
		String[] alphabetNFA;
		String[] alphabetDFA;
		String ssNFA;	//start state NFA
		String ssDFA;	//start state DFA
		String tempFinal = null;
		String tempTo;
		String tempState;

		List<String> stateDFA = new ArrayList<String>();
		List<String> fsNFA = new ArrayList<String>();	//final state NFA
		List<String> fsDFA = new ArrayList<String>();	//final state DFA
		
		
		/*---NFA---*/
		
		//user input for states
		System.out.println("Enter number of states in the NFA");
		stateNum = numInput.nextInt();
		
		//fill state array
		stateNFA = new String[stateNum];
		for (int i = 0; i < stateNum; i++)
		{	
			stateNFA[i] = "" + (i+1);
		}
		//print state array
		System.out.print("State set of the NFA: {");
		for (int i = 0; i < stateNum; i++) 
		{
			if (i == (stateNum - 1))
			{
				System.out.print(stateNFA[i]);
			}	
			else
			{
				System.out.print(stateNFA[i] + ", ");
			}
		}
		System.out.print("}" + "\n" + "\n");
		
		//get alphabet for NFA
		System.out.println("Enter number of symbols in the alphabet for the NFA (not counting epsilon)");
		alphabetNum = numInput.nextInt();
		alphabetEx = alphabetNum + 1;	//add 1 more space to hold epsilon
		
		//fill alphabet array
		alphabetNFA = new String[alphabetEx];
		alphabetNFA[0] = "epsilon";
		for (int i = 1; i < alphabetEx; i++) 
		{
			alphabetNFA[i] = Character.toString((char)(i+96));
		}
		
		//print alphabet array
		System.out.print("Alphabet of the NFA: {");
		for (int i = 1; i < alphabetEx; i++) 
		{
			if (i == (alphabetEx - 1))
			{	
				System.out.print(alphabetNFA[i]);
			}
			else
			{
				System.out.print(alphabetNFA[i] + ", ");
			}
		}
		System.out.print("}" + "\n" + "\n");
		
		//partially fill NFA delta arraylist
		for (int i = 0; i < stateNum; i++) 
		{
			for (int j = 0; j < alphabetEx; j++) 
			{
				Delta transition = new Delta(stateNFA[i], alphabetNFA[j]);
				deltaNFA.add(transition);
			}
		}
		
		//get transition function
		System.out.println("Enter the transition function for the NFA");
		System.out.println("Enter the number(s) of the states, Example: 2,3 (for inputs that go to multiple states)");
		System.out.println("Don't worry about epsilon, ex: if (3,a)=1 but (1,epsilon)=3 only enter 1 for (3,a) [NOT 1,3]");
		System.out.println("Enter 0 for empty state" + "\n");
		
		for (int i = 0; i < deltaNFA.size(); i++) 
		{
			System.out.print("delta(" + deltaNFA.get(i).getFrom() + ", " + deltaNFA.get(i).getInput() + ") = ");
			tempTo = stringInput.nextLine();
			deltaNFA.get(i).setTo(tempTo);
		}
		System.out.println();
		
		//start state
		System.out.println("Enter the start state (as a number from the state set)");
		ssNFA = stringInput.nextLine();
		
		//final state(s)
		System.out.println("Enter final state(s) (as numbers from the state set), or enter -1 to finish");
		while (fsNFA.isEmpty() || !(tempFinal.equals("-1"))) 
		{
			tempFinal = stringInput.nextLine();
			if (!(tempFinal.equals("-1")))
			{
				fsNFA.add(tempFinal);
			}
				
		}
		
		//final state NFA
		System.out.print("Final state set of NFA: {");
		for (int i = 0; i < fsNFA.size(); i++) 
		{
			if (i == (fsNFA.size() - 1)) 
			{
				System.out.print(fsNFA.get(i));
			}
			else
			{
				System.out.print(fsNFA.get(i) + ", ");
			}
		}
		System.out.print("}" + "\n" + "\n");
	
		/*---DFA---*/
		
		System.out.println("=======Equivalent DFA=======" + "\n");
		
		//alphabet array 
		alphabetDFA = new String[alphabetNum];
		int k = 1;
		for (int i = 0; i < alphabetNum; i++) 
		{
			alphabetDFA[i] = alphabetNFA[k];
			k++;
		}
		
				
		//state set 
		
		//create and add empty state
		stateDFA.add("0");
		
		int emptystate = stateDFA.size();
		
		//add original NFA state
		for (int i = 0; i < stateNum; i++) 
		{
			stateDFA.add(stateNFA[i]);
		}
		
		int originalstate = stateDFA.size();
		
		
		/*transition function of DFA*/
		
		//partially fill transitions (non-combined state)
		for (int i = 0; i < emptystate; i++) 
		{
			for (int j = 0; j < alphabetNum; j++) //first indices are always for empty set
			{ 
				Delta transition = new Delta(stateDFA.get(i), alphabetDFA[j], "0");
				deltaDFA.add(transition);
			}
		}
		
		for (int i = 0; i < deltaNFA.size(); i++) 
		{
			Delta transition = deltaNFA.get(i);
			if (!transition.getInput().equals("epsilon"))
			{
				deltaDFA.add(transition);
			}
		}
		
		//check epsilon transition
		for (int i = 0; i < deltaDFA.size(); i++) 
		{
			for (int j = 0; j < deltaNFA.size(); j++) 
			{
				Delta from = deltaDFA.get(i);
				Delta to = deltaNFA.get(j);
				if (from.getTo().equals(to.getFrom()) && to.getInput().equals("epsilon") && !to.getTo().equals("0")) 
				{
					String temp = from.getTo() + to.getTo();
					temp = sortString(temp);
					from.setTo(temp);
				}
			}
		}
		
		
		//add combined state
		for (int i = 0; i < (stateNum - 1); i++) 
		{
			for (int j = (i+1); j < stateNum; j++) 
			{
				tempState = stateNFA[i] + "," + stateNFA[j];
				stateDFA.add(tempState);
			}
		}
		
		//add state of all state
		tempState = "";
		for (int i = 0; i < stateNum; i++) 
		{
			if (i == (stateNum - 1)) 
			{
				tempState = tempState.concat(stateNFA[i]);
			}
			else
			{
				tempState = tempState.concat(stateNFA[i] + ",");
			}
		}
		stateDFA.add(tempState);
		
		//print state set
		System.out.println("State set of the DFA:");
		System.out.print("{");
		for (int i = 0; i < stateDFA.size(); i++) 
		{
			if (i == (stateDFA.size() - 1))
			{
				System.out.print("{" + stateDFA.get(i) + "}");
			}
			else
			{
				System.out.print("{" + stateDFA.get(i) + "}, ");
			}
		}
		System.out.print("}" + "\n" + "\n");
		
		//print alphabet array
		System.out.print("Alphabet of the DFA: {");
		for (int i = 0; i < alphabetNum; i++) 
		{
			if (i == (alphabetNum - 1)) 
			{
				System.out.print(alphabetDFA[i]);
			}
			else
			{
				System.out.print(alphabetDFA[i] + ", ");
			}
		}
		System.out.print("}" + "\n" + "\n");
		
		//fill combined state
		String newTo;
		for(int i = originalstate; i < stateDFA.size(); i++) 
		{
			for (int j = 0; j < alphabetNum; j++) 
			{
				String state = stateDFA.get(i);
				String alphabet = alphabetDFA[j];
				newTo = search(state, alphabet);
				newTo = sortString(newTo);
				//fix Ex commas
				if (newTo.length() != 0)
				{
					newTo = fixCommas(newTo);
					Delta temp = new Delta(state, alphabet, newTo);
					deltaDFA.add(temp);
				}
			}
		}
		
		//print array
		System.out.println("Transition function of the DFA:");
		for (int i = 0; i < deltaDFA.size(); i++) 
		{
			Delta temp = deltaDFA.get(i);
			System.out.print("delta'({" + temp.getFrom() + "}, " + temp.getInput() + ") = " + "{" + temp.getTo() + "}" + "\n");
		}
		System.out.println();
		
		
		//start state
		
		ssDFA = ssNFA;
		
		//check epsilon transition
		for (int i = 0; i < deltaNFA.size(); i++) 
		{
			Delta temp = deltaNFA.get(i);
			if (temp.getFrom().equals(ssDFA) && temp.getInput().equals("epsilon") && !temp.getTo().equals("0")) 
			{
				ssDFA = ssDFA.concat("," + temp.getTo());
			}
		}
		
		//print start state
		System.out.println("Start state of the DFA = {" + ssDFA + "}" + "\n");
		
		/*final state(s) of DFA*/
		//fill arraylist with DFA
		for (int i = 0; i < fsNFA.size(); i++) 
		{
			fsDFA.add(fsNFA.get(i));
		}
		
		for (int i = 0; i < fsNFA.size(); i++) 
		{
			for (int j = 0; j < stateDFA.size(); j++) 
			{
				String finalNFA = fsNFA.get(i);
				String finalDFA = stateDFA.get(j);
				if (finalDFA.contains(finalNFA)) 
				{
					if (!checkRepeats(fsDFA, finalDFA))
					{
						fsDFA.add(finalDFA);
					}
				}
			}
		}
		
		//print DFA
		System.out.print("Final state set of the DFA = {");
		for (int i = 0; i < fsDFA.size(); i++) 
		{
			if (i == (fsDFA.size() - 1))
			{
				System.out.print("{" + fsDFA.get(i) + "}");
			}
			else
			{
				System.out.print("{" + fsDFA.get(i) + "}, ");
			}
		}
		System.out.println("}");
	}
	
	
	static String search(String state, String alphabet) 
	{
		String to = "";
		for (int i = 0; i < deltaDFA.size(); i++) 
		{
			Delta temp = deltaDFA.get(i);
			if (state.contains(temp.getFrom()) && alphabet.equals(temp.getInput()) && !temp.getTo().equals("0")) 
			{
				to = to.concat(temp.getTo());
			}
		}
		return to;
	}
	
	//sort and removes duplicates
	static String sortString(String temp) 
	{
		char[] tempChars = temp.toCharArray();
		Arrays.sort(tempChars);
		
		StringBuilder newTemp = new StringBuilder();
		if (tempChars.length != 0) 
		{
			newTemp.append(tempChars[0]);
			for (int n = 1; n < tempChars.length; n++) 
			{
				if (tempChars[n] != tempChars[n-1] && tempChars[n] != '0') 
				{
					newTemp.append("," + tempChars[n]);
				}
			}
		}
		temp = newTemp.toString();
		return temp;
	}
	
	
	//returns true if state is already in list
	static boolean checkRepeats(List<String> fs, String state) {
		boolean check = false;
		if (fs.size() < 1) 
		{
			check = false;
		}
		else 
		{
			for (int i = 0; i < fs.size(); i++) 
			{
				if (state.equals(fs.get(i))) 
				{
					check = true;
					break;
				}
				else 
				{
					check = false;
				}
			}
		}
		return check;
	}
	
	static String fixCommas(String input) 
	{
		String fixed;
		if (input.charAt(0) == ',' && input.charAt(1) == ',') 
		{
			fixed = input.substring(2);
		}
		else
		{
			fixed = input;
		}
		return fixed;
	}
}
