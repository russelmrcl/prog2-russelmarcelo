package b04a2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DynArray<T> {

    private T[] data;
    private int size = 0;
    private int capacity = 1;

    @SuppressWarnings("unchecked")
    public DynArray() {
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public T get(int pos) {
        if (pos > capacity - 1 || pos < 0 || pos >= size) {
            throw new IllegalStateException();
        }
        return data[pos];
    }

    public T set(int pos, T e) {

        T replacedELement;
        if (pos > capacity - 1 || pos < 0 || pos >= size) {
            throw new IllegalStateException();
        }
        replacedELement = data[pos];
        data[pos] = e;
        return replacedELement;
    }

    public void addFirst(T e) {

        if (size() == capacity()) {
            increase();
        }
        for (int i = size - 1; i >= 0; i--) {
            data[i + 1] = data[i];
        }
        data[0] = e;
        size++;
    }

    public void addLast(T e) {

        if (size() == capacity()) {
            increase();
        }
        data[size++] = e;
    }

    public T removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedElement = data[0];
        data[0] = null;
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        if (size * 4 <= capacity) {
            decrease();
        }
        return removedElement;
    }

    public T removeLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedElement = data[size-1];
        data[size-1] = null;
        size--;
        if (size * 4 <= capacity) {
            decrease();
        }
        return removedElement;
    }

    private void increase() {
        capacity *= 2;
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void decrease() {
        capacity /= 2;
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }
}

