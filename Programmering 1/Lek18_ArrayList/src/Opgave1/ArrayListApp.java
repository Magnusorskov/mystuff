package Opgave1;

import java.util.ArrayList;
import java.util.List;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("Hans");
        s.add("Viggo");
        s.add("Jens");
        s.add("Børge");
        s.add("Bent");

        System.out.println(s.size());

        s.add(2,"Jane");

        System.out.println(s);

        s.remove(1);

        s.addFirst("Pia");

        s.add("Ib");

        System.out.println(s.size());

        s.set(2,"Hansi");

        System.out.println(s.size());

        System.out.println(s);

        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i).length());
        }

        for (String navn: s) {
            System.out.println(navn.length());
        }
    }
}
