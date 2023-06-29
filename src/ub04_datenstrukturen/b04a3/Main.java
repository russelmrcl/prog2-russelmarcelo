package b04a3;

public class Main {
    public static void main(String[] args) {

        Ringpuffer<Integer> a = new Ringpuffer<>(4);
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addLast(10);
        System.out.println(a);
        a.addFirst(20);
        System.out.println(a);
    }
}
