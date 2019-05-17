package model;

import model.api.ICorner;
import model.api.IEdge;
import model.api.IGraph;
import model.exception.GraphException;

import java.util.ArrayList;
import java.util.List;

public class Graph implements IGraph {

    private String name;
    private List<ICorner> corners;
    private List<IEdge> edges;

    public Graph(String name) {
        this.name = name;
    }

    public Graph(String name, List<ICorner> corners, List<IEdge> edges) {
        this.name = name;
        this.corners = corners;
        this.edges = edges;
    }

    public List<ICorner> getCoreners() {
        return corners;
    }

    public List<IEdge> getEdges() {
        return edges;
    }

    public void addCorner(ICorner corner) {
        if (corners.contains(corner)) {
            throw new GraphException("Corner " + corner + " already in Graph!");
        } else {
            corners.add(corner);
        }

    }

    public void addEdge(IEdge edge, ICorner cornerA, ICorner cornerB) {

    }

    public void removeCorner(ICorner corner) {

    }

    public void removeEdge(IEdge edge) {

    }

    //todo fix this
    @Override
    public List<ICorner> getAdajacentCorners(ICorner corner) {
        List<ICorner> adjacents = new ArrayList<>();
        corners.stream().filter(c -> c == corner).forEach(c -> c.getEdges().forEach(e -> adjacents.addAll(e.getCorners())));
        return adjacents;
    }

    //todo fix this
    @Override
    public List<IEdge> getAdjacentEdges(ICorner corner) {
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
        edges = new ArrayList<>();
    }

    @Override
    public int calculateDiameter() {
        int max = -1;
        for (int i = 0; i < corners.size(); i++) {

        }
        return max;
    }
}
