package homeworks_experiments.modulararithmetic;

public class MinNumberFrom3TwoDigitIntegers {
    public static void main(String[] args) {

        int minimumPossibleNumber = solve(23, 43, 11);
        System.out.println("minimumPossibleNumber = " + minimumPossibleNumber);

    }

    public static int solve(int A, int B, int C) {
        int first = A;
        int second = B;
        int third = C;

        if (B < first) {
            if (B < C) {
                first = B;
                if (A < C) {
                    second = A;
                    third = C;
                } else {
                    second = C;
                    third = A;
                }
            } else {
                first = C;
                second = B;
                third = A;
            }
        } else if (C < first) {
            if (C < B) {
                first = C;
                if (A < B) {
                    second = A;
                    third = B;
                } else {
                    second = B;
                    third = A;
                }
            } else {
                first = B;
                second = C;
                third = A;
            }
        } else if (second > C) {
            second = C;
            third = B;
        }
        return first * 100_00 + second * 100 + third;

    }

}


/**
 * public static int solve(int A, int B, int C) {
 * int first = A;
 * int second = B;
 * int third = C;
 * <p>
 * if(B < first){
 * if(B < C){
 * first = B;
 * if(A < C){
 * second = A;
 * third = C;
 * } else{
 * second = C;
 * third = A;
 * }
 * } else {
 * first = C;
 * second = B;
 * third = A;
 * }
 * } else if(C < first){
 * if(C < B){
 * first = C;
 * if(A < B){
 * second = A;
 * third = B;
 * } else {
 * second = B;
 * third = A;
 * }
 * } else {
 * first = B;
 * second = C;
 * third = A;
 * }
 * } else if(second > C){
 * second = C;
 * third = B;
 * }
 * return first*100_00 + second * 100 + third;
 * <p>
 * }
 */