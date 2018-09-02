public class CircularBuffer<T> {

    private T[] elements;
    private int capacity;
    private int head;
    private int tail;
    private int length;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
    }

    public void clear() {
        head = tail = length = 0;
    }

    public void overwrite(T t) throws BufferIOException {
        if (isFull()) {
            read();
        }
        write(t);
    }

    public boolean isFull() {
        return length > 0 && head == tail;
    }

    public T read() throws BufferIOException {
        if (isEmpty()) {
            throw new BufferIOException("Tried to read from empty buffer");
        }
        T result = elements[head];
        head = (head + 1) % capacity;
        length--;
        return result;
    }

    public void write(T t) throws BufferIOException {
        if (isFull()) {
            throw new BufferIOException("Tried to write to full buffer");
        }
        elements[tail] = t;
        tail = (tail + 1) % capacity;
        length++;
    }

    public boolean isEmpty() {
        return length == 0;
    }
}
