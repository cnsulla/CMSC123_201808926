import java.util.*;

public class DArray<T>
{
    private T[] arr = (T[]) new Object[0];

    public void insertValue(T input)
    {
        T[] arr1 = (T[]) new Object[arr.length+1];

        for(int i = 0; i < arr.length; i++)
        {
            arr1[i] = arr[i];
        }

        arr1[arr.length] = input;
        arr = arr1;
    }

    public T deleteValue()
    {
        T[] arr1 = (T[]) new Object[arr.length-1];

        T topmost = arr[arr.length - 1];

        for(int i = 0; i < arr1.length; i++)
        {
            arr1[i] = arr[i];
        }        
        arr = arr1;
        return topmost;
    }

    public boolean isEmpty()
    {
        if (arr.length == 0)
            return true;
        return false;
    }

    public T peek()
    {
        if (arr.length==0)
        {
            return null;
        }
        T top = arr[arr.length-1];
        return top;
    }

    public int getSize()
    {
        return arr.length;
    }
}