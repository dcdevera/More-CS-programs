
/**
 * Write a description of class HashtableOpen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class HashtableOpen<K, V>
{
    public V remove(Object key)
    {
        int index = find(key);
        if(table[index] == null)
        {
            return null;
        }
        V oldValue = table[index].value;
        table[index] = DELETED;
        numKeys--;
        return oldValue;
    }    
}
