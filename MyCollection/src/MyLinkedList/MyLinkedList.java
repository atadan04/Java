package MyLinkedList;

public class MyLinkedList<T> {
    private Node head;
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public void remove(int index) {
        int point = 0;
        Node temp = head;
        if (index == 0) {
            head = head.getNext();
        } else {
            while (index - 1 != point) {
                temp = temp.getNext();
                point++;
            }
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }
}

class Node<T> {

    private Node next;
    private T value;

    public Node(T value) {
        this.value = value;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
