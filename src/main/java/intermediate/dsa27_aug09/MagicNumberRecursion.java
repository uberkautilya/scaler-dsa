package intermediate.dsa27_aug09;

public class MagicNumberRecursion {
    public int solve(int A) {

        int resultOnDigitAddition = findDigit(A);
        if (resultOnDigitAddition == 1) return 1;
        return 0;
    }

    public int findDigit(int num) {
        if (num / 10 == 0) return num;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return findDigit(sum);
    }
}
