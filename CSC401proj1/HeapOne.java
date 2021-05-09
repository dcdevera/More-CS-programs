
/**
 * Write a description of class HeapOne here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HeapOne<E>
{
    private E[] heap;
    private int size;
    private int capacity;
    private final int DEFAULT_MAX_CAPACITY = 5;

    //default
    public HeapOne() 
    {
        this.capacity = DEFAULT_MAX_CAPACITY;
        this.size = 0;
        heap = (E[]) new Object[this.capacity];
    }

    //overloaded
    public HeapOne(int capacity) 
    {
        this.capacity = capacity;
        this.size = 0;
        heap = (E[]) new Object[this.capacity];
    }

    //insert to heap and compare parent
    public void insert(E obj) 
    {
        if(size >= capacity) 
        {
            return;
        }
        heap[size] = obj;
        int temp = size++;

        //compare new object with parent then swap
        while(temp > 0 && ((classTime)heap[temp]).getStartTime() < ((classTime) heap[parent(temp)]).getStartTime()) 
        {
            swap(temp, parent(temp));
            temp = parent(temp);
        }
    }

    //swap objects in heap
    public void swap(int x, int y)
    {
        E temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    //return parent index
    private int parent(int i) 
    {
        if(i == 0)
        {
            return 0;
        }
        return ((i-1) / 2);
    }

    //return left child
    public int leftChild(int i)
    {
        return 2*i+1;
    }

    //return right child
    public int rightChild(int i)
    {
        return 2*i+2;
    }

    //check if node is leaf
    public boolean isLeaf(int i) 
    {
        if(i >= (size/2) && i <= size) 
        {
            return true;
        }
        return false;
    }

    //remove method
    public Object remove() 
    {
        if(size == 0)
        {
            System.out.println("Heap is empty");
            return null;
        }
        E temp = heap[0];
        heap[0] = heap[size - 1];
        size--;
        reHeap(0);
        return temp;

    }

    //redo heap
    public void reHeap(int i) 
    {
        int l, r, min;
        l = leftChild(i);
        r = rightChild(i);
        min = l;
        //check if index is in range
        if (r >= size) 
        {
            if (l >= size)
            {
                return;
            }
        }
        //compare left and right children
        else 
        {
            if (((classTime) heap[l]).getStartTime() < ((classTime)heap[r]).getStartTime())
            {
                min = l;
            }
            else
            {
                min = r;
            }
        }
        //compare times then swap
        if (((classTime)heap[i]).getStartTime() > ((classTime)heap[min]).getStartTime()) 
        {
            swap(i, min);
            reHeap(min);
        }
    }

    //print heap
    public String toString() 
    {
        String s = "";
        for (int i = 0; i < size / 2 || (size == 1 && i == 0); i++)
        {
            s += "Parent: " + printNode(i)+ " Left child: " + printNode(leftChild(i)) + " Right Child:" + printNode(rightChild(i)) + "\n";
        }
        if(size == 0)
        {
            s = "Heap is empty \n";
        }
        return s;
    }

    //print specific node
    public String printNode(int i)
    {
        String s = "";
        // checks to see if number is within the size of heap
        if(i >= size) 
        {
            s = "Does not exist";
            return s;
        }
        else
        {
            s = ((classTime)heap[i]).toString();
            return s;
        }
    }

    //return node
    public Object returnNode(int i)
    {
        return heap[i];
    }

    //return size
    public int getSize()
    {
        return size;
    }

    public void swap(E obj)
    {
        heap[0] = obj;
    }

    public classTime peek()
    {
        return (classTime) heap[0];
    }
}
