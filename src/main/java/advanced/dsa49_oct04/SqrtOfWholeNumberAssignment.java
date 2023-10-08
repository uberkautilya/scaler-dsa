package advanced.dsa49_oct04;

public class SqrtOfWholeNumberAssignment {
    public int sqrt(int A) {
        if(A == 0){
            return 0;
        }
        int l = 1;
        int h = A;
        int sqrt = -1;

        while(l <= h){
            int mid = (l + h) /2;
            if(mid * mid <= A){
                sqrt = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return sqrt;
    }
}
