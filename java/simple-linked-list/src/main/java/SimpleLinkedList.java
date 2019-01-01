import java.util.NoSuchElementException;

public class SimpleLinkedList<T> {

    transient int size = 0;

    transient Node<T> first;

    transient Node<T> last;

    public SimpleLinkedList() {
    }

    public SimpleLinkedList(Object[] array) {
        for (Object obj : array) {
            push((T) obj);
        }
    }

    public int size() {
        return size;
    }

    public T pop() {
        Node<T> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    public void push(T element) {
        linkFirst(element);
    }

    public void reverse() {
        Node<T> current = first;
        Node<T> previous = null;
        Node<T> next;
        while (current != null) {
            next = current.next;
            current.prev = next;
            current.next = previous;
            previous = current;
            first = current;
            current = next;
        }
    }

    public Object[] asArray(Class<T> clazz) {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = first; x != null; x = x.next) {
            result[i++] = x.item;
        }
        return result;
    }

    private void linkFirst(T t) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(null, t, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    private T unlinkFirst(Node<T> f) {
        // assert f == first && f != null;
        T element = f.item;
        Node<T> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return element;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
