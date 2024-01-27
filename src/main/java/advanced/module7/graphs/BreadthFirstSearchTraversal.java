package advanced.module7.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BreadthFirstSearchTraversal {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjoinList = new ArrayList<>();
        ArrayList<Integer> intList;

        intList = new ArrayList<>(Arrays.asList(1, 3));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(2, 0));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(3, 5));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(4, 6));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(4, 6));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(4, 6));
        adjoinList.add(new ArrayList<>(intList));
        intList = new ArrayList<>(Arrays.asList(4, 6));
        adjoinList.add(new ArrayList<>(intList));

        Node[] nodeArray = {
                new Node(101, "Node101"),
                new Node(102, "Node102"),
                new Node(103, "Node103"),
                new Node(104, "Node104"),
                new Node(105, "Node105"),
                new Node(106, "Node106"),
                new Node(100, "Node100")
        };
        for (int i = 0; i < nodeArray.length; i++) {
            breadthFirstSearch(
                    nodeArray,
                    i,
                    new boolean[7],
                    new CustomQueue(),
                    adjoinList
            );
        }
    }

    public static void breadthFirstSearch(Node[] nodeArray, Integer index, boolean[] visited,
                                          Queue<Node> queue, ArrayList<ArrayList<Integer>> adjoinNodesArray) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        queue.add(nodeArray[index]);

        while (!queue.isEmpty()) {
            Node n = queue.remove();
            System.out.println(n);

            //adjoinNodesArray.get(index) gives the list of nodes to which the current index node is connected
            for (Integer adjoinNodeIndex : adjoinNodesArray.get(index)) {
                if (!visited[adjoinNodeIndex]) {
                    visited[adjoinNodeIndex] = true;
                    queue.add(nodeArray[adjoinNodeIndex]);
                }
            }
        }
    }
}
