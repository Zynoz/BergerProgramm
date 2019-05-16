package model;

import model.api.ICorner;

import java.util.List;

public class Corner implements ICorner {

    private List<ICorner> adjacents;
    private String name;

    public Corner(String name) {
        this.name = name;
    }

    public List<ICorner> getAdjacents() {
        return adjacents;
    }

    public String getName() {
        return name;
    }
}
