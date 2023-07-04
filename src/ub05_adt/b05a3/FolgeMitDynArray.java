package b05a3;

import b05a2.Folge;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class FolgeMitDynArray<T> implements Folge<T> {

    private T data[];
    private int size = 0;
    private int capacity = 1;

    @SuppressWarnings("unchecked")
    public FolgeMitDynArray() {
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
        if (size() == capacity()) {
            grow();
        }
        data[size++] = i;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T removedElement = data[size() - 1];
        data[size() - 1] = null;
        size--;
        if (size() * 4 == capacity()) {
            shrink();
        }
        return removedElement;
    }

    @Override
    public T get(int pos) {
        if (pos < 0 || pos > capacity() - 1 || pos > size()) {
            throw new IllegalStateException();
        }
        return data[pos];
    }

    @Override
    public T set(int pos, T e) {
        if (pos < 0 || pos > capacity() - 1 || pos > size()) {
            throw new IllegalStateException();
        }
        T replacedElement = data[pos];
        data[pos] = e;
        return replacedElement;
    }

    @Override
    public T remove(int pos) {

        if (pos < 0 || pos > capacity() - 1 || pos > size()) {
            throw new IllegalStateException();
        }

        T removedElement = data[pos];
        data[pos] = null;
        return removedElement;

    }

    @Override
    public void insert(int pos, T e) {
        if (pos >= 0 && pos <= size) {
            data[pos] = e;
        } else {
            throw new IllegalStateException();
        }
    }

    private void grow() {
        capacity *= 2;
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size(); i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void shrink() {

        capacity /= 2;
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size(); i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        return "FolgeMitDynArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}