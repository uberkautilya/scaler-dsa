package intermediate.dsa01_june21;

public class PrimeOrNot {
    public static void main(String[] args) {
        int N = 89;
        int factors = countFactors(N);
        if (factors < 3) {
            System.out.println("The number is prime");
        }else {
            System.out.println("The number is not a prime");
        }
        if (isPrime(N)) {
            System.out.println("The number is prime from isPrime method");
        } else {
            System.out.println("The number is not a prime from isPrime method");
        }
    }

    /**
     * Counts the number of factors of a number
     * @param number
     * @return
     */
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

    /**
     * Checks if the given number is a prime or not
     * @param number
     * @return
     */
    private static boolean isPrime(int number) {
        if (number ==1 || number == 2) {
            return true;
        }
        for (int i = 2; i * i <= number; i++) {

            if (number % i == 0) {

                return false;
            }
        }

        return true;
    }

}



//-------------------------
/*
public class Solution {
    public int solve(long A) {
        int count = 0;
        for(int i=1; i*i<=A; i++){
            if(A%i == 0){
                count +=2;
                if(A/i == i){
                    count -= 1;
                }
            }
        }
        return count==2 ? 1 : 0;
    }
}
 */