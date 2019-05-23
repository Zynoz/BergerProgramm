package model.api;

import java.util.List;

public interface INode extends ICE {
    List<IEdge> getEdges();
    void addEdge(IEdge edge);
    void deleteCorner();
}
