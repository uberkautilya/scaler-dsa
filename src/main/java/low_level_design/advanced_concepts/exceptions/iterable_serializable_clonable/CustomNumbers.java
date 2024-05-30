package low_level_design.advanced_concepts.exceptions.iterable_serializable_clonable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomNumbers implements Iterable<Integer> {
    List<Integer> integerList = new ArrayList<>();
    List<String> strList = new ArrayList<>();

    @Override
    public Iterator<Integer> iterator() {
        return new CustomNumberIterator(this);
    }
}