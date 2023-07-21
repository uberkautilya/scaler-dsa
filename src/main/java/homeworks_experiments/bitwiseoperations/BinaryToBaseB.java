package homeworks_experiments.bitwiseoperations;

public class BinaryToBaseB {
    public static void main(String[] args) {

        int numberInBaseB = decimalToAnyBase(10, 4);
        System.out.println("numberInBaseB: " + numberInBaseB);

    }

    public static int decimalToAnyBase(int A, int B) {
        int numInDecimals = binaryToDecimal(A);
        System.out.println("numInDecimals: " + numInDecimals);

        return decimalToBaseB(numInDecimals, B);
    }

    public static int binaryToDecimal(int A) {
        int numInDecimals = 0;

        int power = 0;
        while (A > 0) {
            int currentPlace = A % 10;

            if (currentPlace != 0) {
                int pow = power;
                int contributionFromPlace = 1;
                while (pow > 0) {
                    //A is a binary number
                    contributionFromPlace *= 2;
                    pow--;
                }
                contributionFromPlace *= currentPlace;
                numInDecimals += contributionFromPlace;
            }
            power++;
            A = A / 10;
        }
        return numInDecimals;
    }

    public static int decimalToBaseB(int num, int B) {
        int countOfDigits = 0;
        int reverseResult = 0;

        while (num > 0) {
            int rem = num % B;
            reverseResult = reverseResult * 10 + rem;
            num /= B;
            countOfDigits++;
        }

        int result = 0;
        while (reverseResult > 0) {
            int rem = reverseResult % 10;
            result = result * 10 + rem;
            reverseResult /= 10;
            countOfDigits--;
        }
        while(countOfDigits-- > 0){
            result = result * 10;
        }
        return result;
    }


}
