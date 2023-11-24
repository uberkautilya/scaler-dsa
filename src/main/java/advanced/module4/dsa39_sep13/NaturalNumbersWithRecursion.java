package advanced.module4.dsa39_sep13;

public class NaturalNumbersWithRecursion {
    public static void main(String[] args) {
        NaturalNumbersWithRecursion naturalNumbersWithRecursion = new NaturalNumbersWithRecursion();
        naturalNumbersWithRecursion.solve(9);
    }

    public void solve(int A) {
        recurse(A);
        System.out.println();
    }

    private void recurse(int A) {
        if (A == 1) {
            System.out.print(A + " ");
            return;
        }
        solve(A - 1);
        System.out.print(A + " ");
    }
}
