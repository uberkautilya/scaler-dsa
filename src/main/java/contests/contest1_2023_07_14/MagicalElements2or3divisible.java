package contests.contest1_2023_07_14;

public class MagicalElements2or3divisible {
    public static void main(String[] args) {
        int[] a = {26, 23, 23, 16, 27, 18, 7, 3, 17};
        System.out.println(solve(a));
    }

    public static int solve(int[] A) {
        int maxSize = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j >= i; j--) {

                if (isMagicalArray(A, i, j)) {
                    int size = j - i + 1;
                    if (size > maxSize) {
                        maxSize = size;
                    }
                }
            }
        }
        //If there is at least one magical element, this condition shouldn't occur
        return maxSize;
    }

    public static boolean isMagicalArray(int[] ar, int startIndex, int endIndex) {

        for (int i = startIndex; i <= endIndex; i++) {
            //If divisible neither by 2 nor 3
            if (ar[i] % 2 != 0 && ar[i] % 3 != 0) {
                return false;
            }
        }
        return true;
    }
}


/**
 * public int solve(int[] A) {
 * <p>
 * if(isMagic(A, 0)){
 * A[0] = 1;
 * }else{
 * A[0] = 0;
 * }
 * <p>
 * for(int i=1; i<A.length; i++){
 * if(isMagic(A, i)){
 * A[i] = A[i-1] + 1;
 * }else{
 * A[i] = 0;
 * }
 * }
 * int max = 0;
 * for(int i=0; i<A.length; i++){
 * if(A[i] > max){
 * max = A[i];
 * }
 * }
 * <p>
 * //If there is at least one magical element, this condition shouldn't occur
 * return max;
 * }
 * <p>
 * public boolean isMagic(int[] ar, int index){
 * if(ar[index] % 2 !=0 && ar[index] % 3 !=0){
 * return false;
 * }
 * return true;
 * }
 */