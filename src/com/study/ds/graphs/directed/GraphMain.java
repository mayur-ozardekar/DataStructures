package com.study.ds.graphs.directed;

public class GraphMain {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        //graph.removeEdge("A", "C");
        //graph.removeNode("A");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        //graph.traverseDepthFirstRecursive("A");
        graph.traverseDepthFirstIterative("G");
        graph.traverseBredthFirst("G");
        graph.print();


        graph = new Graph();
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");

        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("X", "P");
        graph.addEdge("X", "P");

        //graph.topologicalSort();


        graph = new Graph();
        graph.addNode("Pete");
        graph.addNode("Barbara");
        graph.addNode("Nick");
        graph.addNode("Sophie");
        graph.addNode("Jonas");
        graph.addNode("Mayur");

        graph.addEdge("Pete", "Nick");
        graph.addEdge("Barbara", "Nick");
        graph.addEdge("Nick", "Sophie");
        graph.addEdge("Sophie", "Jonas");
        //graph.addEdge("Nick", "Jonas");
        graph.addEdge("Sophie", "Nick");

        graph.print();

        //System.out.println("-----");
        //System.out.println(graph.hasCycle());
        //System.out.println("-----");
        // graph.topologicalSort();
        System.out.println("-----");
        graph.traverseDepthFirstIterative("Sophie");
        System.out.println("-----");
        graph.traverseDepthFirstRecursive("Pete");
        // System.out.println("-----");
        // graph.traverseBredthFirst("Sophie");
    }
}
