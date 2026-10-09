
/**
 * This ArrayLog object represents a Log ADT implemented as
 * a generic data type array using the EnhancedLogInterface.
 * 
 * @author  
 * @version 
 */
@SuppressWarnings("unchecked")  // eliminates compiler warnings from cast below
public class ArrayLog<T> implements EnhancedLogInterface<T>
{
    // Instance variables
    private T[] log;
    private String name;
    private int size;
    
    // Create a new String array with a capacity of 4 elements
    // and assign values to instance variables.
    public ArrayLog(String name)
    {
        // cannot create a generic array object, so has to be cast
        // from an Object back into the generic in order to compile
        this.log = (T[])new Object[4];
        this.name = name;
        this.size = 0; //size of log based on number of elements
    }

    // Returns the name of this StringLog.
    public String getName()
    {
        return this.name;
    }

    // Returns the logical size of this StringLog.
    public int size()
    {
        return this.size;
    }
    
    // Returns true if this list contains no elements.
    public boolean isEmpty()
    {
        return this.size == 0;
    }
    
    // Returns true if this list is completely full.
    public boolean isFull()
    {
        return this.size == this.log.length;
    }

    // Appends the specified element to the end of this list.
    public void add(T element)
    {
        this.size++;
        if(this.size > this.log.length)
        {
            T[] newLog = (T[])new Object[this.log.length * 2];
            for(int i = 0; i < this.log.length; i++)
            {
                newLog[i] = this.log[i];
            }
            this.log = newLog;
        }
        this.log[this.size - 1] = element;
    }
  
    // Returns the element at the specified position in this list.
    public T get(int index)
    {   
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        if(index >= this.size)
        {
            return null;
        }
        return this.log[index];
    }
    
    // Returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element.
    public int indexOf(T element)
    {
        for(int i = 0; i < this.size; i++)
        {
            if(this.log[i].equals(element))
            {
                return i;
            }
        }
        return -1;
    }
    
    // Returns true if this list contains the specified element.
    public boolean contains(T element)
    {
        return indexOf(element) != -1;
    }
    
    // Returns a formatted string representation of this StringLog.
    public String toString()
    {
        String result = "Log: " + name + "\n";
        for (int i = 0; i < size; i++)
        {
            result += (i + 1) + ". " + log[i] + "\n";
        }
        return result;
    }
    
    // Replaces the element at the specified position in this list
    // with the specified element.  Returns what was at that location
    public T set(int index, T element)
    {
        if(index > this.size - 1 || index < 0)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        T old = this.log[index];
        this.log[index] = element;
        return old;
    }
    
    // Inserts the specified element at the specified position in this list.
    public void add(int index, T element)
    {
        if(index > this.size || index < 0)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        this.size++;
        if(this.size > this.log.length)
        {
            T[] newLog = (T[])new Object[this.log.length * 2];
            for(int i = 0; i < this.log.length; i++)
            {
                newLog[i] = this.log[i];
            }
            this.log = newLog;
        }
        for(int i = this.size - 1; i > index; i--)
        {
            this.log[i] = this.log[i - 1];
        }
        this.log[index] = element;
    }
    
    // Removes the element at the specified position in this list, and
    // returns the element that was removed.  Any unused array elements
    // are set to null.
    public T remove(int index)
    {
        if(index > this.size - 1 || index < 0)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        T removed = this.log[index];
        for(int i = index; i < this.size - 1; i++)
        {
            this.log[i] = this.log[i + 1];
        }
        this.log[this.size] = null;
        this.size--;
        if(this.size < this.log.length / 2&&this.log.length > 4)
        {
            T[] newLog = (T[])new Object[this.log.length / 2];
            for(int i = 0; i < this.size; i++)
            {
                newLog[i] = this.log[i];
            }
            this.log = newLog;
        }
        return removed;
    }
    
    // Removes the first occurance of the specified element from this
    // list, if it is present.  Returns true if element was found (and 
    // removed), false otherwise.
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
    
    // Removes all of the elements from this list.
    public void clear()
    {
        this.log = (T[])new Object[4];
        this.size = 0;
    }
}
