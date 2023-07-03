package homeworks_experiments;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] a = {3, 2, 4, 5, 2, 7, -1, 5};
        int leaders = countLeaders(a);
        System.out.println("No. of leaders: " + leaders);
    }

    /**
     * Leaders are those numbers for which all elements on its left are smaller than it
     *
     * @param a - an array of integers
     * @return the count of leaders
     */
    private static int countLeaders(int[] a) {
        //The first number is always a leader by default
        int leader = a[0];
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > leader) {
                leader = a[i];
                count++;
            }
        }
        return count;
    }
}

