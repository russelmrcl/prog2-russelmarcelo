package b10a5;

import b07a2.Boxer;
import b07a2.Person;
import b07a2.Student;
import b08a4.Puffer;
import b08a4.SchlangeMitEVL;

public class Main {
    public static void main(String[] args) {

        Puffer<Boxer> a1 = new SchlangeMitEVL<>();
        Puffer<Person> a2 = new SchlangeMitEVL<>();

        a1.insert(new Boxer("A", "B", 10));
        a2.insert(new Student("B", "C", 11));

        FolgeMitDynArray<Person> folge = new FolgeMitDynArray<>();
        folge.insert(new Student("C", "D", 12));
        folge.insert(new Boxer("E", "F", 13));

    }
}
