package advanced.module6.contest2023_11_03;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimesInRange {
    public static void main(String[] args) {
        PrimesInRange primesInRange = new PrimesInRange();
        ArrayList<Integer> result = primesInRange.solve(2, 7);
        System.out.println("result = " + result);
    }

    public ArrayList<Integer> solve(int A, int B) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[B + 1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= B; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= B; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = A; i <= B; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
