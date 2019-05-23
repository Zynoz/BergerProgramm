package model;

import model.api.ICorner;
import model.api.IEdge;
import model.exception.MatrixException;
import model.utils.MatrixUtils;
import model.utils.UniqueList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class GraphManagment {

    private final Logger logger = LogManager.getLogger(GraphManagment.class);

    private Graph graph;

    public GraphManagment() {

    }

    public void createGraph(String name, final Matrix matrix) throws MatrixException{
        if (!MatrixUtils.isValidMatrix(matrix)) {
            throw new MatrixException("Matrix not valid!");
        }
        int[][] m = matrix.getGrid();

        List<ICorner> corners = new ArrayList<>();
        List<IEdge> edges = new ArrayList<>();

        UniqueList uniqueCorners = new UniqueList();

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                ICorner corner = new Corner(1 + ":" + j);
                System.out.println(corner);
//                addEdgeds(edges, i, j);
            }
        }

//        Graph graph = new Graph(name, corners, edges);
//        this.graphs.add(graph);
//        logger.info(graph.toString());
    }

//    private void addEdgeds(final Set<IEdge> edges, final Set<ICorner> corners, final int i, final int j) {
//        IEdge edge = new Edge(i + ":" + j, corners.);
//    }
}
