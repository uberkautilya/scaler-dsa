package homeworks_experiments.bitwiseoperations;

import java.util.ArrayList;
import java.util.List;

public class MagicNumbersPowersOf5 {
    public static void main(String[] args) {
        System.out.println("solve(10) = " + solve(10));
    }


    public static int solve(int A) {
        //Magic Numbers: 5, 25, 30, 125, 130, 150, 155, 625, 630, 650, 655, 750..
        List<Integer> valueList = new ArrayList<>();
        if (A == 1) return 5;
        if (A == 2) return 25;
        valueList.add(5);
        valueList.add(25);

        int power = 25;
        int count = 2;

        while (count <= A) {
            for (int i = 0; i < valueList.size(); i++) {
                Integer val = valueList.get(i);
                if (val < power) {
                    count++;
                    if (count == A) return (power + val);
                    valueList.add(power + val);
                }
            }
            power *= 5;
            count++;
            if (count == A) return power;
            valueList.add(power);
        }

        return 0;
    }
}
