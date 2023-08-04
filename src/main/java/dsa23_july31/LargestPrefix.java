package dsa23_july31;

public class LargestPrefix {
    public static void main(String[] args) {
        System.out.println("longestCommonPrefix(new String[]{}) = " + longestCommonPrefix(new String[]{
                "prefix", "prefixSome", "prefadmin"
        }));
    }

    public static String longestCommonPrefix(String[] A) {
        String smallestString = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i].length() < smallestString.length()) {
                smallestString = A[i];
            }
        }

        for (int i = smallestString.length(); i >= 0; i--) {
            String prefix = A[0].substring(0, i);
            boolean prefixExist = true;
            for (int j = 1; j < A.length; j++) {
                if (!A[j].substring(0, i).equals(prefix)) {
                    prefixExist = false;
                    break;
                }
            }
            if (prefixExist) {
                return prefix;
            }
        }
        return "";
    }
}
