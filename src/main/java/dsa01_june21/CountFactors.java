package dsa01_june21;

public class CountFactors {
    public static void main(String[] args) {
        int N = 24;
        int factors = countFactors(N);
        System.out.println(factors);
    }

    private static int countFactors(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {

            if (number % i == 0) {

                count += 2;
                //When the number is perfect square, there is only a single factor involved
                if (i == number / i) {
                    count--;
                }
            }
        }

        return count;
    }


}
