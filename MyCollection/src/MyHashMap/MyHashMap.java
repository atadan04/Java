package MyHashMap;

import java.util.Objects;

public class MyHashMap<K, V> {
    public Node<K, V>[] bucket = new Node[5];
    private int size = 0;

    public void put(K key, V value) {

        int hash = key.hashCode();
        Node node = new Node(hash, key, value, null);
        int index = node.calculationIndex();
        if (bucket[index] == null) {
            bucket[index] = node;

        } else {
            if ((get(key) != null)) {
                if (compareKey(get(key).getKey(), key)) {
                    get(key).setValue(value);
                }

            }
            Node lastNode = getLastNode(bucket[index]);
            lastNode.setNext(node);
        }
        size++;
    }

    private Boolean compareKey(K key1, K key2) {
        if (key1.hashCode() == key2.hashCode()) {
            if (key1.equals(key2)) {
                return true;
            }
        }
        return false;
    }

    public Node<K, V> get(K key) {
        int hash = key.hashCode();
        int index = hash & 4;
        System.out.println(bucket[index].getKey().hashCode() + "\t" + hash);
        if (compareKey(bucket[index].getKey(), key)) {
            return bucket[index];
        } else {
            return getEqualsNode(bucket[index], key);
        }
    }

    private Node<K, V> getEqualsNode(Node node, K key) {
        if (node.getKey().equals(key)) {
            return node;
        } else {
            if (node.getNext() != null)
                return getEqualsNode(node.getNext(), key);
        }
        return null;
    }

    private Node<K, V> getLastNode(Node node) {
        if (node.getNext() == null)
            return node;
        else {
            return getLastNode(node.getNext());
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class Node<K, V> {

    private Node<K, V> next;
    private int hash;
    private K key;
    private V value;

    public Node<K, V> getNext() {

        return next;

    }


    public Node(int hash, K key, V value, Node<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public void setNext(Node<K, V> node) {
        this.next = node;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int calculationIndex() {
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

        return Objects.hashCode(key);

    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}