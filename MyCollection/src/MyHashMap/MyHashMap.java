package MyHashMap;

import java.util.LinkedList;
import java.util.Objects;

public class MyHashMap<K,V> {
    public  Node<K,V>[] arrayNodes = new Node[5];
    private int size = 0;
//    public  Node<K,V>[] initArrayNodes(){
//        arrayNodes = new Node[16];
//        return arrayNodes;
//    }
    public void put(K key,V value)
   {       //initArrayNodes();

            int hash = key.hashCode();
            Node node = new Node(hash,key,value,null);
            int index = node.calculationIndex();
            if (arrayNodes[index]==null)
            {
                arrayNodes[index] = node;
                size++;
            }
            else
            {
                Node temp = arrayNodes[index];
                if (!temp.equals(key))
                {
                    while(temp.getNext()!=null)
                    {
                        temp = temp.getNext();
                        if (temp.getNext()==null)
                        {
                            break;
                        }
                        else
                        {
                            temp = temp.getNext();
                        }
                    }
                    System.out.println("FFDSFSDF");
                    temp.setNext(node);
//                    temp.setValue(value);
                }
                else
                {
                    temp = node;
                }


            }

    }
    public Node<K,V> get(K key)
    {
        int hash = key.hashCode();
        int index = hash & 4;
        if (arrayNodes[index].getKey().hashCode()==hash)
        {
            if (arrayNodes[index].getKey().equals(key))
            {
                return arrayNodes[index];
            }
            else
            {
                Node temp = arrayNodes[index].getNext();
                while(temp!=null)
                {

                    if (temp.getKey().hashCode()==hash)
                    {
                        if (temp.getKey().equals(key))
                        {
                            return temp;
                        }
                        else
                        {
                            continue;
                        }
                    }
                    else
                    {
                        continue;
                    }
                }
            }
        }
        return null;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
class Node<K,V> {

    private Node<K,V> next;
    private int hash ;
    private K key;
    private V value;
    public Node<K,V> getNext(){

        return next;

    }



    public Node(int hash, K key, V value, Node<K,V> next)
    {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
    public void setNext(Node<K,V> node)
    {
        this.next = node;
    }
    public K getKey()
    {
        return key;
    }
    public void setKey(K key)
    {
        this.key = key;
    }
    public V getValue()
    {
        return value;
    }
    public void setValue(V value)
    {
        this.value = value;
    }
    public int calculationIndex()
    {
         int index = hash & 4;
         return index;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return Objects.equals(key, node.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}