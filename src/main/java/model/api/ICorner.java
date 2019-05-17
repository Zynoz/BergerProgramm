package model.api;

import javafx.collections.ObservableList;

import java.util.List;

public interface ICorner {
    ObservableList<List<IEdge>> getEdges();
    String getName();
}
