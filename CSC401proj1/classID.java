
/**
 * Write a description of class classID here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class classID
{
    private ArrayList <classTime> room;
    int id; 
    int endTime;
    int interval;
    public classID(int id, int i)
    {
        this.id = id;
        this.interval = i;
        room = new ArrayList<classTime>(i);
        this.endTime = 0;
    }

    public String toString() 
    {
        return "Class id: " + id + " " + room.toString() + " ";
    }

    public int getEndTime()
    {
        return this.endTime;
    }

    public void setEndTime(int end)
    {
        this.endTime = end;
    }

    public Boolean add(classTime ct)
    {
        if(ct.getStartTime() >= this.endTime)
        {
            room.add(ct);
            setEndTime(ct.getEndTime());
            return true;
        }
        else
        {
            return false;
        }
    }
}
