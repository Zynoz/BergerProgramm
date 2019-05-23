package model;

import model.api.INode;
import model.api.IEdge;
import model.api.IGraph;
import model.exception.GraphException;
import model.utils.UniqueList;

import java.util.ArrayList;
import java.util.List;

public class Graph implements IGraph {

    private String name;
    private List<INode> corners;

    public Graph(String name) {
        this.name = name;
    }

    public Graph(String name, List<INode> corners) {
        this.name = name;
        this.corners = corners;
    }

    public List<INode> getCorners() {
        return corners;
    }

    public List<IEdge> getEdges() {
        UniqueList<IEdge> uniqueEdges = new UniqueList<>();
        for (INode c : corners) {
            for (int j = 0; j < c.getEdges().size(); j++) {
                uniqueEdges.add(c.getEdges().get(j));
            }
        }
        return uniqueEdges.getList();
    }

    public void addCorner(INode corner) {
        if (corners.contains(corner)) {
            throw new GraphException("Node " + corner + " already in Graph!");
        } else {
            corners.add(corner);
        }

    }

    @Override
    public List<INode> getAdajacentCorners(INode corner) {
        List<INode> adjacents = new ArrayList<>();
        corners.stream().filter(c -> c == corner).forEach(c -> c.getEdges().forEach(e -> {
            adjacents.add(e.getCornerA());
            adjacents.add(e.getCornerB());
        }));
        return adjacents;
    }

    @Override
    public List<IEdge> getAdjacentEdges(INode corner) {
        return corner.getEdges();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void reset() {
        name = "";
        corners = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Graph{" +
                "name='" + name + '\'' +
                ", corners=" + corners +
                '}';
    }
}
