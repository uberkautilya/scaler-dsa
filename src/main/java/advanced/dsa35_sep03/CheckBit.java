package advanced.dsa35_sep03;

public class CheckBit {
    public int solve(int A, int B) {
        //A & (1<<B) is zero if Bth bit was unset in A.
        return (A & (1 << B)) != 0 ? 1 : 0;
    }

}
