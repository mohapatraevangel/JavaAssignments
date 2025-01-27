package exception;

public class CustomerDaoException extends RuntimeException {
    public CustomerDaoException(String message) {
        super(message);
    }
}
