package b09a5;

import b08a4.Puffer;
import b08a4.SchlangeMitArray;
import b08a4.SchlangeMitEVL;

public class Main {
    public static void main(String[] args) {

        Puffer<Integer> a1 = new SchlangeMitEVL<>();
        Puffer<Integer> a2 = new SchlangeMitEVL<>();

        a1.insert(15);
        a1.insert(5);
        a1.insert(10);
        a2.insert(24);
        a2.insert(22);
        a2.insert(17);

        GenericUtil.insertInto(a1, a2);
        System.out.println(a1);

    }
}
