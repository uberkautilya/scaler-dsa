package dsa21_July28_contest_2;

public class ConstructBinaryNumber {
    public static void main(String[] args) {
        //11100
        int A = 3;
        int B = 2;

        System.out.println("solve(A, B); = " + solve(A, B));
        ;
    }

    private static Integer solve(int A, int B) {
        if (A == 0) return 0;

        Integer result = 0;
        while (A > 0) {
            result = result * 2 + 1;
            A--;
        }
        while (B > 0) {
            result = result << 1;
            B--;
        }
        return result;
    }
}
