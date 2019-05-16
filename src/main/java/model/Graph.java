package model;

import model.api.IGraph;

import java.util.List;

public class Graph implements IGraph {

    private List<IGraph> adjazents;

    public Graph() {

    }


    public List<IGraph> getAdjazent() {
        return adjazents;

    }
}
