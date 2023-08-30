package intermediate.dsa23_july31;

/**
 * You are given a string A of size N.
 * <p>
 * Return the string A after reversing the string word by word.
 */
public class ReverseSentence {
    public static void main(String[] args) {
        ReverseSentence reverseSentence = new ReverseSentence();
        String resultString = reverseSentence.solve("   the    sky is blue   ");
        System.out.println("resultString = " + resultString);

    }

    public String solve(String A) {
        String[] split = A.split("[ \\s]+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            stringBuilder.append(split[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
