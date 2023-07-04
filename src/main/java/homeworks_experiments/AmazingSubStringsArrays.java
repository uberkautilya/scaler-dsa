package homeworks_experiments;

public class AmazingSubStringsArrays {
    public static void main(String[] args) {
        String str = "pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn";
        char[] charArray = str.toCharArray();
        countAmazingSubstringsAlternative(charArray);
    }

    private static void countAmazingSubstrings(char[] charArray) {
        long amazingSubstringCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u' ||
                    charArray[i] == 'A' || charArray[i] == 'E' || charArray[i] == 'I' || charArray[i] == 'O' || charArray[i] == 'U'
            ) {
                amazingSubstringCount += charArray.length - i;
            }
        }
        System.out.println("amazingSubstringCount = " + amazingSubstringCount);
    }

    private static void countAmazingSubstringsAlternative(char[] charArray) {
        long amazingSubstringCount = 0;
        int countFromEnd = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            countFromEnd++;

            if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u' ||
                    charArray[i] == 'A' || charArray[i] == 'E' || charArray[i] == 'I' || charArray[i] == 'O' || charArray[i] == 'U'
            ) {
                amazingSubstringCount += countFromEnd;
            }
        }
        System.out.println("amazingSubstringCount = " + (int) amazingSubstringCount);
    }


}
