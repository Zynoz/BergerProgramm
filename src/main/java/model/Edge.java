package model;

import model.api.INode;
import model.api.IEdge;

public class Edge implements IEdge {

    private INode cornerA;
    private INode cornerB;
    private String name;

    public Edge(String name, INode cornerA) {
        this.name = name;
        this.cornerA = cornerA;
    }

    public Edge(String name, INode cornerA, INode cornerB) {
        this.name = name;
        this.cornerA = cornerA;
        this.cornerB = cornerB;
    }

    @Override
    public void setCorner(INode corner) {
        if (cornerA == null) {
            this.cornerA = corner;
        } else {
            this.cornerB = corner;
        }
    }

    @Override
    public void deleteEdge() {
        cornerA.getEdges().remove(this);
        cornerB.getEdges().remove(this);
    }

    public INode getCornerA() {
        return cornerA;
    }

    public void setCornerA(INode cornerA) {
        this.cornerA = cornerA;
    }

    public INode getCornerB() {
        return cornerB;
    }

    public void setCornerB(INode cornerB) {
        this.cornerB = cornerB;
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
//                "cornerA=" + cornerA +
//                ", cornerB=" + cornerB +
                ", name='" + name + '\'' +
                '}';
    }
}