package advanced.dsa41_sep18;

public class GCDGreatestCommonDivisor {
    public static void main(String[] args) {
        int a = 10;
        int b = 13;
        int gcd = gcd(a, b);
        System.out.println("gcd = " + gcd);
    }

    private static int gcd(int a, int b) {

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
}
