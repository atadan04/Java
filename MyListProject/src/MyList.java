public class MyList<T> {
    private int len = 5;
    private Object[] array = new Object[len];
    private int pointer = 0;
    public void add(T obj)
    {
        if (pointer==array.length-1)
        {
            Object[] newArray = new Object[array.length+5];
            System.arraycopy(array,0,newArray,0,pointer);
            array = newArray;
        }
        array[pointer++] = obj;
    }
    public void delete(int index)
    {
        try
        {
            Object [] newArray = new Object[array.length];
            for (int i = 0; i<array.length;i++)
            {
                if (i == index)
                {
                    newArray[i] = array[i+1];
                }
                else {
                    newArray[i] = array[i];
                }
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Индекс находится за пределами");
        }
    }
    public T pow(int index)
    {
        return (T) array[index];
    }
public int count()
{
    return pointer;
}


}
