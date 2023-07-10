package b05a3;

public class Main {
    public static void main(String[] args) {

        FolgeMitRing<Integer> ring = new FolgeMitRing<Integer>(5);

        ring.insert(0, 1);
        ring.insert(1, 2);
        ring.insert(2, 3);
        ring.insert(3, 4);
        ring.insert(4, 5);
        ring.remove();
        ring.remove();
        ring.remove();
        ring.remove();
        System.out.println(ring);
        ring.insert(1);
        System.out.println(ring);
        ring.insert(2);
        System.out.println(ring);
        ring.insert( 10);
        System.out.println(ring);
        ring.insert(2, 20);
        System.out.println(ring);
    }
}
