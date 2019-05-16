package model.api;

import java.util.List;

public interface IGraph {
    List<IGraph> getAdjazent();
}
