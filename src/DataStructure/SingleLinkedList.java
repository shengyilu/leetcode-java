package DataStructure;

public class SingleLinkedList<T> {

    private class Node {
        T element;
        Node next;
        Node(T element) {
            this.element = element;
        }
    }

    public Node first;

    public void add(T element) {
        Node node = new Node(element);
        if (first == null) {
            first = node;
        } else {
            append(node);
        }
    }

    private void append(Node node) {
        Node last = first;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
    }

    public T get(int index) {
        Node n = first;
        int i = 0;
        while (n != null) {
            if (i == index) {
                return n.element;
            }
            i++;
            n = n.next;
        }
        return null;
    }



}
