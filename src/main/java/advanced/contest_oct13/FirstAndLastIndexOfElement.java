package advanced.contest_oct13;

public class FirstAndLastIndexOfElement {
    public int[] solve(int[] A, Integer needle) {
        int firstIndex = -1;
        int lastIndex = -1;

        int l = 0;
        int h = A.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (A[mid] == needle) {
                //Use binary search 2 more times to get smallest index and largest index
                if (A[mid - 1] != needle) {
                    firstIndex = mid;
                } else {
                    h = mid - 1;
                }
                if (A[mid + 1] != needle) {
                    lastIndex = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (A[mid] < needle) {
                l = mid + 1;
            }
            if (A[mid] > needle) {
                h = mid - 1;
            }
        }
        return new int[]{firstIndex, lastIndex};
    }
}
