package model;

import model.api.ICorner;
import model.api.IEdge;
import model.exception.MatrixException;
import model.utils.MatrixUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GraphManagment {

    private final Logger logger = LogManager.getLogger(GraphManagment.class);

    private List<Graph> graphs = new ArrayList<>();

    public GraphManagment() {

    }

    public void createGraph(final Matrix matrix) throws MatrixException{
        if (!MatrixUtils.isValidMatrix(matrix)) {
            throw new MatrixException("Matrix not valid!");
        }
        int[][] m = matrix.getGrid();
        List<ICorner> corners = new ArrayList<>(m.length);
        List<IEdge> edges = new ArrayList<>();

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                corners.add(new Corner(i + ":" + j));
                if (m[j][i] == m[j][i] && m[j][i] == 1) {
                    edges.add(new Edge(i + ":" + j, corners.get(i), corners.get(j)));
                }
            }
        }

        Graph graph = new Graph("Test", corners, edges);
        this.graphs.add(graph);
        logger.info(graph.toString());
    }
}