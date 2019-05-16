package model.api;

import java.util.List;

public interface IEdge {
    List<ICorner> getCorners();
    void setCorners(List<ICorner> iCorners);
    String getName();
    void setName(String name);
}
