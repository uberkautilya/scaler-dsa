package intermediate.dsa23_july31;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("solve(\"relacss\") = " + solve("relacss"));
    }

    public static String solve(String A) {
        char[] ar = A.toCharArray();
        for (int i = 0; i < ar.length / 2; i++) {
            char temp = ar[i];
            ar[i] = ar[ar.length - 1 - i];
            ar[ar.length - 1 - i] = temp;
        }
        return String.valueOf(ar);
    }
}
