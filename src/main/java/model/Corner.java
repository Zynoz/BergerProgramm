package model;

import model.api.ICorner;
import model.api.IEdge;

import java.util.List;

public class Corner implements ICorner {

    private List<IEdge> edges;
    private String name;

    public Corner(String name) {
        this.name = name;
    }

    public void addEdge(IEdge edge) {
        this.edges.add(edge);
    }

    public List<IEdge> getEdges() {
        return edges;
    }

    public String getName() {
        return name;
    }
}
