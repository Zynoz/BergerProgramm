package model.api;

import java.util.List;

public interface ICorner {
    List<ICorner> getAdjacents();
    String getName();
}
