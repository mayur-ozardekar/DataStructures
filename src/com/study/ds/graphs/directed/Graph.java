package com.study.ds.graphs.directed;

import java.util.*;

public class Graph {

    class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();
        Node toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        Set<Node> nodes = adjacencyList.keySet();
        for (Node source : nodes) {
            List<Node> targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null) return;

        List<Node> nodeList = adjacencyList.get(node);
        for (Node nodeAdjacent : nodeList)
            adjacencyList.get(nodeAdjacent).remove(node);

        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String fromLabel, String toLabel) {
        Node fromNode = nodes.get(fromLabel);
        Node toNode = nodes.get(toLabel);

        if (fromNode == null || toNode == null) return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseBredthFirst(String root) {
        Node node = nodes.get(root);

        if (node == null) return;

        traverseBreadthFirst(node);
    }

    private void traverseBreadthFirst(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        Set<Node> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (Node neighbour : adjacencyList.get(current))
                if (!visited.contains(neighbour))
                    queue.add(neighbour);
        }
    }

    public void traverseDepthFirstIterative(String root) {
        Node node = nodes.get(root);
        if (node == null) return;
        traverseDepthFirstIterative(node);
    }

    public void topologicalSort() {

        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (Node node : nodes.values())
            topologicalSort(node, stack, visited);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    public boolean hasCycle(){
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while(!all.isEmpty()){
            Node current = all.iterator().next();
            if(hasCycle(current, all, visiting, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for(Node neighbour : adjacencyList.get(node)){
            if(visited.contains(neighbour)) continue;
            if(visiting.contains(neighbour)) return true;

            if(hasCycle(neighbour, all, visiting, visited))
                return true;
        }

        visited.add(node);
        visiting.remove(node);

        return false;
    }

    private void topologicalSort(Node root, Stack<Node> stack, Set<Node> visited) {
        if(visited.contains(root)) return;

        visited.add(root);

        for (Node neighbour : adjacencyList.get(root))
            topologicalSort(neighbour, stack, visited);

        stack.push(root);
    }

    /**
     * DFS Iterative
     */
    private void traverseDepthFirstIterative(Node root) {

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        Set<Node> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (Node neighbours : adjacencyList.get(current)) {
                if (!visited.contains(neighbours))
                    stack.push(neighbours);
            }
        }

    }

    public void traverseDepthFirstRecursive(String root) {
        Node node = nodes.get(root);
        if (node != null)
            traverseDepthFirstRecursive(nodes.get(root), new HashSet<>());
    }

    /**
     * DFS Recursion
     */
    private void traverseDepthFirstRecursive(Node root, Set<Node> visited) {
//        System.out.println(root);
        visited.add(root);

        for (Node node : adjacencyList.get(root))
            if (!visited.contains(node))
                traverseDepthFirstRecursive(node, visited);

        System.out.println(root);
    }
}
