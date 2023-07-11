package b10a2;

import b08a4.Puffer;
import b08a4.SchlangeMitEVL;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {


        Puffer<Boxer> b = new SchlangeMitEVL<>();
        b.insert(new Boxer("D", "D", 91));

        Puffer<Student> s = new SchlangeMitEVL<>();
        s.insert(new Student("A", "D", 100000));

        System.out.println(GenericUtil.getMinima(b, s));

        /*System.out.println(GenericUtil.getMinima(b, s, (o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        }));*/

    }
}
