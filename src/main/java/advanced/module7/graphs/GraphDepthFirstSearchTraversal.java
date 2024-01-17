package advanced.module7.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * In the class the approach with arrays was discussed - node array, adjoinArray and visited array.
 * Here, the same has been implemented with HashMap.
 */
public class GraphDepthFirstSearchTraversal {
    public static void main(String[] args) {
        Node node101 = new Node(101, "Node101");
        Node node102 = new Node(102, "Node102");
        Node node103 = new Node(103, "Node103");
        Node node104 = new Node(104, "Node104");
        Node node105 = new Node(105, "Node105");
        Node node106 = new Node(106, "Node106");
        Node node107 = new Node(107, "Node107");
        Node node108 = new Node(108, "Node108");
        Node node109 = new Node(109, "Node109");
        List<Node> nodeList = new ArrayList<>(Arrays.asList(
                node101,
                node102,
                node103,
                node104,
                node105,
                node106,
                node107,
                node108,
                node109
        ));
        HashMap<Node, List<Node>> adjoinMap = new HashMap<>();
        adjoinMap.put(node101, new ArrayList<>(Arrays.asList(node107, node109)));
        adjoinMap.put(node102, new ArrayList<>(Arrays.asList(node108, node109)));
        adjoinMap.put(node103, new ArrayList<>(Arrays.asList(node103, node104)));
        adjoinMap.put(node104, new ArrayList<>(Arrays.asList(node105, node103)));
        adjoinMap.put(node105, new ArrayList<>(Arrays.asList(node108, node102)));
        adjoinMap.put(node106, new ArrayList<>(Arrays.asList(node104, node103)));
        adjoinMap.put(node107, new ArrayList<>(Arrays.asList(node102, node109)));
        adjoinMap.put(node108, new ArrayList<>(Arrays.asList(node108, node109)));
        adjoinMap.put(node109, new ArrayList<>(Arrays.asList(node106, node101)));
        new GraphDepthFirstSearchTraversal().traverse(nodeList, adjoinMap);
    }

    public void traverse(List<Node> nodeList, HashMap<Node, List<Node>> adjoinMap) {
        HashMap<Node, Boolean> visited = new HashMap<>();
        for (Node node : nodeList) {
            visited.put(node, false);
        }
        for (Node node : nodeList) {
            if (!visited.get(node)) {
                depthFirstSearch(node, visited, adjoinMap);
            }
        }
    }

    private void depthFirstSearch(Node node, HashMap<Node, Boolean> visited,
                                  HashMap<Node, List<Node>> adjoinMap) {
        visited.put(node, true);
        System.out.println(node);

        for (Node destinationNode : adjoinMap.get(node)) {
            if (!visited.get(destinationNode)) {
                depthFirstSearch(destinationNode, visited, adjoinMap);
            }
        }
    }
}
