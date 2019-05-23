package model;

import model.api.INode;
import model.exception.MatrixException;
import model.utils.MatrixUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.MatrixGrid;

import java.util.ArrayList;
import java.util.List;

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
        List<INode> corners = new ArrayList<>();

        for (int i = 0; i < m.length; i++) {
            if (i == 0) continue;
            Node corner = new Node(MatrixGrid.getXHeader(false).get(i).getText());
            corners.add(corner);
            for (int j = 0; j < m[i].length; j++) {
                if (j == 0) continue;
                logger.info(i + " " + j);
                if (m[i][j] == 1) {
                    logger.info("edge at " + i + " " + j);
                    Edge edge = new Edge(i + " : " + j, corner);
                    corner.addEdge(edge);
                }
            }
        }

        graph = new Graph(name, corners);
    }

    public int calculateRadius() {
        return 0;
    }

    public int calculateDiameter() {
        return 0;
    }

    @Override
    public String toString() {
        return "GraphManagment{" +
                "logger=" + logger +
                ", graph=" + graph +
                '}';
    }
}
