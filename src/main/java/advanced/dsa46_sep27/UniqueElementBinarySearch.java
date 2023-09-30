package advanced.dsa46_sep27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UniqueElementBinarySearch {
    public static void main(String[] args) {
        int uniqueElement = new UniqueElementBinarySearch().solve(
                Arrays.asList(3, 3, 7, 7, 4, 4, 9, 9, 24, 12, 12, 14, 14, 6, 6)
        );
        System.out.println("uniqueElement = " + uniqueElement);
    }

    public int solve(List<Integer> numbers) {
        return findUnique(numbers, 0, numbers.size() - 1);
    }

    private int findUnique(List<Integer> numbers, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex) / 2;
        Integer midElement = numbers.get(mid);
        Integer precedingElement = numbers.get(mid - 1);
        Integer succeedingElement = numbers.get(mid + 1);

        //If index of the first occurrence is even, then we know the unique element comes on the right half
        //If index of the first occurrence is off, then the unique element occurs in the first half

        if (!Objects.equals(midElement, precedingElement) &&
                !Objects.equals(midElement, succeedingElement)) {
            //When the element is not equal to its preceding and succeeding elements, the element is unique
            return midElement;
        } else if (Objects.equals(midElement, precedingElement)) {
            //Landed on second occurrence. Moving to the first occurrence
            mid = mid - 1;
        } else {
            //Landed on first occurrence. midElement = succeedingElement. Do nothing
        }
        if (mid % 2 == 0) {
            //Implies the unique element is not in the first half. Move over the current pair
            return findUnique(numbers, mid + 2, endIndex);
        }
        //Element is in the first half. Last element would be the element just preceding the current element at mid.
        return findUnique(numbers, startIndex, mid - 1);
    }
}
