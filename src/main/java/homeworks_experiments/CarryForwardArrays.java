package homeworks_experiments;

public class CarryForwardArrays {

    public static void main(String[] args) {

        char[] a = {'a', 'd', 'g', 'a', 'g', 'a', 'g', 'f', 'g'};
        int count = countPairsAlternative(a); //Same result as the previous approach
        System.out.println("The number of pairs of i, j such that i<j and a[i] =='a' && a[j]=='g': " + count);
    }

    //TODO REVISE: Interesting
    private static int countPairs(char[] a) {
        int answer = 0;
        int countOfGs = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 'g') {
                countOfGs++;
            } else if (a[i] == 'a') {
                answer += countOfGs;
            }
        }
        return answer;
    }

    private static int countPairsAlternative(char[] a) {
        int answer = 0;
        int countOfAs = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'a') {
                countOfAs++;
            } else if (a[i] == 'g') {
                answer += countOfAs;
            }
        }
        return answer;
    }
}
