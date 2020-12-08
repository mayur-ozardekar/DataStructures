package com.study.ds.graphs.undirected;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<String> nodes = new ArrayList<>();

    public void add(String path){
        nodes.add(path);
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
