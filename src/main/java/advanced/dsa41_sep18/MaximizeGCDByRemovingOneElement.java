package advanced.dsa41_sep18;

public class MaximizeGCDByRemovingOneElement {
    public static void main(String[] args) {
        int maxGcd = deleteOneElement(new int[]{7, 98, 49});
        System.out.println("maxGcd = " + maxGcd);
    }

    private static int deleteOneElement(int[] elements) {
        int length = elements.length;
        if (length == 2) return max(elements[0], elements[1]);
        //Find prefix GCD of the array, both left and right(suffix GCD)
        //create pf gcd
        int[] pfGcd = generatePrefixGcd(elements);
        //create sf gcd
        int[] sfGcd = generateSuffixGcd(elements);

        //Start with max of gcd when the either first or last element in the array is removed
        int result = max(sfGcd[0], pfGcd[length - 2]);

        for (int i = 1; i < length - 1; i++) {
            int left = pfGcd[i - 1];
            int right = sfGcd[i + 1];
            int gcd = calculateGcd(left, right);
            result = max(result, gcd);
        }

        return result;
    }

    private static int[] generatePrefixGcd(int[] elements) {
        int[] pfGcd = new int[elements.length];
        pfGcd[0] = elements[0];

        for (int i = 1; i < elements.length; i++) {
            pfGcd[i] = calculateGcd(pfGcd[i - 1], elements[i]);
        }
        return pfGcd;
    }

    private static int[] generateSuffixGcd(int[] elements) {
        int length = elements.length;
        int[] sfGcd = new int[length];
        //Last index suffix gcd
        sfGcd[length - 1] = elements[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            sfGcd[i] = calculateGcd(sfGcd[i + 1], elements[i]);
        }
        return sfGcd;
    }

    private static int calculateGcd(int num1, int num2) {
        if (num1 == 0 && num2 == 0) {
            //Could be provided in the question
            return 0;
        }
        if (num2 == 0) {
            return num1;
        }
        return calculateGcd(num2, num1 % num2);
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
