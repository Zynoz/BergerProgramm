package model.utils;

import model.api.ICE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueList<T extends ICE> {

    private HashSet<T> masterSet = new HashSet();
    private ArrayList<T> innerList;
    private Object[] returnable;

    public UniqueList() {
        innerList = new ArrayList<T>();
    }

    public UniqueList(int size) {
        innerList = new ArrayList<T>(size);
    }

    public void add(T thing) {
        if (!masterSet.contains(thing)) {
            masterSet.add(thing);
            innerList.add(thing);
        }
    }

    public List<T> getList() {
        return innerList;
    }

    public int size() {
        return innerList.size();
    }

    public boolean contains(T t) {
        return masterSet.contains(t);
    }

    public T get(int index) {
        return innerList.get(index);
    }

    public Object[] toObjectArray() {
        int size = innerList.size();
        returnable = new Object[size];
        for (int i = 0; i < size; i++) {
            returnable[i] = innerList.get(i);
        }
        return returnable;
    }
}
