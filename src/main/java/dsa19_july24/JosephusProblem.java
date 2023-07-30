package dsa19_july24;

public class JosephusProblem {
    public static void main(String[] args) {
        calculatePosition(6);

    }

    public static int calculatePosition(Integer count) {
        int originalCount = count;

        int highestPowerOf2 = 1;
        while (count > 1) {
            count /= 2;
            highestPowerOf2 *= 2;
        }

        int countOfTransfers = originalCount - highestPowerOf2;
        int positionAtEnd = 1 + 2 * countOfTransfers;
        System.out.println("positionAtEnd = " + positionAtEnd);
        return positionAtEnd;
    }
}
