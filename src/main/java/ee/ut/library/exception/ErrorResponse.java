package ee.ut.library.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String title;
    private String message;
}