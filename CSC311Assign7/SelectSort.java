
/**
 * Write a description of class SelectSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class SelectSort
{
    public static void main(String[] args)
    {
        int array[] = {40,35,80,75,60,90,70,75,50,22};
        System.out.println("Starting Array");
        for(int i = 0;i < array.length;i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        for(int i = 0;i < array.length-1;i++)
        {
            int min = i;
            for(int j = i+1;j < array.length;j++)
            {
                if(array[j] < array[min])
                {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        System.out.println("Sorted Array");
        for(int i = 0;i < array.length;i++)
        {
            System.out.print(array[i] + " ");
        }
        
    }
}
