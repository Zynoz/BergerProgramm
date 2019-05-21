package model;

import model.api.ICorner;
import model.api.IEdge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Edge implements IEdge {

    private List<ICorner> corners = new ArrayList<>();
    private String name;

    public Edge(String name, ICorner... corners) {
        this.name = name;
        this.corners.addAll(Arrays.asList(corners));
    }

    public List<ICorner> getCorners() {
        return corners;
    }

    public void setCorners(List<ICorner> corners) {
        this.corners = corners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "name='" + name + '\'' +
                '}';
    }
}
