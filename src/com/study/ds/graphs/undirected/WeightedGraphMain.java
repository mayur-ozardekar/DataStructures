package com.study.ds.graphs.undirected;

public class WeightedGraphMain {
    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addNode("A");
        weightedGraph.addNode("B");
        weightedGraph.addNode("C");
        weightedGraph.addNode("D");

        weightedGraph.addEdge("A", "B", 1);
        weightedGraph.addEdge("B", "C", 2);
        weightedGraph.addEdge("C", "D", 10);
        weightedGraph.addEdge("D", "A", 5);

        weightedGraph.print();

        Path path = weightedGraph.shortestPath("A", "C");
        System.out.println(path);

        System.out.println(weightedGraph.hasCycle());

        System.out.println(weightedGraph.getMinimumSpanningTree());

    }
}
