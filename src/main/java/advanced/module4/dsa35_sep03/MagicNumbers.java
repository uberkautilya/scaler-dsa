package advanced.module4.dsa35_sep03;

import java.util.ArrayList;
import java.util.Arrays;

public class MagicNumbers {
    public static void main(String[] args) {
        MagicNumbers mN = new MagicNumbers();
        int result = mN.solve(257); //Expected: 1953130
        System.out.println("result = " + result);

        int num = 257;
        ArrayList<Integer> intList = mN.getList(num);
        System.out.println("intList = " + intList.get(num - 1));
    }

    public int solve(int A) {
        int count = 2;
        ArrayList<Integer> magicNums = new ArrayList<>(Arrays.asList(5, 25));
        while (count < A) {
            int size = magicNums.size();
            int lastPower = magicNums.get(size - 1);
            for (int i = 0; i <= size - 2; i++) {
                int newNum = lastPower + magicNums.get(i);
                count++;
                if (count == A) {
                    return newNum;
                }
                magicNums.add(newNum);
            }
            int newPower = lastPower * 5;
            count++;
            if (count == A) {
                return newPower;
            }
            magicNums.add(newPower);
        }
        return magicNums.get(A - 1);
    }

    public ArrayList<Integer> getList(int A) {
        int count = 2;
        ArrayList<Integer> magicNums = new ArrayList<>(Arrays.asList(5, 25));
        while (count < A) {
            int size = magicNums.size();
            int lastPower = magicNums.get(size - 1);
            for (int i = 0; i <= size - 2; i++) {
                int newNum = lastPower + magicNums.get(i);
                count++;
                if (count == A) {
                    magicNums.add(newNum);
                    return magicNums;
                }
                magicNums.add(newNum);
            }
            int newPower = lastPower * 5;
            count++;
            if (count == A) {
                magicNums.add(newPower);
                return magicNums;
            }
            magicNums.add(newPower);
        }
        return magicNums;
    }

    private static void printBinaries(ArrayList<Integer> magicNums) {
        for (int num : magicNums) {
            System.out.println(String.format("%5s", num + ": ") + String.format("%10s", Integer.toBinaryString(num)));
        }
    }
}
