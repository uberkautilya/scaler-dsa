package advanced.dsa37_sep11.advanced_recursion;

public class TimeComplexity {
    /*
    Assume T.C. to calculate sum(N) = f(N)
    Hence, T.C. to calculate sum(N-1) = f(N)
    f(N) = f(N-1) + 1, assuming Time to resolve N to be O(1)
    f(N-1) = f(N-2) + 1
    => f(N) = f(N-2) + 1 + 1
    ..and further.

    f(N) = f(N-k) + k
    At N-k = 1, the value is defined. f(1) = 1
    i.e., f(N-k) = 1, at N-k = 1
    => f(N) = 1 + k, where k = N-1

    f(N) = 1 + K
         = 1 + N - 1
         = N
    Hence, the T.C. is O(N)
    Note: If for factorial the T.C. is calculated, time is added still
    Time is always added, never multiplied
     */
}
