package ui;

import javafx.scene.control.Button;

public class GridButton extends Button {

    private RootBorderPane rootBorderPane;

    private String name;
    private boolean isFinal;
    private int posx, posy;

    public GridButton(RootBorderPane rootBorderPane, int posx, int posy) {
        init();
        listener();
        this.posx = posx;
        this.posy = posy;
        this.rootBorderPane = rootBorderPane;
    }

    public GridButton(RootBorderPane rootBorderPane, boolean isFinal, int posx, int posy) {
        init();
        listener();
        this.isFinal = isFinal;
        this.posx = posx;
        this.posy = posy;
        this.rootBorderPane = rootBorderPane;
    }

    private void init() {
        this.name = "0";
        setText(name);
    }

    private void listener() {
        this.setOnAction(event -> {
            invert();
            this.setText(name);
        });
    }

    public void setName(String name) {
        this.setText(name);
    }

    public String getName() {
        return this.getText();
    }

    public void invert() {
        if (!isFinal) {
            if (name.equals("1")) {
                name = "0";
//                rootBorderPane.getMatrixGrid().changeDiagonal(posy, posx, name);
            } else {
                name = "1";
            }
            rootBorderPane.getMatrixGrid().changeDiagonal(posy, posx, name);
        }
        this.setText(name);
    }

    public boolean isFinal() {
        return isFinal;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    @Override
    public String toString() {
        return "GridButton{" +
                "name='" + name + '\'' +
                ", isFinal=" + isFinal +
                ", posx=" + posx +
                ", posy=" + posy +
                '}';
    }
}
