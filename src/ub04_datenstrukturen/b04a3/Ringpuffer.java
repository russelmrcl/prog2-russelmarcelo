package b04a3;

import java.util.NoSuchElementException;

public class Ringpuffer<T> {

    private T[] data;
    private int pointer = 0;
    private int size = 0;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Ringpuffer(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public T get(int pos) {
        if (pos > capacity - 1 || pos < 0 || pos > size) {
            throw new IllegalStateException();
        }
        return data[pos];
    }

    public T set(int pos, T e) {

        T replacedELement;
        if (pos > capacity - 1 || pos < 0 || pos > size) {
            throw new IllegalStateException();
        }
        replacedELement = data[pos];
        data[pos] = e;
        return replacedELement;
    }

    public void addFirst(T e) {
        if (size == capacity) {
            throw new IllegalStateException();
        }
        @SuppressWarnings("unchecked")
        T[] tmp = (T[]) new Object[capacity];
        for (int i = pointer; i <= capacity + pointer; i++) {
            tmp[(i + 1) % capacity] = data[i % capacity];
        }
        data = tmp;
        data[pointer] = e;
        size++;
    }

    public void addLast(T e) {

        if (size == capacity) {
            throw new IllegalStateException();
        }
        int index = (size + pointer) % capacity;
        data[index] = e;
        size++;
    }


    public T removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedElement = data[pointer];
        data[pointer] = null;
        pointer = (pointer + 1) % capacity;
        size--;
        return removedElement;

    }


    public T removeLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedElement = data[size - 1];
        size--;
        int index = (size + pointer) % capacity;
        data[index] = null;
        return removedElement;
    }

    public void reset() {
        for (int i = 0; i < capacity; i++) {
            data[i] = null;
        }
        size = 0;
        pointer = 0;
    }

    public T pointer() {
        return data[pointer];
    }

    private int pointerPos() {
        return pointer;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}
