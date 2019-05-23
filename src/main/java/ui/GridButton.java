package ui;

import javafx.scene.control.Button;

public class GridButton extends Button {
    private String name;
    private boolean isFinal = false;

    public GridButton() {
        init();
        listener();
    }

    public GridButton(boolean isFinal) {
        this.isFinal = isFinal;
        init();
        listener();
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
        if (!isFinal) {
            this.setDisable(true);
            this.setStyle("-fx-background-color: #00ff00");
        }
    }

    public void setName(String name) {
        this.setText(name);
    }

    public String getName() {
        return this.getText();
    }

    public void invert() {
        if (isFinal) {
            if (name.equals("1")) {
                name = "0";
            } else {
                name = "1";
            }
        }

        this.setText(name);
    }
}
