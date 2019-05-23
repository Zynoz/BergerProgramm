package model.api;

import java.util.List;

public interface ICorner extends ICE {
    List<IEdge> getEdges();
    void addEdge(IEdge edge);
    String getName();
}
