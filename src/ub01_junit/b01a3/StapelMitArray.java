package b01a3;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StapelMitArray implements Stapel {

    private int[] data;
    private int currentSize;

    public StapelMitArray(int maxGroesse) {
        data = new int[maxGroesse];
        currentSize = -1;
    }


    @Override
    public boolean isEmpty() {
        return currentSize == -1;
    }

    @Override
    public int size() {
        return currentSize +1;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public void insert(Integer i) throws IllegalStateException {
        if (this.size() == this.capacity()) {
            throw new IllegalStateException();
        } else {
            data[++currentSize] = i;
        }
    }

    @Override
    public int remove() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return data[currentSize--];
        }
    }

    @Override
    public int top() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return data[currentSize];
        }
    }

    public void applyToAll(Funktion funktion) {
        for(int i = 0; i < this.size(); i++) {
            data[i] = funktion.auswerten(data[i]);
        }
    }

    @Override
    public String toString() {
        return "StapelMitArray{" +
                "data=" + Arrays.toString(data) +
                ", currentSize=" + currentSize +
                '}';
    }
}
