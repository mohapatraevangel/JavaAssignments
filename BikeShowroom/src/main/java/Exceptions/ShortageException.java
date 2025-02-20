package Exceptions;

public class ShortageException extends RuntimeException {
    public ShortageException(String message) {
        super(message);
    }
}
