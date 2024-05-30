package low_level_design.advanced_concepts.exceptions.iterable_serializable_clonable;

import java.util.Arrays;
import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        CustomList customNumber = new CustomList();
        customNumber.integerList = Arrays.asList(12, 23, 19, 20, 1, 90, 18, 21, 15, 80);
        customNumber.strList = Arrays.asList("A", "B", "C", "Aa", "Bb", "Cc");

        for (Integer valInClass : customNumber) {
            System.out.println(valInClass);
        }

        System.out.println("Custom Iterator on the list");
        Iterator<Integer> integerIterator = new CustomListIntIterator(customNumber);
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }

        System.out.println("Custom Iterator on the list");
        Iterator<String> strIterator = new CustomListStrIterator(customNumber);
        while (strIterator.hasNext()) {
            System.out.println(strIterator.next());
        }
    }
}
