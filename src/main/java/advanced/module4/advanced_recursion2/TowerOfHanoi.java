package advanced.module4.advanced_recursion2;

/**
 * 3 towers, N discs on them, smaller ones stacked on larger ones. Move them across to the 3rd post
 * At no point can a larger disc be placed over a smaller disc. Also, only a single disc can be moved at a time.
 * Print the sequence of movements.
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        int discCount = 3;
        char source = 'A';
        char temp = 'B';
        char destination = 'C';

        new TowerOfHanoi().solve(discCount, source, temp, destination);
    }

    private void solve(int discCount, char source, char temp, char destination) {
        //Algorithm:
        // 1. Move n-1 to the temp first.
        // 2. Move the last disc from source to destination
        // 3. Move the n-1 discs kept at temp to the destination
        // discCount = 0 or discCount = 1 are valid base conditions
        if (discCount == 1) {
            System.out.println(source + "-> " + destination);
            return;
        }
        solve(discCount - 1, source, destination, temp);
        System.out.println(source + "-> " + destination);
        solve(discCount - 1, temp, source, destination);
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
