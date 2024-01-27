package advanced.module7.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BreadthFirstSearchTraversal {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjoinList = new ArrayList<>();
        ArrayList<Integer> intList;

        intList = new ArrayList<>(Arrays.asList(6, 3));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(4, 0));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(6, 5));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(2, 6));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(4, 1));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(4, 5));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(1, 3));
        adjoinList.add(new ArrayList<>(intList));
        boolean[] visited = new boolean[7];

        Node[] nodeArray = {
                new Node(100, "Node100"),
                new Node(101, "Node101"),
                new Node(102, "Node102"),
                new Node(103, "Node103"),
                new Node(104, "Node104"),
                new Node(105, "Node105"),
                new Node(106, "Node106")
        };
        for (int index = 0; index < nodeArray.length; index++) {
            breadthFirstSearch(
                    nodeArray,
                    index,
                    visited,
                    new CustomQueue(),
                    adjoinList
            );
        }
    }

    public static void breadthFirstSearch(Node[] nodeArray, Integer index, boolean[] visited,
                                          Queue<Node> queue, ArrayList<ArrayList<Integer>> adjoinNodesList) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        queue.add(nodeArray[index]);

        while (!queue.isEmpty()) {
            Node n = queue.remove();
            System.out.println(n);

            //adjoinNodesList.get(index) gives the list of nodes to which the current index node is connected
            for (Integer adjoinNodeIndex : adjoinNodesList.get(index)) {
                if (!visited[adjoinNodeIndex]) {
                    visited[adjoinNodeIndex] = true;
                    queue.add(nodeArray[adjoinNodeIndex]);
                }
            }
        }
    }
}
