package MyArrayList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList<T> {
    private static final int INITIAL_CAPACITY = 5;
    private int capacity = 0;
    private Object[] array;
    private int size;
    public MyArrayList()
    {
        array = new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void add(T item)
    {
        if (size<capacity)
        {
            array[size++] = item;
        }
        else
        {

            Object[] newArray = new Object[capacity+=5];
            for (int i=0;i<array.length;i++)
            {
                newArray[i] = array[i];
            }
            array = newArray;
            newArray = null;
            array[size++] = item;
        }

    }
    public T get(int index)
    {
        return (T)array[index];
    }
    public void delete(int index)
    {
        Object[] newArray = new Object[array.length];
        int j = 0;
        for (int i =0;i<array.length;i++)
        {
           if(j == index)
           {
               newArray[i] = array[j+=1];
               j++;

           }
           else
           {
               if (j<array.length)
               newArray[i] = array[j++];

           }



        }
        array = newArray;
        newArray = null;
        size--;
    }
    public void show()
    {
        for (int i =0;i<array.length;i++){
            if (array[i]!=null)
            System.out.print(array[i] + " ");

        }
        System.out.println();


    }

}
