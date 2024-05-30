package low_level_design.advanced_concepts.exceptions.iterable_serializable_clonable;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        CustomNumbers customNumber = new CustomNumbers();
        customNumber.integerList = Arrays.asList(12, 23, 19, 20, 1, 90, 18, 21, 15, 80);

        for (Integer valInClass : customNumber) {
            System.out.println(valInClass);
        }
    }
}
