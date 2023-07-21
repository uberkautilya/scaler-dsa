package homeworks_experiments.bitwiseoperations;

public class ReverseUnsignedInt {
    public static void main(String[] args) {
        int A = 3;
        printInBinary(A);

        int i = 0;
        long reversed = 0;

        while (A > 0) {
            int bit = (A & 1) == 0 ? 0 : 1;
            reversed += (long) bit * (1L << (31 - i));
            A = A >> 1;
            i++;
        }
        System.out.println("reversed = " + reversed);
    }


    public static void printInBinary(long num) {
        System.out.print("\n" + num + ": ");
        long binaryNum = 0;
        int count = 0;
        while (num > 0) {
            binaryNum = binaryNum * 10 + num % 2;
            count++;
            num = num / 2;
        }
        while (binaryNum > 0) {
            System.out.print(binaryNum % 10);
            binaryNum = binaryNum / 10;
            count--;
        }
        while (count > 0) {
            System.out.print(0);
            count--;
        }
    }

}
/**
 * long number = 6;
 * printInBinary(number);
 * long binaryNum = 0;
 * while (number > 0) {
 * binaryNum = binaryNum * 10 + number % 2;
 * number = number / 2;
 * }
 * //Now find the decimal representation of the binaryNum variable(not reversed)
 * int index = 0;
 * long decimalNumber = 0;
 * while (binaryNum > 0) {
 * decimalNumber += (binaryNum % 10) << index;
 * index++;
 * binaryNum = binaryNum / 10;
 * }
 * printInBinary(decimalNumber);
 * }
 */