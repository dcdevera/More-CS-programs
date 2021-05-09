
/**
 * Write a description of class SNQ here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class SNQ
{
    public static void main(String[] args)
    {
        ArrayDeque<Integer> stack1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> queue1 = new ArrayDeque<Integer>();
        
        stack1.push(1);
        stack1.push(15);
        stack1.push(23);
        stack1.push(44);
        stack1.push(4);
        stack1.push(99);
        System.out.println("Stack 1:");
        System.out.println(stack1);
        System.out.println("----------------------------");
        
        while(stack1.size() > 0)
        {
            int num = stack1.pop();
            stack2.push(num);
            queue1.offer(num);
        }
        
        System.out.println("Stack 1 transferred to Stack 2:");
        System.out.println(stack2);
        System.out.println("----------------------------");
        System.out.println("Stack 1 transferred to Queue");
        System.out.println(queue1);
        System.out.println("----------------------------");
        System.out.println("Stack 2 printed");
        while(stack2.size() > 0)
        {
            int result = stack2.pop();
            System.out.println(result);
        }
        System.out.println("----------------------------");
        System.out.println("Queue printed");
        while(queue1.size() > 0)
        {
            int result2 = queue1.poll();
            System.out.println(result2);
        }
    }
}
