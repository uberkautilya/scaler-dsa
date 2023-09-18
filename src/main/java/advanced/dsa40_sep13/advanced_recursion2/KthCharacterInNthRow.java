package advanced.dsa40_sep13.advanced_recursion2;

public class KthCharacterInNthRow {
    public static void main(String[] args) {
        int value = new KthCharacterInNthRow().solve(2, 1);
        System.out.println("value = " + value);
    }

    private int solve(int row, int k) {
        if (k == 0) {
            return 0;
        }
        int parentElement = solve(row - 1, k / 2);
        //If current k is even, it is same as the parent.
        // Else, the value is the compliment of the parent element
        if (k % 2 == 0) {
            return parentElement;
        }
        //Else compliment of parent is present at the given position of k
        return parentElement == 0 ? 1 : 0;
    }
}
