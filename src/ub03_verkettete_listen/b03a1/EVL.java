package b03a1;

import java.util.NoSuchElementException;

public class EVL<T> {

    private ListElement first = null;
    private int size = 0;

    private class ListElement {

        private T data;
        private ListElement next = null;

        ListElement(T data) {
            this.data = data;
        }
    }

    public T getFirst() {

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return first.data;
        }

    }

    public T getLast() {

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            ListElement tmp = first;
            while (null != tmp.next) {
                tmp = tmp.next;
            }
            return tmp.data;
        }

    }

    public void addFirst(T e) {

        if (null == e) {
            throw new IllegalStateException();
        } else {
            ListElement element = new ListElement(e);
            if (this.isEmpty()) {
                first = element;
            } else {
                element.next = this.first;
                this.first = element;
            }
        }
    }

    public void addLast(T e) {

        if (null == e) {
            throw new IllegalStateException();
        } else {
            ListElement element = new ListElement(e);
            if (this.isEmpty()) {
                first = element;
            } else {
                ListElement tmp = first;
                while (null != tmp.next) {
                    tmp = tmp.next;
                }
                tmp.next = element;
            }
            size++;
        }
    }

    public T removeLast() {

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T removedElement;
            if (1 == this.size) {
                removedElement = first.data;
                first = null;
            } else {
                ListElement tmp = first;
                while (null != tmp.next.next) {
                    tmp = tmp.next;
                }
                removedElement = tmp.next.data;
                tmp.next = null;
            }
            size--;
            return removedElement;
        }
    }

    public T removeFirst() {

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T removedElement;
            if (1 == this.size) {
                removedElement = first.data;
                first = null;
            } else {
                removedElement = this.getFirst();
                first = first.next;
            }
            size--;
            return removedElement;
        }
    }

    public boolean contains(T e) {

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            ListElement tmp = first;
            while (null != tmp) {
                if (tmp.data.equals(e)) {
                    return true;
                } else {
                    tmp = tmp.next;
                }
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return this.toString(first);
    }

    private String toString(ListElement current) {

        if (this.isEmpty()) {
            return "Empty!";
        } else if (null == current.next) {
            return current.data.toString();
        } else {
            return current.data + "-> " + toString(current.next);
        }
    }

    private boolean isEmpty() {
        return this.size() == 0;
    }
}
