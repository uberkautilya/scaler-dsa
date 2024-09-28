package low_level_design.advanced_concepts.exceptions.iterable_serializable_clonable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList implements Iterable<Integer> {
    List<Integer> integerList = new ArrayList<>();
    List<String> strList = new ArrayList<>();

    @Override
    public Iterator<Integer> iterator() {
        //Iterator returning only even numbers from the list
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                while (index < integerList.size()) {
                    if (integerList.get(index) % 2 == 0) {
                        break;
                    }
                    index++;
                }
                return index != integerList.size();
            }

            @Override
            public Integer next() {
                return integerList.get(index++);
            }
        };
    }
}