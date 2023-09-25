package advanced.dsa44_sep22;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxAndMinMagicNumber {

    private ArrayList<Integer> solve(ArrayList<Integer> A) {
        int maxMagicNum = 0;
        int minMagicNum = 0;
        //Quick sort it. Add maximum to min and so on to get the maximum possible magic number
        //Add minimum to minimum after half and so on to get the minimum possible magic number
        return new ArrayList<>(Arrays.asList(maxMagicNum, minMagicNum));
    }
}
