
/**
 * This LinkedLog object represents a Log ADT implemented as
 * a LinkedList using the EnhancedLogInterface.
 * 
 * @author 
 * @version 
 */
public class LinkedLog<T> implements EnhancedLogInterface<T>
{
    private LLNode<T> log;
    private String name;
    private int size;

    public LinkedLog(String name)
    {
        this.log = null;
        this.name = name;
        this.size = 0;
    }
    
    // returns the name of this StringLog
    public String getName() { return this.name; }

    // returns the logical size of this StringLog
    public int size() { return this.size; }
    
    // returns true if this list contains no elements
    public boolean isEmpty() { return this.size == 0; }
    
    // returns true if this list is completely full
    //     so... never?
    public boolean isFull() { return false; }

    // appends the specified element to the end of this list
    public void add(T element) { add(this.size, element); }
  
    // returns the element at the specified position in this list
    public T get(int index)
    {
        if(index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Index "+index+" is not in indices [0, "+(this.size-1)+"].");
        }
        LLNode<T> curNode = log;
        for(int i = 0; i < index; i++)
        {
            curNode = curNode.getLink();
        }
        return curNode.getInfo();
    }
    
    // returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element
    public int indexOf(T element)
    {
        LLNode<T> curNode = log;
        int index = 0;
        while(curNode != null)
        {
            if(curNode.getInfo().equals(element))
            {
                return index;
            }
            curNode = curNode.getLink();
            index++;
        }
        return -1;
    }
    
    // returns true if this list contains the specified element
    public boolean contains(T element)
    {
        return indexOf(element) != -1;
    }
    
    // returns a formatted string representation of this StringLog
    public String toString()
    {
        String result = "Log: " + name + "\n";
        LLNode<T> curNode = log;
        int count = 0;
    
        while (curNode != null)
        {
            count++;
            result += count + ". " + curNode.getInfo() + "\n";
            curNode = curNode.getLink();
        }
    return result;
    }
    
    // replaces the element at the specified position in this list
    // with the specified element
    public T set(int index, T element)
    {
        if(index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Index "+index+" is not in indices [0, "+(this.size-1)+"].");
        }
        LLNode<T> curNode = log;
        for(int i = 0; i < index; i++)
        {
            curNode = curNode.getLink();
        }
        T oldInfo = curNode.getInfo();
        curNode.setInfo(element);
        return oldInfo;
    }
    
    // inserts the specified element at the specified position in this list
    public void add(int index, T element)
    {
        if(index < 0 || index > this.size)
        {
            throw new IndexOutOfBoundsException("Index "+index+" is not in indices [0, "+(this.size)+"].");
        }
        LLNode<T> curNode = log;
        this.size++;
        if(index == 0)
        {
            LLNode<T> newNode = new LLNode<T>(element);
            newNode.setLink(log);
            log = newNode;
        }
        else{
            //its index-1 because otherwise the node would be added at the wrong index
            for(int i = 0; i < index-1; i++)
            {
                curNode = curNode.getLink();
            }
            LLNode<T> newNode = new LLNode<T>(element);
            newNode.setLink(curNode.getLink());
            curNode.setLink(newNode);
        }
    }
    
    // removes the element at the specified position in this list
    public T remove(int index)
    {
        if(index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Index "+index+" is not in indices [0, "+(this.size-1)+"].");
        }
        else if(index == 0)
        {
            T oldInfo = log.getInfo();
            log = log.getLink();
            this.size--;
            return oldInfo;
        }
        else
        {
            this.size--;
            LLNode<T> curNode = log;
            for(int i = 0; i < index-1; i++)
            {
                curNode = curNode.getLink();
            }
            T oldInfo = curNode.getLink().getInfo();
            LLNode<T> otherNode = curNode.getLink().getLink();
            curNode.setLink(otherNode);
            return oldInfo;
        }
    }
    
    // removes the first occurance of the specified element from this
    // list, if it is present
    // runs the other remove method because its easier that way
    public boolean remove(T element)
    {
        int index = indexOf(element);
        if(index != -1)
        {
            remove(index);
            return true;
        }
        return false;
    }
        
    // removes all of the elements from this list
    public void clear()
    {
        this.log = null;
        this.size = 0;
    }
}
