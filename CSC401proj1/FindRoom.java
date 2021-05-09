
/**
 * Write a description of class FindRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class FindRoom
{
    public void start()
    {
        ArrayList<classTime> room = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of intervals: ");
        int x = input.nextInt();
        HeapOne knightClass = new HeapOne(x);
        HeapOne calvaryClass = new HeapOne(x);
        System.out.println("Please enter start time for intervals:");
        int startTime = input.nextInt();
        System.out.println("Please enter end time for intervals: ");
        int endTime = input.nextInt();
        
        //add intervals
        for(int i = 0; i < x; i++)
        {
            room.add(randomInterval(i, startTime, endTime));
        }
        
        //print array with intervals
        System.out.println("Initial Intervals: ");
        for(int i = 0; i < x; i++)
        {
            System.out.println(room.get(i).toString());
        }
        
        //setting intervals for scheduling
        for(int i = 0; i < x; i++)
        {
            knightClass.insert(room.get(i));
        }
        
        int id = 0;
        ArrayList<classTime> moonCell = new ArrayList<>();
        for(int i = 0; i < x; i++)
        {
            moonCell.add((classTime)knightClass.remove());
        }
        
        //setting intervals for partitioning
        for(int i = 0; i < x; i++)
        {
            calvaryClass.insert(room.get(i));
        }
        ArrayList<classTime> fuyukiCity = new ArrayList<>();
        for(int i = 0; i < x; i++)
        {
            fuyukiCity.add((classTime)calvaryClass.remove());
        }
        
        //making classrooms for scheduling
        classID exCalibur = new classID(id, x);
        for(int i = 0; i < x; i++)
        {
            if((exCalibur.add((fuyukiCity.get(i)))))
            {
                continue;
            }

        }
        
        //print interval scheduling
        System.out.println("Interval Scheduling: ");
        System.out.println(exCalibur.toString());
        
        //making classrooms for partitioning
        classID saber = new classID(id, x);
        ArrayList<classID> enter = new ArrayList<>(x);
        int index = 0;
        enter.add(saber);
        
        //print interval scheduling
        System.out.println("Interval Partitioning: ");
        for(int i = 0; i < x; i++)
        {
            for(int j =0; j<=id;j++) 
            {
                if((enter.get(index).add(moonCell.get(i))))
                {
                    index = 0;
                    break;
                }
                else if(index == id) 
                {
                    id++;
                    classID caster = new classID(id, x);
                    enter.add(caster);
                    enter.get(id).add(moonCell.get(i));
                    index = 0;
                    break;
                }
                else
                {
                    index++;
                }
            }
        }
        for(int i = 0; i < enter.size(); i++)
        {
            System.out.println(enter.get(i).toString());
        }
    }
    
    //random number generator
    public int randomNum(int start, int end)
    {
        int rand;
        rand = ((int)(Math.random()* (end-start)) + start);
        return rand;
    }
    
    //random interval generator
    public classTime randomInterval(int i, int startTime, int endTime)
    {
        int start, end;
        start = randomNum(startTime, endTime);
        end = randomNum(startTime, endTime);
        while(end <= start)
        {
            end = randomNum(startTime, endTime);
        }

        classTime finalTime = new classTime(i, start, end);

        return finalTime;

    }
}
