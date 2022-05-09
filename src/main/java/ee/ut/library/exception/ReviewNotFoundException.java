package ee.ut.library.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Long id) {
        super(String.format("Review not found with id of %s", id));
    }
}
