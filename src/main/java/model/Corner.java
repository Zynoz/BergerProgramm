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

    @Override
    public void addEdge(IEdge edge) {
        this.edges.add(edge);
    }

    @Override
    public List<IEdge> getEdges() {
        return edges;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Corner{" +
                "name='" + name + '\'' +
                '}';
    }
}
