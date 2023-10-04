package advanced.dsa47_oct04;

public class FindCthMagicalNumber {
    public static void main(String[] args) {
        int cThMagicalNumber = new FindCthMagicalNumber().magicalNumber(2, 3, 8);
        System.out.println("cThMagicalNumber = " + cThMagicalNumber);
    }

    private int magicalNumber(Integer a, Integer b, Integer count) {
        int lcm = lcm(a, b);
        //Range is 1 to Minimum(a, b) * count
        int low = 1;
        int high = minimum(a, b) * count;
        int ans = 0;

        while (low <= high) {
            int midValue = (low + high) / 2;
            //Count of elements from 1 to midValue
            int cnt = (midValue / a) + (midValue / b) - (midValue / lcm);
            if (cnt == count) {
                //We need to find the minimum value at which this count is met
                ans = midValue;
                high = midValue - 1;
            } else if (cnt < count) {
                low = midValue + 1;
            } else {
                //count > cnt
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
