package by.epam.jwdparsertask.exception;

public class InvalidXmlFileException extends RuntimeException {
    public InvalidXmlFileException() {
        super();
    }

    public InvalidXmlFileException(String message) {
        super(message);
    }

    public InvalidXmlFileException(Throwable cause) {
        super(cause);
    }

    public InvalidXmlFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
