package intermediate.dsa24_aug02;

import java.util.HashMap;

public class IsDictionary {

    public static void main(String[] args) {
        IsDictionary isDictionary = new IsDictionary();
        System.out.println("\"yiyc\".compareTo(\"yi\") = " + "yiyc".compareTo("yi"));
        int result = isDictionary.solve(
                new String[]{"fine", "none", "no"}, "qwertyuiopasdfghjklzxcvbnm"
//                new String[]{"hello", "scaler", "interviewbit"}, "adhbcfegskjlponmirqtxwuvzy"
        );
        System.out.println("result = " + result);

    }

    public int solve(String[] A, String B) {
        String[] newArray = A.clone();

        HashMap<Character, Character> hashMap = new HashMap<>();
        char[] order = B.toCharArray();
        char[] alpha = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z'
        };
        for (int i = 0; i < order.length; i++) {
            hashMap.put(order[i], alpha[i]);
        }
        for (int j = 0; j < A.length; j++) {
            char[] chars = A[j].toCharArray();
            char[] rearranged = new char[A[j].length()];
            for (int i = 0; i < chars.length; i++) {
                rearranged[i] = hashMap.get(chars[i]);
            }
            newArray[j] = new String(rearranged);
        }

        for (int i = 1; i < newArray.length; i++) {
            if (newArray[i - 1].compareTo(newArray[i]) > 0) {
                return 0;
            }
        }
        return 1;
    }

    /*
    public int solve(String[] A, String B) {

        int sorted = 1;
        char[] order = B.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            hashMap.put(order[i], i);
        }

        for (int i = 0; i < A.length; i++) {
            char[] charA = A[i].toCharArray();
            char l = order[0];
            for (int j = 0; j < charA.length; j++) {
                if (hashMap.get(charA[j]) >= hashMap.get(l)) {
                    l = charA[j];
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }
     */
}
