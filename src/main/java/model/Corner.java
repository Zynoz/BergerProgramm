package model;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import model.api.ICorner;
import model.api.IEdge;

import java.util.Collections;
import java.util.List;

public class Corner implements ICorner {

    private SimpleListProperty<List<IEdge>> edges = new SimpleListProperty<>();
    private SimpleStringProperty name = new SimpleStringProperty();

    public Corner(String name) {
        this.name.set(name);
    }

    public void addEdge(IEdge edge) {
        this.edges.get().add(Collections.singletonList(edge));
    }

    public ObservableList<List<IEdge>> getEdges() {
        return edges.get();
    }

    public String getName() {
        return name.get();
    }
}
