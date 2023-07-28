package dsa21_July28_contest_2;

import java.util.ArrayList;

public class AlternateNegAndPositiveArray {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(-2);
        a.add(3);
        a.add(-7);
        System.out.println("solve(a) = " + solve(a));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int nIndex = 0;
        int pIndex = 0;
        int size = A.size();
        ArrayList<Integer> newArray = new ArrayList<>();
        while (pIndex < size || nIndex < size) {
            while (nIndex < size) {
                if (A.get(nIndex) < 0) {
                    newArray.add(A.get(nIndex));
                    nIndex++;
                    break;
                } else {
                    nIndex++;
                }
            }

            while (pIndex < size) {
                if (A.get(pIndex) > 0) {
                    newArray.add(A.get(pIndex));
                    pIndex++;
                    break;
                } else {
                    pIndex++;
                }
            }
        }
        return newArray;
    }
}
