package b08a2;

public class Main {
    public static void main(String[] args) {


        Integer[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        SnakeIterator2DArray<Integer> si = new SnakeIterator2DArray<>(a);
        while (si.hasNext()) {
            System.out.println(si.next());
        }
    }
}
