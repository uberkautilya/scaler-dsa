package homeworks_experiments.bitwiseoperations;

public class MinSumFromXorOn2Numbers {
    public static void main(String[] args) {
//        int minSum = minSumOfXors(498762569, 964200544); //Expect 616696617
//        int minSum = minSumOfXors(372302376, 598056189); //Expect 898989781
//        int minSum = minSumOfXors(355130376, 269793606);
//        System.out.println("minSum = " + minSum);

//        int solve = solve(3, 1); //Expect 2
//        int solve = solve(2, 3);
//        int solve = solve(279090537, 408979424); //Expect 146936457
//        int solve = solve(4, 1);
//        int solve = solve(2, 1);
        int sum = minSumOfXorsOn2Nums(3, 1);

        System.out.println("\nsolve = " + sum);
    }

    public static int minSumOfXorsOn2Nums(int num1, int num2) {
        int sum = 0;
        int number = num1 & num2;
        System.out.println("number = " + number);
        sum = (num1^number) + (num2^number);
        return sum;
    }

    public static int solve(int A, int B) {
        if (A == B) return 0;

        long binaryA = decimalToBinary(A);
        long binaryB = decimalToBinary(B);
        System.out.printf("\n%10d%s", binaryA, "  binary");
        System.out.printf("\n%10d%s", binaryB, "  binary");

        long binaryResult = 0;
        int count = 0;

        while (binaryA > 0 || binaryB > 0) {
            binaryResult = binaryResult * 10;

            boolean flag1 = false;
            boolean flag2 = false;
            if (binaryA % 10 > 0) {
                flag1 = true;
            }
            if (binaryB % 10 > 0) {
                flag2 = true;
            }
            if (flag1 && flag2) {
                binaryResult += 1;
                count++;
            } else if (!flag1 && !flag2) {
                //Case where both digits are zero, the value is 0
                count++;
            } /*else if (binaryA/10 - binaryB/10 > 0) {
                //Case where both digits are distinct
                binaryResult += 0;
                count++;
            }*/ else {
                binaryResult += 1;
                count++;
            }
            binaryA /= 10;
            binaryB /= 10;
        }

        int reversed = 0;
        while (count > 0) {
            reversed *= 10;
            reversed += binaryResult % 10;
            binaryResult /= 10;
            count--;
        }
        System.out.printf("\n%10d", reversed);

        long val = binaryToDecimal(reversed);
        return (int) ((val ^ A) + (val ^ B));
    }

    public static long decimalToBinary(int num) {
        int countOfDigits = 0;
        int reverseResult = 0;

        while (num > 0) {
            int rem = num % 2;
            reverseResult = reverseResult * 10 + rem;
            num /= 2;
            countOfDigits++;
        }

        long result = 0;
        while (reverseResult > 0) {
            int rem = reverseResult % 10;
            result = result * 10 + rem;
            reverseResult /= 10;
            countOfDigits--;
        }
        while (countOfDigits-- > 0) {
            result = result * 10;
        }
        return result;
    }

    public static long binaryToDecimal(long A) {
        long numInDecimals = 0;

        int power = 0;
        while (A > 0) {
            long currentPlace = A % 10;

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



    /*public static int minSumOfXors(int A, int B) {
        int max = B;
        int min = A;
        if (A > B) {
            max = A;
            min = B;
        }
        if(min == max){
            return 0;
        }
        int minSum = A + B;

        for (int i = min; i <= max; i++) {
            int val = (A ^ i) + (B ^ i);
            if (val < minSum) {
                minSum = val;
            }
        }
        return minSum;
    }*/

}
