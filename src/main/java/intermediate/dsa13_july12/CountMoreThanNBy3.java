package intermediate.dsa13_july12;

public class CountMoreThanNBy3 {
    public static void main(String[] args) {
        int[] A = {
                1000727, 1000727, 1000641, 1000517, 1000212, 1000532, 1000727, 1001000, 1000254, 1000106, 1000405, 1000100,
                1000736, 1000727, 1000727, 1000787, 1000105, 1000713, 1000727, 1000333, 1000069, 1000727, 1000877, 1000222,
                1000727, 1000505, 1000641, 1000533, 1000727, 1000727, 1000727, 1000508, 1000475, 1000727, 1000573, 1000727,
                1000618, 1000727, 1000309, 1000486, 1000792, 1000727, 1000727, 1000426, 1000547, 1000727, 1000972, 1000575,
                1000303, 1000727, 1000533, 1000669, 1000489, 1000727, 1000329, 1000727, 1000050, 1000209, 1000109};
        int mostRepeated = repeatedNumber(A);
        System.out.println("mostRepeated: " + mostRepeated);
    }

    public static int repeatedNumber(int[] A) {
        int valOne = Integer.MIN_VALUE;
        int oneCount = 0;
        int other = Integer.MIN_VALUE;
        int otherCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == valOne) {
                oneCount++;
            } else if (A[i] == other) {
                otherCount++;
            } else if (valOne == Integer.MIN_VALUE) {
                valOne = A[i];
                oneCount++;
            } else if (other == Integer.MIN_VALUE) {
                other = A[i];
                otherCount++;
            }  else {
                oneCount--;
                otherCount--;
                if (oneCount == 0) {
                    valOne = Integer.MIN_VALUE;
                }
                if (otherCount == 0) {
                    other = Integer.MIN_VALUE;
                }
            }
        }
        int fCount = 0;
        int sCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (valOne == A[i]) {
                fCount++;
            }
            if (other == A[i]) {
                sCount++;
            }
        }
        if (fCount > A.length / 3) {
            return valOne;
        }
        if (sCount > A.length / 3) {
            return other;
        }
        return -1;
    }
}


