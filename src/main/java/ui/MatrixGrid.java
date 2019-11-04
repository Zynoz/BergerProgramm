package ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MatrixGrid extends GridPane {

    private final Logger logger = LogManager.getLogger(MatrixGrid.class);

    private boolean header;
    private RootBorderPane rootBorderPane;

    private int size;
    private List<GridButton> buttons = new ArrayList<>();
    private static final List<Label> headersX = new ArrayList<>();
    private static final List<Label> headersY = new ArrayList<>();
    private static final List<Label> headersX1 = new ArrayList<>();
    private static final List<Label> headersY1 = new ArrayList<>();

    static  {
        headersX.add(new Label(""));
        headersX.add(new Label("A"));
        headersX.add(new Label("B"));
        headersX.add(new Label("C"));
        headersX.add(new Label("D"));
        headersX.add(new Label("E"));
        headersX.add(new Label("F"));
        headersX.add(new Label("G"));
        headersX.add(new Label("H"));
        headersX.add(new Label("I"));
        headersX.add(new Label("J"));
        headersX.add(new Label("K"));
        headersX.add(new Label("L"));
        headersX.add(new Label("M"));
        headersX.add(new Label("N"));
        headersX.add(new Label("O"));

        headersY.add(new Label(""));
        headersY.add(new Label("A"));
        headersY.add(new Label("B"));
        headersY.add(new Label("C"));
        headersY.add(new Label("D"));
        headersY.add(new Label("E"));
        headersY.add(new Label("F"));
        headersY.add(new Label("G"));
        headersY.add(new Label("H"));
        headersY.add(new Label("I"));
        headersY.add(new Label("J"));
        headersY.add(new Label("K"));
        headersY.add(new Label("L"));
        headersY.add(new Label("M"));
        headersY.add(new Label("N"));
        headersY.add(new Label("O"));

        headersX1.add(new Label(""));
        headersX1.add(new Label("1"));
        headersX1.add(new Label("2"));
        headersX1.add(new Label("3"));
        headersX1.add(new Label("4"));
        headersX1.add(new Label("5"));
        headersX1.add(new Label("6"));
        headersX1.add(new Label("7"));
        headersX1.add(new Label("8"));
        headersX1.add(new Label("9"));
        headersX1.add(new Label("10"));
        headersX1.add(new Label("11"));
        headersX1.add(new Label("12"));
        headersX1.add(new Label("13"));
        headersX1.add(new Label("14"));
        headersX1.add(new Label("15"));

        headersY1.add(new Label(""));
        headersY1.add(new Label("1"));
        headersY1.add(new Label("2"));
        headersY1.add(new Label("3"));
        headersY1.add(new Label("4"));
        headersY1.add(new Label("5"));
        headersY1.add(new Label("6"));
        headersY1.add(new Label("7"));
        headersY1.add(new Label("8"));
        headersY1.add(new Label("9"));
        headersY1.add(new Label("10"));
        headersY1.add(new Label("11"));
        headersY1.add(new Label("12"));
        headersY1.add(new Label("13"));
        headersY1.add(new Label("14"));
        headersY1.add(new Label("15"));
    }

    public static List<Label> getXHeader(boolean header) {
        return header ? headersX1 : headersX;
    }

    public static List<Label> getYHeader(boolean header) {
        return header ? headersY1 : headersY;
    }

    public MatrixGrid(RootBorderPane rootBorderPane, int size, boolean header) {
        this.rootBorderPane = rootBorderPane;
        if (size > 15 || size < 2) {
            logger.warn("Size must be between 1 and 16!");
            Main.createAlert(Alert.AlertType.ERROR, "Size must be between 1 and 16!");
        } else {
            this.size = ++size;
            this.header = header;
            init();
            addHeader();
        }
    }

    private void init() {
        logger.info("initializing...");
        this.setHgap(10);
        this.setVgap(10);
        this.setMaxSize(size * 35, size * 20);
        int row = size;
        int column = size;
        for (int i = 1; i < column; i++) {
            for (int j = 1; j < row; j++) {
                GridButton gb;
                if (i == j) {
                    gb = new GridButton(rootBorderPane, true, i, j);
                    System.out.println("created final button at " + i + " and " + j);
                    gb.setDisable(true);
                    gb.setStyle("-fx-background-color: #00ff00");
                } else {
                    gb = new GridButton(rootBorderPane, i, j);
                    System.out.println("created non final button at " + i + " and " + j);
                }
                buttons.add(gb);
                this.add(gb, i, j);
                System.out.println(gb);
            }
        }
    }

    private void addHeader() {
        logger.info("adding headers...");
        for (int i = 0; i < size; i++) {
            if (header) {
                this.add(headersX1.get(i), i, 0);
                this.add(headersY1.get(i), 0, i);
                logger.info("adding x: " + headersX1.get(i).getText());
                logger.info("adding y: " + headersY1.get(i).getText());
            } else {
                this.add(headersX.get(i), i, 0);
                this.add(headersY.get(i), 0, i);
                logger.info("adding x: " + headersX.get(i).getText());
                logger.info("adding y: " + headersY.get(i).getText());
            }
        }
    }

    private List<GridButton> getUniqueButtons() {
        List<GridButton> toRemove = new ArrayList<>();
        for (int i = 0; i < buttons.size(); i++) {
            for (int j = 0; j < buttons.size(); j++) {
                if (buttons.get(i).getPosx() == buttons.get(j).getPosx() && buttons.get(i).getPosy() == buttons.get(i).getPosy()) {
                    toRemove.add(buttons.get(j));
                }
            }
        }
        buttons.removeAll(toRemove);
        return buttons;
    }

    public Matrix getMatrix() {
        int[][] matrix = new int[size][size];
        int row = 0;
        int cursor = 0;

        for (int i = 0; i < buttons.size(); i++) {
            if (i != 0) {
                if (row < size - 1) {
                    row++;
                } else {
                    row = 0;
                    cursor++;
                }
//                if (cursor < size - 1) {
//                    cursor++;
//                } else {
//                    cursor = 0;
//                    row++;
//                }
            }

            System.out.println("size: " + size);
            System.out.println("index: " + i);
            System.out.println("cursor: " + cursor);
            System.out.println("row: " + row);
            System.out.println(buttons.get(i).toString());
            System.out.println("-----------");
            matrix[cursor][row] = Integer.parseInt(buttons.get(i).getText());
        }

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                if (cursor < row) {
//                    matrix[i][line] = 0;
//                }
//                try {
//                    matrix[i][j] = Integer.parseInt(buttons.get(cursor).getText());
//                } catch (NumberFormatException nfe) {
//                    matrix[i][j] = -1;
//                }
//                cursor++;
//            }
//            line++;
//        }
        return new Matrix(matrix);
    }

    public void invert() {
        for (GridButton button : buttons) {
            button.invert();
        }
    }

    public void changeDiagonal(int posx, int posy, String name) {
        for (GridButton button : buttons) {
            if (posx != posy) {
                if (button.getPosx() == posx && button.getPosy() == posy) {
                    button.setName(name);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        for (GridButton gb : buttons) {
            sb.append(gb).append("\n");
        }
        return "MatrixGrid{" +
                "buttons=" + sb.toString() +
                '}';
    }
}
