package model.api;

import java.util.List;

public interface IGraph {
    List<INode> getCorners();
    List<IEdge> getEdges();
    List<INode> getAdajacentCorners(INode corner);
    List<IEdge> getAdjacentEdges(INode corner);
    void setName(String name);
    String getName();
}
