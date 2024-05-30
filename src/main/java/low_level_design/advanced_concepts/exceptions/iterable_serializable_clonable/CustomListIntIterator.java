package low_level_design.advanced_concepts.exceptions.iterable_serializable_clonable;

import java.util.Iterator;

public class CustomListIntIterator implements Iterator<Integer> {

    private int index;
    private final CustomList customList;

    //Start at index 0
    public CustomListIntIterator(CustomList customNumbers) {
        this.index = 0;
        this.customList = customNumbers;
    }

    /**
     * Tells if more elements are available to be traversed
     */
    @Override
    public boolean hasNext() {
        //Example of an iterator that goes through the 5th next element
        while (index < customList.integerList.size()) {
            if (customList.integerList.get(index) % 5 == 0) {
                break;
            }
            index++;
        }
        return index != customList.integerList.size();
    }

    /**
     * Returns the next element, increasing the index by 1
     */
    @Override
    public Integer next() {
        return customList.integerList.get(index++);
    }
}
