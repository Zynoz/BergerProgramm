package model.api;

public interface IEdge extends ICE {
    void setCorner(INode cornerB);
    void deleteEdge();
    INode getCornerA();
    INode getCornerB();
    void setCornerA(INode cornerA);
    void setCornerB(INode cornerB);
}
