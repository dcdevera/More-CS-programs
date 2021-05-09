import java.util.*;
public class CopyOfCarList<E extends Comparable<E>> implements Iterable<E> {
    LinkedList<E> theList = new LinkedList<>();
    
    public void add(E obj) {
        ListIterator<E> iter = theList.listIterator();
        while(iter.hasNext())
        {
            if(obj.compareTo(iter.next()) < 0)
            {
                iter.previous();
                iter.add(obj);
                return;
            }
        }
        iter.add(obj);
    }

    public E get(int index) {
       return theList.get(index);
    }

    public Iterator<E> iterator() {
        return theList.iterator();
    }

    public int size(){
        return theList.size();
    }

    public void remove(E obj){
        theList.remove(obj);
        
    }

}
     
