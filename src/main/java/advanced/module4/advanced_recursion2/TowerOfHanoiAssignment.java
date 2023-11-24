package advanced.module4.advanced_recursion2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
 * The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
 * You have the following constraints:
 * <p>
 * Only one disk can be moved at a time.
 * A disk is slid off the top of one tower onto another tower.
 * A disk cannot be placed on top of a smaller disk.
 * You have to find the solution to the Tower of Hanoi problem.
 * You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
 * In each row, there should be 3 integers (disk, start, end), where:
 * <p>
 * disk - number of the disk being moved
 * start - number of the tower from which the disk is being moved
 * end - number of the tower to which the disk is being moved
 */
public class TowerOfHanoiAssignment {
    public static void main(String[] args) {
        int discCount = 3;
        int source = 1;
        int temp = 2;
        int destination = 3;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        new TowerOfHanoiAssignment().solve(discCount, source, temp, destination, result);
        System.out.println("result = " + result);
    }

    private void solve(int discCount, int source, int temp, int destination, ArrayList<ArrayList<Integer>> result) {
        //Algorithm:
        // 1. Move n-1 to the temp first.
        // 2. Move the last disc from source to destination
        // 3. Move the n-1 discs kept at temp to the destination
        // discCount = 0 or discCount = 1 are valid base conditions
        if (discCount == 1) {
            System.out.println(discCount + ": " + source + "-> " + destination);
            result.add(new ArrayList<>(Arrays.asList(discCount, source, destination)));
            return;
        }
        solve(discCount - 1, source, destination, temp, result);
        result.add(new ArrayList<>(Arrays.asList(discCount, source, destination)));
        System.out.println(discCount + ": " + source + "-> " + destination);
        solve(discCount - 1, temp, source, destination, result);
    }
}

/*
//This is also a valid base condition
if (discCount == 0) {
    return;
}
Answer for discCount = 3
A-> C
A-> B
C-> B
A-> C
B-> A
B-> C
A-> C
 */
/*
To find the time complexity, we need to form the recursive relationship first
T(N) = T(N-1) + 1 + T(N-1) = 2T(N-1) + 1
    T(N-1) = 2T(N-2) + 1
T(N) = 4 T(N-2) + 3
    T(N-2) = 2T(N-3) + 1
T(N) = 8T(N-3) + 7

T(N) = 2^k T(N-k) + (2^k - 1)

At k = N  - 1, T(N-k) = T(1)
=> T(N) = 2^(N - 1) + 2^(N - 1) - 1 = 2 ^ (N - 1) * (1 + 1) - 1 = 2^N - 1
 */
