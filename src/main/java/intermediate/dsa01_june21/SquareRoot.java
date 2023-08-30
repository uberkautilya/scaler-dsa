package intermediate.dsa01_june21;

public class SquareRoot {
    public static void main(String[] args) {
        int number = 625;
        System.out.println(squareRootOfPerfectSquare(number));
        int imperfectSquareNumber = 624;
        System.out.println(floorSquareRootGeneric(imperfectSquareNumber));
    }

    private static double floorSquareRootGeneric(double number) {
        int i = 1, answer = 1;
        while (i * i <= number) {
            answer = i;
            i++;
        }
        return answer;
    }

    /**
     * If the number is given to be a perfect square
     *
     * @param number
     * @return
     */
    private static int squareRootOfPerfectSquare(int number) {
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                return i;
            }
        }
        return -1;
    }


}
