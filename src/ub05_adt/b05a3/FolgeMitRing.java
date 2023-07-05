package b05a3;

import b05a2.Folge;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class FolgeMitRing<T> implements Folge<T> {

    private T[] data;
    private int pointer = 0;
    private int size = 0;
    private int capacity;

    @SuppressWarnings("unchecked")
    public FolgeMitRing(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public void insert(T i) throws IllegalStateException {
        if (size == capacity) {
            throw new IllegalStateException();
        }
        int index = (size + pointer) % capacity;
        data[index] = i;
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedElement = data[pointer];
        data[pointer] = null;
        pointer = (pointer + 1) % capacity;
        size--;
        return removedElement;
    }

    @Override
    public T get(int pos) {
        if (pos > capacity - 1 || pos < 0 || pos > size) {
            throw new IllegalStateException();
        }
        return data[pos];
    }

    @Override
    public T set(int pos, T e) {
        T replacedELement;
        if (pos > capacity - 1 || pos < 0 || pos > size) {
            throw new IllegalStateException();
        }
        replacedELement = data[pos];
        data[pos] = e;
        return replacedELement;
    }

    @Override
    public T remove(int pos) {
        if (pos < 0 || pos > capacity() - 1 || pos > size()) {
            throw new IllegalStateException();
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T removedElement = data[pos];

        for (int i = pos; i < size() - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size() - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public void insert(int pos, T e) {
        if (pos < 0 || pos > size) {
            throw new IllegalStateException();
        }

        if (data[pos] != null) {
            int index = (pointer == 0) ? size - 1 : size;
            for (int i = index; i >= pos; i--) {
                data[(i + 1) % capacity] = data[i % capacity];
            }
        }
        data[pos] = e;
        size++;
    }
}
