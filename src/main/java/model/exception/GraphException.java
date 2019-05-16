package model.exception;

public class GraphException extends IllegalArgumentException {
    public GraphException() {
        super();
    }

    public GraphException(String s) {
        super(s);
    }

    public GraphException(String message, Throwable cause) {
        super(message, cause);
    }

    public GraphException(Throwable cause) {
        super(cause);
    }
}
