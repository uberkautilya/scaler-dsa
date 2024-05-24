package low_level_design.advanced_concepts.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        customGenericTypeExample();
        rawTypeExample();

        List<Integer> list = new ArrayList<>();
        Pair.doSomething(5);

    }

    private static void customGenericTypeExample() {
        Pair<Integer, String> pair = new Pair<>(5, "Example");
        Integer first = pair.getFirst();
        System.out.println("first = " + first);
        pair.setSecond("STR");
    }

    private static void rawTypeExample() {
        //Raw types
        Pair p = new Pair(6, "");
        Object obj = p.getFirst();
        System.out.println("obj = " + obj);

        //Backward compatibility: Raw types
        HashMap h = new HashMap();//Raw type - the types would be Object inside the map
        h.put(101, 1200);
        h.put("Str", "Text"); //Not cool
    }
}
