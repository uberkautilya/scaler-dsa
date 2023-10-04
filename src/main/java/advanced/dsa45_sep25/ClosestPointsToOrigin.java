package advanced.dsa45_sep25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ClosestPointsToOrigin {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 3));
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        arrayList.add(list);

        ArrayList<ArrayList<Integer>> solve = new ClosestPointsToOrigin().solve(
                arrayList,
                1
        );
        System.out.println("solve = " + solve);
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        A.sort(new ArrayListComparator());
        ArrayList<ArrayList<Integer>> closestBPoints = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            closestBPoints.add(A.get(i));
        }
        return closestBPoints;
    }

    private class ArrayListComparator implements Comparator<ArrayList<Integer>> {

        @Override
        public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
            Integer x1 = a1.get(0);
            Integer y1 = a1.get(1);
            Integer x2 = a2.get(0);
            Integer y2 = a2.get(1);
            long x1Squared = (long) x1 * x1;
            long y1Squared = (long) y1 * y1;
            long x2Squared = (long) x2 * x2;
            long y2Squared = (long) y2 * y2;

            double dist1 = Math.sqrt((x1Squared + y1Squared) % 1000_000_007);
            double dist2 = Math.sqrt((x2Squared + y2Squared) % 1000_000_007);
            return (int) (dist1 - dist2);
        }
    }
}
