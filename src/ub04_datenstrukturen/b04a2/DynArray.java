package b04a2;

public class DynArray<T> {

    private T[] data;
    private int size = 1;

    @SuppressWarnings("unchecked")
    public DynArray() {
        data =  (T[]) new Object[size];
    }

}
