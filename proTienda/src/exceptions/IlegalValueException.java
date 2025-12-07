package exceptions;

public class IlegalValueException extends RuntimeException {
    public IlegalValueException(String message) {
        super(message);
    }
}
