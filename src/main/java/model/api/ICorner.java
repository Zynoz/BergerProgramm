package model.api;

import java.util.List;

public interface ICorner {
    List<IEdge> getEdges();
    void addEdge(IEdge edge);
    String getName();
}
