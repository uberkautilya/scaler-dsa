package low_level_design.advanced_concepts.exceptions.iterable_serializable_clonable;

import java.util.Iterator;

public class CustomNumberIterator implements Iterator<Integer> {

    private int index;
    private final CustomNumbers numbers;

    //Start at index 0
    public CustomNumberIterator(CustomNumbers customNumbers) {
        this.index = 0;
        this.numbers = customNumbers;
    }

    /**
     * Tells if more elements are available to be traversed
     */
    @Override
    public boolean hasNext() {
        //Example of an iterator that goes through the 5th next element
        while (index < numbers.integerList.size()) {
            if (numbers.integerList.get(index) % 5 == 0) {
                break;
            }
            index++;
        }
        return index != numbers.integerList.size();
    }

    /**
     * Returns the next element, increasing the index by 1
     */
    @Override
    public Integer next() {
        return numbers.integerList.get(index++);
    }
}
