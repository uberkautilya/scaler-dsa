package advanced.module7.graphs;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * In the class the approach with array of adjacency list was discussed, adjoinAdjacencyListArray and visited array.
 * Here, the same has been implemented with HashMap.
 */
public class DFSearchArrayImplementation {

    public static void main(String[] args) {
        Node[] nodeList = getNodes();
        ArrayList<Integer>[] adjoinArray = new ArrayList[nodeList.length];
        adjoinArray[0] = new ArrayList<>(Arrays.asList(1, 2, 3));
        adjoinArray[1] = new ArrayList<>(Arrays.asList(0, 8));
        adjoinArray[2] = new ArrayList<>(Arrays.asList(7));
        adjoinArray[3] = new ArrayList<>(Arrays.asList(6, 5, 1));
        adjoinArray[4] = new ArrayList<>(Arrays.asList(2, 8));
        adjoinArray[5] = new ArrayList<>(Arrays.asList(2));
        adjoinArray[6] = new ArrayList<>(Arrays.asList(1, 4));
        adjoinArray[7] = new ArrayList<>(Arrays.asList(5, 1, 8));
        adjoinArray[8] = new ArrayList<>(Arrays.asList(7, 6, 3));
        new DFSearchArrayImplementation().traverse(nodeList, adjoinArray);
    }

    private static Node[] getNodes() {

        Node node101 = new Node(101, "Node101");
        Node node102 = new Node(102, "Node102");
        Node node103 = new Node(103, "Node103");
        Node node104 = new Node(104, "Node104");
        Node node105 = new Node(105, "Node105");
        Node node106 = new Node(106, "Node106");
        Node node107 = new Node(107, "Node107");
        Node node108 = new Node(108, "Node108");
        Node node109 = new Node(109, "Node109");
        return new Node[]{
                node101,
                node102,
                node103,
                node104,
                node105,
                node106,
                node107,
                node108,
                node109
        };
    }

    public void traverse(Node[] nodeArray, ArrayList<Integer>[] adjoinArray) {

        boolean[] visited = new boolean[nodeArray.length];
        for (int i = 0; i < nodeArray.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < nodeArray.length; i++) {
            if (!visited[i]) {
                depthFirstSearch(nodeArray, i, visited, adjoinArray);
            }
        }
    }

    private void depthFirstSearch(Node[] nodeArray, int index, boolean[] visited,
                                  ArrayList<Integer>[] adjoinArray) {
        visited[index] = true;
        System.out.println(nodeArray[index]);

        for (Integer i : adjoinArray[index]) {
            if (!visited[i]) {
                depthFirstSearch(nodeArray, i, visited, adjoinArray);
            }
        }
    }
}