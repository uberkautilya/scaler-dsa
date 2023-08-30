package intermediate.dsa23_july31;

public class ToggleCaseOfChars {
    public static void main(String[] args) {
        System.out.println("solve(\"sdfIHIFdsfwef\") = " + solve("sdfIHIFdsfwef"));
    }

    public static String solve(String A) {
        char[] str = new char[A.length()];
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (A.charAt(i) >= 'a' && A.charAt(i) <= 'z') {
                c = (char) (A.charAt(i) - 32);
            }
            if (A.charAt(i) >= 'A' && A.charAt(i) <= 'Z') {
                c = (char) (A.charAt(i) + 32);
            }
            str[i] = c;
        }
        return String.valueOf(str);
    }
}
