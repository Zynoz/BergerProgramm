package model.exception;

public class MatrixException extends IllegalArgumentException {
    public MatrixException() {
        super();
    }

    public MatrixException(String s) {
        super(s);
    }

    public MatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixException(Throwable cause) {
        super(cause);
    }
}
