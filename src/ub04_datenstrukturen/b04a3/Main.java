package b04a3;

public class Main {
    public static void main(String[] args) {

        Ringpuffer<Integer> ringpuffer = new Ringpuffer<>(3);
        ringpuffer.addFirst(10);
        ringpuffer.addFirst(20);
        ringpuffer.addFirst(30);
        System.out.println(ringpuffer);
        ringpuffer.removeFirst();
        System.out.println(ringpuffer);
        ringpuffer.addFirst(30);
        System.out.println(ringpuffer);
    }
}
