package model;

import model.api.INode;
import model.api.IEdge;

import java.util.ArrayList;
import java.util.List;

public class Node implements INode {

    private List<IEdge> edges;
    private String name;

    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    @Override
    public List<IEdge> getEdges() {
        return edges;
    }

    @Override
    public void addEdge(IEdge edge) {
        this.edges.add(edge);
    }

    @Override
    public void deleteCorner() {
        for (IEdge edge : edges) {
            if (edge.getCornerA().equals(this)) {
                edge.setCornerA(null);
            } else if (edge.getCornerB().equals(this)) {
                edge.setCornerB(null);
            }
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Node{" +
//                "edges=" + edges +
                ", name='" + name + '\'' +
                '}';
    }
}