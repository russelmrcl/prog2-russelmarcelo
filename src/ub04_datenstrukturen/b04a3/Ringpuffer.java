package b04a3;

public class Ringpuffer<T> {

    private T[] data;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public Ringpuffer(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public void addFirst(T e) {

        int index = size % capacity;
        for (int i = index - 1; i >= 0; i--) {
            data[i + 1] = data[i];
        }
        data[0] = e;
        if (size < capacity) {
            size++;
        }
    }

    public void addLast(T e) {
        
        int index = size % capacity;
        data[index] = e;
        if (size < capacity) {
            size++;
        }
    }
}
