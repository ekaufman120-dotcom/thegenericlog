
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
    }

    // Returns the name of this StringLog.
    public String getName()
    {
        return "";
    }

    // Returns the logical size of this StringLog.
    public int size()
    {
        return -1;
    }
    
    // Returns true if this list contains no elements.
    public boolean isEmpty()
    {
        return false;
    }
    
    // Returns true if this list is completely full.
    public boolean isFull()
    {
        return false;
    }

    // Appends the specified element to the end of this list.
    public void add(T element)
    {
    }
  
    // Returns the element at the specified position in this list.
    public T get(int index)
    {   
        return null;
    }
    
    // Returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element.
    public int indexOf(T element)
    {
        return -1;
    }
    
    // Returns true if this list contains the specified element.
    public boolean contains(T element)
    {
        return false;
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
        return null;
    }
    
    // Inserts the specified element at the specified position in this list.
    public void add(int index, T element)
    {
    }
    
    // Removes the element at the specified position in this list, and
    // returns the element that was removed.  Any unused array elements
    // are set to null.
    public T remove(int index)
    {
        return null;
    }
    
    // Removes the first occurance of the specified element from this
    // list, if it is present.  Returns true if element was found (and 
    // removed), false otherwise.
    public boolean remove(T element)
    {
        return false;
    }
    
    // Removes all of the elements from this list.
    public void clear()
    {
    }
}
