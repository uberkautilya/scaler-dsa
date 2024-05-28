package low_level_design.advanced_concepts.generics.assignments;

import java.util.Arrays;
import java.util.Comparator;

public class MaxElement {

    // TODO: Implement a generic method called 'findMax' that finds and returns the maximum element from an array.

    // The method should use bounded generics to ensure that the array elements extend the Comparable interface.
    // The method should return NULL in case of empty or null array

    // The method template below is written for integer arrays only. You are required to implement it for arrays of any data type.
    public static <T extends Comparable> T findMax(T[] array) {

        // Write code here
        if(array == null || array.length == 0) return null;
        return (T) Arrays.stream(array).max(Comparator.naturalOrder()).orElse(null);
    }


    public static void main(String[] args) {
        Integer[] numbers = {4, 7, 1, 9, 3, 5};
        Double[] decimals = {3.14, 2.71, 1.618, 2.718};
        String[] words = {"Apple", "Banana", "Peach", "Orange"};
        Character[] letters = {'a', 'e', 'i', 'o', 'u'};
        Integer[] negativeNumbers = {-1, -3, -7, -4};
        Float[] floatDecimals = {1.0f, 3.14f, -1.618f, 2.718f};

        // Demonstrating max element for each array
        System.out.println("Maximum Integer: " + MaxElement.findMax(numbers));
        System.out.println("Maximum Double: " + MaxElement.findMax(decimals));
        System.out.println("Maximum String: " + MaxElement.findMax(words));
        System.out.println("Maximum Character: " + MaxElement.findMax(letters));
        System.out.println("Maximum Negative Integer: " + MaxElement.findMax(negativeNumbers));
        System.out.println("Maximum Float: " + MaxElement.findMax(floatDecimals));

        // Handling null and empty arrays
        Integer[] nullArray = null;
        Integer[] emptyArray = {};
        System.out.println("Maximum of null array: " + MaxElement.findMax(nullArray)); // Expected to be null or throw an exception based on implementation
        System.out.println("Maximum of empty array: " + MaxElement.findMax(emptyArray)); // Expected to be null or throw an exception based on implementation
    }
}