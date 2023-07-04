package b04a3;

public class Main {
    public static void main(String[] args) {

        Ringpuffer<Integer> ringpuffer = new Ringpuffer<>(4);
        ringpuffer.addFirst(10);
        ringpuffer.addFirst(20);
        ringpuffer.addFirst(30);
        ringpuffer.addFirst(40);
        System.out.println(ringpuffer);
        ringpuffer.removeFirst();
        ringpuffer.addFirst(40);
        ringpuffer.removeFirst();
        System.out.println(ringpuffer);
        ringpuffer.addFirst(40);
        System.out.println(ringpuffer);
        ringpuffer.removeFirst();
        System.out.println(ringpuffer);
        ringpuffer.addFirst(40);
        System.out.println(ringpuffer);
    }
}
