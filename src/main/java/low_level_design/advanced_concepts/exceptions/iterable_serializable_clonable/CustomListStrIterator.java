package low_level_design.advanced_concepts.exceptions.iterable_serializable_clonable;

import java.util.Iterator;

public class CustomListStrIterator implements Iterator<String> {

    private int index;
    private final CustomList customList;

    //Start at index 0
    public CustomListStrIterator(CustomList customNumbers) {
        this.index = 0;
        this.customList = customNumbers;
    }

    /**
     * Tells if more elements are available to be traversed
     */
    @Override
    public boolean hasNext() {
        //Example of an iterator that goes through the 5th next element
        while (index < customList.strList.size()) {
            if (customList.strList.get(index).startsWith("A")) {
                break;
            }
            index++;
        }
        return index != customList.strList.size();
    }

    /**
     * Returns the next element, increasing the index by 1
     */
    @Override
    public String next() {
        return customList.strList.get(index++);
    }
}
