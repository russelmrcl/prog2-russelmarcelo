package b05a3;

import b04a3.Ringpuffer;

public class Main {
    public static void main(String[] args) {

        FolgeMitRing<Integer> a = new FolgeMitRing<>(4);
        a.insert(0, 1);
        a.insert(1, 2);
        a.insert(2, 3);
        a.insert(0, 10);
        System.out.println(a);
        a.remove();
        System.out.println(a);
        a.insert(2, 20);
        System.out.println(a);
        a.remove(2);
        System.out.println(a);
        a.insert(2, 100);
        System.out.println(a);
        a.remove();
        System.out.println(a);
        a.insert(2, 300);
        System.out.println(a);
        a.remove(1);
        System.out.println(a);
        a.insert(1, 200);
        System.out.println(a);
        a.remove();
        System.out.println(a);
        a.insert(3,300);
        System.out.println(a);
        a.remove();
        System.out.println(a);
        a.insert(1, 300);
        System.out.println(a);
    }
}
