package advanced.module5.dsa49_oct04;

public class FindCthMagicalNumberAssignment {
    public static void main(String[] args) {
        int cThMagicalNumber = new FindCthMagicalNumberAssignment().magicalNumber(807414236, 3788, 38141); //Expected: 238134151
        System.out.println("cThMagicalNumber = " + cThMagicalNumber);
    }

    private int magicalNumber(Integer A, Integer B, Integer C) {
        int lcm = lcm(B, C);
        //Range is 1 to Minimum(B, C) * A
        long low = 1;
        long high = ((long) minimum(B, C) * A);
        int ans = 0;

        while (low <= high) {
            long midValue = (low + high) / 2;
            //Count of elements from 1 to midValue
            long cnt = (((midValue / B) + (midValue / C) - (midValue / lcm)));
            if (cnt == A) {
                //We need to find the minimum value at which this A is met
                ans = (int)(midValue % 1000_000_007);
                high = midValue - 1;
            } else if (cnt < A) {
                low = midValue + 1;
            } else {
                //A > cnt
                high = midValue - 1;
            }
        }
        return ans;
    }

    private int lcm(Integer a, Integer b) {
        int gcd = gcd(a, b);
        return (a * b) / gcd;
    }

    private int gcd(Integer a, Integer b) {
        if (a == 0 && b == 0) {
            //This value might be given in the question
            return 0;
        }
        if (b == 0) {
            return a;
        }
        //Auto handles cases where a<b, even though the derived formula is for a>b
        return gcd(b, a % b);
    }

    private int minimum(Integer a, Integer b) {
        return a > b ? a : b;
    }
}
