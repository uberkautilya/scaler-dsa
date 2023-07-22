package homeworks_experiments.modulararithmetic;

public class ModulusOfExponentialNumber {
    public static void main(String[] args) {
        //Find (a^n) % p

        int a = 2;
        int n = 4;
        int p = 6;
        long answer = 1;
        for (int i = 0; i < n; i++) {
            //Answer will always hold  values in the range 0 to p-1, but the calculation needs 10^9 * 10^9 in worst case scenario
            //The whole calculation has to be at one go
            // -> to stay within the range of 0 - 10^9 even though the intermittent calculation produces 10^18
            answer = (answer * a) % p;
        }
        System.out.println("answer = " + answer);

        /*
        for (int i = 0; i < n; i++) {
            answer *= (a % p);
        }
        long finalAnswer = answer % p;
        System.out.println("finalAnswer = " + finalAnswer);
        */
    }
}
