package model.api;

import java.util.List;

public interface IGraph {
    List<ICorner> getCoreners();
    List<IEdge> getEdges();

    void addCorner(ICorner corner);
    void addEdge(IEdge edge, ICorner cornerA, ICorner cornerB);

    void removeCorner(ICorner corner);
    void removeEdge(IEdge edge);

    List<ICorner> getAdajacentCorners(ICorner corner);
    List<IEdge> getAdjacentEdges(ICorner corner);

    void setName(String name);
    String getName();

    int calculateDiameter();
}
