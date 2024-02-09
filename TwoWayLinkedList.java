public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0; // Number of elements in the list

    public TwoWayLinkedList() {
    }

    public TwoWayLinkedList(E[] objects) {
        for (E object : objects) {
            addLast(object);
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        if (head != null) {
            head.previous = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        if (tail == null) {
            addFirst(e);
        } else {
            Node<E> newNode = new Node<>(e);
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            size++;
        }
    }

    // Implement other methods adjusting for previous references accordingly

    public E removeFirst() {
        if (size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            head.previous = null;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) return null;
        else if (size == 1) {
            return removeFirst();
        } else {
            Node<E> temp = tail;
            tail = tail.previous;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    // Remember to update the add(int index, E e) and remove(int index) methods to handle previous references

    // Implement the listIterator() method as per the original task description
    // This involves creating a ListIterator<E> that can traverse the list in both directions

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    // Additional methods to be implemented as exercises
}
