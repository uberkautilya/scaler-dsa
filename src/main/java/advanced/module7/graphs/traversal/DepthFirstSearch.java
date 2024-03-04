package advanced.module7.graphs.traversal;

import advanced.module7.graphs.Node;

import java.util.Arrays;
import java.util.List;

public class DepthFirstSearch {
    static boolean[] isVisited;
    static List<Integer>[] adjacencyList;

    public static void traversal(int n) {
        //boolean array to control an endless recursion
        boolean[] isVisited = new boolean[n+1];

        Arrays.fill(isVisited, false);
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
    }

    public static void dfs(int n) {
        isVisited[n] = true;
        System.out.println(n);

        for (int d : adjacencyList[n]) {
            if (!isVisited[d]) {
                dfs(d);
            }
        }
    }
}
