package com.khanchych.sandbox.graphtask;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int verticeCount;
    private List<Integer>[] adjacents;
    private int edgeCount;

    public Graph(int verticeCount) {
        this.verticeCount = verticeCount;
        this.adjacents = (List<Integer>[]) new List[verticeCount];
        for (int i = 0; i < verticeCount; i++) {
            adjacents[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adjacents[v].add(w);
        adjacents[w].add(v);
        edgeCount++;
    }

    public Iterable<Integer> getAdjacents(int v) {
        return adjacents[v];
    }
}
