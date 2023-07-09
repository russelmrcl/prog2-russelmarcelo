package b08a4;

public class Main {
    public static void main(String[] args) {

       SchlangeMitEVL<String> a = new SchlangeMitEVL<>();
        a.insert("A");
        a.insert("B");
        a.insert("C");
        a.insert("D");
        for (String v : a) {
            System.out.println(v);
        }
    }
}
