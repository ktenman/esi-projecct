package ee.ut.library.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not found with the given id");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}