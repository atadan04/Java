import java.util.Arrays;

public class MyList {
    private Node head;
    private int size;
    public void add(int value)
    {

        if (head == null)
        {
            head = new Node(value);

        }
        else{
            Node temp = head;
        while(temp.getNext()!=null)
        {
            temp = temp.getNext();

        }
            temp.setNext(new Node(value));


        }
        size++;
    }
    public int get(int index)
    {
        int ind = 0;
        Node temp = head;
        while (temp!=null)
        {
            if (ind==index)
            {
                return temp.getValue();
            }
            else
            {
                temp = temp.getNext();
                ind++;
            }

        }
        throw new IllegalArgumentException ("Index is outside");
    }
    public void remove(int index)
    {
        Node temp = head;
        int ind = 0;
        if (index == 0)
        {
            head = head.getNext();
            size--;
            return;
        }
        while(temp!=null)
        {
            if ((ind) == index-1 )
            {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            }
            else
            {
                ind++;
                temp = temp.getNext();
            }

            // [1]->[3]->null
        }
    }

    public String toString()
    {
        int[] array = new int[size];
        int index = 0;
        Node temp = head;
        for (int i=0;i<size;i++)
        {
            if (temp!=null)
            {
                array[index++] = temp.getValue();
                temp = temp.getNext();

            }
            else
            {
                temp = temp.getNext();
            }
        }
        return Arrays.toString(array);
    }
    private static class Node

    {

        private Node next;
        private int value;
        public Node(int value)
        {
            this.value = value;

        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }
}
