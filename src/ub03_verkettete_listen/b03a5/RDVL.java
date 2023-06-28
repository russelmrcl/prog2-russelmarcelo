package b03a5;


import java.util.NoSuchElementException;

public class RDVL<T> {

    private ListElement entry = null;
    private int size = 0;

    private class ListElement {

        private T data;
        private ListElement prev = null;
        private ListElement next = null;

        ListElement(T data) {
            this.data = data;
        }

    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T e) {

        ListElement newElement = new ListElement(e);
        if (this.isEmpty()) {
            entry = newElement;
            entry.prev = entry;
            entry.next = entry;
        } else {
            ListElement prevElement = entry.prev;
            entry.prev = newElement;
            prevElement.next = newElement;
            newElement.next = entry;
            newElement.prev = prevElement;
        }
        size++;
    }

    public T remove() {

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T removedElement;
            if (this.size() == 1) {
                removedElement = entry.data;
                entry = null;
            } else {
                ListElement secondLastElement = entry.prev.prev;
                removedElement = entry.prev.data;
                entry.prev = entry.prev.prev;
                secondLastElement.next = entry;
                entry = entry.next;
            }
            size--;
            return removedElement;
        }
    }

    public T element() {
        return this.entry.data;
    }

    public void next(int s) {
        while (s > 0) {
            entry = entry.next;
            s--;
        }
    }

    public void prev(int s) {
        while (s > 0) {
            entry = entry.prev;
            s--;
        }
    }

    /*@Override
    public String toString() {
        return "prev: " + entry.prev.data + " entry: " + entry.data +
                " next: " + entry.next.data;
    }*/
}

