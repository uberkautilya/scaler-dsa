package advanced.dsa32_aug28;

public class Flip {
    public static void main(String[] args) {
        Flip flip = new Flip();
        flip.flip()
    }
    public int[] flip(String A) {
        boolean all1s = true;
        for (char c : A.toCharArray()) {
            if (c == '0') {
                all1s = false;
                break;
            }
        }
        if (all1s) return new int[0];

        int[] indices = new int[2];
        //Todo: Solve the problem
        return indices;
    }
}
