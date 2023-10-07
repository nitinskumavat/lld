package exceptions;

public class InvalidGameParameterException extends Exception {
    public InvalidGameParameterException(String message) {
        super((message));
    }
}
