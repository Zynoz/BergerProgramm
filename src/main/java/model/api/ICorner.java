package model.api;

import java.util.List;

public interface ICorner {
    List<IEdge> getEdges();
    String getName();
}
