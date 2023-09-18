package advanced.dsa41_sep15;

public class PairWithModulo0 {
    public static void main(String[] args) {
        int[] intArray = new int[]{
                13, 14, 22, 3, 32, 19, 16
        };
        int countOfPairs = new PairWithModulo0().countOfPairs(intArray, 4);
        System.out.println("countOfPairs = " + countOfPairs);
    }

    private int countOfPairs(int[] valArray, int M) {
        int count = 0;
        int[] counterArray = new int[M];
        for (int num : valArray) {
            //Creating a frequency array, of possible remainders on % with M
            int index = num % M;
            counterArray[index] += 1;
        }
        //for each remainder, the other remainder has to be M - remainder. Edge case: 0
        int lIndex = 1;
        int rIndex = M - 1;
        while (lIndex < rIndex) {
            count += counterArray[lIndex] * counterArray[rIndex];
            lIndex++;
            rIndex--;
        }
        //Edge Case 1: lIndex = rIndex -> Count C 2, as all the three numbers are different instances
        if (lIndex == rIndex) {
            //Choose 2 elements from N element
            int lValue = counterArray[lIndex];
            count += lValue * (lValue - 1) / 2;
        }

        //Edge Case 2: count[0[. Combinations with 2 at a time NC2: N * (N-1) / 2
        int zeroModFrequency = counterArray[0];
        count += zeroModFrequency * (zeroModFrequency - 1) / 2;
        return count;
    }
}
