
/**
 * Write a description of class classRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class classTime
{
    private int interval;
    private int startTime;
    private int endTime;
    public classTime(int i, int start, int end)
    {
        this.interval = i;
        this.startTime = start;
        this.endTime = end;
    }

    public int getInterval()
    {
        return this.interval;
    }
    
    public void setInterval(int i)
    {
        this.interval = i;
    }

    public int getStartTime()
    {
        return this.startTime;
    }
    
    public void setStartTime(int start)
    {
        this.startTime = start;
    }

    public int getEndTime()
    {
        return this.endTime;
    }

    public void setEndTime(int end)
    {
        this.endTime = end;
    }

    public String toString()
    {
        String s = ("[" + this.interval + ", (" + this.startTime + ", " + this.endTime + ")]");
        return s;
    }
}
