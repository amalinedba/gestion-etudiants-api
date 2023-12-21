package exception;

public class FiliereNotFoundException extends RuntimeException {

    public FiliereNotFoundException() {
    }

    public FiliereNotFoundException(String message) {
        super(message);
    }

    public FiliereNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FiliereNotFoundException(Throwable cause) {
        super(cause);
    }

    public FiliereNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
